package clases;

import funciones.httpRequest;
import config.Config;
import config.Frames;
import static funciones.funciones.ejecutarAsAdm;
import static funciones.funciones.getVCompilacion;
import static funciones.funciones.makeCarpeta;
import static funciones.funciones.verificarInternet;
import java.awt.TrayIcon;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class downloadUpdate extends Thread
{
    JProgressBar progreso;
    
    public downloadUpdate(JProgressBar progreso)
    {
        super();
        this.progreso = progreso;
    }
    
    public void run()
    {
        if(!verificarInternet())
        {
            Config.addNotify("No se logro conectar con el servidor", "Verifica tu conexion a internet.\nSolo se ejecutaran las funciones Offline", TrayIcon.MessageType.WARNING);
            Frames.showMenu_root();
        }
        else
        {
            try
            {
                
                if(getVCompilacion() > Config.getVersionCompilacion())
                {
                    httpRequest request = new httpRequest();
                    //get URL instalador
                    String instalador = request.execute("getInstaladorUpdate.php").getString("Instalador");

                    //Descarga de archivo
                    try
                    {
                        if(makeCarpeta(Config.getDirInstall()))
                        {
                            URL url = new URL (instalador);

                            URLConnection urlCon = url.openConnection();

                            int tamaño = urlCon.getContentLength();
                            String nombre = instalador.substring((instalador.lastIndexOf("/")) + 1);

                            InputStream is = urlCon.getInputStream();
                            FileOutputStream fos = new FileOutputStream(Config.getDirInstall()+nombre);

                            int tamArreglo = 1000;
                            byte[] array = new byte[tamArreglo];
                            int leido = is.read(array);
                            int cont = 0;

                            while (leido > 0)
                            {
                                fos.write(array, 0, leido);
                                leido = is.read(array);
                                cont++;

                                progreso.setValue((cont * (tamArreglo*100))/tamaño);
                            }

                            is.close();
                            fos.close();

                            ejecutarAsAdm(Config.getDirInstall()+nombre);

                            System.exit(0);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Ocurrio un error al tratar de descargar la actualizacion, El sistema intentara ejecutarse como administrador.");
                            ejecutarAsAdm(Config.getDirInstall()+"GamersStore.exe");
                            System.exit(0);
                        }
                    }
                    catch (Exception e)
                    {
                        JOptionPane.showMessageDialog(null,e);
                    }
                }
            }
            catch(Exception e)
            {
                    
            }
        }
    }
}
