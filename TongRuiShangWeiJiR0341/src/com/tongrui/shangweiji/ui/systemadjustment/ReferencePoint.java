/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * ReferencePoint.java
 *
 * Created on 2012-9-30, 22:02:38
 */
package com.tongrui.shangweiji.ui.systemadjustment;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.comm.BedInfo;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.comm.CureInfo;
import com.tongrui.shangweiji.comm.CurePolar;
import com.tongrui.shangweiji.comm.DeviceInfo;
import com.tongrui.shangweiji.data.CatDeviceparamValue;
import com.tongrui.shangweiji.data.CatTreatmentCollType;
import com.tongrui.shangweiji.ui.treatmentcontrol.CollimateState;
import com.tongrui.shangweiji.ui.treatmentcontrol.ColorLight;
import com.tongrui.shangweiji.ui.treatmentcontrol.CureHeadState;
import com.tongrui.shangweiji.ui.treatmentcontrol.SketchPanel;
import common.CommonMethod;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class ReferencePoint extends javax.swing.JFrame {
    private static ReferencePoint manualRefPt= null;
    public static ReferencePoint getInstance() {
        if(manualRefPt == null) {
            try {
                manualRefPt = new ReferencePoint();
            } catch (Throwable ex) {
                Logger.getLogger(ReferencePoint.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
            }
        }
        return manualRefPt;
    }
    
    private static final Log log = LogFactory.getLog(ReferencePoint.class);
    /** Creates new form ReferencePoint */
    public ReferencePoint() throws Throwable {
        initComponents();
        this.setLocationRelativeTo(null);
        initValues();

        if(Constant.DEBUG_this_is_TouDao == true) {
            jButton5.setVisible(false);
            jButton6.setVisible(false);
            jLabel21.setVisible(false);
            jTextField4.setVisible(false);
            jTextField5.setVisible(false);
            jTextField12.setVisible(false);
        } else { //if it's TiDao
            jButton1.setText("参考点就位");
            jLabel17.setVisible(false);
            jLabel10.setVisible(false);
            jPanel11.setVisible(false);
            jPanel12.setVisible(false);
            jTextField9.setVisible(false);
            jTextField10.setVisible(false);
            jLabel5.setText("X(mm)");
            jLabel8.setText("Y(mm)");
            jLabel7.setText("Z(mm)");
            jLabel14.setText("床位左右");
            jLabel15.setText("床位上下");
            jLabel18.setVisible(false);
            jTextField11.setVisible(false);
            jLabel19.setVisible(false);
        }

        new ViewRefresh(this).start();
        this.setLocation(0, 0);
    }

    class ViewRefresh extends Thread {

        private ReferencePoint obj = null;

        public ViewRefresh(ReferencePoint obj_) {
            this.obj = obj_;
        }

        public void run() {
                while (true) {
                try {
                    obj.viewUpdate();
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    log.fatal(null, ex);
                }
                }
        }
    }

    private static ControllerSvcImpl  ctrlSvcImplObj = ControllerSvcImpl.getInstance();
    private void viewUpdate() {
        BedInfo bedInfo = ctrlSvcImplObj.getBedInfo();
        update_data(bedInfo);
        
        CureInfo cureInfo = ctrlSvcImplObj.getCureInfo();
        DefaultTableModel table1 = (DefaultTableModel)this.jTable1.getModel();
        table1.setValueAt(cureInfo.getRadioTimer1(), 0, 2);
        table1.setValueAt(cureInfo.getRadioTimer2(), 0, 3);
        
        CurePolar curePolar = ctrlSvcImplObj.getCurePolar();
        cureHeadState1.update_date(curePolar);
        collimateState1.update_date(curePolar);
        
        String st = jTextField11.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st, false);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        double percent = 100*cureInfo.getRadioTimer1()/value;
        if(percent > 100) {
            percent = 100;
        }
        jProgressBar1.setValue((int)percent);
        
        DeviceInfo deviceInfo = ctrlSvcImplObj.getDeviceInfo();
        double cureRoomShieldState = deviceInfo.getDeviceShieldState_Y2();
        double deviceShieldState = deviceInfo.getCureRoomShieldState();
        ((ColorLight) jPanel18).setClockColor(deviceShieldState > 0.0 ? Color.green : Color.red);
        ((ColorLight) jPanel19).setClockColor(cureRoomShieldState > 0.0 ? Color.green : Color.red);
    }

    private void initValues() throws Throwable{
        jTable1.getTableHeader().setFont(new java.awt.Font("宋体", 0, 24));
        updateCollInfo();
        updateReferencePosition();
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel18 = new ColorLight(Color.RED, false, 10);
        ;
        jPanel19 = new ColorLight(Color.RED, false, 10);
        ;
        jLabel20 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        cureHeadState1 = new com.tongrui.shangweiji.ui.treatmentcontrol.CureHeadState();
        collimateState1 = new com.tongrui.shangweiji.ui.treatmentcontrol.CollimateState();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new SketchPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel8 = new ColorLight(Color.GREEN, true, 8);
        jLabel13 = new javax.swing.JLabel();
        jPanel9 = new ColorLight(Color.GREEN, true, 8);
        jPanel10 = new ColorLight(Color.GREEN, true, 8);
        jTextField8 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel11 = new ColorLight(Color.GRAY, false, 8);
        jLabel17 = new javax.swing.JLabel();
        jPanel12 = new ColorLight(Color.GRAY, false, 8);
        jLabel21 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel7.setMinimumSize(new java.awt.Dimension(400, 300));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(708, 50));

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setText("参考点检测");
        jPanel1.add(jLabel1);

        jPanel7.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "参数", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel5.setMaximumSize(new java.awt.Dimension(1000, 600));
        jPanel5.setMinimumSize(new java.awt.Dimension(300, 260));
        jPanel5.setPreferredSize(new java.awt.Dimension(600, 260));

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources_cn"); // NOI18N
        jLabel2.setText(bundle.getString("treatment.control.roomgate")); // NOI18N

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel3.setText(bundle.getString("treatment.control.devicegate")); // NOI18N

        jTable1.setFont(new java.awt.Font("宋体", 0, 24));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "准直器号", "准直器直径(mm)", "定时器1(Sec)", "定时器2(Sec)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
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

        jPanel18.setBackground(new java.awt.Color(204, 255, 255));
        jPanel18.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel18.setMinimumSize(new java.awt.Dimension(22, 22));

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

        jPanel19.setBackground(new java.awt.Color(204, 255, 255));
        jPanel19.setMaximumSize(new java.awt.Dimension(22, 22));
        jPanel19.setMinimumSize(new java.awt.Dimension(22, 22));

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

        jLabel20.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel20.setText("辐照时间");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 223, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel2))
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(22, 22, 22))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(jPanel5, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "状态", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 300));
        jPanel3.setPreferredSize(new java.awt.Dimension(550, 480));
        jPanel3.setLayout(new java.awt.GridLayout(1, 0));
        jPanel3.add(cureHeadState1);
        jPanel3.add(collimateState1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "手动操作", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(102, 102, 102));
        jPanel4.setMinimumSize(new java.awt.Dimension(600, 300));
        jPanel4.setPreferredSize(new java.awt.Dimension(700, 490));
        jPanel4.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(204, 255, 255));
        jPanel13.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel13.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel13.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel13);
        jPanel13.setBounds(8, 27, 374, 400);

        jButton1.setFont(new java.awt.Font("宋体", 0, 24));
        jButton1.setText("启动照射");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);
        jButton1.setBounds(173, 447, 160, 37);

        jButton2.setFont(new java.awt.Font("宋体", 0, 24));
        jButton2.setText("设备归位");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);
        jButton2.setBounds(8, 447, 130, 37);

        jComboBox1.setFont(new java.awt.Font("宋体", 0, 24));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1#", "2#", "3#", "4#" }));
        jComboBox1.setMinimumSize(new java.awt.Dimension(33, 30));
        jComboBox1.setPreferredSize(new java.awt.Dimension(38, 30));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel4.add(jComboBox1);
        jComboBox1.setBounds(442, 116, 93, 30);

        jLabel4.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel4.setText("准直器选择");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(444, 77, 120, 29);

        jLabel18.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel18.setText("辐照时间设定");
        jPanel4.add(jLabel18);
        jLabel18.setBounds(432, 196, 144, 29);

        jTextField11.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField11.setText("20");
        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField11);
        jTextField11.setBounds(442, 235, 90, 35);

        jLabel19.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel19.setText("秒");
        jPanel4.add(jLabel19);
        jLabel19.setBounds(550, 240, 24, 29);

        jButton5.setFont(new java.awt.Font("宋体", 0, 24));
        jButton5.setText("启动拍片");
        jPanel4.add(jButton5);
        jButton5.setBounds(546, 447, 140, 37);

        jButton6.setFont(new java.awt.Font("宋体", 0, 24));
        jButton6.setText("偏差修正");
        jPanel4.add(jButton6);
        jButton6.setBounds(377, 447, 140, 37);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(jPanel4, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "床位信息", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(102, 102, 102))); // NOI18N
        jPanel6.setMaximumSize(new java.awt.Dimension(1000, 450));
        jPanel6.setMinimumSize(new java.awt.Dimension(600, 260));
        jPanel6.setPreferredSize(new java.awt.Dimension(700, 260));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        jLabel11.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel11.setText(bundle.getString("treatment.control.tps")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel11, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel10.setText(bundle.getString("treatment.control.mask.inout")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel10, gridBagConstraints);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField3.setText("200.0");
        jTextField3.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField3, gridBagConstraints);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField2.setText("200.0");
        jTextField2.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField2, gridBagConstraints);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField1.setText("200.0");
        jTextField1.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField1, gridBagConstraints);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField6.setText("200.0");
        jTextField6.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField6, gridBagConstraints);

        jTextField7.setEditable(false);
        jTextField7.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField7.setText("200.0");
        jTextField7.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField7, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel12.setText(bundle.getString("treatment.control.tps.currentvalue")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel12, gridBagConstraints);

        jPanel8.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel8, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel13.setText(bundle.getString("treatment.control.status")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel13, gridBagConstraints);

        jPanel9.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel9, gridBagConstraints);

        jPanel10.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel10, gridBagConstraints);

        jTextField8.setEditable(false);
        jTextField8.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField8.setText("200.0");
        jTextField8.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField8, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel5.setText(bundle.getString("treatment.control.coordinate.x")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel6.setText(bundle.getString("treatment.control.coordinate")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel6, gridBagConstraints);

        jTextField10.setEditable(false);
        jTextField10.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField10.setText("200.0");
        jTextField10.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField10, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel7.setText(bundle.getString("treatment.control.coordinate.z")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel7, gridBagConstraints);

        jTextField9.setEditable(false);
        jTextField9.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField9.setText("200.0");
        jTextField9.setPreferredSize(new java.awt.Dimension(80, 35));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jTextField9, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel8.setText(bundle.getString("treatment.control.coordinate.y")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel9.setText(bundle.getString("treatment.control.coordinate.name")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel9, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel14.setText(bundle.getString("treatment.control.head.leftright")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel15.setText(bundle.getString("treatment.control.head.updown")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel15, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel16.setText(bundle.getString("treatment.control.bed.inout")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel16, gridBagConstraints);

        jPanel11.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel11, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel17.setText(bundle.getString("treatment.control.bed.move")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jLabel17, gridBagConstraints);

        jPanel12.setPreferredSize(new java.awt.Dimension(30, 30));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jPanel12, gridBagConstraints);

        jLabel21.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel21.setText("偏差量:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel6.add(jLabel21, gridBagConstraints);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField4.setText("-1.0");
        jTextField4.setPreferredSize(new java.awt.Dimension(80, 35));
        jTextField4.setSelectionEnd(5);
        jTextField4.setSelectionStart(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        jPanel6.add(jTextField4, gridBagConstraints);

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField5.setText("1.2");
        jTextField5.setPreferredSize(new java.awt.Dimension(80, 35));
        jTextField5.setSelectionEnd(5);
        jTextField5.setSelectionStart(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        jPanel6.add(jTextField5, gridBagConstraints);

        jTextField12.setEditable(false);
        jTextField12.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField12.setText("3.2");
        jTextField12.setPreferredSize(new java.awt.Dimension(80, 35));
        jTextField12.setSelectionEnd(5);
        jTextField12.setSelectionStart(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 30;
        jPanel6.add(jTextField12, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(jPanel6, gridBagConstraints);

        jPanel7.add(jPanel2, java.awt.BorderLayout.CENTER);

        jScrollPane2.setViewportView(jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1419, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        try {
            // TODO add your handling code here:
            updateCollInfo();
        } catch (Throwable ex) {
            Logger.getLogger(ReferencePoint.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "本地数据库访问出错,请重试!");
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ctrlSvcImplObj.sendCommand(Constant.REFERENCE_DEVICE_BACK);
        System.out.println("sendCommand(Constant.REFERENCE_DEVICE_BACK)");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String st = jTextField11.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);

        int collimaterNo = jComboBox1.getSelectedIndex() + 1;
        ctrlSvcImplObj.sendCommand(Constant.REFERENCE_RADIATE_START, value, collimaterNo);
        System.out.println("sendCommand(Constant.REFERENCE_RADIATE_START, " + value + "; " + collimaterNo);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        manualRefPt = null;
    }//GEN-LAST:event_formWindowClosing

    private void updateCollInfo() throws Throwable{
        int collimater_index = jComboBox1.getSelectedIndex() + 1;
        DefaultTableModel table_collimater = (DefaultTableModel)this.jTable1.getModel();
        table_collimater.setValueAt(collimater_index, 0, 0);
        
        this.setCursor(Cursor.WAIT_CURSOR);
        try {
            CatTreatmentCollType collType = ServiceLocator.getCollTypeService().findById(collimater_index);
            table_collimater.setValueAt(collType.getSize(), 0, 1);   
            jComboBox1.setBackground(Color.WHITE);
        } catch (Exception e) {
            jComboBox1.setBackground(Color.red);
            this.setCursor(Cursor.DEFAULT_CURSOR);
            throw e;
        }
        this.setCursor(Cursor.DEFAULT_CURSOR);
    }
    
    private void updateReferencePosition() throws Throwable{
        List<CatDeviceparamValue> paramList = ServiceLocator.getParameterService().findByTypeName("reference_position");
        if (paramList == null || paramList.isEmpty()) {
            JDialog errDlg = new JDialog(this, false);
            JOptionPane.showMessageDialog(errDlg, "can't find device parameter: reference_position", "Error Message", JOptionPane.ERROR_MESSAGE);
            errDlg.setVisible(true);
        } else {
            for (int i = 0; i < paramList.size(); i++) {
                CatDeviceparamValue param = paramList.get(i);
                String name = param.getName();
                String value = "";
                if (param.getValue() != null) {
                    value = param.getValue().toString();
                }

                if (name.equals("X11")) {
                    jTextField1.setText(value);
                } else if (name.equals("Y11")) {
                    jTextField2.setText(value);
                } else if (name.equals("X2")) {
                    jTextField3.setText(value);
                }
            }
        }
    }
    
    public void update_data(BedInfo bedInfo){
        //current
        jTextField6.setText(String.valueOf(bedInfo.getHeadFrameLR_X11()));
        jTextField7.setText(String.valueOf(bedInfo.getHeadFrameUD_Y11()));
        jTextField8.setText(String.valueOf(bedInfo.getBedInOut_X2()));
        if(Constant.DEBUG_this_is_TouDao == true) {
            jTextField9.setText(String.valueOf(bedInfo.getBedFollowUp_X12()));
            jTextField10.setText(String.valueOf(bedInfo.getHeadFrameInOut_Z11()));
        }
        
        ((SketchPanel)jPanel13).update_graph(bedInfo.getHeadFrameLR_X11(),bedInfo.getHeadFrameUD_Y11(),bedInfo.getBedInOut_X2());
                
        //X11 state-light
        int state = bedInfo.getHeadFrameLRState_X11();
        if(state == 0) { //stop state
            ((ColorLight)jPanel8).setArrow(false);
            ((ColorLight)jPanel8).setClockColor(Color.gray);
        } else {
            ((ColorLight)jPanel8).setArrow(true);
            ((ColorLight)jPanel8).setClockColor(Color.green);
            ((ColorLight)jPanel8).setArrowDirection(dir_LR(state));
        }
        
        //Y11 state-light
        state = bedInfo.getHeadFrameUDState_Y11();
        if(state == 0) { //stop state
            ((ColorLight)jPanel9).setArrow(false);
            ((ColorLight)jPanel9).setClockColor(Color.gray);
        } else {
            ((ColorLight)jPanel9).setArrow(true);
            ((ColorLight)jPanel9).setClockColor(Color.green);
            ((ColorLight)jPanel9).setArrowDirection(dir_UD(state));
        }
        
        //X2 state-light
        state = bedInfo.getBedInOutState_X2();
        if(state == 0) { //stop state
            ((ColorLight)jPanel10).setArrow(false);
            ((ColorLight)jPanel10).setClockColor(Color.gray);
        } else {
            ((ColorLight)jPanel10).setArrow(true);
            ((ColorLight)jPanel10).setClockColor(Color.green);
            ((ColorLight)jPanel10).setArrowDirection(dir_IO(state));
        }
        
        if(Constant.DEBUG_this_is_TouDao == true) {
            //X12 state-light
            state = bedInfo.getBedFollowUpState_X12();
            if (state == 0) { //stop state
                ((ColorLight) jPanel11).setArrow(false);
                ((ColorLight) jPanel11).setClockColor(Color.gray);
            } else {
                ((ColorLight) jPanel11).setArrow(true);
                ((ColorLight) jPanel11).setClockColor(Color.green);
                ((ColorLight) jPanel11).setArrowDirection(dir_LR(state));
            }

            //Z11 state-light
            state = bedInfo.getHeadFrameInOutState_Z11();
            if (state == 0) { //stop state
                ((ColorLight) jPanel12).setArrow(false);
                ((ColorLight) jPanel12).setClockColor(Color.gray);
            } else {
                ((ColorLight) jPanel12).setArrow(true);
                ((ColorLight) jPanel12).setClockColor(Color.green);
                ((ColorLight) jPanel12).setArrowDirection(dir_IO(state));
            }
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
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if(manualRefPt == null) {
                    manualRefPt = ReferencePoint.getInstance();
                }
                manualRefPt.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.tongrui.shangweiji.ui.treatmentcontrol.CollimateState collimateState1;
    private com.tongrui.shangweiji.ui.treatmentcontrol.CureHeadState cureHeadState1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
