/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui;

import com.tongrui.shangweiji.biz.PatientService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.biz.TreatmentPlanService;
import com.tongrui.shangweiji.comm.BedInfo;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.comm.CureInfo;
import com.tongrui.shangweiji.comm.CurePolar;
import com.tongrui.shangweiji.comm.DeviceInfo;
import com.tongrui.shangweiji.data.CatDeviceparamValue;
import com.tongrui.shangweiji.data.CatTreatmentCollType;
import com.tongrui.shangweiji.data.CatTreatmentPatientCase;
import com.tongrui.shangweiji.data.CatTreatmentPlan;
import com.tongrui.shangweiji.data.CatTreatmentPlanFocus;
import com.tongrui.shangweiji.data.CatTreatmentPlanFraction;
import com.tongrui.shangweiji.ui.logmanagement.LogRecorder;
import com.tongrui.shangweiji.ui.logmanagement.ReportError;
import com.tongrui.shangweiji.ui.logmanagement.ReportLog;
import com.tongrui.shangweiji.ui.parametersetting.LeadscrewCompensateParam;
import com.tongrui.shangweiji.ui.parametersetting.ParamPositionSpeedView;
import com.tongrui.shangweiji.ui.parametersetting.ChangeSourcePara;
import com.tongrui.shangweiji.ui.patientmanagement.PatientList;
import com.tongrui.shangweiji.ui.patientmanagement.PatientSelect;
import com.tongrui.shangweiji.ui.patientmanagement.TPSFileParser;
import com.tongrui.shangweiji.ui.patientmanagement.TPSTimer;
import com.tongrui.shangweiji.ui.patientmanagement.TmpDBReader;
import com.tongrui.shangweiji.ui.systemadjustment.BedPositionManual;
import com.tongrui.shangweiji.ui.systemadjustment.ChangeSource;
import com.tongrui.shangweiji.ui.systemadjustment.NutOffSet;
import com.tongrui.shangweiji.ui.systemadjustment.ReferencePoint;
import com.tongrui.shangweiji.ui.systemadjustment.SourcePartManual;
//import com.tongrui.shangweiji.ui.treatmentcontrol.ControlPanel;
import com.tongrui.shangweiji.ui.treatmentcontrol.ColorLight;
import com.tongrui.shangweiji.ui.treatmentcontrol.ImagePanel;
import com.tongrui.shangweiji.ui.treatmentcontrol.NotesJDialog;
import com.tongrui.shangweiji.ui.treatmentcontrol.SketchPanel;
import com.tongrui.shangweiji.ui.usermanagement.PasswordReset;
import common.SystemInfo;
import com.tongrui.shangweiji.ui.usermanagement.UserView;
import common.CommonMethod;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class MainWindow extends javax.swing.JFrame implements WindowListener{
    private static final Log log = LogFactory.getLog(MainWindow.class);
    public static ResourceBundle resources_cn = SystemInfo.getUserWantedResource();  //ResourceBundle.getBundle("resources_cn");
    public boolean langToggle =false;
    private static MainWindow mainWinInstance = new MainWindow();
    private static String patientIdFromDB = null;
    private static String patientNameFromDB = null;
    
    private float lowLimitX11, upLimitX11;
    private float lowLimitY11, upLimitY11;
    private float lowLimitZ11, upLimitZ11;
    private float lowLimitX12, upLimitX12;
    private float lowLimitX2, upLimitX2;
    private float lowLimitY2, upLimitY2;

    public float getLowLimitX11() {
        return lowLimitX11;
    }

    public float getLowLimitX12() {
        return lowLimitX12;
    }

    public float getLowLimitX2() {
        return lowLimitX2;
    }

    public float getLowLimitY11() {
        return lowLimitY11;
    }

    public float getLowLimitY2() {
        return lowLimitY2;
    }

    public float getLowLimitZ11() {
        return lowLimitZ11;
    }

    public float getUpLimitX11() {
        return upLimitX11;
    }

    public float getUpLimitX12() {
        return upLimitX12;
    }

    public float getUpLimitX2() {
        return upLimitX2;
    }

    public float getUpLimitY11() {
        return upLimitY11;
    }

    public float getUpLimitY2() {
        return upLimitY2;
    }

    public float getUpLimitZ11() {
        return upLimitZ11;
    }
    
    SketchPanel sketchPanel = null;
    public static ResourceBundle getResources_cn() {
        return resources_cn;
    }

    public static void setResources_cn(ResourceBundle resources_cn) {
        MainWindow.resources_cn = resources_cn;
    }

    public static String getPatientIdFromDB() {
        return patientIdFromDB;
    }

    public static String getPatientNameFromDB() {
        return patientNameFromDB;
    }

    /**
     * Creates new form MainWindow
     */
    public MainWindow() {

        initComponents();

        addWindowListener(this); //添加监听函数，引发WindowEvent事件
        setPatientEmpty();

        Font ft = new Font("宋体", 0, 24);
        jTable1.getTableHeader().setFont(ft);
        ListSelectionModel selectionMode = jTable1.getSelectionModel();
        selectionMode.addListSelectionListener(new TableListSelectionListener());

        jPanel9.add(new ImagePanel());
        sketchPanel = new SketchPanel();
        jPanel9.add(sketchPanel);

        if (Constant.DEBUG_this_is_TouDao == true) {
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            jLabel33.setVisible(false);
            jTextField18.setVisible(false);
            jTextField19.setVisible(false);
            jTextField20.setVisible(false);
        } else { //if it's TiDao
            deformationLabel.setVisible(false);
            deformation.setVisible(false);
            jLabel15.setVisible(false);
            jLabel16.setVisible(false);
            jLabel9.setVisible(false);
            jLabel10.setVisible(false);
            jTextField9.setVisible(false);
            jTextField10.setVisible(false);
            jPanel14.setVisible(false);
            jPanel15.setVisible(false);
            jLabel14.setText("X(mm)");
            jLabel3.setText("Y(mm)");
            jLabel4.setText("Z(mm)");
            jLabel6.setText("床位左右");
            jLabel7.setText("床位上下");
            DefaultTableModel d_model = (DefaultTableModel) jTable1.getModel();
            d_model.setColumnCount(6);
        }

        if (SystemInfo.getCurrentUser() != null) { //wys.Only for debug
            jLabel31.setText(SystemInfo.getCurrentUser().getUserName());
            if (SystemInfo.getCurrentUser().getCatAccRole().getRoleName().equalsIgnoreCase("Operator")) {
                paramSettingMenu.setEnabled(false);
                systemAdjustmentMenu.setEnabled(false);
                jMenuItem2.setEnabled(false);
            }
            if (SystemInfo.getCurrentUser().getCatAccRole().getRoleName().equalsIgnoreCase("Manager")) {
                paramSettingMenu.setEnabled(false);
                jMenuItem8.setEnabled(false);
                jMenuItem9.setEnabled(false);
                jMenuItem11.setEnabled(false);
                jMenuItem12.setEnabled(false);
            }
        }

        initLimits();
        new ReadIdCard();
       // new LowComputerRefresh().start();
    }

    private void initLimits() {
        List<CatDeviceparamValue> paramList;
        paramList = ServiceLocator.getParameterService().findByTypeName("axiles_range");
        if (paramList == null || paramList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,程序将退出!");
            System.exit(0);
        } else {
            for (int i = 0; i < paramList.size(); i++) {
                CatDeviceparamValue param = paramList.get(i);
                String name = param.getName();
                float upLimit = 10;
                float lowLimit = 10;
                if (param.getUplimit() != null) {
                    upLimit = param.getUplimit();
                }
                if (param.getLowlimit() != null) {
                    lowLimit = param.getLowlimit();
                }

                setLimits(name, upLimit, lowLimit);
            }
        }
    }

    private void setLimits(String name, float up, float low) {
        if (name.equals("X11")) {
            lowLimitX11 = low;
            upLimitX11 = up;
        } else if (name.equals("Y11")) {
            lowLimitY11 = low;
            upLimitY11 = up;
        } else if (name.equals("Z11")) {
            lowLimitZ11 = low;
            upLimitZ11 = up;
        } else if (name.equals("X12")) {
            lowLimitX12 = low;
            upLimitX12 = up;
        } else if (name.equals("X2")) {
            lowLimitX2 = low;
            upLimitX2 = up;
        } else if (name.equals("Y2")) {
            lowLimitY2 = low;
            upLimitY2 = up;
        }
    }

    private void setPatientEmpty() {
        //Person information
        idField.setText("");
        name.setText("");
        sex.setText("");
        age.setText("");
        batch.setText("");

        //Bed target position
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");

        //Cure focus information
        jTextField4.setText("");
        jTextField16.setText("");
        jTextField17.setText("");
        jTextField5.setText("");

    }

    @Override
    public void windowOpened(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        //wys!!!.if it's curing, can't exit
        System.exit(0);
        int result = JOptionPane.showConfirmDialog(this, "确定要退出系统吗?", "询问", JOptionPane.YES_NO_OPTION);
        if (result == 0) //Select Yes
        {
            System.exit(0);
        }
        //else
        //do nothing
    }

    @Override
    public void windowClosed(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowIconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowActivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    class TableListSelectionListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {

            int[] rows = jTable1.getSelectedRows();
            if (rows.length < 1) {
                return;
            }

            //update bed target info
            String x = String.valueOf(jTable1.getValueAt(rows[0], 1));
            String y = String.valueOf(jTable1.getValueAt(rows[0], 2));
            String z = String.valueOf(jTable1.getValueAt(rows[0], 3));
            jTextField1.setText(x);
            jTextField2.setText(y);
            jTextField3.setText(z);

            //更新右边靶点信息
            Integer focusIdx = Integer.valueOf(jTable1.getValueAt(rows[0], 0).toString());
            Integer focusCount = jTable1.getRowCount();
            Integer collIdx = Integer.valueOf(jTable1.getValueAt(rows[0], 4).toString());
            double planPeriod = Double.valueOf(jTable1.getValueAt(rows[0], 5).toString());
            CatTreatmentCollType collType = ServiceLocator.getCollTypeService().findById(collIdx);
            jTextField4.setText("".format("%s/%s", focusIdx, focusCount));
            jTextField16.setText(collIdx.toString());
            jTextField17.setText("".format("%s", collType.getSize()));
            jTextField5.setText("".format("%s", planPeriod));

            int persent = (int) 100.0 * focusIdx / focusCount;
            if (persent > 100) {
                persent = 100;
            }
            jProgressBar1.setValue(persent);
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
        java.awt.GridBagConstraints gridBagConstraints;

        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem3 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem12 = new javax.swing.JCheckBoxMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        batchLabel = new javax.swing.JLabel();
        idButton5 = new javax.swing.JButton();
        idField = new javax.swing.JTextField();
        patientLabel = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        batch = new javax.swing.JLabel();
        sex = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTextField8 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel11 = new ColorLight(Color.GRAY, false, 10);
        jPanel12 = new ColorLight(Color.GREEN, true, 10);
        jPanel13 = new ColorLight(Color.GRAY, false, 10);
        jPanel14 = new ColorLight(Color.GREEN, true, 10);
        jPanel15 = new ColorLight(Color.GREEN, true, 10);
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        deformationLabel = new javax.swing.JLabel();
        deformation = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel18 = new ColorLight(Color.RED, false, 10);
        ;
        jProgressBar2 = new javax.swing.JProgressBar();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jTextField14 = new javax.swing.JTextField();
        jPanel19 = new ColorLight(Color.RED, false, 10);
        ;
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jTextField16 = new javax.swing.JTextField();
        jTextField17 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        cureHeadState1 = new com.tongrui.shangweiji.ui.treatmentcontrol.CureHeadState();
        collimateState1 = new com.tongrui.shangweiji.ui.treatmentcontrol.CollimateState();
        jPanel20 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        userMgtMenu = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        PatientPlanMgtMenu = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        treatmentMgtMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        paramSettingMenu = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        systemAdjustmentMenu = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        logMenu = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem14 = new javax.swing.JMenuItem();
        systemConfigMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();

        jCheckBoxMenuItem2.setSelected(true);
        jCheckBoxMenuItem2.setText(resources_cn.getString("JCHECKBOXMENUITEM2")); // NOI18N

        jCheckBoxMenuItem3.setSelected(true);
        jCheckBoxMenuItem3.setText(resources_cn.getString("JCHECKBOXMENUITEM3")); // NOI18N

        jCheckBoxMenuItem12.setSelected(true);
        jCheckBoxMenuItem12.setText(resources_cn.getString("JCHECKBOXMENUITEM12")); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(resources_cn.getString("main.title")); // NOI18N

        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setPreferredSize(new java.awt.Dimension(1850, 1080));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel6.setEnabled(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(900, 110));

        batchLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources_cn"); // NOI18N
        batchLabel.setText(bundle.getString("treatment.control.batch")); // NOI18N

        idButton5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        idButton5.setText(bundle.getString("treatment.control.idinput")); // NOI18N
        idButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idButton5inputID(evt);
            }
        });

        idField.setBackground(new java.awt.Color(204, 204, 204));
        idField.setEditable(false);
        idField.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        idField.setText("12345678");
        idField.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        idField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        idField.setEnabled(false);
        idField.setMinimumSize(new java.awt.Dimension(100, 35));

        patientLabel.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        patientLabel.setText(bundle.getString("treatment.control.patient")); // NOI18N

        name.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        name.setText("李珍");

        batch.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        batch.setText("4/8");

        sex.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        sex.setText("女");

        age.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        age.setText("40");

        jLabel32.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel32.setText("年龄");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idButton5)
                    .addComponent(patientLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(name)
                        .addGap(96, 96, 96)
                        .addComponent(sex))
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(age)
                .addGap(152, 152, 152)
                .addComponent(batchLabel)
                .addGap(18, 18, 18)
                .addComponent(batch)
                .addGap(68, 68, 68))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idButton5)
                    .addComponent(idField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name)
                    .addComponent(patientLabel)
                    .addComponent(sex)
                    .addComponent(jLabel32)
                    .addComponent(age)
                    .addComponent(batchLabel)
                    .addComponent(batch)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jPanel6, gridBagConstraints);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setPreferredSize(new java.awt.Dimension(900, 250));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jTextField8.setBackground(new java.awt.Color(204, 204, 204));
        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField8.setText("200.0");
        jTextField8.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField8.setEnabled(false);
        jTextField8.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField8.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField8, gridBagConstraints);

        jTextField7.setBackground(new java.awt.Color(204, 204, 204));
        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField7.setText("200.0");
        jTextField7.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField7.setEnabled(false);
        jTextField7.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField7.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField7, gridBagConstraints);

        jTextField6.setBackground(new java.awt.Color(204, 204, 204));
        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField6.setText("200.0");
        jTextField6.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField6.setEnabled(false);
        jTextField6.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField6.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField6, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel12.setText(bundle.getString("treatment.control.tps.currentvalue")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel12, gridBagConstraints);

        jTextField2.setBackground(new java.awt.Color(204, 204, 204));
        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField2.setText("200.0");
        jTextField2.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField2.setEnabled(false);
        jTextField2.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField2.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField2, gridBagConstraints);

        jTextField3.setBackground(new java.awt.Color(204, 204, 204));
        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField3.setText("200.0");
        jTextField3.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField3.setEnabled(false);
        jTextField3.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField3.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField3, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel11.setText(bundle.getString("treatment.control.tps")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel11, gridBagConstraints);

        jTextField1.setBackground(new java.awt.Color(204, 204, 204));
        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField1.setText("200.0");
        jTextField1.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField1.setEnabled(false);
        jTextField1.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField1, gridBagConstraints);

        jPanel11.setBackground(new java.awt.Color(204, 255, 255));
        jPanel11.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel11.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel11.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel11, gridBagConstraints);

        jPanel12.setBackground(new java.awt.Color(204, 255, 255));
        jPanel12.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel12.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel12.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel12, gridBagConstraints);

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel13.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel13.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel13, gridBagConstraints);

        jPanel14.setBackground(new java.awt.Color(204, 255, 255));
        jPanel14.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel14.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel14.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel14, gridBagConstraints);

        jPanel15.setBackground(new java.awt.Color(204, 255, 255));
        jPanel15.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel15.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel15.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jPanel15, gridBagConstraints);

        jTextField9.setBackground(new java.awt.Color(204, 204, 204));
        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField9.setText("200.0");
        jTextField9.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField9.setEnabled(false);
        jTextField9.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField9.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField9, gridBagConstraints);

        jTextField10.setBackground(new java.awt.Color(204, 204, 204));
        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField10.setText("200.0");
        jTextField10.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField10.setEnabled(false);
        jTextField10.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField10.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jTextField10, gridBagConstraints);

        deformationLabel.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        deformationLabel.setText(bundle.getString("treatment.control.deformation")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(deformationLabel, gridBagConstraints);

        deformation.setBackground(new java.awt.Color(204, 204, 204));
        deformation.setEditable(false);
        deformation.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        deformation.setText("0.6");
        deformation.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        deformation.setEnabled(false);
        deformation.setMinimumSize(new java.awt.Dimension(100, 35));
        deformation.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(deformation, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel13.setText(bundle.getString("treatment.control.status")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel13, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel4.setText(bundle.getString("treatment.control.coordinate.z")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel4, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel6.setText(bundle.getString("treatment.control.head.leftright")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel7.setText(bundle.getString("treatment.control.head.updown")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel7, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel5.setText(bundle.getString("treatment.control.coordinate.name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel5, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel8.setText(bundle.getString("treatment.control.bed.inout")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel9.setText(bundle.getString("treatment.control.bed.move")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel10.setText(bundle.getString("treatment.control.mask.inout")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel10, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel2.setText(bundle.getString("treatment.control.coordinate")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel3.setText(bundle.getString("treatment.control.coordinate.y")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel3, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel14.setText(bundle.getString("treatment.control.coordinate.x")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel15.setText("X12(mm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel15, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel16.setText("Z11(mm)");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel7.add(jLabel16, gridBagConstraints);

        jLabel33.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jLabel33.setText("偏差量:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        jPanel7.add(jLabel33, gridBagConstraints);

        jTextField18.setBackground(new java.awt.Color(204, 204, 204));
        jTextField18.setEditable(false);
        jTextField18.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField18.setText("200.0");
        jTextField18.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextField18.setEnabled(false);
        jTextField18.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField18.setPreferredSize(new java.awt.Dimension(100, 35));
        jTextField18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        jPanel7.add(jTextField18, gridBagConstraints);

        jTextField19.setBackground(new java.awt.Color(204, 204, 204));
        jTextField19.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField19.setText("200.0");
        jTextField19.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField19.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        jPanel7.add(jTextField19, gridBagConstraints);

        jTextField20.setBackground(new java.awt.Color(204, 204, 204));
        jTextField20.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField20.setText("200.0");
        jTextField20.setMinimumSize(new java.awt.Dimension(100, 35));
        jTextField20.setPreferredSize(new java.awt.Dimension(100, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        jPanel7.add(jTextField20, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jPanel7, gridBagConstraints);

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel8.setMinimumSize(new java.awt.Dimension(900, 230));
        jPanel8.setPreferredSize(new java.awt.Dimension(900, 230));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jScrollPane2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jScrollPane2.setPreferredSize(new java.awt.Dimension(452, 160));

        jTable1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "靶点号：", "X(mm)", "Y(mm)", "Z(mm)", "准直器(#)", "计划辐照(Sec)", "模拟选择"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setRowHeight(40);
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setPreferredWidth(60);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
        jTable1.getColumnModel().getColumn(4).setPreferredWidth(45);
        jTable1.getColumnModel().getColumn(5).setPreferredWidth(120);
        jTable1.getColumnModel().getColumn(6).setPreferredWidth(60);

        jPanel8.add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jPanel8, gridBagConstraints);

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel9.setPreferredSize(new java.awt.Dimension(820, 410));
        jPanel9.setLayout(new java.awt.GridLayout(1, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jPanel9, gridBagConstraints);

        jPanel2.add(jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setLayout(new java.awt.GridLayout(0, 1));

        jPanel16.setLayout(null);
        jPanel16.add(jProgressBar1);
        jProgressBar1.setBounds(350, 139, 550, 30);

        jLabel17.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel17.setText(bundle.getString("treatment.control.collimator.number")); // NOI18N
        jPanel16.add(jLabel17);
        jLabel17.setBounds(34, 190, 130, 29);

        jLabel18.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel18.setText(bundle.getString("treatment.control.target")); // NOI18N
        jPanel16.add(jLabel18);
        jLabel18.setBounds(30, 140, 210, 29);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("2/3");
        jPanel16.add(jTextField4);
        jTextField4.setBounds(240, 140, 80, 35);

        jPanel18.setBackground(new java.awt.Color(204, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel18.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel18.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel18);
        jPanel18.setBounds(180, 20, 22, 20);

        jProgressBar2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jPanel16.add(jProgressBar2);
        jProgressBar2.setBounds(250, 339, 650, 30);

        jLabel19.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel19.setText(bundle.getString("treatment.control.radiation.totaltime")); // NOI18N
        jPanel16.add(jLabel19);
        jLabel19.setBounds(250, 370, 200, 29);

        jLabel20.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel20.setText(bundle.getString("treatment.control.curetime")); // NOI18N
        jPanel16.add(jLabel20);
        jLabel20.setBounds(20, 370, 200, 29);

        jLabel21.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel21.setText(bundle.getString("treatment.control.timer2")); // NOI18N
        jPanel16.add(jLabel21);
        jLabel21.setBounds(764, 370, 140, 29);

        jLabel22.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel22.setText(bundle.getString("treatment.control.timer1")); // NOI18N
        jPanel16.add(jLabel22);
        jLabel22.setBounds(510, 370, 140, 29);

        jTextField11.setEditable(false);
        jTextField11.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setText("500.00");
        jPanel16.add(jTextField11);
        jTextField11.setBounds(30, 410, 130, 35);

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.setText("500.00");
        jTextField12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField12ActionPerformed(evt);
            }
        });
        jPanel16.add(jTextField12);
        jTextField12.setBounds(280, 410, 130, 35);

        jTextField13.setEditable(false);
        jTextField13.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.setText("500.00");
        jPanel16.add(jTextField13);
        jTextField13.setBounds(510, 410, 140, 35);

        jTextField14.setEditable(false);
        jTextField14.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField14.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField14.setText("500.00");
        jPanel16.add(jTextField14);
        jTextField14.setBounds(770, 410, 130, 35);

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel19.setMinimumSize(new java.awt.Dimension(22, 22));
        jPanel19.setPreferredSize(new java.awt.Dimension(22, 22));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jPanel16.add(jPanel19);
        jPanel19.setBounds(850, 20, 22, 20);

        jLabel23.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel23.setText(bundle.getString("treatment.control.devicegate")); // NOI18N
        jPanel16.add(jLabel23);
        jLabel23.setBounds(30, 10, 120, 29);

        jLabel24.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel24.setText(bundle.getString("treatment.control.roomgate")); // NOI18N
        jPanel16.add(jLabel24);
        jLabel24.setBounds(670, 10, 144, 29);

        jLabel25.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel25.setText(bundle.getString("treatment.control.radiation.time")); // NOI18N
        jPanel16.add(jLabel25);
        jLabel25.setBounds(20, 340, 110, 29);

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField5.setText("400.00");
        jPanel16.add(jTextField5);
        jTextField5.setBounds(670, 230, 105, 35);

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField15.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField15.setText("系统正常");
        jPanel16.add(jTextField15);
        jTextField15.setBounds(15, 53, 890, 35);

        jTextField16.setEditable(false);
        jTextField16.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField16.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField16.setText("3");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });
        jPanel16.add(jTextField16);
        jTextField16.setBounds(30, 230, 90, 35);

        jTextField17.setEditable(false);
        jTextField17.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jTextField17.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField17.setText("20");
        jPanel16.add(jTextField17);
        jTextField17.setBounds(350, 230, 144, 35);

        jLabel26.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel26.setText(bundle.getString("treatment.control.plantime")); // NOI18N
        jPanel16.add(jLabel26);
        jLabel26.setBounds(660, 190, 204, 29);

        jLabel27.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel27.setText(bundle.getString("treatment.control.collimator.diameter")); // NOI18N
        jPanel16.add(jLabel27);
        jLabel27.setBounds(340, 190, 168, 29);

        jPanel5.add(jPanel16);

        jPanel17.setLayout(new java.awt.GridLayout(1, 0));
        jPanel17.add(cureHeadState1);
        jPanel17.add(collimateState1);

        jButton1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton1.setText(bundle.getString("treatment.control.reset")); // NOI18N
        jButton1.setEnabled(false);
        jButton1.setPreferredSize(new java.awt.Dimension(130, 40));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton2.setText(bundle.getString("treatment.control.remark")); // NOI18N
        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(130, 40));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton3.setText(bundle.getString("treatment.control.pause")); // NOI18N
        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(130, 40));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton4.setText(bundle.getString("treatment.control.selfcheck")); // NOI18N
        jButton4.setEnabled(false);
        jButton4.setPreferredSize(new java.awt.Dimension(130, 40));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton5.setText("启动拍片");

        jButton6.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jButton6.setText("偏差修正");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap(90, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addGap(87, 87, 87))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 88, Short.MAX_VALUE)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 88, Short.MAX_VALUE)))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addContainerGap(388, Short.MAX_VALUE))
            .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel20Layout.createSequentialGroup()
                    .addGap(0, 162, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(11, 11, 11)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 162, Short.MAX_VALUE)))
        );

        jPanel17.add(jPanel20);

        jPanel5.add(jPanel17);

        jPanel2.add(jPanel5);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jPanel21.setLayout(new javax.swing.BoxLayout(jPanel21, javax.swing.BoxLayout.LINE_AXIS));

        jLabel28.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel28.setText("状态：");
        jPanel21.add(jLabel28);

        jLabel29.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel29.setText("模拟状态 UPS供电");
        jPanel21.add(jLabel29);

        jLabel35.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 51));
        jLabel35.setText("不能存库的错误");
        jPanel21.add(jLabel35);

        jPanel3.add(jPanel21);

        jPanel22.setLayout(new javax.swing.BoxLayout(jPanel22, javax.swing.BoxLayout.LINE_AXIS));

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jPanel22.add(jLabel1);

        jLabel30.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel30.setText("登陆人：");
        jPanel22.add(jLabel30);

        jLabel31.setFont(new java.awt.Font("宋体", 0, 24)); // NOI18N
        jLabel31.setText("李医生");
        jPanel22.add(jLabel31);

        jPanel3.add(jPanel22);

        jPanel1.add(jPanel3, java.awt.BorderLayout.SOUTH);

        jScrollPane1.setViewportView(jPanel1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        userMgtMenu.setText(resources_cn.getString("main.menu.usermgt")); // NOI18N
        userMgtMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem2.setText("用户浏览");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        userMgtMenu.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem3.setText("密码更改");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        userMgtMenu.add(jMenuItem3);

        jMenuBar1.add(userMgtMenu);

        PatientPlanMgtMenu.setText(resources_cn.getString("main.menu.patientPlan")); // NOI18N
        PatientPlanMgtMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        PatientPlanMgtMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PatientPlanMgtMenuActionPerformed(evt);
            }
        });

        jMenuItem4.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem4.setText("患者浏览");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        PatientPlanMgtMenu.add(jMenuItem4);

        jMenuBar1.add(PatientPlanMgtMenu);

        treatmentMgtMenu.setText(resources_cn.getString("main.menu.treatmentControl")); // NOI18N
        treatmentMgtMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem1.setText("患者选择");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        treatmentMgtMenu.add(jMenuItem1);

        jMenuBar1.add(treatmentMgtMenu);

        paramSettingMenu.setText(resources_cn.getString("main.menu.paramSetting")); // NOI18N
        paramSettingMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem5.setText("位置和速度");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        paramSettingMenu.add(jMenuItem5);

        jMenuItem6.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem6.setText("螺距补偿");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        paramSettingMenu.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem7.setText("换源参数");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        paramSettingMenu.add(jMenuItem7);

        jMenuBar1.add(paramSettingMenu);

        systemAdjustmentMenu.setText(resources_cn.getString("main.menu.systemAdjust")); // NOI18N
        systemAdjustmentMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        jMenuItem8.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem8.setText("床位手动");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        systemAdjustmentMenu.add(jMenuItem8);

        jMenuItem9.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem9.setText("射源体手动");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        systemAdjustmentMenu.add(jMenuItem9);

        jMenuItem10.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem10.setText("参考点检测");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        systemAdjustmentMenu.add(jMenuItem10);

        jMenuItem11.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem11.setText("螺距补偿");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        systemAdjustmentMenu.add(jMenuItem11);

        jMenuItem12.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem12.setText("换源操作");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        systemAdjustmentMenu.add(jMenuItem12);

        jMenuBar1.add(systemAdjustmentMenu);

        logMenu.setText(resources_cn.getString("main.menu.logWarning")); // NOI18N
        logMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N

        jMenuItem13.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem13.setText("报警显示");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        logMenu.add(jMenuItem13);

        jMenuItem14.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jMenuItem14.setText("日志查询");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        logMenu.add(jMenuItem14);

        jMenuBar1.add(logMenu);

        systemConfigMenu.setText(resources_cn.getString("main.menu.sysConfig")); // NOI18N
        systemConfigMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        systemConfigMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                systemConfigMenuActionPerformed(evt);
            }
        });
        jMenuBar1.add(systemConfigMenu);

        helpMenu.setText(bundle.getString("main.menu.help")); // NOI18N
        helpMenu.setFont(new java.awt.Font("宋体", 1, 24)); // NOI18N
        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void systemConfigMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_systemConfigMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_systemConfigMenuActionPerformed

    private void PatientPlanMgtMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PatientPlanMgtMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PatientPlanMgtMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        PatientSelect ps = null;
        ps = PatientSelect.getInstance();
        if (ps != null) {
            ps.setVisible(true);
            ps.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void idButton5inputID(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idButton5inputID
        String idString = JOptionPane.showInputDialog(this, "输入患者ID", "输入", JOptionPane.PLAIN_MESSAGE);
        boolean inputValid = CommonMethod.checkIntFromTextField(idString, this);
        if (!inputValid) {
            return;
        }

        updateBy_PCard(idString);
    }//GEN-LAST:event_idButton5inputID

    public void updateBy_PCard(String pID) {
        idField.setText(pID);
        CatTreatmentPatientCase patientCase = null;

        patientCase = patientSvc.findByPatientID(pID.trim());
        if (patientCase != null) {
            loadPatientInfo(patientCase);

            Set<CatTreatmentPlan> plans = patientCase.getCatTreatmentPlans();
            if (plans.size() > 1) {
                PatientSelect ps = new PatientSelect(this, patientCase);
                ps.setVisible(true);
            } else if (plans.size() == 1) {
                loadFocusTable(plans.iterator().next());
            } else {
                JOptionPane.showMessageDialog(this, "没找到患者的计划数据!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "库中没找到患者数据!");
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ctrlSvcImplObj.sendCommand(Constant.REFERENCE_DEVICE_BACK);
        System.out.println("sendCommand(Constant.REFERENCE_DEVICE_BACK)");
}//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //NotesJDialog notes_ui= new NotesJDialog(new JFrame(),true); 
        NotesJDialog notes_ui = new NotesJDialog(null, true);
        notes_ui.setTitle("备注信息");
        notes_ui.setLocationRelativeTo(null);
        notes_ui.setAlwaysOnTop(true);
        notes_ui.setVisible(true);
}//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ctrlSvcImplObj.sendCommand(Constant.CURE_AUTO_SUSPEND);
        System.out.println("sendCommand(Constant.CURE_AUTO_SUSPEND)");
}//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int result = JOptionPane.showConfirmDialog(this, "确定要自检吗?");
        if (result == 0) { //if Yes
            ctrlSvcImplObj.sendCommand(Constant.CURE_AUTO_CHECK);
            System.out.println("sendCommand(Constant.CURE_AUTO_CHECK)");
        }
}//GEN-LAST:event_jButton4ActionPerformed

    private void jTextField12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12ActionPerformed

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        UserView userViewWindow = UserView.getInstance();
        if (SystemInfo.getCurrentUser() != null) { //wys.Only for debug
            String roleName = SystemInfo.getCurrentUser().getCatAccRole().getRoleName();
            try {
                this.setCursor(Cursor.WAIT_CURSOR);
                if (roleName.equals("Engineer")) {
                    userViewWindow.loadRows2UserListTable(0);
                } else if (roleName.equals("Manager")) {
                    userViewWindow.loadRows2UserListTable(1);
                }
                userViewWindow.setVisible(true);
            } catch (Throwable ex) {
                Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
            }
            userViewWindow.setExtendedState(JFrame.NORMAL);
            this.setCursor(Cursor.DEFAULT_CURSOR);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        PasswordReset pwr = null;
        pwr = PasswordReset.getInstance();
        if(pwr != null) {
            pwr.setLocationRelativeTo(null);  //Display at screen center
            pwr.setVisible(true);
            pwr.setExtendedState(JFrame.NORMAL);
        }
        pwr.setExtendedState(Frame.NORMAL);  //Restore to display after minilized
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);

        PatientList pl = null;
        pl = PatientList.getInstance();
        if (pl != null) {
            pl.setVisible(true);
            pl.setExtendedState(JFrame.NORMAL);
        }

        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        this.setCursor(Cursor.WAIT_CURSOR);
        ParamPositionSpeedView paramPositionSpeedWin = null;
        paramPositionSpeedWin = ParamPositionSpeedView.getInstance();
        if(paramPositionSpeedWin != null) {
            paramPositionSpeedWin.setVisible(true);
            paramPositionSpeedWin.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        this.setCursor(Cursor.WAIT_CURSOR);
        // TODO add your handling code here:
        LeadscrewCompensateParam leadscrewCompensateParam = null;
        leadscrewCompensateParam = LeadscrewCompensateParam.getInstance();
        if(leadscrewCompensateParam != null) {
            leadscrewCompensateParam.setVisible(true);
            leadscrewCompensateParam.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        ChangeSourcePara changeSourcePara = null;
        changeSourcePara = ChangeSourcePara.getInstance();
        if(changeSourcePara != null) {
            changeSourcePara.setVisible(true);
            changeSourcePara.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        BedPositionManual bedPos = null;
        bedPos = BedPositionManual.getInstance();
        if(bedPos != null) {
            bedPos.setVisible(true);
            bedPos.setExtendedState(JFrame.NORMAL);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        // TODO add your handling code here:
        SourcePartManual spm = null;
        spm = SourcePartManual.getInstance();
        if(spm != null) {
            spm.setVisible(true);
            spm.setExtendedState(JFrame.NORMAL);
        }
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        this.setCursor(Cursor.WAIT_CURSOR);
        // TODO add your handling code here:
        ReferencePoint rp = null;
        rp = ReferencePoint.getInstance();
        if(rp != null) {
            rp.setVisible(true);
            rp.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        NutOffSet manualScrew = null;
        manualScrew = NutOffSet.getInstance();
        if(manualScrew != null) {
            manualScrew.setVisible(true);
            manualScrew.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        ChangeSource manaulChgSource = null;
        manaulChgSource = ChangeSource.getInstance();
        if(manaulChgSource != null) {
            manaulChgSource.setVisible(true);
            manaulChgSource.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        ReportError reportError = null;
        reportError = ReportError.getInstatnce();
        if(reportError != null) {
            reportError.setVisible(true);
            reportError.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here:
        this.setCursor(Cursor.WAIT_CURSOR);
        ReportLog reportLog = null;
        reportLog = ReportLog.getInstatnce();
        if(reportLog != null) {
            reportLog.setVisible(true);
            reportLog.setExtendedState(JFrame.NORMAL);
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jTextField18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField18ActionPerformed

    //按修改后的方案,刷卡自动调患者数据,这个函数就没有用了.
    public void loadPatientInfoByPlanId(int pId) throws Throwable {
        CatTreatmentPlan plan = planSvc.findById(pId);
        CatTreatmentPatientCase patientCase = plan.getCatTreatmentPatientCase();

        loadPatientInfo(patientCase);
        loadFocusTable(plan);
    }

    private void loadPatientInfo(CatTreatmentPatientCase patientCase) {
        patientIdFromDB = patientCase.getPatientId();
        patientNameFromDB = patientCase.getName();

        name.setText(patientNameFromDB);
        sex.setText(patientCase.getSex().toString().equals("1") ? "男" : "女");
        age.setText("" + patientCase.getAge());
        batch.setText("1/" + patientCase.getCatTreatmentPlanFractions().size());
        SystemInfo.setCurrentPlanFraction((CatTreatmentPlanFraction) patientCase.getCatTreatmentPlanFractions().toArray()[0]); //wys?.第一分次
    }

    private void loadFocusTable(CatTreatmentPlan plan) {
        CatTreatmentPlanFocus focus = null;

        DefaultTableModel d_model = (DefaultTableModel) jTable1.getModel();
        Iterator<CatTreatmentPlanFraction> fractions = plan.getCatTreatmentPlanFractions().iterator();

        while (fractions.hasNext()) {
            CatTreatmentPlanFraction fraction = fractions.next();
            Iterator<CatTreatmentPlanFocus> focuses = fraction.getCatTreatmentPlanFocuses().iterator();

            d_model.setRowCount(0);
            while (focuses.hasNext()) {
                focus = focuses.next();
                Object[] row = new Object[6];
                row[0] = focus.getFocusNumber();
                row[1] = focus.getPlanX();
                row[2] = focus.getPlanY();
                row[3] = focus.getPlanZ();
                row[4] = focus.getCollType();
                row[5] = focus.getPlanCurePeriod();
                d_model.addRow(row);
            }
            if (focus != null) {
                ctrlSvcImplObj.sendAutoCureData(focus);
            }
            break; //wys?.TBD跳过后面的分次,只用第一分次.
        }

    }
    
    class LowComputerRefresh extends Thread{      
        public void run() {
            try {
                while (true) {
                    refreshUI();
                    Thread.sleep(3000);
                }
            } catch (InterruptedException ex) {
                log.fatal(null, ex);
            }
        }
    }

    private void refreshUI() {
        ctrlSvcImplObj.updateLowComputerInfo();
        ctrlSvcImplObj.updateBedInfo();
        ctrlSvcImplObj.updateCureInfo();
        ctrlSvcImplObj.updateDeviceInfo();
        ctrlSvcImplObj.updateCurePolar();

        //左床位
        BedInfo bedinfo = ctrlSvcImplObj.getBedInfo();
        updateBedInfo(bedinfo);

        //示意图
        sketchPanel.update_graph(bedinfo.getHeadFrameLR_X11(), bedinfo.getHeadFrameUD_Y11(), bedinfo.getBedInOut_X2());

        //右靶点
        CureInfo cureInfo = ctrlSvcImplObj.getCureInfo();
        updateCureInfo(cureInfo);
        DeviceInfo deviceInfo = ctrlSvcImplObj.getDeviceInfo();
        double cureRoomShieldState = deviceInfo.getDeviceShieldState_Y2();
        double deviceShieldState = deviceInfo.getCureRoomShieldState();
        ((ColorLight) jPanel18).setClockColor(deviceShieldState > 0.0 ? Color.green : Color.red);
        ((ColorLight) jPanel19).setClockColor(cureRoomShieldState > 0.0 ? Color.green : Color.red);

        //右状态
        CurePolar curePolar = ctrlSvcImplObj.getCurePolar();
        cureHeadState1.update_date(curePolar);
        collimateState1.update_date(curePolar);

        int autoCheck = ctrlSvcImplObj.getAutoCheckState();
        if (autoCheck != Constant.AUTO_CHECK_REQUEST && autoCheck != Constant.AUTO_CHECK_ING) {
            jButton4.setEnabled(false);
        } else {
            jButton4.setEnabled(true);
        }

        if (patientIdFromDB != null) {
            jButton2.setEnabled(true);
        } else {
            jButton2.setEnabled(false);
        }

        errorCheck();
    }

    private void errorCheck() {

        TPSTimer tps = TPSTimer.getInstance();
        TPSFileParser parser = TPSFileParser.getInstanceTPS();
        TmpDBReader tmpDB = TmpDBReader.getInstanceTmpDB();

        //TPS timer
        if(tps.getStateOfTPS_DB() == Constant.RESULT_NO) {
            jLabel35.setText("不能读取TPS文件或访问本地数据库出错");
        } else if(tps.getStateOfCRC() == Constant.RESULT_NO) {
            jLabel35.setText("TPS文件CRC校验出错");
        }

        //TPS file
        else if(parser.isIsAgeOutRange()){
            jLabel35.setText("TPS中年龄超范围,解析失败!");
        } else if(parser.isIsAxilesOutRange()){
            jLabel35.setText("TPS中靶点坐标超范围,解析失败!");
        }
        
        //TPS DB
        else if(tmpDB.isIsAgeOutRange()){
            jLabel35.setText("TPS中年龄超范围,解析失败!");
        }else if(tmpDB.isIsAxilesOutRange()){
            jLabel35.setText("TPS中靶点坐标超范围,解析失败!");
        }else if(tmpDB.isIsExceptionDB()){
            jLabel35.setText("TPS临时数据库访问失败!");
        }
        
        else if(LogRecorder.getLogState() == Constant.RESULT_NO) {
            jLabel35.setText("本地数据库访问出错!");
        }
                
        //Normal for jLabel35
        else {
            jLabel35.setText("");
        }
        
        //Error state for jTextField15
        LogRecorder lr = LogRecorder.getInstantce();
        String msg = lr.getErrorState();
        if (msg.isEmpty()) {
            msg = "系统正常";
            jTextField15.setForeground(Color.black);
        } else {
            jTextField15.setForeground(Color.red);
        }
        jTextField15.setText(msg);

    }

    public void updateBedInfo(BedInfo bedInfo) {
        System.out.println("main--update bedPanel -data");
        //床位变形量
        deformation.setText(CommonMethod.dobuleToPointsString(bedInfo.getBedDifference(), 2) + "mm");

        //current
        jTextField6.setText(CommonMethod.dobuleToPointsString(bedInfo.getHeadFrameLR_X11(), 2));
        jTextField7.setText(CommonMethod.dobuleToPointsString(bedInfo.getHeadFrameUD_Y11(), 2));
        jTextField8.setText(CommonMethod.dobuleToPointsString(bedInfo.getBedInOut_X2(), 2));
        if (Constant.DEBUG_this_is_TouDao == true) {
            jTextField9.setText(CommonMethod.dobuleToPointsString(bedInfo.getBedFollowUp_X12(), 2));
            jTextField10.setText(CommonMethod.dobuleToPointsString(bedInfo.getHeadFrameInOut_Z11(), 2));
        }

        //X11 state-light
        int state = bedInfo.getHeadFrameLRState_X11();
        if (state == 0) { //stop state
            ((ColorLight) jPanel11).setArrow(false);
            ((ColorLight) jPanel11).setClockColor(Color.gray);
        } else {
            ((ColorLight) jPanel11).setArrow(true);
            ((ColorLight) jPanel11).setClockColor(Color.green);
            ((ColorLight) jPanel11).setArrowDirection(dir_LR(state));
        }

        //Y11 state-light
        state = bedInfo.getHeadFrameUDState_Y11();
        if (state == 0) { //stop state
            ((ColorLight) jPanel12).setArrow(false);
            ((ColorLight) jPanel12).setClockColor(Color.gray);
        } else {
            ((ColorLight) jPanel12).setArrow(true);
            ((ColorLight) jPanel12).setClockColor(Color.green);
            ((ColorLight) jPanel12).setArrowDirection(dir_UD(state));
        }

        //X2 state-light
        state = bedInfo.getHeadFrameInOutState_Z11();
        if (state == 0) { //stop state
            ((ColorLight) jPanel13).setArrow(false);
            ((ColorLight) jPanel13).setClockColor(Color.gray);
        } else {
            ((ColorLight) jPanel13).setArrow(true);
            ((ColorLight) jPanel13).setClockColor(Color.green);
            ((ColorLight) jPanel13).setArrowDirection(dir_IO(state));
        }

        if (Constant.DEBUG_this_is_TouDao == true) {
            //X12 state-light
            state = bedInfo.getBedFollowUpState_X12();
            if (state == 0) { //stop state
                ((ColorLight) jPanel14).setArrow(false);
                ((ColorLight) jPanel14).setClockColor(Color.gray);
            } else {
                ((ColorLight) jPanel14).setArrow(true);
                ((ColorLight) jPanel14).setClockColor(Color.green);
                ((ColorLight) jPanel14).setArrowDirection(dir_LR(state));
            }

            //Z11 state-light
            state = bedInfo.getHeadFrameInOutState_Z11();
            if (state == 0) { //stop state
                ((ColorLight) jPanel15).setArrow(false);
                ((ColorLight) jPanel15).setClockColor(Color.gray);
            } else {
                ((ColorLight) jPanel15).setArrow(true);
                ((ColorLight) jPanel15).setClockColor(Color.green);
                ((ColorLight) jPanel15).setArrowDirection(dir_IO(state));
            }
        }
    }

    public void updateCureInfo(CureInfo cureInfo) {
        System.out.println("main--update CureInfo -data: ");
        jTextField11.setText(CommonMethod.dobuleToPointsString(cureInfo.getAccumulateCurePeriod(), 2));
        jTextField12.setText(CommonMethod.dobuleToPointsString(cureInfo.getAccumulateRadiatePeriod(), 2));
        jTextField13.setText(CommonMethod.dobuleToPointsString(cureInfo.getRadioTimer1(), 2));
        jTextField14.setText(CommonMethod.dobuleToPointsString(cureInfo.getRadioTimer2(), 2));

        String st = jTextField5.getText();
        if (CommonMethod.checkDoubleFromTextField(st, false)) {  //Incase jTextField5 is empty
            double planPeriod = Double.valueOf(st);
            int persent = (int) (100 * cureInfo.getRadioTimer1() / planPeriod);
            if (persent > 100) {
                persent = 100;
            }
            jProgressBar2.setValue(persent);
        } else {
            jProgressBar2.setValue(0);
        }
    }

    private double dir_LR(int state) {
        double result = 0;
        switch (state) {
            case 1: { //Positive direction
                result = 3.0;
                break;
            }
            case 2: { //Negitive direction
                result = 9.0;
                break;
            }
        }
        return result;
    }

    private double dir_UD(int state) {
        double result = 0;
        switch (state) {
            case 1: { //Positive direction
                result = 0.0;
                break;
            }
            case 2: { //Negitive direction
                result = 6.0;
                break;
            }
        }
        return result;
    }

    private double dir_IO(int state) {
        double result = 0;
        switch (state) {
            case 1: { //Positive direction
                result = 7.5;
                break;
            }
            case 2: { //Negitive direction
                result = 1.5;
                break;
            }
        }
        return result;
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
                if (resources_cn.getString("NIMBUS").equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                mainWinInstance.setResources_cn(ResourceBundle.getBundle("resources_cn"));
                mainWinInstance.setVisible(true);
            }
        });
    }

    public static MainWindow getInstance() {
        return mainWinInstance;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu PatientPlanMgtMenu;
    private javax.swing.JLabel age;
    private javax.swing.JLabel batch;
    private javax.swing.JLabel batchLabel;
    private com.tongrui.shangweiji.ui.treatmentcontrol.CollimateState collimateState1;
    private com.tongrui.shangweiji.ui.treatmentcontrol.CureHeadState cureHeadState1;
    private javax.swing.JTextField deformation;
    private javax.swing.JLabel deformationLabel;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JButton idButton5;
    private javax.swing.JTextField idField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem12;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JMenu logMenu;
    private javax.swing.JLabel name;
    private javax.swing.JMenu paramSettingMenu;
    private javax.swing.JLabel patientLabel;
    private javax.swing.JLabel sex;
    private javax.swing.JMenu systemAdjustmentMenu;
    private javax.swing.JMenu systemConfigMenu;
    private javax.swing.JMenu treatmentMgtMenu;
    private javax.swing.JMenu userMgtMenu;
    // End of variables declaration//GEN-END:variables
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance();
    private static TreatmentPlanService planSvc = ServiceLocator.getTreatmentPlanService();
    private static PatientService patientSvc = ServiceLocator.getPatientService();
}
