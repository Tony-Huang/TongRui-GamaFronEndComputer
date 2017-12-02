/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BedPositionManual.java
 *
 * Created on 2012-10-2, 10:59:06
 */
package com.tongrui.shangweiji.ui.systemadjustment;

import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.comm.BedInfo;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.comm.CureInfo;
import com.tongrui.shangweiji.comm.CurePolar;
import com.tongrui.shangweiji.comm.DeviceInfo;
import com.tongrui.shangweiji.comm.LowComputerInfo;
import com.tongrui.shangweiji.ui.treatmentcontrol.SketchPanel;
import common.CommonMethod;
import java.awt.Dimension;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Administrator
 */
public class BedPositionManual extends javax.swing.JFrame {
    private static final Log log = LogFactory.getLog(BedPositionManual.class);
    
    private static BedPositionManual manualBedPos = null;
    public static BedPositionManual getInstance() {
        if(manualBedPos == null){
            manualBedPos = new BedPositionManual();
        }
        return manualBedPos;
    }

    /** Creates new form BedPositionManual */
    public BedPositionManual() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        if(Constant.DEBUG_this_is_TouDao == true) {
            
        } else { //if it's TiDao
            jRadioButton2.setText("X使能");
            jRadioButton4.setText("Y使能");
            jRadioButton5.setText("Z使能");
            jRadioButton3.setVisible(false);
            jRadioButton6.setVisible(false);
            jToggleButton2.setVisible(false);
            jToggleButton8.setVisible(false);
            jToggleButton14.setVisible(false);
            jToggleButton20.setVisible(false);
            jToggleButton5.setVisible(false);
            jToggleButton11.setVisible(false);
            jToggleButton17.setVisible(false);
            jToggleButton23.setVisible(false);
            jTextField2.setVisible(false);
            jTextField8.setVisible(false);
            jTextField5.setVisible(false);
            jTextField11.setVisible(false);
       }
        
        new ViewRefresh(this).start();
    }

    class ViewRefresh extends Thread {

        private BedPositionManual obj = null;

        public ViewRefresh(BedPositionManual obj_) {
            this.obj = obj_;
        }

        public void run() {
            try {
                while (true) {
                    obj.viewUpdate();
                    Thread.sleep(300);
                }
            } catch (InterruptedException ex) {
                log.error(null, ex);
            }
        }
    }
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance();
    private int cycles = 0;
    private void viewUpdate() {
        BedInfo bedInfo = ctrlSvcImplObj.getBedInfo();
        DeviceInfo deviceinfo = ctrlSvcImplObj.getDeviceInfo();
        LowComputerInfo lowComputerInfo = ctrlSvcImplObj.getLowComputerInfo();

        DefaultTableModel tableL = (DefaultTableModel) this.jTable1.getModel();
        DefaultTableModel tableR = (DefaultTableModel) this.jTable2.getModel();

        tableL.setValueAt(bedInfo.getHeadFrameLR_X11(), 0, 1);
        tableL.setValueAt(bedInfo.getHeadFrameUD_Y11(), 1, 1);
        if(Constant.DEBUG_this_is_TouDao == true) {
            tableL.setValueAt(bedInfo.getHeadFrameInOut_Z11(), 2, 1);
            tableR.setValueAt(bedInfo.getBedFollowUp_X12(), 0, 1);
        }
        tableR.setValueAt(bedInfo.getBedInOut_X2(), 1, 1);
        tableR.setValueAt(deviceinfo.getDeviceShieldPosition_Y2(), 2, 1);

        jTextField1.setText(Double.valueOf(bedInfo.getHeadFrameLR_X11()).toString());
        if(Constant.DEBUG_this_is_TouDao == true) {
            jTextField2.setText(Double.valueOf(bedInfo.getBedFollowUp_X12()).toString());
            jTextField4.setText(Double.valueOf(bedInfo.getHeadFrameInOut_Z11()).toString());
        }
        jTextField3.setText(Double.valueOf(bedInfo.getHeadFrameUD_Y11()).toString());
        jTextField5.setText(Double.valueOf(bedInfo.getBedInOut_X2()).toString());
        jTextField6.setText(Double.valueOf(deviceinfo.getDeviceShieldPosition_Y2()).toString());

        if (isMovingButtonValid()) {
            cycles++;
            if (cycles >= 4 && lowComputerInfo.getMovingState() == 0) { //Moving action is end
                restoreEnable2ValidGroup();
                releaseAllToggleButtons();
                System.out.println("Moving is end.");
            }
        } else {
            cycles = 0;
        }
        
        ((SketchPanel)jPanel9).update_graph(bedInfo.getHeadFrameLR_X11(),bedInfo.getHeadFrameUD_Y11(),bedInfo.getBedInOut_X2());
    }

    boolean isMovingButtonValid() {
        return (jToggleButton13.isSelected() || jToggleButton14.isSelected() || jToggleButton15.isSelected() || jToggleButton16.isSelected() || jToggleButton17.isSelected() || jToggleButton18.isSelected()
                || jToggleButton19.isSelected() || jToggleButton20.isSelected() || jToggleButton21.isSelected() || jToggleButton22.isSelected() || jToggleButton23.isSelected() || jToggleButton24.isSelected());
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
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel9 = new SketchPanel();
        jPanel6 = new javax.swing.JPanel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jRadioButton7 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jToggleButton7 = new javax.swing.JToggleButton();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jToggleButton10 = new javax.swing.JToggleButton();
        jToggleButton11 = new javax.swing.JToggleButton();
        jToggleButton12 = new javax.swing.JToggleButton();
        jToggleButton13 = new javax.swing.JToggleButton();
        jToggleButton14 = new javax.swing.JToggleButton();
        jToggleButton15 = new javax.swing.JToggleButton();
        jToggleButton16 = new javax.swing.JToggleButton();
        jToggleButton17 = new javax.swing.JToggleButton();
        jToggleButton18 = new javax.swing.JToggleButton();
        jToggleButton19 = new javax.swing.JToggleButton();
        jToggleButton20 = new javax.swing.JToggleButton();
        jToggleButton21 = new javax.swing.JToggleButton();
        jToggleButton22 = new javax.swing.JToggleButton();
        jToggleButton23 = new javax.swing.JToggleButton();
        jToggleButton24 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "手动床位", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel5.setMinimumSize(new java.awt.Dimension(10, 100));
        jPanel5.setPreferredSize(new java.awt.Dimension(350, 530));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jPanel7.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel7.setPreferredSize(new java.awt.Dimension(40, 150));

        jTable1.setFont(new java.awt.Font("宋体", 0, 24));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X11", null},
                {"Y11", null},
                {"Z11", null}
            },
            new String [] {
                "轴名", "当前值(mm)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setEditingColumn(1);
        jTable1.setRowHeight(40);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 30, 0, 0);
        jPanel5.add(jPanel7, gridBagConstraints);

        jPanel8.setMinimumSize(new java.awt.Dimension(20, 20));
        jPanel8.setPreferredSize(new java.awt.Dimension(40, 150));

        jTable2.setFont(new java.awt.Font("宋体", 0, 24));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"X12", null},
                {"X2", null},
                {"Y2", null}
            },
            new String [] {
                "轴名", "当前值(mm)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.setColumnSelectionAllowed(true);
        jTable2.setRowHeight(40);
        jTable2.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable2);
        jTable2.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel5.add(jPanel8, gridBagConstraints);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setMaximumSize(new java.awt.Dimension(400, 400));
        jPanel9.setMinimumSize(new java.awt.Dimension(400, 400));
        jPanel9.setPreferredSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 396, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 60);
        jPanel5.add(jPanel9, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel6.setMinimumSize(new java.awt.Dimension(646, 100));
        jPanel6.setPreferredSize(new java.awt.Dimension(646, 100));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("无使能");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton1, gridBagConstraints);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton2.setText("X11使能");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton2, gridBagConstraints);

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton3.setText("X12使能");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton3, gridBagConstraints);

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton4.setText("Y11使能");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton4, gridBagConstraints);

        buttonGroup1.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton5.setText("Z11使能");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton5, gridBagConstraints);

        buttonGroup1.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton6.setText("X2使能");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton6, gridBagConstraints);

        buttonGroup1.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("宋体", 0, 24));
        jRadioButton7.setText("Y2使能");
        jRadioButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel6.add(jRadioButton7, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel3.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 120;
        jPanel6.add(jLabel3, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        jPanel5.add(jPanel6, gridBagConstraints);

        jPanel1.add(jPanel5, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18), new java.awt.Color(51, 51, 51))); // NOI18N
        jPanel4.setMinimumSize(new java.awt.Dimension(768, 400));
        jPanel4.setPreferredSize(new java.awt.Dimension(805, 200));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowLeft.gif"))); // NOI18N
        jToggleButton1.setEnabled(false);
        jToggleButton1.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton1.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton1.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton1, gridBagConstraints);

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowLeft.gif"))); // NOI18N
        jToggleButton2.setEnabled(false);
        jToggleButton2.setFocusPainted(false);
        jToggleButton2.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton2.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton2.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton2, gridBagConstraints);

        jToggleButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowUp.gif"))); // NOI18N
        jToggleButton3.setEnabled(false);
        jToggleButton3.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton3.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton3.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton3, gridBagConstraints);

        jToggleButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowForword.gif"))); // NOI18N
        jToggleButton4.setEnabled(false);
        jToggleButton4.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton4.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton4.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton4, gridBagConstraints);

        jToggleButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowForword.gif"))); // NOI18N
        jToggleButton5.setEnabled(false);
        jToggleButton5.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton5.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton5.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton5, gridBagConstraints);

        jToggleButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowUp.gif"))); // NOI18N
        jToggleButton6.setEnabled(false);
        jToggleButton6.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton6.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton6.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton6, gridBagConstraints);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField1.setText("value");
        jTextField1.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField1.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField1, gridBagConstraints);

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField2.setText("value");
        jTextField2.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField2.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField2, gridBagConstraints);

        jTextField3.setEditable(false);
        jTextField3.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField3.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField3.setText("value");
        jTextField3.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField3.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField3, gridBagConstraints);

        jTextField4.setEditable(false);
        jTextField4.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField4.setText("value");
        jTextField4.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField4.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField4, gridBagConstraints);

        jTextField5.setEditable(false);
        jTextField5.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField5.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField5.setText("value");
        jTextField5.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField5.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField5, gridBagConstraints);

        jTextField6.setEditable(false);
        jTextField6.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField6.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField6.setText("value");
        jTextField6.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField6.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jTextField6, gridBagConstraints);

        jTextField7.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField7.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField7.setText("0.0");
        jTextField7.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField7.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField7, gridBagConstraints);

        jTextField8.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField8.setText("0.0");
        jTextField8.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField8.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField8, gridBagConstraints);

        jTextField9.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField9.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField9.setText("0.0");
        jTextField9.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField9.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField9, gridBagConstraints);

        jTextField10.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField10.setText("0.0");
        jTextField10.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField10.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField10, gridBagConstraints);

        jTextField11.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField11.setText("0.0");
        jTextField11.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField11.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField11, gridBagConstraints);

        jTextField12.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField12.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTextField12.setText("0.0");
        jTextField12.setMinimumSize(new java.awt.Dimension(60, 25));
        jTextField12.setPreferredSize(new java.awt.Dimension(80, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 44;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(jTextField12, gridBagConstraints);

        jButton13.setFont(new java.awt.Font("宋体", 0, 24));
        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/Stop.gif"))); // NOI18N
        jButton13.setText("停止");
        jButton13.setMaximumSize(new java.awt.Dimension(55, 40));
        jButton13.setMinimumSize(new java.awt.Dimension(55, 40));
        jButton13.setPreferredSize(new java.awt.Dimension(55, 40));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 40);
        jPanel4.add(jButton13, gridBagConstraints);

        jToggleButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowRight.gif"))); // NOI18N
        jToggleButton7.setEnabled(false);
        jToggleButton7.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton7.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton7.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton7, gridBagConstraints);

        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowRight.gif"))); // NOI18N
        jToggleButton8.setEnabled(false);
        jToggleButton8.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton8.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton8.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton8, gridBagConstraints);

        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowDown.gif"))); // NOI18N
        jToggleButton9.setEnabled(false);
        jToggleButton9.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton9.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton9.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton9, gridBagConstraints);

        jToggleButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowBackword.gif"))); // NOI18N
        jToggleButton10.setEnabled(false);
        jToggleButton10.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton10.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton10.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton10, gridBagConstraints);

        jToggleButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowBackword.gif"))); // NOI18N
        jToggleButton11.setEnabled(false);
        jToggleButton11.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton11.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton11.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton11ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton11, gridBagConstraints);

        jToggleButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ArrowDown.gif"))); // NOI18N
        jToggleButton12.setEnabled(false);
        jToggleButton12.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton12.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton12.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton12ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton12, gridBagConstraints);

        jToggleButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton13.setEnabled(false);
        jToggleButton13.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton13.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton13.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton13ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton13, gridBagConstraints);

        jToggleButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton14.setEnabled(false);
        jToggleButton14.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton14.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton14.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton14ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton14, gridBagConstraints);

        jToggleButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton15.setEnabled(false);
        jToggleButton15.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton15.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton15.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton15ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton15, gridBagConstraints);

        jToggleButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton16.setEnabled(false);
        jToggleButton16.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton16.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton16.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton16ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton16, gridBagConstraints);

        jToggleButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton17.setEnabled(false);
        jToggleButton17.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton17.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton17.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton17ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton17, gridBagConstraints);

        jToggleButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToZero.gif"))); // NOI18N
        jToggleButton18.setEnabled(false);
        jToggleButton18.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton18.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton18.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton18ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel4.add(jToggleButton18, gridBagConstraints);

        jToggleButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton19.setEnabled(false);
        jToggleButton19.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton19.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton19.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton19ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton19, gridBagConstraints);

        jToggleButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton20.setEnabled(false);
        jToggleButton20.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton20.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton20.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton20ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton20, gridBagConstraints);

        jToggleButton21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton21.setEnabled(false);
        jToggleButton21.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton21.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton21.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton21ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton21, gridBagConstraints);

        jToggleButton22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton22.setEnabled(false);
        jToggleButton22.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton22.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton22.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton22ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton22, gridBagConstraints);

        jToggleButton23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton23.setEnabled(false);
        jToggleButton23.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton23.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton23.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton23ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton23, gridBagConstraints);

        jToggleButton24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tongrui/shangweiji/ui/image/ToPoint.gif"))); // NOI18N
        jToggleButton24.setEnabled(false);
        jToggleButton24.setMaximumSize(new java.awt.Dimension(300, 60));
        jToggleButton24.setMinimumSize(new java.awt.Dimension(100, 30));
        jToggleButton24.setPreferredSize(new java.awt.Dimension(130, 30));
        jToggleButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton24ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        jPanel4.add(jToggleButton24, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setText("当前值(mm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanel4.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel2.setText("给定值(mm):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel4.add(jLabel2, gridBagConstraints);

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton2.setEnabled(true);
        jToggleButton8.setEnabled(true);
        jToggleButton14.setEnabled(true);
        jToggleButton20.setEnabled(true);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton5.setEnabled(true);
        jToggleButton11.setEnabled(true);
        jToggleButton17.setEnabled(true);
        jToggleButton23.setEnabled(true);
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        releaseAllToggleButtons();
        restoreEnable2ValidGroup();
        ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
        System.out.println("sendCommand(Constant.MENUL_AXILES_STOP)");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton1.setEnabled(true);
        jToggleButton7.setEnabled(true);
        jToggleButton13.setEnabled(true);
        jToggleButton19.setEnabled(true);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton3.setEnabled(true);
        jToggleButton9.setEnabled(true);
        jToggleButton15.setEnabled(true);
        jToggleButton21.setEnabled(true);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton4.setEnabled(true);
        jToggleButton10.setEnabled(true);
        jToggleButton16.setEnabled(true);
        jToggleButton22.setEnabled(true);
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton7ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();

        jToggleButton6.setEnabled(true);
        jToggleButton12.setEnabled(true);
        jToggleButton18.setEnabled(true);
        jToggleButton24.setEnabled(true);
    }//GEN-LAST:event_jRadioButton7ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        disableAllToggleButtons();
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton2.isSelected()) { //Only pressed is valid
            jToggleButton8.setEnabled(false);
            jToggleButton14.setEnabled(false);
            jToggleButton20.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X12_LEFT);
            System.out.println("sendCommand(Constant.MANUL_X12_LEFT)");
        } else {                         //All buttons are valid
            jToggleButton8.setEnabled(true);
            jToggleButton14.setEnabled(true);
            jToggleButton20.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton8.isSelected()) { //Only pressed is valid
            jToggleButton2.setEnabled(false);
            jToggleButton14.setEnabled(false);
            jToggleButton20.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X12_RIGHT);
            System.out.println("sendCommand(Constant.MANUL_X12_RIGHT)");
        } else {                         //All buttons are valid
            jToggleButton2.setEnabled(false);
            jToggleButton14.setEnabled(false);
            jToggleButton20.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton14ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton14.isSelected()) { //Only pressed is valid
            jToggleButton2.setEnabled(false);
            jToggleButton8.setEnabled(false);
            jToggleButton20.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton14.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X12_ZERO);
        System.out.println("sendCommand(Constant.MANUL_X12_ZERO)");

    }//GEN-LAST:event_jToggleButton14ActionPerformed

    private void jToggleButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton20ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton20.isSelected()) { //Only pressed is valid
            jToggleButton2.setEnabled(false);
            jToggleButton8.setEnabled(false);
            jToggleButton14.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton20.setSelected(true); //Keep pressed state
        }

        String st = jTextField8.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X12_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_X12_POINT, " + value);

    }//GEN-LAST:event_jToggleButton20ActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton1.isSelected()) { //Only pressed is valid
            jToggleButton7.setEnabled(false);
            jToggleButton13.setEnabled(false);
            jToggleButton19.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X11_LEFT);
            System.out.println("sendCommand(Constant.MANUL_X11_LEFT)");
        } else {                         //All buttons are valid
            jToggleButton7.setEnabled(true);
            jToggleButton13.setEnabled(true);
            jToggleButton19.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jToggleButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton7ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton7.isSelected()) { //Only pressed is valid
            jToggleButton1.setEnabled(false);
            jToggleButton13.setEnabled(false);
            jToggleButton19.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X11_RIGHT);
            System.out.println("sendCommand(Constant.MANUL_X11_RIGHT)");
        } else {                         //All buttons are valid
            jToggleButton1.setEnabled(true);
            jToggleButton13.setEnabled(true);
            jToggleButton19.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton7ActionPerformed

    private void jToggleButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton13ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton13.isSelected()) { //Only pressed is valid
            jToggleButton1.setEnabled(false);
            jToggleButton7.setEnabled(false);
            jToggleButton19.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton13.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X11_ZERO);
        System.out.println("sendCommand(Constant.MANUL_X11_ZERO)");

    }//GEN-LAST:event_jToggleButton13ActionPerformed

    private void jToggleButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton19ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton19.isSelected()) { //Only pressed is valid
            jToggleButton1.setEnabled(false);
            jToggleButton7.setEnabled(false);
            jToggleButton13.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton19.setSelected(true); //Keep pressed state
        }
        String st = jTextField7.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X11_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_X11_POINT, " + value);

    }//GEN-LAST:event_jToggleButton19ActionPerformed

    private void jToggleButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton3ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton3.isSelected()) { //Only pressed is valid
            jToggleButton9.setEnabled(false);
            jToggleButton15.setEnabled(false);
            jToggleButton21.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Y11_UP);
            System.out.println("sendCommand(Constant.MANUL_Y11_UP)");
        } else {                         //All buttons are valid
            jToggleButton9.setEnabled(true);
            jToggleButton15.setEnabled(true);
            jToggleButton21.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton3ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton9.isSelected()) { //Only pressed is valid
            jToggleButton3.setEnabled(false);
            jToggleButton15.setEnabled(false);
            jToggleButton21.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Y11_DOWN);
            System.out.println("sendCommand(Constant.MANUL_Y11_DOWN)");
        } else {                         //All buttons are valid
            jToggleButton3.setEnabled(true);
            jToggleButton15.setEnabled(true);
            jToggleButton21.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jToggleButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton15ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton15.isSelected()) { //Only pressed is valid
            jToggleButton3.setEnabled(false);
            jToggleButton9.setEnabled(false);
            jToggleButton21.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton15.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Y11_ZERO);
        System.out.println("sendCommand(Constant.MANUL_Y11_ZERO)");

    }//GEN-LAST:event_jToggleButton15ActionPerformed

    private void jToggleButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton21ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton21.isSelected()) { //Only pressed is valid
            jToggleButton3.setEnabled(false);
            jToggleButton9.setEnabled(false);
            jToggleButton15.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton21.setSelected(true); //Keep pressed state
        }
        String st = jTextField9.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Y11_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_Y11_POINT, " + value);

    }//GEN-LAST:event_jToggleButton21ActionPerformed

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton4ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton4.isSelected()) { //Only pressed is valid
            jToggleButton10.setEnabled(false);
            jToggleButton16.setEnabled(false);
            jToggleButton22.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Z11_IN);
            System.out.println("sendCommand(Constant.MANUL_Z11_IN)");
        } else {                         //All buttons are valid
            jToggleButton10.setEnabled(true);
            jToggleButton16.setEnabled(true);
            jToggleButton22.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton4ActionPerformed

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton10ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton10.isSelected()) { //Only pressed is valid
            jToggleButton4.setEnabled(false);
            jToggleButton16.setEnabled(false);
            jToggleButton22.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Z11_OUT);
            System.out.println("sendCommand(Constant.MANUL_Z11_OUT)");
        } else {                         //All buttons are valid
            jToggleButton4.setEnabled(true);
            jToggleButton16.setEnabled(true);
            jToggleButton22.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton10ActionPerformed

    private void jToggleButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton16ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton16.isSelected()) { //Only pressed is valid
            jToggleButton4.setEnabled(false);
            jToggleButton10.setEnabled(false);
            jToggleButton22.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton16.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Z11_ZERO);
        System.out.println("sendCommand(Constant.MANUL_Z11_ZERO)");

    }//GEN-LAST:event_jToggleButton16ActionPerformed

    private void jToggleButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton22ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton22.isSelected()) { //Only pressed is valid
            jToggleButton4.setEnabled(false);
            jToggleButton10.setEnabled(false);
            jToggleButton16.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton22.setSelected(true); //Keep pressed state
        }

        String st = jTextField10.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Z11_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_Z11_POINT, " + value);

    }//GEN-LAST:event_jToggleButton22ActionPerformed

    private void jToggleButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton5ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton5.isSelected()) { //Only pressed is valid
            jToggleButton11.setEnabled(false);
            jToggleButton17.setEnabled(false);
            jToggleButton23.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X2_IN);
            System.out.println("sendCommand(Constant.MANUL_X2_IN)");
        } else {                         //All buttons are valid
            jToggleButton11.setEnabled(true);
            jToggleButton17.setEnabled(true);
            jToggleButton23.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton5ActionPerformed

    private void jToggleButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton11ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton11.isSelected()) { //Only pressed is valid
            jToggleButton5.setEnabled(false);
            jToggleButton17.setEnabled(false);
            jToggleButton23.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_X2_OUT);
            System.out.println("sendCommand(Constant.MANUL_X2_OUT)");
        } else {                         //All buttons are valid
            jToggleButton5.setEnabled(true);
            jToggleButton17.setEnabled(true);
            jToggleButton23.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton11ActionPerformed

    private void jToggleButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton17ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton17.isSelected()) { //Only pressed is valid
            jToggleButton5.setEnabled(false);
            jToggleButton11.setEnabled(false);
            jToggleButton23.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton17.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X2_ZERO);
        System.out.println("sendCommand(Constant.MANUL_X2_ZERO)");

    }//GEN-LAST:event_jToggleButton17ActionPerformed

    private void jToggleButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton23ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton23.isSelected()) { //Only pressed is valid
            jToggleButton5.setEnabled(false);
            jToggleButton11.setEnabled(false);
            jToggleButton17.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton23.setSelected(true); //Keep pressed state
        }
        String st = jTextField11.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_X2_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_X2_POINT, " + value);

    }//GEN-LAST:event_jToggleButton23ActionPerformed

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton6ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton6.isSelected()) { //Only pressed is valid
            jToggleButton12.setEnabled(false);
            jToggleButton18.setEnabled(false);
            jToggleButton24.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Y2_UP);
            System.out.println("sendCommand(Constant.MANUL_Y2_UP)");
        } else {                         //All buttons are valid
            jToggleButton12.setEnabled(true);
            jToggleButton18.setEnabled(true);
            jToggleButton24.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton6ActionPerformed

    private void jToggleButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton12ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton12.isSelected()) { //Only pressed is valid
            jToggleButton6.setEnabled(false);
            jToggleButton18.setEnabled(false);
            jToggleButton24.setEnabled(false);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_Y2_DOWN);
            System.out.println("sendCommand(Constant.MANUL_Y2_DOWN)");
        } else {                         //All buttons are valid
            jToggleButton6.setEnabled(true);
            jToggleButton18.setEnabled(true);
            jToggleButton24.setEnabled(true);
            ctrlSvcImplObj.sendCommand(Constant.MANUL_AXILES_STOP);
            System.out.println("sendCommand(Constant.MANUL_AXILES_STOP)");
        }

    }//GEN-LAST:event_jToggleButton12ActionPerformed

    private void jToggleButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton18ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton18.isSelected()) { //Only pressed is valid
            jToggleButton6.setEnabled(false);
            jToggleButton12.setEnabled(false);
            jToggleButton24.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton18.setSelected(true); //Keep pressed state
        }
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Y2_ZERO);
        System.out.println("sendCommand(Constant.MANUL_Y2_ZERO)");

    }//GEN-LAST:event_jToggleButton18ActionPerformed

    private void jToggleButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton24ActionPerformed
        // TODO add your handling code here:
        if (jToggleButton24.isSelected()) { //Only pressed is valid
            jToggleButton6.setEnabled(false);
            jToggleButton12.setEnabled(false);
            jToggleButton18.setEnabled(false);
        } else {                         //All buttons are valid
            jToggleButton24.setSelected(true); //Keep pressed state
        }
        String st = jTextField12.getText().trim();
        boolean inputValid = CommonMethod.checkDoubleFromTextField(st,true);
        if (!inputValid) {
            return;
        }
        double value = Double.valueOf(st);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_Y2_POINT, value);
        System.out.println("sendCommand(Constant.MANUL_Y2_POINT, " + value);

    }//GEN-LAST:event_jToggleButton24ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        manualBedPos = null;
    }//GEN-LAST:event_formWindowClosing

    private void disableAllToggleButtons() {
        jToggleButton1.setEnabled(false);
        jToggleButton2.setEnabled(false);
        jToggleButton3.setEnabled(false);
        jToggleButton4.setEnabled(false);
        jToggleButton5.setEnabled(false);
        jToggleButton6.setEnabled(false);
        jToggleButton7.setEnabled(false);
        jToggleButton8.setEnabled(false);
        jToggleButton9.setEnabled(false);
        jToggleButton10.setEnabled(false);
        jToggleButton11.setEnabled(false);
        jToggleButton12.setEnabled(false);
        jToggleButton13.setEnabled(false);
        jToggleButton14.setEnabled(false);
        jToggleButton15.setEnabled(false);
        jToggleButton16.setEnabled(false);
        jToggleButton17.setEnabled(false);
        jToggleButton18.setEnabled(false);
        jToggleButton19.setEnabled(false);
        jToggleButton20.setEnabled(false);
        jToggleButton21.setEnabled(false);
        jToggleButton22.setEnabled(false);
        jToggleButton23.setEnabled(false);
        jToggleButton24.setEnabled(false);
    }

    private void releaseAllToggleButtons() {
        jToggleButton1.setSelected(false);
        jToggleButton2.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
        jToggleButton7.setSelected(false);
        jToggleButton8.setSelected(false);
        jToggleButton9.setSelected(false);
        jToggleButton10.setSelected(false);
        jToggleButton11.setSelected(false);
        jToggleButton12.setSelected(false);
        jToggleButton13.setSelected(false);
        jToggleButton14.setSelected(false);
        jToggleButton15.setSelected(false);
        jToggleButton16.setSelected(false);
        jToggleButton17.setSelected(false);
        jToggleButton18.setSelected(false);
        jToggleButton19.setSelected(false);
        jToggleButton20.setSelected(false);
        jToggleButton21.setSelected(false);
        jToggleButton22.setSelected(false);
        jToggleButton23.setSelected(false);
        jToggleButton24.setSelected(false);
    }

    private void restoreEnable2ValidGroup() {
        if (buttonGroup1.getSelection() == jRadioButton2.getModel()) {
            jToggleButton1.setEnabled(true);
            jToggleButton7.setEnabled(true);
            jToggleButton13.setEnabled(true);
            jToggleButton19.setEnabled(true);
        } else if (buttonGroup1.getSelection() == jRadioButton3.getModel()) {
            jToggleButton2.setEnabled(true);
            jToggleButton8.setEnabled(true);
            jToggleButton14.setEnabled(true);
            jToggleButton20.setEnabled(true);
        } else if (buttonGroup1.getSelection() == jRadioButton4.getModel()) {
            jToggleButton3.setEnabled(true);
            jToggleButton9.setEnabled(true);
            jToggleButton15.setEnabled(true);
            jToggleButton21.setEnabled(true);
        } else if (buttonGroup1.getSelection() == jRadioButton5.getModel()) {
            jToggleButton4.setEnabled(true);
            jToggleButton10.setEnabled(true);
            jToggleButton16.setEnabled(true);
            jToggleButton22.setEnabled(true);
        } else if (buttonGroup1.getSelection() == jRadioButton6.getModel()) {
            jToggleButton5.setEnabled(true);
            jToggleButton11.setEnabled(true);
            jToggleButton17.setEnabled(true);
            jToggleButton23.setEnabled(true);
        } else if (buttonGroup1.getSelection() == jRadioButton7.getModel()) {
            jToggleButton6.setEnabled(true);
            jToggleButton12.setEnabled(true);
            jToggleButton18.setEnabled(true);
            jToggleButton24.setEnabled(true);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                if(manualBedPos == null) {
                    manualBedPos = BedPositionManual.getInstance();
                }
                manualBedPos.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton13;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
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
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton11;
    private javax.swing.JToggleButton jToggleButton12;
    private javax.swing.JToggleButton jToggleButton13;
    private javax.swing.JToggleButton jToggleButton14;
    private javax.swing.JToggleButton jToggleButton15;
    private javax.swing.JToggleButton jToggleButton16;
    private javax.swing.JToggleButton jToggleButton17;
    private javax.swing.JToggleButton jToggleButton18;
    private javax.swing.JToggleButton jToggleButton19;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton20;
    private javax.swing.JToggleButton jToggleButton21;
    private javax.swing.JToggleButton jToggleButton22;
    private javax.swing.JToggleButton jToggleButton23;
    private javax.swing.JToggleButton jToggleButton24;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton7;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    // End of variables declaration//GEN-END:variables
}
