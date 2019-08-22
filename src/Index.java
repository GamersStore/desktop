
import frames.login;
import BaseDeDatos.conexion;
import config.Config;
import config.Frames;
import java.awt.TrayIcon;
import static funciones.funciones.getActivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
                Connection conexion = con.conectar();
                
                PreparedStatement select = conexion.prepareStatement
                (
                    "SELECT Informacion FROM gamersstore WHERE Id = 6"
                );
                ResultSet result = select.executeQuery();
                while (result.next())
                {
                    int VersionCompilacion = Integer.valueOf((String)result.getObject("Informacion"));
                    if(VersionCompilacion > Config.getVersionCompilacion())
                    {
                        JOptionPane.showMessageDialog(null,"Actualiza GamersStore antes de continuar.");
                        System.exit(0);
                    }
                }
                
                select = conexion.prepareStatement
                (
                    "SELECT Informacion FROM gamersstore WHERE Id = 5"
                );
                result = select.executeQuery();
                while (result.next())
                {
                    String Version = (String)result.getObject("Informacion");
                    Config.setVersion(Version);
                }
                
                Frames.getLogin().setVisible(true);
            }
        }
    }
    
    public static void loadInit()
    {
        try
        {
            Config.setVersionCompilacion(1);
            Config.Notify();
        }
        catch (Exception ex)
        {
            Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}