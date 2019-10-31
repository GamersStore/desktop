package DB;

import config.Config;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class sqlLite
{
    String fileName = "GamersStore.s3db";
    String url = Config.getDirInstall()+fileName;
    private Connection conexion;

    //Metodo Conectar
    public Connection conectar()
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            conexion = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conexion!=null)
            {
                return conexion;
            }
        }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"sqlLite: "+ex);
            System.err.println(ex.getMessage());
        }
        catch (ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"sqlLite: "+ex);
        }
        return conexion;
    }

    //Metodo Cerrar
    public Connection cerrar()
    {
        try
        {
            conexion.close();
            return conexion;
        }
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return null;
    }    
}
