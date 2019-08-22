package config;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Config
{
    private static Config instanciaInit = null;
    public static Config getInstance()
    {
        if(instanciaInit == null)
        {
            instanciaInit = new Config();
        }
        return instanciaInit;
    }
    private static boolean config = false;
    
    public static void setIcon(JFrame frame)
    {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Luis Acxis\\Documents\\NetBeansProjects\\GamersStore\\src\\images\\LogoGS.png"));
    }   
    
    public static void center(JFrame frame)
    {
        frame.setLocationRelativeTo(null);
    }
    
    private static TrayIcon icono;
    private static PopupMenu menu = new PopupMenu();
    
    public static void Notify() throws AWTException, InterruptedException
    {
        if(config == false)
        {
            icono = new TrayIcon(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Luis Acxis\\Documents\\NetBeansProjects\\GamersStore\\src\\images\\icon-LogoGSMin.png"),"GamersStore",addMenu("Salir"));

            SystemTray.getSystemTray().add(icono);
            icono.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(User.getLogin())
                    {
                        Frames.getMenu_root().setVisible(true);
                    }
                    else
                    {
                        Frames.getLogin().setVisible(true);
                    }
                }
            });
            Thread.sleep(5000);
            
            config = true;
        }
    }
    
    public static void addNotify(String Titulo, String Mensaje, MessageType Tipo)
    {
        if(false)
        {
            icono.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {

                }
            });
        }
        icono.displayMessage(Titulo, Mensaje, Tipo);
    }
    
    public static PopupMenu addMenu(String Titulo)
    {
        MenuItem subMenu = new MenuItem(Titulo);
        subMenu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                close();
            }
        });
        menu.add(subMenu);
        return menu;
    }
    
   public static void addOpcionGamersLinkStop()
   {
       MenuItem subMenu = new MenuItem("Detener GamersLink");
        subMenu.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.exit(0);
            }
        });
        menu.add(subMenu);
   }
   
    public static String version = "1.0.0";
    public static void setVersion(String version)
    {
        try
        {
            Object u = (Object)version;
            Field field = Config.class.getDeclaredField("version");
            field.setAccessible(true);
            field.set(u,version);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static String getVersion()
    {
        return version;
    }
    
    public static int versionCompilacion = 1;
    public static void setVersionCompilacion(int versionCompilacion)
    {
        try
        {
            Object u = (Object)versionCompilacion;
            Field field = Config.class.getDeclaredField("versionCompilacion");
            field.setAccessible(true);
            field.set(u,versionCompilacion);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static int getVersionCompilacion()
    {
        return versionCompilacion;
    }
    
   public static void close()
   {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Cerrar GamersStore?", "Salir", dialog);
        if(result == 0)
        {
            System.exit(0);
        }
   }
}
