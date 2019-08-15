import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileToHex
{
    public static void hexDump(File file) throws IOException
    {
        InputStream is = new FileInputStream(file);
        int i = 0;
        String txt_content_id = "";
        
        while (is.available() > 0)
        {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder("   ");
            //out.printf("%04X  ", i * 16);
            for (int j = 0; j < 16; j++)
            {
                if (is.available() > 0)
                {
                    int value = (int) is.read();
                    sb1.append(String.format("%02X ", value));
                    if (!Character.isISOControl(value))
                    {
                        sb2.append((char)value);
                        txt_content_id += (char)value;
                    }
                    else
                    {
                        sb2.append(".");
                    }
                }
                else
                {
                    for (;j < 16;j++)
                    {
                        sb1.append("   ");
                    }
                }
            }
            //out.print(sb1);
            //out.println(sb2);
            i++;
            if(i == 6)
            {
                break;
            }
        }
        is.close();
        //System.out.println(txt_content_id);
        
        String content_id = txt_content_id.substring(txt_content_id.length() - 36);
        
        System.out.println(content_id);
    }

    public static void main(String args[]) throws Exception
    {
        // dump to the console
        FileToHex.hexDump(new File("C:\\Users\\Luis Acxis\\Documents\\NetBeansProjects\\ServidorWeb\\webMAN_MOD_1.47.20_Installer.pkg"));
        // dump to a file
        //FileToHex.hexDump(new java.io.PrintStream("c:/temp/nvir.hex"), new File("c:/temp/nvir.log"));        
    }  
}
