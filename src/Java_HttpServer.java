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
import java.util.Date;
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
            HttpServer httpServer = HttpServer.create(new InetSocketAddress(puerto), 0);
            
            httpServer.createContext("/", new MyHttpHandler());
            
            httpServer.createContext("/webMAN_MOD_1.47.20_Installer.pkg", new GetHttpHandler());
            
            httpServer.setExecutor(null);
            httpServer.start();
        }
        catch (IOException ex)
        {
            Logger.getLogger(Java_HttpServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    static class MyHttpHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange he) throws IOException
        {        
            String response = "<a href=\"webMAN_MOD_1.47.20_Installer.pkg\" >webMAN_MOD_1.47.20_Installer.pkg</a>";
            he.sendResponseHeaders(responseCode_OK, response.length());
             
            OutputStream outputStream = he.getResponseBody();
            outputStream.write(response.getBytes());
            outputStream.close();
        }
    }
     
    static class GetHttpHandler implements HttpHandler
    {
        @Override
        public void handle(HttpExchange he) throws IOException
        {
            File file = new File ("webMAN_MOD_1.47.20_Installer.pkg");
            byte[] bytes  = new byte [(int)file.length()];
            
            Headers headers = he.getResponseHeaders();
            headers.add("Server", "Luis Acxis 1.0");
            headers.add("Date", String.valueOf(new Date()));
            headers.add("Type", getFileExtension(file));
            headers.add("Content-Length", String.valueOf(file.length()));
            headers.add("Content-Type", "application/octet-stream pkg");
             
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
        return name.substring(lastIndexOf);
    }
}