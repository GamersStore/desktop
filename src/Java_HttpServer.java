import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class Java_HttpServer
{
    static int puerto = 8080;
    static final int responseCode_OK = 200;
 
    public static void main(String[] args)
    {
        try
        {            
            List<infoFile> File = getFiles(System.getProperty("user.dir"));
            
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(puerto), 0);
            httpServer.createContext("/", new MyHttpHandler(File));
            
            for (int i = 0; i <= File.size()-1; i++)
            {
                System.out.println
                (
                    "Nombre: " + File.get(i).getNombre() + " " +
                    "Tamaño: " + File.get(i).getTamaño() + " " +
                    "Ultima Modificacion: " + File.get(i).getUltModificacion() + " " +
                    "Tipo de archivo: " + File.get(i).getTipo()
                );

                httpServer.createContext("/"+File.get(i).getNombre(), new GetHttpHandler(File.get(i).getNombre(), File.get(i).getTamaño(), File.get(i).getTipo()));
            }
            
            httpServer.setExecutor(null);
            httpServer.start();
            
            System.out.println("Servidor Iniciado");
        }
        catch (IOException ex)
        {
            Logger.getLogger(Java_HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    static class MyHttpHandler implements HttpHandler
    {
        private List<infoFile> File;
        
        private MyHttpHandler(List<infoFile> _File)
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
"	<title>Gamers</title>\n" +
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
"			<td>"+convertirBtoGB((int) File.get(i).getTamaño())+"</td>\n" +
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
     
    static class GetHttpHandler implements HttpHandler
    {
        private String Nombre;
        private long Tamaño;
        private String Tipo;
        
        private GetHttpHandler(String _Nombre, long _Tamaño, String _Tipo)
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
            byte[] bytes  = new byte [(int)file.length()];
            
            Headers headers = he.getResponseHeaders();
            headers.add("Server", "Luis Acxis 1.0");
            headers.add("Date", String.valueOf(new Date()));
            headers.add("Type", Tipo);
            headers.add("Content-Length", String.valueOf(file.length()));
            headers.add("Content-Type", "application/octet-stream "+Tipo);
             
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedInputStream.read(bytes, 0, bytes.length);
 
            he.sendResponseHeaders(responseCode_OK, file.length());
            OutputStream outputStream = he.getResponseBody();
            outputStream.write(bytes, 0, bytes.length);
            outputStream.close();
        }
    }
    
    static private String getFileExtension(File file)
    {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1)
        {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }
    
    static private List<infoFile> getFiles(String sCarpAct)
    {
        List<infoFile> ejemploLista = new ArrayList<infoFile>();
        
        File carpeta = new File(sCarpAct);
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0)
        {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return null;
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i=0; i< archivos.length; i++)
            {
                File archivo = archivos[i];
                if(archivo.isDirectory() == false && getFileExtension(archivo).equals("pkg"))
                {
                    ejemploLista.add
                    (
                        new infoFile
                        (
                            archivo.getName(),
                            archivo.length(),
                            sdf.format(archivo.lastModified()),
                            getFileExtension(archivo)
                        )
                    );
                }
            }
        }
        return ejemploLista;
    }
    
    public static String convertirBtoGB(int bytes)
    {
        int kb = bytes / 1024;
        double Mb = kb / 1024;
        double GB = Mb / 1024;
        
        if(GB > 1)
        {
            return String.valueOf(GB)+" GB";
        }
        if(Mb > 1)
        {
            return String.valueOf(Mb)+" Mb";
        }
        if(kb > 1)
        {
            return String.valueOf(kb)+" kb";
        }
        return String.valueOf(bytes)+" bytes";
    }
    
   public static final class infoFile
   {
        private String Nombre;
        private long Tamaño;
        private String UltModificacion;
        private String Tipo;
        
        private infoFile(String _Nombre, long _Tamaño, String _UltModificacion, String _Tipo)
        {
            setNombre(_Nombre);
            setTamaño(_Tamaño);
            setUltModificacion(_UltModificacion);
            setTipo(_Tipo);
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public long getTamaño() {
            return Tamaño;
        }

        public void setTamaño(long Tamaño) {
            this.Tamaño = Tamaño;
        }

        public String getUltModificacion() {
            return UltModificacion;
        }

        public void setUltModificacion(String ultModificacion) {
            this.UltModificacion = ultModificacion;
        }

        public String getTipo() {
            return Tipo;
        }

        public void setTipo(String Tipo) {
            this.Tipo = Tipo;
        }
    }
}