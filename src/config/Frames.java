package config;

import GamersLink.GamersLink;
import frames.login;
import frames.menu_root;
import javax.swing.JFrame;


public class Frames
{
    private static Frames instanciaFrames = null;
    public static Frames getInstance()
    {
        if(instanciaFrames == null)
        {
            instanciaFrames = new Frames();
        }
        return instanciaFrames;
    }
    
    public static int fadeInTime = 20;
    public static int fadeOutTime = 20;
    
    // login
    private static boolean instanciaLogin = false;
    public static login login = null;
    public static login getLogin()
    {
        if(instanciaLogin == false)
        {
            instanciaLogin = true;
            login = new login();
            return login;
        }
        return login;
    }
    public static boolean getInsLogin()
    {
        return instanciaLogin;
    }
    public static void showLogin()
    {
        Frames.getLogin().setVisible(true);
        int sta = Frames.getLogin().getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;
        Frames.getLogin().setVisible(true);
        Frames.getLogin().setExtendedState(sta); 
        Frames.getLogin().setAlwaysOnTop(true); 
        Frames.getLogin().toFront(); 
        Frames.getLogin().requestFocus(); 
        Frames.getLogin().setAlwaysOnTop(false);
    }
    public static void disposeLogin()
    {
        Frames.getLogin().dispose();
    }
    
    // menu_root
    private static boolean instanciaMenu_root = false;
    public static menu_root menu_root = null;
    public static menu_root getMenu_root()
    {
        if(instanciaMenu_root == false)
        {
            instanciaMenu_root = true;
            menu_root = new menu_root();
            return menu_root;
        }
        return menu_root;
    }
    public static boolean getInsMenu_root()
    {
        return instanciaMenu_root;
    }
    public static void showMenu_root()
    {
        Frames.getMenu_root().setVisible(true);
        int sta = Frames.getMenu_root().getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;
        Frames.getMenu_root().setVisible(true);
        Frames.getMenu_root().setExtendedState(sta); 
        Frames.getMenu_root().setAlwaysOnTop(true); 
        Frames.getMenu_root().toFront(); 
        Frames.getMenu_root().requestFocus(); 
        Frames.getMenu_root().setAlwaysOnTop(false);
    }
    public static void disposeMenu_root()
    {
        Frames.getMenu_root().dispose();
    }
    
    // GamersLink
    private static boolean instanciaGamersLink = false;
    public static GamersLink GamersLink = null;
    public static GamersLink getGamersLink()
    {
        if(instanciaGamersLink == false)
        {
            instanciaGamersLink = true;
            GamersLink = new GamersLink();
            return GamersLink;
        }
        return GamersLink;
    }
    public static boolean getInsGamersLink()
    {
        return instanciaGamersLink;
    }
    public static void showGamersLink()
    {
        Frames.getGamersLink().setVisible(true);
        int sta = Frames.getGamersLink().getExtendedState() & ~JFrame.ICONIFIED & JFrame.NORMAL;
        Frames.getGamersLink().setVisible(true);
        Frames.getGamersLink().setExtendedState(sta); 
        Frames.getGamersLink().setAlwaysOnTop(true); 
        Frames.getGamersLink().toFront(); 
        Frames.getGamersLink().requestFocus(); 
        Frames.getGamersLink().setAlwaysOnTop(false);
    }
    public static void disposeGamersLink()
    {
        Frames.getGamersLink().dispose();
    }
}
