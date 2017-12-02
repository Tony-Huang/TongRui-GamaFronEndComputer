/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PatientSelect.java
 *
 * Created on 2012-9-21, 16:44:14
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.PatientService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.TreatmentPlanService;
import com.tongrui.shangweiji.data.*;
import com.tongrui.shangweiji.ui.MainWindow;
import common.DateUtil;
import common.SystemInfo;
import common.TableUtil;
import java.awt.Cursor;
import java.awt.Font;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class PatientSelect extends javax.swing.JFrame {
    
    private static PatientSelect pSelect = null;
    
    public static PatientSelect getInstance() {
        if(pSelect == null) {
            try {
                pSelect = new PatientSelect();
            } catch (Throwable ex) {
                Logger.getLogger(PatientSelect.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
            }
        }
        return pSelect;
    }
    
   static final int PLAN_STATE_APPROVED = 1;
   static final int PLAN_STATE_SIMULATED = 2;
   static final int PLAN_STATE_GOING = 3;
   static final int PLAN_STATE_FINISHED = 4;
   static final int PLAN_STATE_MODIFIED = 5;
   
   static final int FRACTION_STATE_TREATED = 2;
   
   MainWindow mainWin = null;
   
   List<CatTreatmentPlan> planList;
    /**
     * Creates new form PatientList
     */
    public PatientSelect() throws Throwable {
        initComponents();
        jButton1.setVisible(false);
        Font font = new Font("宋体", 0, 24);
        patientTable.getTableHeader().setFont(font);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLocationRelativeTo(null);
        
        this.setCursor(Cursor.WAIT_CURSOR);
        if (SystemInfo.getCurrentUser().getCatAccRole().getRoleName().equalsIgnoreCase("Manager")) {
                jButton2.setEnabled(true); 
        }

        try {
            planList = planSvc.findByStateId(PLAN_STATE_GOING);
            loadData2Table();
            planList = planSvc.findByStateId(PLAN_STATE_SIMULATED);
            loadData2Table();
            planList = planSvc.findByStateId(PLAN_STATE_APPROVED);
            loadData2Table();
        } catch (Exception e) {
            throw e;
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
        
        if(patientTable.getRowCount() > 0) {
            patientTable.setRowSelectionInterval(0, 0);
            jButton1.setEnabled(true);
        }
    }
    
    public PatientSelect(MainWindow mainWin,CatTreatmentPatientCase pCase) {
        initComponents();
        Font font = new Font("宋体", 0, 24);
        patientTable.getTableHeader().setFont(font);
        patientTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setLocationRelativeTo(null);
        jButton2.setVisible(false);
        jLabel1.setText("计划选择");
        
        Set<CatTreatmentPlan> plans = pCase.getCatTreatmentPlans();
        TreeSet<CatTreatmentPlan> sortplans = new TreeSet(plans);
        Iterator<CatTreatmentPlan> it = sortplans.iterator();
        while (it.hasNext()) {
            CatTreatmentPlan plan = it.next();
            //generate row
            Object[] row = generateRowByPlan(plan);
            DefaultTableModel model= (DefaultTableModel)this.patientTable.getModel();
            model.addRow(row);
        }
       
        if(patientTable.getRowCount() > 0) {
            patientTable.setRowSelectionInterval(0, 0);
            jButton1.setEnabled(true);
        }
        
        this.mainWin = mainWin;
    }
    
    private  static  TreatmentPlanService planSvc = ServiceLocator.getTreatmentPlanService();
    
    /**
     * 获取已治疗次数
     * @param planId
     * @return 
     */
    static int  getTreeatedCount(int planId){
      int result=0 ;
      CatTreatmentPlan plan= planSvc.findById(planId);
      Set<CatTreatmentPlanFraction> fracs=plan.getCatTreatmentPlanFractions();
      Iterator<CatTreatmentPlanFraction> it =fracs.iterator();
      while(it.hasNext()){
       CatTreatmentPlanFraction frac=   it.next();
       CatTreatmentFractionState state = frac.getCatTreatmentFractionState();
       if(state!=null&&state.getId()!=null){
       if(state.getId()==FRACTION_STATE_TREATED)
           result++;
         } 
       
      }
      
      return result;
    }
    
    /**
     * 获取治疗总次数
     * @param planId
     * @return 
     */
     static int getTreatmentCount(int planId){
     int result=0 ;
     CatTreatmentPlan plan= planSvc.findById(planId);
     result = plan.getCatTreatmentPlanFractions().size();
     return result;
    }
    
    private void loadData2Table(){
         List<CatTreatmentPlan> pts = this.planList;
         for(int i=0;i<pts.size();i++){
          CatTreatmentPlan pl = pts.get(i);
          Object[] row = generateRowByPlan(pl);
          DefaultTableModel model= (DefaultTableModel)this.patientTable.getModel();
          model.addRow(row);
          }
    }
    
    private Object[] generateRowByPlan(CatTreatmentPlan pl){
         Object[] row = new Object[11];
         Integer id = pl.getId();
         row[0] = id;
         row[1] = pl.getPlanName();
         String name = pl.getCatTreatmentPatientCase().getName();
         row[2] = name;
         Byte sexByte=  pl.getCatTreatmentPatientCase().getSex();
         String sex= sexByte ==1? "男":"女";
         row[3] =sex;
         Integer age = pl.getCatTreatmentPatientCase().getAge();
         row[4] = age;
         row[5] = getTreatmentCount(id);
         row[6] = getTreeatedCount(id);
         row[7] = pl.getDiaglose();
         row[8] = pl.getDoctorName();
         row[9] = pl.getPlanDate();
         //row[9] = pl.getCatTreatmentPatientCase().getNotes();
         CatTreatmentPlanState state = pl.getCatTreatmentPlanState();
         row[10] = state==null?"":state.getStateName() ;  
       return row;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        patientTableScrollPane = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setText("患者选择");
        jPanel2.add(jLabel1);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        patientTableScrollPane.setFont(new java.awt.Font("宋体", 0, 18));

        patientTable.setFont(new java.awt.Font("宋体", 0, 24));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "计划ID", "计划名", "姓名", "性别", "年龄", "总次数", "已治次数", "病症", "计划医生", "批准日期", "状态"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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

        jPanel1.add(patientTableScrollPane, java.awt.BorderLayout.CENTER);

        jButton1.setFont(new java.awt.Font("宋体", 0, 24));
        jButton1.setText("患者调入");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jButton2.setFont(new java.awt.Font("宋体", 0, 24));
        jButton2.setText("治疗更改");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.patientTable.getSelectedRow();
        if(selectedRow>-1){
           DefaultTableModel model = (DefaultTableModel) this.patientTable.getModel();
           Integer planId = (Integer)model.getValueAt(selectedRow, 0);
           try {
               this.mainWin.loadPatientInfoByPlanId(planId);
           } catch (Throwable e) {
               JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
               return;
           }
           System.out.println("Selected planId = " + planId);
        }
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int selectedRow = this.patientTable.getSelectedRow();
        if(selectedRow>-1){
           CatTreatmentPlanState planState = new CatTreatmentPlanState();
           planState.setId(PLAN_STATE_MODIFIED);
           
           DefaultTableModel model = (DefaultTableModel) this.patientTable.getModel();
           Integer planId = (Integer)model.getValueAt(selectedRow, 0);
           try {
               CatTreatmentPlan plan = planSvc.findById(planId);
               plan.setCatTreatmentPlanState(planState);
               planSvc.update(plan);
           } catch (Exception e) {
               JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
               return;
           }
           
           this.patientTable.setValueAt("计划实施更改", selectedRow, 10);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        pSelect = null;
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if(pSelect == null) {
                    try {
                        pSelect = new PatientSelect();
                    } catch (Throwable ex) {
                        Logger.getLogger(PatientSelect.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(null, "本地数据库访问出错!");
                    }
                }
                pSelect.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTable patientTable;
    private javax.swing.JScrollPane patientTableScrollPane;
    // End of variables declaration//GEN-END:variables
}
