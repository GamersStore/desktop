package config;

import GamersLink.Init;
import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

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
    
    private static boolean initNotify = false;
    
    public static int versionCompilacion = 1;
    
    public static String dirInstall = "C:\\Program Files\\GamersStore\\";
    
    public static String urlApi = "http://localhost/Paginas/gamersstore/api/desktop/";
    
    public static String getDirInstall()
    {
        return dirInstall;
    }
    
    public static void setIcon(JFrame frame)
    {
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage(Config.getInstance().getClass().getResource("/lib/images/LogoGS.png")));
    }
    
    public static void center(JFrame frame)
    {
        frame.setLocationRelativeTo(null);
    }
    
    public static void setControlBar(JFrame frame, JPanel bar, JLabel minimizar, JLabel maximizar, JLabel cerrar)
    {
        if(bar != null)
        {
            bar.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mousePressed(java.awt.event.MouseEvent evt)
                {
                    bar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter()
                     {
                         public void mouseDragged(java.awt.event.MouseEvent evt)
                         {
                             moveFrame(evt, frame);                    
                         }
                     });
                }
            });
            bar.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseReleased(java.awt.event.MouseEvent evt)
                {
                    mover = false;
                }
            });
        }
        if(minimizar != null)
        {
            minimizar.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    minimizar(evt, frame);
                }
            });
        }
        
        if(maximizar != null)
        {
            maximizar.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    maximizar(evt, frame);
                }
            });
        }
        
        if(cerrar != null)
        {
            cerrar.addMouseListener(new java.awt.event.MouseAdapter()
            {
                public void mouseClicked(java.awt.event.MouseEvent evt)
                {
                    cerrar(evt, frame);
                }
            });
        }
    }

    private static int x;
    private static int y;
    private static int ubicacionClicX;
    private static int ubicacionClicY;
    private static boolean mover = false;
    private static void moveFrame(java.awt.event.MouseEvent evt, JFrame frame)
    {                                          
        Point point = MouseInfo.getPointerInfo().getLocation();
        
        if(!mover)
        {
            ubicacionClicX = (point.x - x) - frame.getLocation().x;
            
            ubicacionClicY = (point.y - y) - frame.getLocation().y;
            
            mover = true;
        }
        
        //int widthFrame = frame.getWidth();
        
        int locateX = (point.x - x) - ubicacionClicX;
        int locateY = (point.y - y) - ubicacionClicY;
        
        frame.setLocation(locateX, locateY);
    }
    
    private static void minimizar(java.awt.event.MouseEvent evt, JFrame frame)
    {                          
        if(frame == Frames.getGamersLink() && Init.getStatus() == true)
        {
            Frames.disposeGamersLink();
            Config.addNotify("GamersLink", "La Aplicacion se esta ejecutando en segundo plano.", TrayIcon.MessageType.INFO);
        }
        else
        {
            frame.setState(frame.ICONIFIED);
        }
    }
    
    private static void maximizar(java.awt.event.MouseEvent evt, JFrame frame)
    {                                          
        frame.setState(frame.ICONIFIED);
    }
    
    private static void cerrar(java.awt.event.MouseEvent evt, JFrame frame)
    {                                          
        close(frame);
    }
    
    private static TrayIcon icono;
    private static PopupMenu menu = new PopupMenu();
    
    public static void Notify() throws AWTException, InterruptedException
    {
        if(initNotify == false)
        {
            icono = new TrayIcon(Toolkit.getDefaultToolkit().getImage(Config.getInstance().getClass().getResource("/lib/images/icon-LogoGS-color-18x12.png")),"GamersStore",addMenuSalir());

            SystemTray.getSystemTray().add(icono);
            icono.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    if(User.getLogin())
                    {
                        Frames.showMenu_root();
                    }
                    else
                    {
                        if(Frames.getInsGamersLink() == false)
                        {
                            Frames.showLogin(); 
                        }
                        else
                        {
                            Frames.showGamersLink();
                        }
                    }
                }
            });
            Thread.sleep(5000);
            
            initNotify = true;
        }
    }
    
    public static void addNotify(String Titulo, String Mensaje, MessageType Tipo)
    {
        if(initNotify == false)
        {
            try
            {
                Notify();
            }
            catch(Exception e)
            {
            System.out.println(e);
            }
        }
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
    
    static MenuItem subMenuSalir = null;
    public static PopupMenu addMenuSalir()
    {
        subMenuSalir = new MenuItem("Salir");
        subMenuSalir.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                close(null);
            }
        });
        menu.add(subMenuSalir);
        return menu;
    }
    public static void removeMenuSalir()
    {
        menu.remove(subMenuSalir);
    }
    
    static MenuItem stopGamersLink = null;
    public static void addMenuGamersLinkStop()
    {
        stopGamersLink  = new MenuItem("Detener GamersLink");
        stopGamersLink.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                closeGamersLink();
            }
        });
        menu.add(stopGamersLink);
    }

    public static void removeMenuGamersLinkStop()
    {
        menu.remove(stopGamersLink);
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
    
    public static String getUrlApi()
    {
        return urlApi;
    }
    
   public static void close(JFrame frame)
   {
        if(frame == Frames.getLogin() && Frames.getInsGamersLink() != false && Init.getStatus())
        {
            Frames.disposeLogin();
            Frames.showGamersLink();
        }
        else
        {
            if(Init.getStatus())
            {
                JOptionPane.showMessageDialog(null,"El servicio de GamersLink se encuentra activo.\nDesactivalo antes de cerrar.");
            }
            else
            {
                int dialog = JOptionPane.YES_NO_OPTION;
                int result = JOptionPane.showConfirmDialog(null, "¿Cerrar GamersStore?", "Salir", dialog);
                if(result == 0)
                {
                    System.exit(0);
                }
            }
        }
   }
   
   public static boolean closeGamersLink()
   {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Al detener GamersLink todas las transferencias seran canceladas ¿Continuar?", "Salir", dialog);
        if(result == 0)
        {
            if(Init.getStatus())
            {
                return true;
            }
            return false;
        }
        return false;
   }
}
