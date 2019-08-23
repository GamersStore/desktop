package GamersLink;

import funciones.funciones;
import listas.listas;

import clases.infoFile;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import config.Config;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Init
{
    private static Init instanciaInit = null;
    public static Init getInstance()
    {
        if(instanciaInit == null)
        {
            instanciaInit = new Init();
        }
        return instanciaInit;
    }
    
   
    static final int responseCode_OK = 200;
    
    public static boolean status = false;
 
    public static HttpServer httpServer = null;
    
    public static List<infoFile> ListFiles = null;
    
    public static boolean start(String folder, int puerto)
    {
        try
        {
            List<infoFile> File = listas.getFiles(folder);
            
            httpServer = HttpServer.create(new InetSocketAddress(puerto), 0);
            httpServer.createContext("/", new setHttpHtml(File));
            
            for (int i = 0; i <= File.size()-1; i++)
            {
                httpServer.createContext("/"+File.get(i).getNombre(), new getHttpFile(folder, File.get(i).getNombre(), File.get(i).getTamaño(), File.get(i).getTipo()));
            }
            
            httpServer.setExecutor(null);
            httpServer.start();
            
            if(File.size() > 0)
            {
                funciones.makeXMLGamersLink(folder, puerto, File);
            }
            
        }
        catch (IOException ex)
        {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        status = true;
        return true;
    }
    
    public static boolean stop()
    {
        httpServer.stop(1);
        status = false;
        httpServer = null;
        return true;
    }
    
    public static boolean getStatus()
    {
        return status;
    }
    
    public static List<infoFile> getList()
    {
        return ListFiles;
    }
     
    static class setHttpHtml implements HttpHandler
    {
        
        private setHttpHtml(List<infoFile> _File)
        {
            setFile(_File);
        }
        public void setFile(List File) {
            ListFiles = File;            
        }
        
        @Override
        public void handle(HttpExchange he) throws IOException
        {
            String html = 
"<!DOCTYPE html>\n" +
"<html>\n" +
"<head>\n" +
"	<title>GamersLink</title>\n" +
"	<link rel=\"shortcut icon\" href=\"https://gamersstore.xyz/images/icono.png\" />\n" +
"       <meta charset=\"UTF-8\">\n"+
"	<link href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\n" +
"</head>\n" +
"<body>\n" +
"<table class=\"table table-hover\">\n" +
"	<thead>\n" +
"		<tr>\n" +
"			<th scope=\"col\">#</th>\n" +
"			<th scope=\"col\">Nombre</th>\n" +
"			<th scope=\"col\">Tamano</th>\n" +
"			<th scope=\"col\">Content_id</th>\n" +
"			<th scope=\"col\">Fecha</th>\n" +
"			<th scope=\"col\">Tipo</th>\n" +
"		</tr>\n" +
"	</thead>\n" +
"	<tbody>";
            
            for (int i = 0; i <= ListFiles.size()-1; i++)
            {
                html +=
"		<tr>\n" +
"			<th scope=\"row\">"+(i+1)+"</th>\n" +
"			<td><a href=\"/"+ListFiles.get(i).getNombre()+"\">"+ListFiles.get(i).getNombre()+"</a></td>\n" +
"			<td>"+funciones.convertirBtoGB((long) ListFiles.get(i).getTamaño())+"</td>\n" +
"			<td>"+ListFiles.get(i).getContent_id()+"</td>\n" +
"			<td>"+ListFiles.get(i).getUltModificacion()+"</td>\n" +
"			<td>"+ListFiles.get(i).getTipo()+"</td>\n" +
"		</tr>";
            }
            
            html +=
"	</tbody>\n" +
"</table>\n" +
"</body>\n" +
"</html>";
            
            he.sendResponseHeaders(responseCode_OK, html.length());
            
            try (OutputStream outputStream = he.getResponseBody())
            {
                outputStream.write(html.getBytes());
            }
        }
    }
     
    static class getHttpFile implements HttpHandler
    {
        private String Folder;
        private String Nombre;
        private long Tamaño;
        private String Tipo;
        boolean transfer = false;
        
        private getHttpFile(String _Folder, String _Nombre, long _Tamaño, String _Tipo)
        {
            setFolder(_Folder);
            setNombre(_Nombre);
            setTamaño(_Tamaño);
            setTipo(_Tipo);
        }
        public void setFolder(String Folder) {
            this.Folder = Folder;
        }
        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }
        public void setTamaño(long Tamaño) {
            this.Tamaño = Tamaño;
        }
        public void setTipo(String Tipo) {
            this.Tipo = Tipo;
        }
        
        @Override
        public void handle(HttpExchange he) throws IOException
        {
            File archivo = new File (Folder+"/"+Nombre);

            try
            {
                Headers headers = he.getResponseHeaders();
                headers.add("Server", "Luis Acxis 1.0");
                headers.add("Date", String.valueOf(new Date()));
                headers.add("Type", Tipo);
                headers.add("Content-Length", String.valueOf(archivo.length()));
                headers.add("Content-Type", "application/octet-stream "+Tipo);

                if(!transfer)
                {
                    Config.addNotify("GamersLink", "Transfiriendo: "+Nombre, TrayIcon.MessageType.INFO);
                    transfer = true;
                }

                he.sendResponseHeaders(responseCode_OK, archivo.length());
                OutputStream outputStream = he.getResponseBody();

                Path path = archivo.toPath();
                Files.copy(path, outputStream);
                outputStream.flush();

                outputStream.close();

                Config.addNotify("GamersLink", Nombre+" Transferido.", TrayIcon.MessageType.INFO);
            }
            catch(IOException e)
            {
                Config.addNotify("GamersLink", "El equipo remoto detuvo la descarga de "+Nombre, TrayIcon.MessageType.WARNING);
            }
        }
    }
    
    public static void setHttpHtmlAviso(HttpExchange he, String Aviso)
    {
        try
        {
            he.sendResponseHeaders(responseCode_OK, Aviso.length());
            
            try (OutputStream outputStream = he.getResponseBody())
            {
                outputStream.write(Aviso.getBytes());
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Init.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}