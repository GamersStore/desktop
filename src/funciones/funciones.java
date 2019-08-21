package funciones;


import clases.infoFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class funciones
{
    public static String convertirBtoGB(long bytes)
    {
        long kb = bytes / 1024;
        double Mb = kb / 1024;
        double GB = Mb / 1024;
        
        if(GB > 1)
        {
            return String.valueOf(GB)+" GB";
        }
        if(Mb > 1)
        {
            return String.valueOf(Mb)+" Mb";
        }
        if(kb > 1)
        {
            return String.valueOf(kb)+" kb";
        }
        return String.valueOf(bytes)+" bytes";
    }
    
    public static String getContent_id(String archivo) throws IOException
    {
        File file = new File(System.getProperty("user.dir")+"\\"+archivo);
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
        
        // dump to the console
        //FileToHex.hexDump(new File("C:\\Users\\Luis Acxis\\Documents\\NetBeansProjects\\ServidorWeb\\webMAN_MOD_1.47.20_Installer.pkg"));
        // dump to a file
        //FileToHex.hexDump(new java.io.PrintStream("c:/temp/nvir.hex"), new File("c:/temp/nvir.log")); 
        
        return content_id;
    }
    
    public static String getFileExtension(File file)
    {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf == -1)
        {
            return ""; // empty extension
        }
        return name.substring(lastIndexOf + 1);
    }
    
    public static void makeXMLGamersLink(List<infoFile> File, int puerto)
    {
        try
        {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            // Init
            org.w3c.dom.Document doc = docBuilder.newDocument();


            // XMBML
            org.w3c.dom.Element XMBML = doc.createElement("XMBML");
            doc.appendChild(XMBML);
                Attr version = doc.createAttribute("version");
                version.setValue("1.0");
                XMBML.setAttributeNode(version);
            
            // View
            org.w3c.dom.Element View_root = doc.createElement("View");
            XMBML.appendChild(View_root);
                Attr id_root = doc.createAttribute("id");
                id_root.setValue("gamerslink_items");
                View_root.setAttributeNode(id_root);

                // Attributes
                org.w3c.dom.Element Attributes_root = doc.createElement("Attributes");
                View_root.appendChild(Attributes_root);

                for(int i=0; i<File.size(); i++)
                {
                    // Table
                    org.w3c.dom.Element Table = doc.createElement("Table");
                    Attributes_root.appendChild(Table);
                        Attr Table_key = doc.createAttribute("key");
                        Table_key.setValue(String.valueOf(i));
                        Table.setAttributeNode(Table_key);

                        // Pair
                        org.w3c.dom.Element Pair1 = doc.createElement("Pair");
                        Table.appendChild(Pair1);
                            Attr Pair_key1 = doc.createAttribute("key");
                            Pair_key1.setValue("icon");
                            Pair1.setAttributeNode(Pair_key1);

                            // String
                            org.w3c.dom.Element String1 = doc.createElement("String");
                            Pair1.appendChild(String1);

                                //Text
                                String1.appendChild(doc.createTextNode("/dev_hdd0/game/GAMESTORE/USRDIR/IMAGES/gamerslink/icon.jpg"));

                        // Pair
                        org.w3c.dom.Element Pair2 = doc.createElement("Pair");
                        Table.appendChild(Pair2);
                            
                            Attr Pair_key2 = doc.createAttribute("key");
                            Pair_key2.setValue("title");
                            Pair2.setAttributeNode(Pair_key2);

                            // String
                            org.w3c.dom.Element String2 = doc.createElement("String");
                            Pair2.appendChild(String2);

                                //Text
                                String2.appendChild(doc.createTextNode(File.get(i).getNombre()));
                                
                        // Pair
                        org.w3c.dom.Element Pair3 = doc.createElement("Pair");
                        Table.appendChild(Pair3);
                            
                            Attr Pair_key3 = doc.createAttribute("key");
                            Pair_key3.setValue("info");
                            Pair3.setAttributeNode(Pair_key3);

                            // String
                            org.w3c.dom.Element String3 = doc.createElement("String");
                            Pair3.appendChild(String3);

                                //Text
                                String3.appendChild(doc.createTextNode(funciones.convertirBtoGB((int) File.get(i).getTamaño())+" / "+getHostNamePC()+":"+getIPPC()));
                }
                
                // Items
                org.w3c.dom.Element Items_root = doc.createElement("Items");
                View_root.appendChild(Items_root);
                
                for(int i=0; i<File.size(); i++)
                {
                    // Query
                    org.w3c.dom.Element Query = doc.createElement("Query");
                    Items_root.appendChild(Query);
                        Attr Query_class = doc.createAttribute("class");
                        Query_class.setValue("type:x-xmb/folder-pixmap");
                        Query.setAttributeNode(Query_class);
                        
                        Attr Query_key = doc.createAttribute("key");
                        Query_key.setValue(String.valueOf(i));
                        Query.setAttributeNode(Query_key);
                        
                        Attr Query_attr = doc.createAttribute("attr");
                        Query_attr.setValue(String.valueOf(i));
                        Query.setAttributeNode(Query_attr);
                        
                        Attr Query_src = doc.createAttribute("src");
                        Query_src.setValue("#"+String.valueOf(i));
                        Query.setAttributeNode(Query_src);
                }
                
                for(int i=0; i<File.size(); i++)
                {
                    // View
                    org.w3c.dom.Element View = doc.createElement("View");
                    XMBML.appendChild(View);
                        Attr id = doc.createAttribute("id");
                        id.setValue(String.valueOf(i));
                        View.setAttributeNode(id);
                        
                    // Attributes
                    org.w3c.dom.Element Attributes = doc.createElement("Attributes");
                    View.appendChild(Attributes);
                    
                        // Table
                        org.w3c.dom.Element Table = doc.createElement("Table");
                        Attributes.appendChild(Table);
                            Attr Table_key = doc.createAttribute("key");
                            Table_key.setValue(String.valueOf(i)+"_install");
                            Table.setAttributeNode(Table_key);

                            // Pair
                            org.w3c.dom.Element Pair1 = doc.createElement("Pair");
                            Table.appendChild(Pair1);
                                Attr Pair_key1 = doc.createAttribute("key");
                                Pair_key1.setValue("prod_pict_path");
                                Pair1.setAttributeNode(Pair_key1);

                                // String
                                org.w3c.dom.Element String1 = doc.createElement("String");
                                Pair1.appendChild(String1);

                                    //Text
                                    String1.appendChild(doc.createTextNode("/dev_hdd0/game/GAMESTORE/USRDIR/IMAGES/gamerslink/icon.jpg"));

                            // Pair
                            org.w3c.dom.Element Pair2 = doc.createElement("Pair");
                            Table.appendChild(Pair2);

                                Attr Pair_key2 = doc.createAttribute("key");
                                Pair_key2.setValue("info");
                                Pair2.setAttributeNode(Pair_key2);

                                // String
                                org.w3c.dom.Element String2 = doc.createElement("String");
                                Pair2.appendChild(String2);

                                    //Text
                                    String2.appendChild(doc.createTextNode("net_package_install"));

                            // Pair
                            org.w3c.dom.Element Pair3 = doc.createElement("Pair");
                            Table.appendChild(Pair3);

                                Attr Pair_key3 = doc.createAttribute("key");
                                Pair_key3.setValue("pkg_src");
                                Pair3.setAttributeNode(Pair_key3);

                                // String
                                org.w3c.dom.Element String3 = doc.createElement("String");
                                Pair3.appendChild(String3);

                                    //Text
                                    String3.appendChild(doc.createTextNode("http://"+getIPPC()+":"+puerto+"/"+File.get(i).getNombre()));
                                    
                            // Pair
                            org.w3c.dom.Element Pair4 = doc.createElement("Pair");
                            Table.appendChild(Pair4);

                                Attr Pair_key4 = doc.createAttribute("key");
                                Pair_key4.setValue("pkg_src_qa");
                                Pair4.setAttributeNode(Pair_key4);

                                // String
                                org.w3c.dom.Element String4 = doc.createElement("String");
                                Pair4.appendChild(String4);

                                    //Text
                                    String4.appendChild(doc.createTextNode("http://"+getIPPC()+":"+puerto+"/"+File.get(i).getNombre()));

                            // Pair
                            org.w3c.dom.Element Pair5 = doc.createElement("Pair");
                            Table.appendChild(Pair5);

                                Attr Pair_key5 = doc.createAttribute("key");
                                Pair_key5.setValue("content_name");
                                Pair5.setAttributeNode(Pair_key5);

                                // String
                                org.w3c.dom.Element String5 = doc.createElement("String");
                                Pair5.appendChild(String5);

                                    //Text
                                    String5.appendChild(doc.createTextNode("pkg_install_pc"));
                                    
                            // Pair
                            org.w3c.dom.Element Pair6 = doc.createElement("Pair");
                            Table.appendChild(Pair6);

                                Attr Pair_key6 = doc.createAttribute("key");
                                Pair_key6.setValue("content_id");
                                Pair6.setAttributeNode(Pair_key6);

                                // String
                                org.w3c.dom.Element String6 = doc.createElement("String");
                                Pair6.appendChild(String6);

                                    //Text
                                    String6.appendChild(doc.createTextNode(File.get(i).getContent_id()));
                                    
                    // Items
                    org.w3c.dom.Element Items = doc.createElement("Items");
                    View.appendChild(Items);
                    
                        // Item
                        org.w3c.dom.Element Item = doc.createElement("Item");
                        Items.appendChild(Item);
                            Attr Item_class = doc.createAttribute("class");
                            Item_class.setValue("type:x-xmb/xmlnpsignup");
                            Item.setAttributeNode(Item_class);

                            Attr Item_key = doc.createAttribute("key");
                            Item_key.setValue(String.valueOf(i)+"_install");
                            Item.setAttributeNode(Item_key);

                            Attr Item_attr = doc.createAttribute("attr");
                            Item_attr.setValue(String.valueOf(i)+"_install");
                            Item.setAttributeNode(Item_attr);
                }

            Source source = new DOMSource(doc);
            //Indicamos donde lo queremos almacenar
            Result result = new StreamResult(new java.io.File("gamerslink.xml")); //nombre del archivo
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);
            
            System.out.println("XML Creado");
        }
        catch(Exception error)
        {
            System.out.println("Error! " +error);
        }
    }
    
    public static String getIPPC()
    {
        try
        {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostAddress();
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static String getHostNamePC()
    {
        try
        {
            InetAddress addr = InetAddress.getLocalHost();
            return addr.getHostName();
        }
        catch (UnknownHostException ex)
        {
            Logger.getLogger(funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static boolean getActivo(int puerto)
    {
        try
        {
            ServerSocket SERVER_SOCKETE = new ServerSocket(puerto);
            return true;
        }
        catch (IOException x)
        {
            return false;
        }
    } 
    
    public static boolean validarCorreo(String correo)
    {
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(correo);
        return matcher.find();
    }
    
    public static String MD5(String md5)
    {
        try
        {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i)
            {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
            return sb.toString();
        }
        catch (java.security.NoSuchAlgorithmException e)
        {
            
        }
        return null;
    }
    
    public static boolean verificarInternet()
    {
        String dirWeb = "sql181.main-hosting.eu";
        int puerto = 80;
        try
        {
            Socket s = new Socket(dirWeb, puerto);
            if(s.isConnected())
            {
                return true;
            }
        }
        catch (IOException ex)
        {
            return false;
        }
        return false;
    }
    
    public static String limpiaCadena(String nombre)
    {
        nombre = nombre.toLowerCase();
        nombre = nombre.replace("á","a").replace("é","e").replace("í","i").replace("ó","o").
            replace("ú", "u").replace("?","").replace("¿","");
        nombre = nombre.replaceAll("[^a-zA-Z0-9.-]+", "_");
        nombre = nombre.replaceAll("[-]+", "_");
        nombre = nombre.replaceAll("[-]+$", "_");
        return nombre;
    }
}
