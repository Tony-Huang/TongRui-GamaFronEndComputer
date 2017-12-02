/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui;

import java.awt.Toolkit;
import java.net.ServerSocket;
import java.util.Locale;
import javax.swing.JOptionPane;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class TongRuiShangWeiJi {
    private static final Log log = LogFactory.getLog(TongRuiShangWeiJi.class);

    public static void main(String args[]) {
        try {
            ServerSocket s = new ServerSocket(54321);//54321为你自己定义的端口号
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "程序已经运行!");
            System.exit(0);
        }

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
        */
         try {
             javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
             for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                 if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                     javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                     break;
                 }
             }
         } catch (ClassNotFoundException ex) {
             java.util.logging.Logger.getLogger(TongRuiShangWeiJi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             java.util.logging.Logger.getLogger(TongRuiShangWeiJi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             java.util.logging.Logger.getLogger(TongRuiShangWeiJi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             java.util.logging.Logger.getLogger(TongRuiShangWeiJi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
         }
         
         
        //</editor-fold>

        log.fatal("\r\n\r\n========= Restart the Progra (This is not error)=========\r\n\r\n") ;
        
        /* Create and display the form */
        Toolkit tk = Toolkit.getDefaultToolkit();
        final int xSize = ((int) tk.getScreenSize().getWidth());
        final int ySize = ((int) tk.getScreenSize().getHeight());

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Locale locale = Locale.getDefault();
                System.out.println("current locale=" + locale.getLanguage());

                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources_cn");
                if (locale.getLanguage().equalsIgnoreCase("zh")) {
                    bundle = java.util.ResourceBundle.getBundle("resources_cn");
                } else {
                    bundle = java.util.ResourceBundle.getBundle("resources_en");
                }

                Login loginWindow = new Login(bundle);
                Login.longWindow = loginWindow;
                loginWindow.setLocation(xSize / 4, ySize / 4);
//                loginWindow.setSize(xSize / 2, ySize / 2);
                loginWindow.setVisible(true);
            }
        });
        System.out.println("---running----");
    }
}
