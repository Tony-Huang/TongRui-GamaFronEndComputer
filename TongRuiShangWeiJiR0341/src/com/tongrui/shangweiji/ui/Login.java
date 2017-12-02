/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.UserService;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.data.CatAccUser;
import com.tongrui.shangweiji.ui.patientmanagement.TPSTimer;
import com.tongrui.shangweiji.ui.patientmanagement.TmpDBTimer;
import common.EncryptUtil;
import common.SystemInfo;
import dbsetting.DBSetting;
import java.awt.Toolkit;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Administrator
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public  Login() {
        initComponents();
    }
    
     public Login( ResourceBundle bundle) {
         this.bundle =bundle;
        initComponents();
    }

static  java.util.ResourceBundle bundle = ResourceBundle.getBundle("resources_cn"); // added by Tony
 
  boolean success = false;
    
   static  Login longWindow=   new Login() ;
//  
//  
  public static Login getInstance(){
   return longWindow;
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
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        btnOk = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnLanguage = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources_cn"); // NOI18N
        setTitle(bundle.getString("login.title")); // NOI18N
        setAlwaysOnTop(true);
        setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        setForeground(java.awt.Color.white);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(100, 60));

        jPanel1.setMaximumSize(new java.awt.Dimension(400, 500));
        jPanel1.setMinimumSize(new java.awt.Dimension(100, 60));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 300));

        userNameLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        userNameLabel.setText(bundle.getString("user.username.label")); // NOI18N

        passwordLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        passwordLabel.setText(bundle.getString("user.password.lable")); // NOI18N

        userName.setColumns(20);
        userName.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        password.setColumns(20);
        password.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N

        btnOk.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        btnOk.setText(bundle.getString("btn.ok")); // NOI18N
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOkMouseClicked(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        btnCancel.setText(bundle.getString("btn.cancel")); // NOI18N
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnLanguage.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        btnLanguage.setText("English");
        btnLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanguageActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton1.setText("数据库设定");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOk)
                        .addGap(56, 56, 56)
                        .addComponent(btnCancel)
                        .addGap(47, 47, 47)
                        .addComponent(btnLanguage))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userNameLabel)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(userName))
                                .addGap(34, 34, 34)))))
                .addGap(69, 69, 69))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLabel)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnOk)
                    .addComponent(btnLanguage)
                    .addComponent(btnCancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseClicked
       
        
    }//GEN-LAST:event_btnOkMouseClicked
 
    private void checkLogin(){
        // TODO add your handling code here:
        //System.out.println(bundle.getString("OK PRESSED!"));


        String name = userName.getText();
        String password = this.getPassword().getText();
        String inputCipherPwd = null;
        // System.out.println(bundle.getString("USER INPUT: NAME=")+name +bundle.getString(";PASSWD=")+password);


        ErrorDialog dialog = new ErrorDialog(this, true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        final int xSize = ((int) tk.getScreenSize().getWidth());
        final int ySize = ((int) tk.getScreenSize().getHeight());
        dialog.setLocation(xSize / 3, ySize / 3);

        //validation
        if (name == null || name.equals("")) {
            dialog.getErrorText().setText(bundle.getString("login.msg.emptyuname"));
            dialog.setVisible(true);
            return;
        }
        if (password == null || password.equals("")) {
            dialog.getErrorText().setText(bundle.getString("login.msg.emptypwd"));
            dialog.setVisible(true);
            return;
        }

        //sec check =======
        CatAccUser user = null;
        try {
            //  user = ServiceLocator.getUserService().findByName(name);
            UserService us = ServiceLocator.getUserService();
            user = us.findByName(name);
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, "本地数据库访问出错!");
           // System.exit(0);
        }
        String existUsername = null;
        String existPasswd = null;

        if (user == null) {

            dialog.getErrorText().setText(bundle.getString("login.msg.notexist"));
            dialog.setVisible(true);
            // success=false;
        } else {
            existUsername = user.getUserName();
            existPasswd = user.getPassword();//从数据库中查的密码，应该是加密的
             inputCipherPwd = EncryptUtil.encryptToMD5(password);

            if (!name.equals(existUsername)) {
                dialog.getErrorText().setText(bundle.getString("login.msg.invaliduname"));
                dialog.setVisible(true);
                // success=false;
            } else if (!inputCipherPwd.equals(existPasswd)) { //!password.equals(existPasswd)
                dialog.getErrorText().setText(bundle.getString("login.msg.invalidpwd"));
                dialog.setVisible(true);
                // success=false;
            }
        }

        if (name.equals(existUsername) && inputCipherPwd.equals(existPasswd)) {//password.equals(existPasswd)
            success = true;
        }

        if (success == true) {
            longWindow.dispose();
            SystemInfo.setCurrentUser(user);

            MainWindow mw = MainWindow.getInstance();
            mw.setSize(xSize, ySize);
            mw.setVisible(true);

            if (Constant.DEBUG_this_is_TouDao == true) {
                //start processing tps files
                TPSTimer tpstimer = TPSTimer.getInstance();
                tpstimer.run();
            } else {
                TmpDBTimer tmpDBtimer = new TmpDBTimer();
                tmpDBtimer.run();
            }
        }
    }
    
    
    
    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        // TODO add your handling code here:
        longWindow.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        // TODO add your handling code here:
       
        this.checkLogin();
       
    }//GEN-LAST:event_btnOkActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
         System.exit(0);
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanguageActionPerformed
        // TODO add your handling code here:

        Toolkit tk = Toolkit.getDefaultToolkit();
        final int xSize = ((int) tk.getScreenSize().getWidth());
        final int ySize = ((int) tk.getScreenSize().getHeight());

        if(btnLanguage.getText().equals("English")) {
            bundle = java.util.ResourceBundle.getBundle("resources_en");
        } else {
            bundle = java.util.ResourceBundle.getBundle("resources_cn");
        }
        Login loginWindow = new Login(bundle);
        Login.longWindow = loginWindow;
        loginWindow.setLocation(xSize / 4, ySize / 4);
        loginWindow.setSize(xSize / 2, ySize / 2);
        loginWindow.setVisible(true);
        
        this.dispose();
      
    }//GEN-LAST:event_btnLanguageActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       DBSetting dbsettingDialog = new DBSetting(this,true);
        Toolkit tk = Toolkit.getDefaultToolkit();
        final int xSize = ((int) tk.getScreenSize().getWidth());
        final int ySize = ((int) tk.getScreenSize().getHeight());

        dbsettingDialog.setLocation(xSize /3, ySize /3);
       // dbsettingDialog.setSize(xSize / 4, ySize / 4);
        dbsettingDialog.setVisible(true);
    
    }//GEN-LAST:event_jButton1ActionPerformed

    int selectedLangIndex=0;

    public int getSelectedLangIndex() {
        return selectedLangIndex;
    }

    public void setSelectedLangIndex(int selectedLangIndex) {
        this.selectedLangIndex = selectedLangIndex;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if (bundle.getString("NIMBUS").equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLanguage;
    private javax.swing.JButton btnOk;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables

    public JTextField getjTextField1() {
        return userName;
    }

    public void setjTextField1(JTextField jTextField1) {
        this.userName = jTextField1;
    }

    public JPasswordField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    

   
}