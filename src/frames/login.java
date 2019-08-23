package frames;

import BaseDeDatos.conexion;
import config.User;
import config.Config;
import config.Frames;
import funciones.funciones;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.net.URI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class login extends javax.swing.JFrame
{


    public login()
    {
        initComponents();

        Config.setIcon(this);
        Config.center(this);
        
        Config.setControlBar(this, jP_bar, jL_minimizar, null, jL_cerrar);
        
        jL_version.setText(Config.getVersion());
        
        jT_correo.requestFocus();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jL_version = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jT_correo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jP_contraseña = new javax.swing.JPasswordField();
        btn_entrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jP_bar = new javax.swing.JPanel();
        jL_cerrar = new javax.swing.JLabel();
        jL_minimizar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicia Sesión");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/LogoGSWhite.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("GamersStore");

        jL_version.setFont(new java.awt.Font("Calibri", 0, 11)); // NOI18N
        jL_version.setForeground(new java.awt.Color(255, 255, 255));
        jL_version.setText("1.0 Beta ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jL_version)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(jL_version))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 370, 480);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Inicia Sesión");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(490, 70, 250, 60);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Contraseña");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(490, 280, 120, 16);

        jT_correo.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jT_correo.setForeground(new java.awt.Color(51, 51, 51));
        jT_correo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jT_correo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jT_correoKeyPressed(evt);
            }
        });
        jPanel1.add(jT_correo);
        jT_correo.setBounds(530, 180, 210, 40);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Correo");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(490, 160, 120, 16);

        jP_contraseña.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jP_contraseña.setForeground(new java.awt.Color(51, 51, 51));
        jP_contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jP_contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jP_contraseñaKeyPressed(evt);
            }
        });
        jPanel1.add(jP_contraseña);
        jP_contraseña.setBounds(530, 300, 210, 40);

        btn_entrar.setBackground(new java.awt.Color(0, 102, 204));
        btn_entrar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("Entrar");
        btn_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });
        btn_entrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btn_entrarKeyPressed(evt);
            }
        });
        jPanel1.add(btn_entrar);
        btn_entrar.setBounds(580, 380, 110, 40);

        jLabel7.setForeground(new java.awt.Color(0, 102, 204));
        jLabel7.setText("https://gamersstore.xyz/#registrate");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel7);
        jLabel7.setBounds(570, 440, 210, 20);

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-Key.png"))); // NOI18N
        jPanel1.add(jLabel9);
        jLabel9.setBounds(490, 300, 40, 40);

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-user.png"))); // NOI18N
        jPanel1.add(jLabel10);
        jLabel10.setBounds(490, 180, 40, 40);

        jP_bar.setBackground(new java.awt.Color(255, 255, 255));
        jP_bar.setForeground(new java.awt.Color(255, 255, 255));
        jP_bar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jP_bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-close.png"))); // NOI18N
        jL_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 0, 30, 50));

        jL_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icon-minimizar.png"))); // NOI18N
        jL_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, -1, 50));

        jPanel1.add(jP_bar);
        jP_bar.setBounds(370, 0, 440, 50);

        jLabel1.setText("Registrate en:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(490, 440, 80, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 814, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(814, 480));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        try
        {
            Desktop.getDesktop().browse(URI.create("https://gamersstore.xyz/#registrate"));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        
        String correo = jT_correo.getText();
        String contraseña = jP_contraseña.getText();
        
        if(jT_correo.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Escribe tu correo");
            jT_correo.requestFocus();
        }
        else if(jP_contraseña.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null,"Escribe tu contraseña");
            jP_contraseña.requestFocus();
        }
        else if(!funciones.validarCorreo(correo))
        {
            JOptionPane.showMessageDialog(null,"Al parecer tu correo esta mal escrito");
            jT_correo.setText("");
            jT_correo.requestFocus();
        }
        else
        {
            try
            {
                conexion con = new conexion();
                Connection conexion = con.conectar();
                
                contraseña = funciones.MD5(contraseña);
                
                PreparedStatement select = conexion.prepareStatement
                (
                    "SELECT Id, Nombre, Usuario, Correo, Cuenta_Id, Version_PKG FROM usuarios WHERE Correo = ? AND Contraseña = ? "
                );
                select.setString(1, correo);
                select.setString(2, contraseña);
                ResultSet result = select.executeQuery();
                
                boolean row = false;
                while (result.next())
                {
                    row = true;
                    
                    String Id = (String)result.getObject("Id");
                    String Nombre = (String)result.getObject("Nombre");
                    String Usuario = (String)result.getObject("Usuario");
                    String Correo = (String)result.getObject("Correo");
                    int Cuenta_Id = Integer.parseInt(String.valueOf(result.getObject("Cuenta_Id")));
                    String Version_PKG = (String)result.getObject("Version_PKG");                        

                    User.setId(Id);
                    User.setNombre(Nombre);
                    User.setUsuario(Usuario);
                    User.setCorreo(Correo);
                    User.setCuenta(Cuenta_Id);

                    switch (Cuenta_Id)
                    {
                        case 3:
                            JOptionPane.showMessageDialog(null,"Tu cuenta fue bloqueada por infringir los derechos de GamersStore.");
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(null,"Activa tu cuenta entrando al link enviado a tu correo.");
                            break;
                        default:
                            this.dispose();
                            User.setLogin(true);
                            Frames.showMenu_root();
                            break;
                    }
                }
                if(!row)
                {
                    JOptionPane.showMessageDialog(null,"Error en el correo o contraseña.");
                    jP_contraseña.setText("");
                    jP_contraseña.requestFocus();
                }
                
            }
            catch (SQLException ex)
            {
                Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btn_entrarActionPerformed

    private int x;
    private int y;
    private void jT_correoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jT_correoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String correo = jT_correo.getText();
            String contraseña = jP_contraseña.getText();
            if(correo.length()!=0)
            {
                if(!funciones.validarCorreo(correo))
                {
                    JOptionPane.showMessageDialog(null,"Al parecer tu correo esta mal escrito");
                    jT_correo.setText("");
                }
                else
                {
                    if(contraseña.length()==0)
                    {
                        jP_contraseña.requestFocus();
                    }
                    else
                    {
                        btn_entrarActionPerformed(null);
                    }
                }
            }
        }
    }//GEN-LAST:event_jT_correoKeyPressed

    private void jP_contraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jP_contraseñaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            String correo = jT_correo.getText();
            String contraseña = jP_contraseña.getText();
            if(contraseña.length()!=0)
            {
                if(correo.length()==0)
                {
                    jT_correo.requestFocus();
                }
                else
                {
                    btn_entrarActionPerformed(null);
                }
            }
        }
    }//GEN-LAST:event_jP_contraseñaKeyPressed

    private void btn_entrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btn_entrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            btn_entrarActionPerformed(null);
        }
    }//GEN-LAST:event_btn_entrarKeyPressed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JLabel jL_cerrar;
    private javax.swing.JLabel jL_minimizar;
    private javax.swing.JLabel jL_version;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jP_bar;
    private javax.swing.JPasswordField jP_contraseña;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jT_correo;
    // End of variables declaration//GEN-END:variables
}
