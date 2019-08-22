package config;

import frames.login;
import frames.menu_root;
import java.lang.reflect.Field;
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
    
    static login loginF = new login();
    public static JFrame login = loginF;
    public static void setLogin(JFrame login)
    {
        try
        {
            Object u = (Object)login;
            Field field = User.class.getDeclaredField("login");
            field.setAccessible(true);
            field.set(u,login);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static JFrame getLogin()
    {
        return login;
    }
    
    static menu_root menu_rootF = new menu_root();
    public static JFrame menu_root = menu_rootF;
    public static void setMenu_root(JFrame menu_root)
    {
        try
        {
            Object u = (Object)menu_root;
            Field field = User.class.getDeclaredField("menu_root");
            field.setAccessible(true);
            field.set(u,menu_root);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static JFrame getMenu_root()
    {
        return menu_root;
    }
}
