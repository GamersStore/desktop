
import jFrames.login;
import BaseDeDatos.conexion;
import config.Config;
import java.awt.TrayIcon;
import static funciones.funciones.getActivo;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Index
{   
    public static void main(String args[]) throws Exception
    {   
        loadInit();
        
        if(!getActivo(1750))
        {
            Config.addNotify("GamersStore", "La aplicacion ya se encuentra en ejecución.", TrayIcon.MessageType.INFO);
            System.exit(0);
        }
        else
        {   
//            config.addNotify("Iniciando", "Cargando programa", TrayIcon.MessageType.INFO);
            conexion con = new conexion();
            if(con.conectar() == null)
            {
                Config.addNotify("No se logro conectar con el servidor", "Verifica tu conexion a internet.\nSolo se ejecutaran las funciones Offline", TrayIcon.MessageType.WARNING);
            }
            else
            {
                login login = new login();
                login.setVisible(true);
            }
        }
    }
    
    public static void loadInit()
    {
        try
        {
            Config.Notify();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}