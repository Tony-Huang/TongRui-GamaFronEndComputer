/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReportError.java
 *
 * Created on 2012-10-2, 23:28:51
 */
package com.tongrui.shangweiji.ui.logmanagement;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.SystemLogService;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.data.CatSystemLog;
import common.CommonMethod;
import java.awt.Cursor;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class ReportError extends javax.swing.JFrame {
    
    private static ReportError reportError = null;
    public static ReportError getInstatnce() {
        if(reportError == null) {
            try {
                reportError = new ReportError();
            } catch (Throwable ex) {
                Logger.getLogger(ReportError.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
            }
        }
        return reportError;
    }
    
    private static final Log log = LogFactory.getLog(ReportError.class);
    private List<CatSystemLog> errList;
    private ViewRefresh freshObj = null;

    /** Creates new form ReportError */
    public ReportError() throws Throwable{
        initComponents();
        this.setLocationRelativeTo(null);
        jTable1.getTableHeader().setFont(new java.awt.Font("宋体", 0, 24));

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -2);
        String startStr = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
        if(startStr != null) {
            jTextField1.setText(startStr);
        }

        displayHistoryError();
        jButton2.setEnabled(false);
//        freshObj = new ViewRefresh(this); //Display current error by default
//        freshObj.start();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFocusable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jTable1.setFont(new java.awt.Font("宋体", 0, 24));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "时间", "内容"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(80);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(300);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "报警信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setText("起始日期");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 52, 0, 0);
        jPanel3.add(jLabel1, gridBagConstraints);

        jTextField1.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField1.setText("2012-5-6");
        jTextField1.setMinimumSize(new java.awt.Dimension(102, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 21, 0, 0);
        jPanel3.add(jTextField1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel3.setText("截止时期");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 43, 0, 0);
        jPanel3.add(jLabel3, gridBagConstraints);

        jTextField2.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField2.setMinimumSize(new java.awt.Dimension(102, 35));
        jTextField2.setPreferredSize(new java.awt.Dimension(102, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 22, 0, 0);
        jPanel3.add(jTextField2, gridBagConstraints);

        jButton1.setFont(new java.awt.Font("宋体", 0, 24));
        jButton1.setText("查询");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 43, 8, 52);
        jPanel3.add(jButton1, gridBagConstraints);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel4.setMinimumSize(new java.awt.Dimension(300, 100));
        jPanel4.setPreferredSize(new java.awt.Dimension(542, 120));

        jButton2.setFont(new java.awt.Font("宋体", 0, 24));
        jButton2.setText("故障恢复");
        jPanel4.add(jButton2);

        jPanel1.add(jPanel4, java.awt.BorderLayout.PAGE_END);

        jPanel5.setPreferredSize(new java.awt.Dimension(200, 311));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton1.setText("当前故障信息");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("故障历史记录");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jRadioButton2, gridBagConstraints);

        jPanel1.add(jPanel5, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 786, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(freshObj != null) {
            freshObj.stop();
            freshObj = null;
        }
        this.setCursor(Cursor.WAIT_CURSOR);
        try {
            displayHistoryError();
        } catch (Throwable ex) {
            Logger.getLogger(ReportError.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jButton1ActionPerformed
      
    private void displayHistoryError() throws Throwable{
        String startTime = jTextField1.getText();
        String endTime = jTextField2.getText();

        if (!CommonMethod.isDateStringValid(startTime) || !CommonMethod.isDateStringValid(endTime)) {
            JOptionPane.showMessageDialog(this, "错误，请输入正确的日期及格式！");
            return; //Date input is invalid
        }

        errList = null;
        try {
            errList = logSvc.findBySearchCriteria("ErrorAndWarning", startTime, endTime);
        } catch (Exception e) {
            throw e;
        }

        DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
        tableModel.setRowCount(0);

        if (errList != null && !errList.isEmpty()) {
            fillParamTable(errList, tableModel);
        }
   }

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        if(freshObj != null) {
            freshObj.stop();
            freshObj = null;
        }
        jTextField1.setVisible(true);
        jTextField2.setVisible(true);
        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        jButton1.setVisible(true);
        jButton2.setEnabled(false);

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -2);
        String startStr = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
        if(startStr != null) {
            jTextField1.setText(startStr);
        }
        
        this.setCursor(Cursor.WAIT_CURSOR);
        try {
            displayHistoryError();
        } catch (Throwable ex) {
            Logger.getLogger(ReportError.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if(freshObj == null) { //Display current errors
            freshObj = new ViewRefresh(this);
            freshObj.start();
        }
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        jButton1.setVisible(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        reportError = null;
    }//GEN-LAST:event_formWindowClosing

    private void initTable() throws Throwable{
        errList = null;
        errList = logSvc.findBySearchCriteria("ErrorAndWarning", null, null);
        if(errList != null && !errList.isEmpty()) {
            DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
            fillParamTable(errList, tableModel);           
        }
    }

    private void fillParamTable(List<CatSystemLog> logList, DefaultTableModel tableModel) {
        for (int i = 0; i < logList.size(); i++) {
            CatSystemLog systemLog = logList.get(i);
            Date date = systemLog.getHappenTime();
            String logMessage = null;
            if(systemLog.getLogMessage() != null) {
                logMessage = systemLog.getLogMessage();
            }
             
            Object[] oneRow = new Object[2];
            oneRow[0] = date.toString();
            oneRow[1] = logMessage;
            tableModel.addRow(oneRow);   
        }       
    }
    
    public void refreshCurrentError() {
        String selectedString = " ";
        DefaultTableModel tableModel = (DefaultTableModel) this.jTable1.getModel();
        int row = jTable1.getSelectedRow();
        if(row != -1) {
            selectedString = (String)tableModel.getValueAt(row, 1);
        }
        tableModel.setRowCount(0);
        
        Object[] oneRow = new Object[2];
        oneRow[0] = "       --";           //Date
        if(ctrlSvcImplObj.isEmergencyStop()) {
            oneRow[1] = "isEmergencyStop";    //Message
            tableModel.addRow(oneRow);
            if(row != -1 && selectedString.equals("isEmergencyStop")) {
                row = jTable1.getRowCount() -1;
                jTable1.setRowSelectionInterval(row,row);
                row = -1 ;
            }
        }
        if(ctrlSvcImplObj.isY2LimitUp()) {
            oneRow[1] = "Y2LimitUp";    //Message
            tableModel.addRow(oneRow);   
            if(row != -1 && selectedString.equals("Y2LimitUp")) {
                row = jTable1.getRowCount() -1;
                jTable1.setRowSelectionInterval(row,row);
                row = -1 ;
            }
        }
        if(ctrlSvcImplObj.isY2LimitDown()) {
            oneRow[1] = "isY2LimitDown";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isY11LimitUp()) {
            oneRow[1] = "isY11LimitUp";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isY11LimitDwon()) {
            oneRow[1] = "isY11LimitDwon";    //Message
            tableModel.addRow(oneRow);   
        }
        if(Constant.DEBUG_this_is_TouDao == true) {
            if (ctrlSvcImplObj.isZ11LimitOut()) {
                oneRow[1] = "isZ11LimitOut";    //Message
                tableModel.addRow(oneRow);
            }
            if (ctrlSvcImplObj.isZ11LimitIn()) {
                oneRow[1] = "isZ11LimitIn";    //Message
                tableModel.addRow(oneRow);
            }
        }
        if(ctrlSvcImplObj.isX2LimitOut()) {
            oneRow[1] = "isX2LimitOut";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isX2LimitIn()) {
            oneRow[1] = "isX2LimitIn";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isX11LimitLeft()) {
            oneRow[1] = "isX11LimitLeft";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isX11LimitRight()) {
            oneRow[1] = "isX11LimitRight";    //Message
            tableModel.addRow(oneRow);   
        }
        if(Constant.DEBUG_this_is_TouDao == true) {
            if (ctrlSvcImplObj.isX12LimitLeft()) {
                oneRow[1] = "isX12LimitLeft";    //Message
                tableModel.addRow(oneRow);
            }
            if (ctrlSvcImplObj.isX12LimitRight()) {
                oneRow[1] = "isX12LimitRight";    //Message
                tableModel.addRow(oneRow);
            }
        }
        if(ctrlSvcImplObj.isServoError()) {
            oneRow[1] = "isServoError";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isTrioError()) {
            oneRow[1] = "isTrioError";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo1Err()) {
            oneRow[1] = "isServo1Err";    //Message
            tableModel.addRow(oneRow);   
            if(row != -1 && selectedString.equals("isServo1Err")) {
                row = jTable1.getRowCount() -1;
                jTable1.setRowSelectionInterval(row,row);
                row = -1 ;
            }
        }
        if(ctrlSvcImplObj.isServo2Err()) {
            oneRow[1] = "isServo2Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo3Err()) {
            oneRow[1] = "isServo3Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo4Err()) {
            oneRow[1] = "isServo4Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo5Err()) {
            oneRow[1] = "isServo1Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo6Err()) {
            oneRow[1] = "isServo6Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo7Err()) {
            oneRow[1] = "isServo7Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isServo8Err()) {
            oneRow[1] = "isServo8Err";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ1()) {
            oneRow[1] = "isFQ1";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ2()) {
            oneRow[1] = "isFQ2";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ3()) {
            oneRow[1] = "isFQ3";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ4()) {
            oneRow[1] = "isFQ4";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ5()) {
            oneRow[1] = "isFQ5";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ6()) {
            oneRow[1] = "isFQ6";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ7()) {
            oneRow[1] = "isFQ7";    //Message
            tableModel.addRow(oneRow);   
        }
        if(ctrlSvcImplObj.isFQ8()) {
            oneRow[1] = "isFQ8";    //Message
            tableModel.addRow(oneRow);
        }
        if (ctrlSvcImplObj.getAutoCheckState() == Constant.AUTO_CHECK_ERROR) {
            oneRow[1] = "Auto checking is error";    //Message
            tableModel.addRow(oneRow);
        }
    }


    class ViewRefresh extends Thread {

        private ReportError obj = null;

        public ViewRefresh(ReportError obj_) {
            this.obj = obj_;
        }

        public void run() {
                while (true) {
                    obj.refreshCurrentError();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    log.fatal(null, ex);
                }
                }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                try {
                    new ReportError().setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(ReportError.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance(); 
    private static SystemLogService  logSvc = ServiceLocator.getSystemLogService();
}
