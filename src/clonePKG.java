
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class clonePKG
{
    public static void main(String []args)
    {   
        try
        {
            System.out.println("Copiando archivo");
            File archivo = new File(System.getProperty("user.dir")+"/npeb01807_juego.pkg");
            FileInputStream archivo_lectura = new FileInputStream(archivo);
            FileOutputStream fichero_nuevo = new FileOutputStream(System.getProperty("user.dir")+"/npeb01807_juego_2.pkg");
            
            boolean final_arr = false;

            while(!final_arr)
            {
                int byte_entrada = archivo_lectura.read();
                if(byte_entrada != -1)
                {
                    fichero_nuevo.write(byte_entrada);
                }
                else
                {
                    final_arr = true;
                }
            }
            fichero_nuevo.close();
            archivo_lectura.close();
            
        }
        catch(IOException error)
        {
            System.out.println("Error: "+error);
        }
    }
}
