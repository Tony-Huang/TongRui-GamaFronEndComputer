/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.data.*;
import common.DateUtil;
import common.TableUtil;
//import com.tongrui.shangweiji.data.CatTreatmentPlanFocus
import java.awt.Font;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class PatientDetail extends JFrame {
    private static PatientDetail patientDetail = null;
    
    public static PatientDetail getInstatnce(CatTreatmentPatientCase patient) {
        if(patientDetail != null) {
            patientDetail.dispose();
        }
        patientDetail = new PatientDetail(patient);
        return patientDetail;
    }

    private CatTreatmentPatientCase patient;
    private CatTreatmentPlan defaultPlan;
    private CatTreatmentPlanFraction defaultFraction;
    private CatTreatmentPlanFocus defaultFocus;

    /**
     * Creates new form PatientDetail
     */
    public PatientDetail(CatTreatmentPatientCase patient) {
        this.patient = patient;
        initComponents();
        Font font = new Font("宋体", 0, 24);
        focusTable.getTableHeader().setFont(font);
        fractionTable.getTableHeader().setFont(font);
        patientTable.getTableHeader().setFont(font);
        planTable.getTableHeader().setFont(font);

        initPatient();
        initPlan();
        initFraction();
        initFocus();

        initTableListeners();
        this.setLocationRelativeTo(null);
    }

    private void initTableListeners() {
        this.fractionTable.getSelectionModel().addListSelectionListener(new FracSelectionListener());
        this.planTable.getSelectionModel().addListSelectionListener(new PlanSelectionListener());
    }

    class PlanSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {
            if (e.getValueIsAdjusting() == false) {
                int selrow = planTable.getSelectedRow();
                if (selrow < 0) {
                    return;
                }
                Integer planId = (Integer) planTable.getValueAt(selrow, 0);
                System.out.println("selected plan id =" + planId);

                Set<CatTreatmentPlan> plans = patient.getCatTreatmentPlans();
                Iterator<CatTreatmentPlan> it = plans.iterator();
                while (it.hasNext()) {
                    CatTreatmentPlan pl = it.next();
                    if (pl.getId().equals(planId)) {
                        defaultPlan = pl;
                    }
                }

                initFraction();
                initFocus();
                System.out.println("selected plan=" + planId + " --selectRow=" + selrow);

            }

        }
    }

    class FracSelectionListener implements ListSelectionListener {

        public void valueChanged(ListSelectionEvent e) {

            if (e.getValueIsAdjusting() == false) {
                int selrow = fractionTable.getSelectedRow();
                if (selrow < 0) {
                    return;
                }
                Integer fracId = (Integer) fractionTable.getValueAt(selrow, 0);


                Set<CatTreatmentPlanFraction> fracs = defaultPlan.getCatTreatmentPlanFractions();
                Iterator<CatTreatmentPlanFraction> it = fracs.iterator();
                while (it.hasNext()) {
                    CatTreatmentPlanFraction frac = it.next();
                    if (frac.getFractionNomber().equals(fracId)) {
                        defaultFraction = frac;
                    }
                }

                initFocus();
                System.out.println("selected Fracid=" + fracId + " --selectRow=" + selrow);

            }
        }
    }

    void initPatient() {
        System.out.println("------init patient:" + patient.getName());
        DefaultTableModel mod = (DefaultTableModel) this.patientTable.getModel();
        Object[] row = generateRowByPatient(this.patient);
        mod.addRow(row);
    }

    private Object[] generateRowByPatient(CatTreatmentPatientCase patient) {
        Object[] row = new Object[8];
        row[0] = patient.getPatientId();
        row[1] = patient.getName();
        row[2] = patient.getSex() == 1 ? "男" : "女";
        row[3] = patient.getAge();
        row[4] = patient.getHeight();
        row[5] = patient.getWeight();
        row[6] = patient.getPhone();
        row[7] = patient.getAddress();

        return row;
    }

    void initPlan() {
        System.out.println("------init plans:");
        TableUtil.clearTableData(planTable);
        DefaultTableModel mod = (DefaultTableModel) this.planTable.getModel();
        CatTreatmentPlan plan = null;

        //get plans...
        Set<CatTreatmentPlan> plans = patient.getCatTreatmentPlans();
        TreeSet<CatTreatmentPlan> sortplans = new TreeSet(plans);
        Iterator<CatTreatmentPlan> it = sortplans.iterator();
        while (it.hasNext()) {
            plan = it.next();
            //generate row
            Object[] row = generateRowByPlan(plan);
            mod.addRow(row);
        }

        if (sortplans.size() > 0) {
            this.defaultPlan = sortplans.first();
            System.out.println("------default plan:" + defaultPlan.getId());
        }

    }

    private Object[] generateRowByPlan(CatTreatmentPlan plan) {
        Object[] row = new Object[12];
        row[0] = plan.getId();//plan.getSerialNumber();
        row[1] = plan.getCourseNumber();
        try {
            row[2] = PatientList.getTreatmentCount(plan.getId());
            row[3] = PatientList.getTreeatedCount(plan.getId());
        } catch (Throwable e) {
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
        }
        row[4] = plan.getFocusCount();
        row[5] = plan.getDose();
        row[6] = plan.getReferper();
        row[7] = plan.getDoctorName();
        row[8] = DateUtil.getDateString(plan.getPlanDate());
        row[9] = DateUtil.getDateString(plan.getPlanLockDate());
        row[10] = plan.getApprovalDoctorName();
        row[11] = plan.getApprovalDate();

        return row;
    }

    void initFraction() {
        System.out.println("------init fractions:");
        TableUtil.clearTableData(fractionTable);

        DefaultTableModel mod = (DefaultTableModel) this.fractionTable.getModel();
        if (defaultPlan == null) {
            return;
        }
        Set<CatTreatmentPlanFraction> fractions = defaultPlan.getCatTreatmentPlanFractions();
        TreeSet<CatTreatmentPlanFraction> sortfractions = new TreeSet(fractions);
        Iterator<CatTreatmentPlanFraction> it = sortfractions.iterator();
        while (it.hasNext()) {
            CatTreatmentPlanFraction frac = it.next();
            Object[] row = generateRowByFraction(frac);
            mod.addRow(row);
        }

        if (sortfractions.size() > 0) {
            this.defaultFraction = sortfractions.first();
            System.out.println("defaultFraction=" + defaultFraction.getId());

        }

    }

    private Object[] generateRowByFraction(CatTreatmentPlanFraction frac) {
        Object[] row = new Object[8];
        row[0] = frac.getFractionNomber();
        row[1] = DateUtil.getDateString(frac.getDueDate());
        row[2] = frac.getFractionNomber();
        CatTreatmentFractionState state = frac.getCatTreatmentFractionState();
        row[3] = state == null ? "" : state.getStateName();
        Byte append = frac.getIsAppended();
        if (append == null) {
            row[4] = null;
        } else {
            row[4] = (append.equals(new Byte("1")) ? true : false);
        }

        row[5] = frac.getAppendDoctorName();
        row[6] = frac.getPerformerName();
        row[7] = frac.getNotes();
        return row;
    }

    void initFocus() {
        System.out.println("------init focuses:");
        TableUtil.clearTableData(focusTable);

        DefaultTableModel mod = (DefaultTableModel) this.focusTable.getModel();
        if (defaultFraction == null) {
            return;
        }
//        Set<CatTreatmentPlanFocus> focuses = defaultFraction.getCatTreatmentPlanFocuses();
//        TreeSet<CatTreatmentPlanFocus> sortfocuses = new TreeSet(focuses);  //By HDP
//        System.out.println("defaultFrac :" + this.defaultFraction.getId());
//        Iterator<CatTreatmentPlanFocus> it = sortfocuses.iterator();
        
        Set<CatTreatmentPlanFocus> focuses = defaultFraction.getCatTreatmentPlanFocuses();
        Iterator<CatTreatmentPlanFocus> it = focuses.iterator();
        while (it.hasNext()) {
            CatTreatmentPlanFocus focus = it.next();
            Object[] row = generateRowByFocus(focus);
            mod.addRow(row);
        }
    }

    private Object[] generateRowByFocus(CatTreatmentPlanFocus focus) {
        Object[] row = new Object[9];
        row[0] = focus.getFocusNumber();
        row[1] = DateUtil.getDateTimeString(focus.getFocusStartTime());
        row[2] = DateUtil.getDateTimeString(focus.getFocusEndTime());
        row[3] = focus.getPlanX();
        row[4] = focus.getPlanY();
        row[5] = focus.getPlanZ();
        row[6] = focus.getCollType();
        row[7] = focus.getPlanCurePeriod();
        row[8] = focus.getCurePeriod();

        return row;
    }

    public CatTreatmentPatientCase getPatient() {
        return patient;
    }

    public void setPatient(CatTreatmentPatientCase patient) {
        this.patient = patient;
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
        patientDetailLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        patientScrollPane = new javax.swing.JScrollPane();
        patientTable = new javax.swing.JTable();
        planScrollPane = new javax.swing.JScrollPane();
        planTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        fractionScrollPane = new javax.swing.JScrollPane();
        fractionTable = new javax.swing.JTable();
        focusScrollPane = new javax.swing.JScrollPane();
        focusTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("患者详情");

        jPanel1.setLayout(new java.awt.BorderLayout());

        patientDetailLabel.setFont(new java.awt.Font("宋体", 1, 18));
        patientDetailLabel.setText("患者详情");
        jPanel2.add(patientDetailLabel);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 600));
        jPanel4.setPreferredSize(new java.awt.Dimension(870, 200));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));

        patientScrollPane.setFont(new java.awt.Font("宋体", 0, 18));
        patientScrollPane.setPreferredSize(new java.awt.Dimension(452, 100));
        patientScrollPane.setRequestFocusEnabled(false);

        patientTable.setFont(new java.awt.Font("宋体", 0, 24));
        patientTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "患者ID", "姓名", "性别", "年龄", "身高", "体重", "电话", "地址"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        patientScrollPane.setViewportView(patientTable);

        jPanel4.add(patientScrollPane);

        planScrollPane.setPreferredSize(new java.awt.Dimension(452, 100));

        planTable.setFont(new java.awt.Font("宋体", 0, 24));
        planTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "计划ID", "疗程", "总次数", "已治次数", "靶数", "剂量", "参考线", "计划医生", "计划日期", "锁定日期", "批准医生", "批准日期"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        planTable.setRowHeight(40);
        planTable.getTableHeader().setReorderingAllowed(false);
        planScrollPane.setViewportView(planTable);

        jPanel4.add(planScrollPane);

        jPanel3.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.Y_AXIS));

        fractionScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "分次信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        fractionTable.setFont(new java.awt.Font("宋体", 0, 24));
        fractionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "分次ID", "预施日期", "分次号", "状态", "是否追加", "追加医生", "治疗医生", "备注"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, true, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        fractionTable.setRowHeight(40);
        fractionTable.getTableHeader().setReorderingAllowed(false);
        fractionScrollPane.setViewportView(fractionTable);

        jPanel5.add(fractionScrollPane);

        focusScrollPane.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "靶点信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N

        focusTable.setFont(new java.awt.Font("宋体", 0, 24));
        focusTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "靶点号", "开始时间", "结束时间", "靶点坐标X11", "靶点坐标Y11", "靶点坐标X2", "准直器号", "计划时间(秒)", "照射时间(秒)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        focusTable.setRowHeight(40);
        focusTable.getTableHeader().setReorderingAllowed(false);
        focusScrollPane.setViewportView(focusTable);

        jPanel5.add(focusScrollPane);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(PatientDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientDetail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                // new PatientDetail().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane focusScrollPane;
    private javax.swing.JTable focusTable;
    private javax.swing.JScrollPane fractionScrollPane;
    private javax.swing.JTable fractionTable;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel patientDetailLabel;
    private javax.swing.JScrollPane patientScrollPane;
    private javax.swing.JTable patientTable;
    private javax.swing.JScrollPane planScrollPane;
    private javax.swing.JTable planTable;
    // End of variables declaration//GEN-END:variables
}
