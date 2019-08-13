import java.io.*;
import java.net.*;
import java.util.*;

public class servidorWeb
{
    int puerto = 90;

    final int ERROR = 0;
    final int WARNING = 1;
    final int DEBUG = 2;

    // funcion para centralizar los mensajes de depuracion
    void depura(String mensaje)
    {
        depura(mensaje,DEBUG);
    }	

    void depura(String mensaje, int gravedad)
    {
        System.out.println("Mensaje: " + mensaje);
    }	

    // punto de entrada a nuestro programa
    public static void main(String [] array)	
    {
        servidorWeb instancia = new servidorWeb(array);	
        instancia.arranca();
    }

    // constructor que interpreta los parameros pasados
    servidorWeb(String[] param)
    {
        procesaParametros();	
    }

    // parseo del fichero de entrada y se establece las variables de clase
    boolean procesaParametros()
    {
        return true;	
    }
	
    boolean arranca()
    {
        depura("Servidor Iniciado",DEBUG);
        try
        {
            ServerSocket s = new ServerSocket(puerto);
            depura("Esperando conexión");
            while(true)
            {
                Socket entrante = s.accept();
                peticionWeb pCliente = new peticionWeb(entrante);
                pCliente.start();
            }
        }
        catch(Exception e)
        {
            depura("Error en servidor\n" + e.toString());
        }
        return true;
    }
	
}



class peticionWeb extends Thread
{
    int contador = 0;

    final int ERROR = 0;
    final int WARNING = 1;
    final int DEBUG = 2;

    void depura(String mensaje)
    {
        depura(mensaje,DEBUG);
    }	

    void depura(String mensaje, int gravedad)
    {
        System.out.println(currentThread().toString() + " - " + mensaje);
    }	

    private Socket scliente = null;		// Peticion del cliente
    private PrintWriter out = null;		// Buffer donde se escribe la respuesta

    peticionWeb(Socket ps)
    {
        depura("Cliente # " + contador);
        contador ++;
        scliente = ps;
        setPriority(NORM_PRIORITY - 1); // hacemos que la prioridad sea baja
    }

    public void run() // emplementamos el metodo run
    {
        depura("Procendo conexion");
        try
        {
            BufferedReader in = new BufferedReader (new InputStreamReader(scliente.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(scliente.getOutputStream(),"8859_1"),true) ;
            String cadena = "";		// cadena donde almacenamos las lineas que leemos
            int i=0;                    // lo usaremos para que cierto codigo solo se ejecute una vez
            do			
            {
                cadena = in.readLine();
                if (cadena != null )
                {
                    depura("--" + cadena + "-");
                }
                if(i == 0) // la primera linea nos dice que fichero hay que descargar
                {
                    i++;
                    StringTokenizer st = new StringTokenizer(cadena);
                    if ((st.countTokens() >= 2) && st.nextToken().equals("GET")) 
                    {
                        retornaFichero(st.nextToken()) ;
                    }
                    else 
                    {
                        out.println("400 Peticion Incorrecta") ;
                    }
                }
            }
            while (cadena != null && cadena.length() != 0);
        }
        catch(Exception e)
        {
            depura("Error en servidor\n" + e.toString());
        }
        depura("End Peticion");
    }

    void retornaFichero(String sfichero)
    {
        depura("Recuperamos el fichero " + sfichero);
        // comprobamos si tiene una barra al principio
        if (sfichero.startsWith("/"))
        {
            sfichero = sfichero.substring(1) ;
        }

        // si acaba en /, le retornamos el index.html de ese directorio
        // si la cadena esta vacia, no retorna el index.html principal
        if (sfichero.endsWith("/") || sfichero.equals(""))
        {
            sfichero = sfichero + "index.html" ;
        }

        try
        {
            // Ahora leemos el fichero y lo retornamos
            File mifichero = new File(sfichero) ;
            
            if(mifichero.exists())
            {
                if(getFileExtension(mifichero).equals(".html"))
                {
                    out.println("HTTP/1.0 200 ok");
                    out.println("Server: Luis Acxis/1.0");
                    out.println("Date: " + new Date());
                    out.println("Content-Type: text/html");
                    out.println("\n");

                    BufferedReader ficheroLocal = new BufferedReader(new FileReader(mifichero));

                    String linea = "";
                    do			
                    {
                        linea = ficheroLocal.readLine();
                        if (linea != null )
                        {
                            out.print(linea);
                        }
                    }
                    while (linea != null);
                    ficheroLocal.close();
                    depura("fin envio fichero: "+mifichero.toString());
                    out.close();
                }
                else
                {
                    //Envio del archivo a descargar por medio del navegador web
                }
            }
            else
            {
                out.println("HTTP/1.0 200 ok");
                out.println("Server: Luis Acxis/1.0");
                out.println("Date: " + new Date());
                out.println("Content-Type: text/html");
                out.println("\n");

                out.print("<h1>El archivo "+mifichero.toString()+" no existe</h1>");

                out.close();   
            }
        }
        catch(Exception e)
        {
            out.println("HTTP/1.0 200 ok");
            out.println("Server: Luis Acxis/1.0");
            out.println("Date: " + new Date());
            out.println("Content-Type: text/html");
            out.println("\n");

            out.print("Error code: "+e);
 
            depura("Error code: "+e);
            out.close();
        }
    }


    private String getFileExtension(File file)
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