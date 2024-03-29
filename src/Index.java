import funciones.httpRequest;
import DB.sqlLite;
import config.Config;
import config.Frames;
import static funciones.funciones.ejecutarAsAdm;
import java.awt.TrayIcon;
import static funciones.funciones.getActivo;
import static funciones.funciones.getVCompilacion;
import static funciones.funciones.getVSoftware;
import static funciones.funciones.isAdmin;
import static funciones.funciones.verificarInternet;
import java.sql.Connection;
import java.sql.SQLException;
import play.sounds;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import org.json.JSONException;

public class Index
{   
    public static boolean update = false;
    public static httpRequest request = new httpRequest();
    
    public static void main(String args[]) throws Exception
    {       
        if(!isAdmin())
        {
            ejecutarAsAdm(Config.getDirInstall()+"GamersStore.exe");
            System.exit(0);
        }
        
        if(!getActivo(1750))
        {
            JOptionPane.showMessageDialog(null,"La aplicacion ya se encuentra en ejecución.");
            System.exit(0);
        }
        
        if(args.length > 0)
        {
            if(args[0].equals("GamersLink"))
            {
                if(!verificarInternet())
                {
                    Frames.showGamersLink();
                }
                else
                {
                    verificarVCompilacion();
                    if(!update)
                    {
                        getVSoftware();

                        Frames.showGamersLink();
                        
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
            }
        }
        else
        {
            sqlLite conLite1 = new sqlLite();
            Connection conLiteC1 = conLite1.conectar();
            
            ResultSet resultLite1 = null;
            
            //Crear acceso directo a GamersLink
            try
            {
                PreparedStatement stLite1 = conLiteC1.prepareStatement("SELECT Config FROM config WHERE Id = 1");
                resultLite1 = stLite1.executeQuery();
                while (resultLite1.next())
                {
                    if((int)resultLite1.getObject("Config") == 0)
                    {
                        ejecutarAsAdm(Config.getDirInstall()+"addMenuGamersLink.bat");
                        ejecutarAsAdm(Config.getDirInstall()+"addFirewallGamersStore.bat");
                        stLite1 = conLiteC1.prepareStatement("UPDATE config SET config = 1 WHERE Id = 1");
                        stLite1.execute();
                    }
                }
                conLite1.cerrar();
            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null,ex.getMessage());
                conLite1.cerrar();
            }

            if(!verificarInternet())
            {
                Config.addNotify("No se logro conectar con el servidor", "Verifica tu conexion a internet.\nSolo se ejecutaran las funciones Offline", TrayIcon.MessageType.WARNING);
                Frames.showMenu_root();
            }
            else
            {
                verificarVCompilacion();
                if(!update)
                {
                    getVSoftware();
                    sqlLite conLite2 = new sqlLite();
                    Connection conLiteC2 = conLite2.conectar();
                    ResultSet resultLite2 = null;
                    try
                    {
                        PreparedStatement stLite2 = conLiteC2.prepareStatement("SELECT Config FROM config WHERE Id = 2");
                        resultLite2 = stLite2.executeQuery();
                        while (resultLite2.next())
                        {   
                            if((int)resultLite2.getObject("Config") == 1)
                            {
                                sounds.introPS1();
                            }
                        }
                        conLite2.cerrar();
                    }
                    catch (SQLException ex)
                    {
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                        conLite2.cerrar();
                    }

                    Frames.showLogin();
                }
            }
        }
    }
    
    public static void verificarVCompilacion() throws JSONException
    {
        if(getVCompilacion() > Config.getVersionCompilacion())
        {
            JOptionPane.showMessageDialog(null,"Actualiza GamersStore antes de continuar.");

            barProgress bar = new barProgress();
            bar.setVisible(true);

            update = true;
        }
    }
}