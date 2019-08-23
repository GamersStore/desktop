package GamersLink;

import AppPackage.AnimationClass;
import clases.infoFile;
import config.Config;
import config.Frames;
import config.User;
import funciones.funciones;
import java.awt.TrayIcon;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class GamersLink extends javax.swing.JFrame {

    public DefaultTableModel modelo;
    
    public GamersLink() {
        
        modelo = new DefaultTableModel(){public boolean isCellEditable(int rowIndex,int columnIndex){return false;}};
        
        initComponents();
        
        jT_lista.setSelectionForeground(new java.awt.Color(255, 255, 255));
        
        Config.setIcon(this);
        Config.center(this);
        
        Config.setControlBar(this, jP_bar, jL_minimizar, null, jL_cerrar);
        
        jL_ip.setText(funciones.getIPPC());
        
        jT_lista.setModel(modelo);
        modelo.addColumn("Nombre");
        modelo.addColumn("Tamaño");
        modelo.addColumn("Content_ID");
        modelo.addColumn("Fecha");
        modelo.addColumn("Tipo");
        
        //750
        TableColumnModel Columnas = jT_lista.getColumnModel();
        Columnas.getColumn(0).setPreferredWidth(230);
        Columnas.getColumn(1).setPreferredWidth(50);
        Columnas.getColumn(2).setPreferredWidth(275);
        Columnas.getColumn(3).setPreferredWidth(125);
        Columnas.getColumn(4).setPreferredWidth(30);
        
//                            Object fila[];
//                            
//                            fila = new Object[5];
//                            fila[0] = "fbanext_mxm_1_0.pkg";
//                            fila[1] = "62.0 Mb";
//                            fila[2] = "AP0001-FBAN00000_00-0000111122223333";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//                            
//                            fila = new Object[5];
//                            fila[0] = "idpset_v0.90.pkg.343.v0.90_brewology_com.pkg";
//                            fila[1] = "535 kb";
//                            fila[2] = "EP0001-IDPSET000_00-0000000000000000";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//
//                            fila = new Object[5];
//                            fila[0] = "mmcm_04.81.02.pkg";
//                            fila[1] = "2.0 Mb";
//                            fila[2] = "MM4PS3-BLES80608_00-MULTIMANAGER0481";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//                            
//                            fila = new Object[5];
//                            fila[0] = "mmcm_04.82.00.pkg";
//                            fila[1] = "2.0 Mb";
//                            fila[2] = "MM4PS3-BLES80608_00-MULTIMANAGER0482";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//                            
//                            fila = new Object[5];
//                            fila[0] = "reactpsn_v3_20_pkg_983_v3_20_brewology_com.pkg";
//                            fila[1] = "358 kb";
//                            fila[2] = "UP0310-RPSN00001_00-0000000000000000";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//                            
//                            fila = new Object[5];
//                            fila[0] = "webman_mod_1.47.20_installer.pkg";
//                            fila[1] = "11.0 Mb";
//                            fila[2] = "EP0001-UPDWEBMOD_00-0000000000000000";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
//                            
//                            fila = new Object[5];
//                            fila[0] = "_ps2u10000_ps2_classics_placeholder.pkg";
//                            fila[1] = "16.0 Mb";
//                            fila[2] = "2P0001-PS2U10000_00-0000111122223333";
//                            fila[3] = "28/05/2015 00:08:16";
//                            fila[4] = "pkg";
//                            modelo.addRow(fila);
                            
                            
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jL_menu = new javax.swing.JLabel();
        icon_return = new javax.swing.JLabel();
        jP_bar = new javax.swing.JPanel();
        jL_minimizar = new javax.swing.JLabel();
        jL_cerrar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jL_ip = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jT_lista = new javax.swing.JTable();
        jL_folder = new javax.swing.JLabel();
        jL_directorio = new javax.swing.JLabel();
        icon_power = new javax.swing.JLabel();
        jL_foldername = new javax.swing.JLabel();
        jL_files = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GamersLink");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-menu-white-32x32.png"))); // NOI18N
        jL_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jL_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_menuMouseClicked(evt);
            }
        });
        jPanel2.add(jL_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        icon_return.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-return-white-32x32.png"))); // NOI18N
        icon_return.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_returnMouseClicked(evt);
            }
        });
        jPanel2.add(icon_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 61, -1, -1));

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 160, 300);

        jP_bar.setBackground(new java.awt.Color(255, 255, 255));
        jP_bar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jP_bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-minimizar-gray-32x32.png"))); // NOI18N
        jL_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 40, 50));

        jL_cerrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-close-gray-32x32.png"))); // NOI18N
        jL_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 50, 50));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GamersLink:");
        jP_bar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 50));

        jL_ip.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jL_ip.setForeground(new java.awt.Color(102, 102, 102));
        jP_bar.add(jL_ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 140, 50));

        jPanel1.add(jP_bar);
        jP_bar.setBounds(160, 0, 770, 50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(772, 240));
        jPanel3.setPreferredSize(new java.awt.Dimension(772, 240));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jT_lista.setAutoCreateRowSorter(true);
        jT_lista.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jT_lista.setForeground(new java.awt.Color(51, 51, 51));
        jT_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jT_lista.setRowMargin(3);
        jT_lista.setSelectionBackground(new java.awt.Color(0, 102, 204));
        jScrollPane1.setViewportView(jT_lista);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 40, 750, 200));

        jL_folder.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_folder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-foldersearch-primary-32x32.png"))); // NOI18N
        jL_folder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jL_folder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_folderMouseClicked(evt);
            }
        });
        jPanel3.add(jL_folder, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 40));

        jL_directorio.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jL_directorio.setForeground(new java.awt.Color(102, 102, 102));
        jL_directorio.setText("Escoje la carpeta que contenga los archivos");
        jPanel3.add(jL_directorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 470, 40));

        icon_power.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        icon_power.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-power-red-32x32.png"))); // NOI18N
        icon_power.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_power.setPreferredSize(new java.awt.Dimension(100, 100));
        icon_power.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_powerMouseClicked(evt);
            }
        });
        jPanel3.add(icon_power, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 40));

        jL_foldername.setFont(new java.awt.Font("Calibri", 0, 24)); // NOI18N
        jL_foldername.setForeground(new java.awt.Color(102, 102, 102));
        jL_foldername.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jPanel3.add(jL_foldername, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, 150, 40));

        jL_files.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jL_files.setForeground(new java.awt.Color(0, 102, 204));
        jL_files.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jL_files, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 40));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(160, 50, 772, 240);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 934, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 293, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jL_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_menuMouseClicked
        AnimationClass logoutR = new AnimationClass();
        logoutR.jLabelXRight(-40, 10, 10, 5, icon_return);
        
        AnimationClass logoutL = new AnimationClass();
        logoutL.jLabelXLeft(10, -40, 10, 5, icon_return);
    }//GEN-LAST:event_jL_menuMouseClicked

    public String folder = null;
    private void jL_folderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_folderMouseClicked
        if(!Init.getStatus())
        {
            JFileChooser fc = new JFileChooser();

            FileNameExtensionFilter filter = new FileNameExtensionFilter("Carpeta con los PKG", "pkg");
            fc.setFileFilter(filter);

            if(folder == null)
            {
                fc.setCurrentDirectory(new File(System.getProperty("user.home")));
            }
            else
            {
                fc.setCurrentDirectory(new File(folder));
            }

            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int respuesta = fc.showOpenDialog(this);

            if (respuesta == JFileChooser.APPROVE_OPTION)
            {
                File archivoElegido = fc.getSelectedFile();

                folder = archivoElegido.getPath();

                jL_directorio.setText(archivoElegido.getPath());
                jL_foldername.setText(archivoElegido.getName());
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Para seleccionar otra carpeta antes debes detener el servidor.");
        }
    }//GEN-LAST:event_jL_folderMouseClicked

    private void icon_powerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_powerMouseClicked
        if(folder == null)
        {
            JOptionPane.showMessageDialog(null,"Por favor selecciona la carpeta donde tengas tus archivos");
        }
        else
        {
            if(!Init.getStatus())
            {
                if(Init.start(folder, 8080))
                {
                    icon_power.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-power-on-32x32.png")));
                    
                    List<infoFile> ListFiles = Init.getList();
                    modelo.setRowCount(0);
                    if(ListFiles.size() > 0)
                    {
                        boolean filesError = false;
                        int totalFiles = 0;
                        Object fila[];
                        for (int i = 0; i <= ListFiles.size()-1; i++)
                        {
                            if(ListFiles.get(i).getTamaño() > 0)
                            {
                                fila = new Object[5];

                                fila[0] = ListFiles.get(i).getNombre();
                                fila[1] = funciones.convertirBtoGB((long) ListFiles.get(i).getTamaño());
                                fila[2] = ListFiles.get(i).getContent_id();
                                fila[3] = ListFiles.get(i).getUltModificacion();
                                fila[4] = ListFiles.get(i).getTipo();

                                modelo.addRow(fila);

                                totalFiles++;
                            }
                            else
                            {
                                filesError = true;
                            }
                        }

                        jL_files.setText(String.valueOf(totalFiles));

                        Config.addNotify("GamersLink", "Servidor Iniciado.", TrayIcon.MessageType.INFO);
                        Config.addMenuGamersLinkStop();
                        try
                        {
                            String path = folder+"\\gamerslink.xml";
                            Runtime.getRuntime().exec("explorer.exe /select," + path);
                        }
                        catch (IOException ex)
                        {
                            Logger.getLogger(GamersLink.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if(filesError)
                        {
                            Config.addNotify("GamersLink", "Algunos archivos fueron ignorados por tener contenido corrupto.", TrayIcon.MessageType.WARNING);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Esta carpeta no contiene archivos para instalar");
                        jL_files.setText("0");
                        if(Init.stop())
                        {
                            icon_power.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-power-off-32x32.png")));
                            modelo.setRowCount(0);
                        }
                    }
                }
            }
            else
            {
                Config.closeGamersLink();
            }
        }
    }//GEN-LAST:event_icon_powerMouseClicked

    private void icon_returnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_returnMouseClicked
        if(User.getLogin())
        {
            Frames.showMenu_root();   
            Frames.disposeGamersLink();
        }
        else
        {
            Frames.showLogin();
            Frames.disposeGamersLink();
        }
    }//GEN-LAST:event_icon_returnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GamersLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GamersLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GamersLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GamersLink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GamersLink().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel icon_power;
    private javax.swing.JLabel icon_return;
    private javax.swing.JLabel jL_cerrar;
    private javax.swing.JLabel jL_directorio;
    public static javax.swing.JLabel jL_files;
    private javax.swing.JLabel jL_folder;
    private javax.swing.JLabel jL_foldername;
    private javax.swing.JLabel jL_ip;
    private javax.swing.JLabel jL_menu;
    private javax.swing.JLabel jL_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jP_bar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jT_lista;
    // End of variables declaration//GEN-END:variables
}
