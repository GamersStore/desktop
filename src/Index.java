import BaseDeDatos.conexion;
import config.Config;
import config.Frames;
import java.awt.TrayIcon;
import static funciones.funciones.getActivo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import play.sounds;

public class Index
{   
    public static void main(String args[]) throws Exception
    {
        if(args.length > 0)
        {
            if(args[0].equals("GamersLink"))
            {
                if(!getActivo(1750))
                {
                    JOptionPane.showMessageDialog(null,"La aplicacion ya se encuentra en ejecución.");
                    System.exit(0);
                }
                conexion con = new conexion();
                if(con.conectar() == null)
                {
                    Frames.showGamersLink();
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

                    Frames.showGamersLink();
                }
                //Set Carpeta e Init Server
                String folder = args[1];
                if(folder.length()!=0)
                {
                    Frames.getGamersLink().folder = args[1];
                    Frames.getGamersLink().setFolderLabel();
                    Frames.getGamersLink().switchServer();
                }
            }
        }
        else
        {
            if(!getActivo(1750))
            {
                JOptionPane.showMessageDialog(null,"La aplicacion ya se encuentra en ejecución.");
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

                    sounds.introPS1();
                    Frames.showLogin();
                }
            }
        }
    }
}