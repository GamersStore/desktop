package frames;

import AppPackage.AnimationClass;
import config.Config;
import config.Frames;
import config.User;

public class menu_root extends javax.swing.JFrame {

    /**
     * Creates new form menu_root
     */
    public menu_root() {
        initComponents();
        
        Config.setIcon(this);
        Config.center(this);
        
        Config.setControlBar(this, jP_bar, jL_minimizar, null, jL_cerrar);
        
        lbl_user.setText(User.getUsuario());
        
        if(!User.getLogin())
        {
            
        }
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
        jLabel1 = new javax.swing.JLabel();
        lbl_user = new javax.swing.JLabel();
        jL_menu = new javax.swing.JLabel();
        icon_logout = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        icon_GamersLink = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jP_bar = new javax.swing.JPanel();
        jL_cerrar = new javax.swing.JLabel();
        jL_minimizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/LogoGS-White.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 180));

        lbl_user.setFont(new java.awt.Font("Calibri", 0, 48)); // NOI18N
        lbl_user.setForeground(new java.awt.Color(255, 255, 255));
        lbl_user.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_user.setText("User");
        jPanel1.add(lbl_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 300, 40));

        jL_menu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-menu-white-32x32.png"))); // NOI18N
        jL_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jL_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jL_menuMouseClicked(evt);
            }
        });
        jPanel1.add(jL_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 30, 30));

        icon_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-logout-white-32x32.png"))); // NOI18N
        icon_logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_logoutMouseClicked(evt);
            }
        });
        jPanel1.add(icon_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 60, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 400));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        icon_GamersLink.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-gamersLink-primary-150x150.png"))); // NOI18N
        icon_GamersLink.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        icon_GamersLink.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                icon_GamersLinkMouseMoved(evt);
            }
        });
        icon_GamersLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                icon_GamersLinkMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                icon_GamersLinkMouseExited(evt);
            }
        });
        jPanel2.add(icon_GamersLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 150, 160));

        jLabel4.setBackground(new java.awt.Color(0, 102, 204));
        jLabel4.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("GamersLink");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 120, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 520, 350));

        jP_bar.setBackground(new java.awt.Color(255, 255, 255));
        jP_bar.setForeground(new java.awt.Color(255, 255, 255));
        jP_bar.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        jP_bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jL_cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-close-gray-32x32.png"))); // NOI18N
        jL_cerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_cerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 30, 50));

        jL_minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jL_minimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lib/images/icon-minimizar-gray-32x32.png"))); // NOI18N
        jL_minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jP_bar.add(jL_minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, -1, 50));

        getContentPane().add(jP_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 520, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jL_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jL_menuMouseClicked
        AnimationClass logoutR = new AnimationClass();
        logoutR.jLabelXRight(-40, 10, 10, 5, icon_logout);
        
        AnimationClass logoutL = new AnimationClass();
        logoutL.jLabelXLeft(10, -40, 10, 5, icon_logout);
        
    }//GEN-LAST:event_jL_menuMouseClicked

    private void icon_GamersLinkMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_GamersLinkMouseMoved
        icon_GamersLink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153,153,153)));
    }//GEN-LAST:event_icon_GamersLinkMouseMoved

    private void icon_GamersLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_GamersLinkMouseExited
        icon_GamersLink.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255,255,255)));
    }//GEN-LAST:event_icon_GamersLinkMouseExited

    private int x;
    private int y;
    private void icon_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_logoutMouseClicked
        Config.close(this);
    }//GEN-LAST:event_icon_logoutMouseClicked

    private void icon_GamersLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon_GamersLinkMouseClicked
            Frames.showGamersLink();
            Frames.disposeMenu_root();
    }//GEN-LAST:event_icon_GamersLinkMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menu_root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menu_root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menu_root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menu_root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_root().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon_GamersLink;
    private javax.swing.JLabel icon_logout;
    private javax.swing.JLabel jL_cerrar;
    private javax.swing.JLabel jL_menu;
    private javax.swing.JLabel jL_minimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jP_bar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_user;
    // End of variables declaration//GEN-END:variables
}
