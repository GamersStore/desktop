
package config;

import java.lang.reflect.*;

public class Config
{
    private static Config instanciaConfig = null;
    public static Config getInstance()
    {
        if(instanciaConfig == null)
        {
            instanciaConfig = new Config();
        }
        return instanciaConfig;
    }
    
    public static String id = "";
    public static void setId(String id)
    {
        try
        {
            Object u = (Object)id;
            Field field = Config.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(u,id);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static String getId()
    {
        return id;
    }
    
    public static String nombre = "";
    public static void setNombre(String nombre)
    {
        try
        {
            Object u = (Object)nombre;
            Field field = Config.class.getDeclaredField("nombre");
            field.setAccessible(true);
            field.set(u,nombre);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static String getNombre()
    {
        return nombre;
    }
   
    public static String usuario = "GamersStore";
    public static void setUsuario(String usuario)
    {
        try
        {
            Object u = (Object)usuario;
            Field field = Config.class.getDeclaredField("usuario");
            field.setAccessible(true);
            field.set(u,usuario);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static String getUsuario()
    {
        return usuario;
    }
   
    public static String correo = "";
    public static void setCorreo(String correo)
    {
        try
        {
            Object u = (Object)correo;
            Field field = Config.class.getDeclaredField("correo");
            field.setAccessible(true);
            field.set(u,correo);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static String getCorreo()
    {
        return correo;
    }
    
    public static int cuenta_id = 0;
    public static void setCuenta(int cuenta_id)
    {
        try
        {
            Object u = (Object)cuenta_id;
            Field field = Config.class.getDeclaredField("cuenta_id");
            field.setAccessible(true);
            field.set(u,cuenta_id);
        }
        catch (Exception e)
        {
            System.out.println("No se pudo cambiar el valor");
            e.printStackTrace(System.out);
        }
    }
    public static int getCuenta()
    {
        return cuenta_id;
    }
}
