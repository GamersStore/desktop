package listas;

import clases.infoFile;
import funciones.funciones;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class listas
{
    public static List<infoFile> getFiles(String sCarpAct) throws IOException
    {
        List<infoFile> ejemploLista = new ArrayList<infoFile>();
        
        File carpeta = new File(sCarpAct);
        File[] archivos = carpeta.listFiles();
        if (archivos == null || archivos.length == 0)
        {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return null;
        }
        else
        {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            for (int i=0; i< archivos.length; i++)
            {
                File archivo = archivos[i];
                if(archivo.isDirectory() == false && funciones.getFileExtension(archivo).equals("pkg"))
                {

                    String cadena = archivo.getName();
                    String remplazado = funciones.limpiaCadena(cadena);

                    File newName = new File(sCarpAct+"/"+remplazado);
                    if(archivo.renameTo(newName))
                    {
                        archivo = newName;
                    }
                     
                    ejemploLista.add
                    (
                        new infoFile
                        (
                            archivo.getName(),
                            archivo.length(),
                            sdf.format(archivo.lastModified()),
                            funciones.getFileExtension(archivo),
                            funciones.getContent_id(archivo.getName())
                        )
                    );
                }
            }
        }
        return ejemploLista;
    }    
}
