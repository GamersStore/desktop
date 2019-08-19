import funciones.funciones;
import listas.listas;

import clases.infoFile;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
 
public class GamersLink
{
    static int puerto = 8080;
    static final int responseCode_OK = 200;
 
    public static void main(String[] args)
    {
        try
        {
            List<infoFile> File = listas.getFiles(System.getProperty("user.dir"));
            
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(puerto), 0);
            httpServer.createContext("/", new setHttpHtml(File));
            
            for (int i = 0; i <= File.size()-1; i++)
            {
                httpServer.createContext("/"+File.get(i).getNombre(), new getHttpFile(File.get(i).getNombre(), File.get(i).getTamaño(), File.get(i).getTipo()));
            }
            
            httpServer.setExecutor(null);
            httpServer.start();
            
            funciones.makeXMLGamersLink(File, puerto);
            
            System.out.println("Servidor Iniciado");
        }
        catch (IOException ex)
        {
            Logger.getLogger(GamersLink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    static class setHttpHtml implements HttpHandler
    {
        private List<infoFile> File;
        
        private setHttpHtml(List<infoFile> _File)
        {
            setFile(_File);
        }
        public void setFile(List File) {
            this.File = File;            
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
            
            for (int i = 0; i <= File.size()-1; i++)
            {
                html +=
"		<tr>\n" +
"			<th scope=\"row\">"+(i+1)+"</th>\n" +
"			<td><a href=\"/"+File.get(i).getNombre()+"\">"+File.get(i).getNombre()+"</a></td>\n" +
"			<td>"+funciones.convertirBtoGB((long) File.get(i).getTamaño())+"</td>\n" +
"			<td>"+File.get(i).getContent_id()+"</td>\n" +
"			<td>"+File.get(i).getUltModificacion()+"</td>\n" +
"			<td>"+File.get(i).getTipo()+"</td>\n" +
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
        private String Nombre;
        private long Tamaño;
        private String Tipo;
        boolean transfer = false;
        
        private getHttpFile(String _Nombre, long _Tamaño, String _Tipo)
        {
            setNombre(_Nombre);
            setTamaño(_Tamaño);
            setTipo(_Tipo);
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
            File file = new File (Nombre);
            if (file.length() > Integer.MAX_VALUE && false)
            {
                System.out.println("Este archivo supera los " + Integer.MAX_VALUE + " bytes permitidos");

                setHttpHtmlAviso(he, "<h3>Este archivo supera los " + Integer.MAX_VALUE + " bytes permitidos</h3>");
            }
            else
            {
                try
                {
                    Headers headers = he.getResponseHeaders();
                    headers.add("Server", "Luis Acxis 1.0");
                    headers.add("Date", String.valueOf(new Date()));
                    headers.add("Type", Tipo);
                    headers.add("Content-Length", String.valueOf(file.length()));
                    headers.add("Content-Type", "application/octet-stream "+Tipo);

                    if(!transfer)
                    {
                        System.out.println("Transfiriendo: "+Nombre);
                        transfer = true;

                        System.out.println("Tamaño: "+file.length());
                    }


                    FileInputStream archivo_lectura = new FileInputStream(file);
                    BufferedInputStream archivo_buffered = new BufferedInputStream(archivo_lectura);
                    he.sendResponseHeaders(responseCode_OK, file.length());
                    OutputStream outputStream = he.getResponseBody();
                    
                    //byte bytes[] = new byte[100];
                    //outputStream.write(bytes,0, 100);

                    boolean final_arr = false;
                    while(!final_arr)
                    {
                        int byte_entrada = archivo_buffered.read();
                        if(byte_entrada != -1)
                        {
                            //outputStream.write(byte_entrada);
                            outputStream.write(byte_entrada);
                        }
                        else
                        {
                            final_arr = true;
                        }
                    }
                    outputStream.close();
                    archivo_lectura.close();
                    archivo_buffered.close();
            
                    System.out.println("Transferencia completa");
                }
                catch(IOException e)
                {
                    System.out.println("Error: "+e); 
                }
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
            Logger.getLogger(GamersLink.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}