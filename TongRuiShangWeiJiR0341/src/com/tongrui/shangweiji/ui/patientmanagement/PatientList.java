/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.PatientService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.TreatmentPlanService;
import com.tongrui.shangweiji.data.*;
import common.CommonMethod;
import common.DateUtil;
import common.TableUtil;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class PatientList extends JFrame {
    private static PatientList pList = null;
    
    public static PatientList getInstance() {
        if(pList == null) {
            try {
                pList = new PatientList();
            } catch (Throwable ex) {
                Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
            }
        }
        return pList;
    }
    
   static final int TREATED_STATE = 2;
   private CatTreatmentPatientCase selectedPatient;
   
   List<CatTreatmentPlan> planList;
    /**
     * Creates new form PatientList
     */
    public PatientList() throws Throwable {
        String name = null, startStr = null, endStr = null;
        Integer planIdInt = null;
        
        initComponents();
        Font font = new Font("宋体", 0, 24);
        patientTable.getTableHeader().setFont(font);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLocationRelativeTo(null);
         
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -7);
        startStr = (new SimpleDateFormat("yyyy-MM-dd")).format(cal.getTime());
        if(startStr != null) {
            searchStartTime.setText(startStr);
        }
        try {
            planList = planSvc.findBySearchCriteria(name, planIdInt, startStr, endStr);
        } catch (Exception e) {
            throw e;
        }
        loadData2Table();
    }
    
    private  static  TreatmentPlanService planSvc = ServiceLocator.getTreatmentPlanService();
    private static PatientService  patientSvc = ServiceLocator.getPatientService();
    
    
    /**
     * 获取已治疗次数
     * @param planId
     * @return 
     */
    static int  getTreeatedCount(int planId) throws Throwable {
        int result = 0;
        CatTreatmentPlan plan = planSvc.findById(planId);
        Set<CatTreatmentPlanFraction> fracs = plan.getCatTreatmentPlanFractions();
        Iterator<CatTreatmentPlanFraction> it = fracs.iterator();
        while (it.hasNext()) {
            CatTreatmentPlanFraction frac = it.next();
            CatTreatmentFractionState state = frac.getCatTreatmentFractionState();
            if (state != null && state.getId() != null) {
                if (state.getId() == TREATED_STATE) {
                    result++;
                }
            }

        }
        return result;
    }
    
    /**
     * 获取治疗总次数
     * @param planId
     * @return 
     */
     static int getTreatmentCount(int planId) throws Throwable {
        int result = 0;
        CatTreatmentPlan plan = planSvc.findById(planId);
        result = plan.getCatTreatmentPlanFractions().size();
        return result;
    }
    
    private void loadData2Table(){
         List<CatTreatmentPlan> pts = this.planList;
         for(int i=0;i<pts.size(); i++) {
            CatTreatmentPlan pl = pts.get(i);
            Object[] row = null;
            try {
                row = generateRowByPlan(pl);
            } catch (Throwable e) {
                JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
            }
            DefaultTableModel model = (DefaultTableModel) this.patientTable.getModel();
            model.addRow(row);
        }
         
        if(patientTable.getRowCount() > 0) {
            patientTable.setRowSelectionInterval(0, 0);
            detailBtn.setEnabled(true);
        }
    }
    
    private Object[] generateRowByPlan(CatTreatmentPlan pl) throws Throwable {
       Object[] row = new Object[11];
         int id = pl.getId();
         Integer serial=pl.getSerialNumber();
         row[0] = id; //serial
         String name = pl.getCatTreatmentPatientCase().getName();
          row[1] = name;
         Byte sexByte=  pl.getCatTreatmentPatientCase().getSex();
         String sex= sexByte ==1? "男":"女";
         row[2] =sex;
         Integer age = pl.getCatTreatmentPatientCase().getAge();
          row[3] = age;
         row[4] = getTreatmentCount(id);
         row[5] = getTreeatedCount(id);
         row[6] = pl.getDiaglose();
         row[7] = pl.getDoctorName();
         row[8] = pl.getPlanDate();
         row[9] = pl.getCatTreatmentPatientCase().getNotes();
         CatTreatmentPlanState state = pl.getCatTreatmentPlanState();
         row[10] = state==null?"":state.getStateName() ;  
       return row;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        searchPanel = new javax.swing.JPanel();
        searchPatientName = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        planIdLabel = new javax.swing.JLabel();
        searchPlanID = new javax.swing.JTextField();
        startTimeLabel = new javax.swing.JLabel();
        searchStartTime = new javax.swing.JTextField();
        endTimeLabel = new javax.swing.JLabel();
        searchEndTime = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        patientTableScrollPane = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        detailBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("患者查询");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        searchPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "查询条件", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        searchPanel.setLayout(new java.awt.GridBagLayout());

        searchPatientName.setColumns(20);
        searchPatientName.setFont(new java.awt.Font("宋体", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 4, 0, 0);
        searchPanel.add(searchPatientName, gridBagConstraints);

        nameLabel.setFont(new java.awt.Font("宋体", 0, 24));
        nameLabel.setText("患者姓名");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 50, 0, 0);
        searchPanel.add(nameLabel, gridBagConstraints);

        planIdLabel.setFont(new java.awt.Font("宋体", 0, 24));
        planIdLabel.setText("计划ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(56, 63, 0, 0);
        searchPanel.add(planIdLabel, gridBagConstraints);

        searchPlanID.setColumns(20);
        searchPlanID.setFont(new java.awt.Font("宋体", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(53, 10, 0, 0);
        searchPanel.add(searchPlanID, gridBagConstraints);

        startTimeLabel.setFont(new java.awt.Font("宋体", 0, 24));
        startTimeLabel.setText("开始时间");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 50, 0, 0);
        searchPanel.add(startTimeLabel, gridBagConstraints);

        searchStartTime.setColumns(20);
        searchStartTime.setFont(new java.awt.Font("宋体", 0, 24));
        searchStartTime.setText("2012-5-3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 4, 0, 0);
        searchPanel.add(searchStartTime, gridBagConstraints);

        endTimeLabel.setFont(new java.awt.Font("宋体", 0, 24));
        endTimeLabel.setText("截止时间");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 63, 0, 0);
        searchPanel.add(endTimeLabel, gridBagConstraints);

        searchEndTime.setColumns(20);
        searchEndTime.setFont(new java.awt.Font("宋体", 0, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 180;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 10, 0, 0);
        searchPanel.add(searchEndTime, gridBagConstraints);

        searchBtn.setFont(new java.awt.Font("宋体", 0, 24));
        searchBtn.setText("查询");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 35, 28, 255);
        searchPanel.add(searchBtn, gridBagConstraints);

        jPanel1.add(searchPanel, java.awt.BorderLayout.NORTH);

        patientTableScrollPane.setFont(new java.awt.Font("宋体", 0, 18));

        patientTable.setFont(new java.awt.Font("宋体", 0, 24));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "计划ID", "姓名", "性别", "年龄", "总次数", "已治次数", "病症", "计划医生", "批准日期", "备注", "状态"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientTable.setRowHeight(40);
        patientTable.getTableHeader().setReorderingAllowed(false);
        patientTableScrollPane.setViewportView(patientTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(patientTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1058, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 312, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(patientTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel2.setMaximumSize(new java.awt.Dimension(32767, 100));
        jPanel2.setMinimumSize(new java.awt.Dimension(115, 40));
        jPanel2.setPreferredSize(new java.awt.Dimension(778, 60));
        jPanel2.setRequestFocusEnabled(false);

        detailBtn.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        detailBtn.setText("患者详情");
        detailBtn.setEnabled(false);
        detailBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                detailBtnActionPerformed(evt);
            }
        });
        jPanel2.add(detailBtn);

        jPanel1.add(jPanel2, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1078, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void detailBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_detailBtnActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.patientTable.getSelectedRow();
        if(selectedRow>-1){
           DefaultTableModel model = (DefaultTableModel) this.patientTable.getModel();
           Integer planId = (Integer)model.getValueAt(selectedRow, 0);
           CatTreatmentPlan plan = null;
           try {
               plan = planSvc.findById(planId);  //this.planSvc.findBySerialNumber(planSerailNumber)
           } catch (Exception e) {
               e.printStackTrace();
               JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
               return;
           }
           this.selectedPatient = plan.getCatTreatmentPatientCase();
        }
        
        if(this.selectedPatient == null) {
            List<CatTreatmentPatientCase> ls = null;
            try {
                ls = patientSvc.findAll();
            } catch (Exception e) {
                e.printStackTrace();
               JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
               return;
            }
            if (ls.size() > 0) {
                selectedPatient = ls.get(0);
            }
        }
        if(selectedPatient==null) return;
         PatientDetail pd = PatientDetail.getInstatnce(selectedPatient);
         pd.setSize(800,600);
         pd.setVisible(true);
         pd.setExtendedState(JFrame.NORMAL);
    }//GEN-LAST:event_detailBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        String name = this.searchPatientName.getText();
        if (!name.isEmpty() && name.charAt(0) == ' ') {
            JOptionPane.showMessageDialog(this, "错误，姓名首字符不能为空格！");
            return;
        }

        String planId = this.searchPlanID.getText();
        CommonMethod.checkIntFromTextField(planId, this);
        Integer planIdInt = null;
        String startStr = this.searchStartTime.getText();
        String endStr = this.searchEndTime.getText();

        if (!CommonMethod.isDateStringValid(startStr) || !CommonMethod.isDateStringValid(endStr)) {
            JOptionPane.showMessageDialog(this, "错误，请输入正确的日期及格式！");
            return;
        }

        System.out.println("name=" + name + ";planId=" + planId + ";startStr=" + startStr + ";endStr=" + endStr);
        //clear old data.
        TableUtil.clearTableData(patientTable);

        if (name.equals("") && planId.equals("") && startStr.equals("") && endStr.equals("")) {
            System.out.println("search criterias are all empty!!");
            try {
                this.planList = planSvc.findAll();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
            }
            
            loadData2Table();
            return;
        }
        if (planId.equals("")) {
            planIdInt = null;
        } else {
            planIdInt = Integer.valueOf(planId.trim());
        }
        if (startStr.equals("")) {
            startStr = null;
        }
        if (endStr.equals("")) {
            endStr = null;
        } else {
            endStr = endStr.trim() + " 23:59:59";
        }

        //add searched data
        try {
            this.planList = planSvc.findBySearchCriteria(name, planIdInt, startStr, endStr);
            this.loadData2Table();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        pList = null;
    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if(pList == null) {
                    pList = PatientList.getInstance();
                }
                pList.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton detailBtn;
    private javax.swing.JLabel endTimeLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTable patientTable;
    private javax.swing.JScrollPane patientTableScrollPane;
    private javax.swing.JLabel planIdLabel;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchEndTime;
    private javax.swing.JPanel searchPanel;
    private javax.swing.JTextField searchPatientName;
    private javax.swing.JTextField searchPlanID;
    private javax.swing.JTextField searchStartTime;
    private javax.swing.JLabel startTimeLabel;
    // End of variables declaration//GEN-END:variables
}
