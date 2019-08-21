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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Init
{
    private static Init instanciaInit = null;
    public static Init getInstance()
    {
        if(instanciaInit == null)
        {
            instanciaInit = new Init();
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
            icono = new TrayIcon(Toolkit.getDefaultToolkit().getImage("C:/Users/Luis Acxis/Documents/NetBeansProjects/GamersStore/src/images/icono.png"),"GamersStore",addMenu("Salir"));

            SystemTray.getSystemTray().add(icono);
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
                System.exit(0);
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
   
   public static void close()
   {
        int dialog = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir?", "Salir", dialog);
        if(result == 0)
        {
            System.exit(0);
        }
   }
}
