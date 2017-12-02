/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.systemadjustment;

import com.tongrui.shangweiji.biz.ParameterService;
import com.tongrui.shangweiji.biz.ServiceLocator;
import com.tongrui.shangweiji.comm.Constant;
import com.tongrui.shangweiji.comm.ControllerSvcImpl;
import com.tongrui.shangweiji.data.CatDeviceparamType;
import com.tongrui.shangweiji.data.CatDeviceparamValue;
import common.CommonMethod;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class NutOffSet extends javax.swing.JFrame {
    
    private static NutOffSet manualScrew = null;
    public static NutOffSet getInstance() {
        if(manualScrew == null) {
            try {
                manualScrew = new NutOffSet();
            } catch (Throwable ex) {
                Logger.getLogger(NutOffSet.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "本地数据库访问出错,请重试!");
            }
        }
        return manualScrew;
    }

    private ArrayList coordStates_bed_num;
    private ArrayList coordStates_head_x11_num;
    private ArrayList coordStates_head_y11_num;

    /**
     * Creates new form NutOffSet
     */
    public NutOffSet() throws Throwable{
        initComponents();
        //removeComponentFromBedPanel();
        //coordStates_bed = new ArrayList<CoordState>();
        //addComponentToBedPanel(19*6);
        initCustomComponent(20 * 6, 20 * 3, 20 * 3);
    }

//    public NutOffSet(int num) {
//        initComponents();
//        removeComponentFromBedPanel();
//        coordStates_bed = new ArrayList<CoordState>();
//        addComponentToBedPanel(num);
//    }
    private void initCustomComponent(int bed_num, int head_x11_num, int head_y11_num) throws Throwable {
        removeComponentFromBedPanel();
        coordStates_bed = new ArrayList<CoordState>();
        coordStates_bed_num = new ArrayList();
        addComponentToBedPanel(bed_num);

        removeComponentFromHeadPanel();
        coordStates_head_x11 = new ArrayList<CoordState>();
        coordStates_head_x11_num = new ArrayList();
        coordStates_head_y11 = new ArrayList<CoordState>();
        coordStates_head_y11_num = new ArrayList();

        addComponentToHeadPanel(head_x11_num, head_y11_num);

    }

    //custom private method
    private void removeComponentFromBedPanel() {
        jPanel13.removeAll();
    }

    private void addComponentToBedPanel(int num) throws Throwable {
        String hql = "from CatDeviceparamValue as u where u.name = 'X2' and u.catDeviceparamType.name = 'screw_compensate' order by u.position asc"; //desc is descrease order
        List<CatDeviceparamValue> paramList = null;
        try {
            paramList = paraSvc.findByHQL(hql);
        } catch (Exception e) {
            throw e;
        }
        if (paramList != null) {  
            int sum = paramList.size();
            System.out.println(sum);
            int cl = ((sum - 1) / 20) + 1;
            for (int i = 0; i < cl; i++) {
                //jPanel12.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                OffSetUnit osunit = new OffSetUnit();
                osunit.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                for (int j = 0; j < 20;j++) {
                    if ((i*20+j)>= sum) {
                        break;
                    }
                    CatDeviceparamValue dpv = paramList.get(i*20+j);
                    CoordState coordState = new CoordState(String.valueOf(Float.valueOf(dpv.getPosition()).intValue()), java.awt.Color.gray);
                    coordStates_bed.add(coordState);
                    coordStates_bed_num.add(Float.valueOf(dpv.getPosition()).intValue());
                    osunit.add(coordState);
                }
                jPanel13.add(osunit);
            }
        }
    }

    private void checkCurrentBedCoordState(int currentBedCoordIndex, Color col) {
        CoordState coordState = coordStates_bed.get(currentBedCoordIndex);
        coordState.setStateByColor(col);
        //返回执行结果；       
    }

    public void displayObj() {
        checkCurrentBedCoordState(currentBedCoord, Color.green);
        checkCurrentBedCoordState(currentBedCoord, Color.blue);
    }

    class BedDispaly extends Thread {

        private NutOffSet obj = null;

        public BedDispaly(NutOffSet obj_) {
            this.obj = obj_;
        }

        public void run() {
            obj.displayObj();
        }
    }

    //head
    private void removeComponentFromHeadPanel() {
        //x11
        jPanel10.removeAll();
        //y11
        jPanel25.removeAll();;
    }

    private void addComponentToHeadPanel(int x11_num, int y11_num) throws Throwable{
        
        String hql = "from CatDeviceparamValue as u where u.name = '%s' and u.catDeviceparamType.name = 'screw_compensate' order by u.position asc"; //desc is descrease order
        System.out.println(String.format(hql, "X11"));
        List<CatDeviceparamValue> params_x11 = null;
        try {
            params_x11 = paraSvc.findByHQL(String.format(hql, "X11"));
        } catch (Exception e) {
            throw e;
        }
        //x11      
        if (params_x11 != null) {  
            int x11_sum = params_x11.size();
            System.out.println(x11_sum);
            int cl = ((x11_sum - 1) / 20) + 1;
            System.out.println(cl);
            for (int i = 0; i < cl; i++) {
                //jPanel9.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                OffSetUnit osunit = new OffSetUnit();
                osunit.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                for (int j = 0; j < 20;j++) {
                    CatDeviceparamValue dpv = params_x11.get(i*20+j);
                    CoordState coordState = new CoordState(String.valueOf(Float.valueOf(dpv.getPosition()).intValue()), java.awt.Color.gray);
                    coordStates_head_x11.add(coordState);
                    coordStates_head_x11_num.add(Float.valueOf(dpv.getPosition()).intValue());
                    osunit.add(coordState);
                    if ((i*20+j+1)>= x11_sum) {
                        break;
                    }
                }
                jPanel10.add(osunit);
            }
        }
        //**************************************************
        List<CatDeviceparamValue> params_y11 = null;
        try {
            params_y11 = paraSvc.findByHQL(String.format(hql, "Y11"));
        } catch (Exception e) {
            throw e;
        }
        //y11       
        if (params_y11 != null) {  
            int y11_sum = params_y11.size();
            System.out.println(y11_sum);
            int cl = ((y11_sum - 1) / 20) + 1;
            System.out.println(cl);
            for (int i = 0; i < cl; i++) {
                //jPanel24.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                OffSetUnit osunit = new OffSetUnit();
                osunit.add(new com.tongrui.shangweiji.ui.systemadjustment.CoordStateTitle(java.awt.Color.white));
                for (int j = 0; j < 20;j++) {
                    CatDeviceparamValue dpv = params_x11.get(i*20+j);
                    CoordState coordState = new CoordState(String.valueOf(Float.valueOf(dpv.getPosition()).intValue()), java.awt.Color.gray);
                    coordStates_head_y11.add(coordState);
                    coordStates_head_y11_num.add(Float.valueOf(dpv.getPosition()).intValue());
                    osunit.add(coordState);
                    if ((i*20+j+1)>= y11_sum) {
                        break;
                    }
                }
                jPanel25.add(osunit);
            }
        }
    }

    private CoordState getCurrentHeadCoord(int currentHeadCoordIndex) {
        if (jRadioButton1.isSelected()) {
            return coordStates_head_x11.get(currentHeadCoordIndex);
        } else {
            return coordStates_head_y11.get(currentHeadCoordIndex);
        }
    }

    private void checkCurrentHeadCoordState(int currentHeadCoordIndex, Color col) {
        CoordState coordState = getCurrentHeadCoord(currentHeadCoordIndex);
        coordState.setStateByColor(col);
        //返回执行结果；       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel7.setPreferredSize(new java.awt.Dimension(1420, 900));

        jPanel1.setPreferredSize(new java.awt.Dimension(869, 30));

        jLabel1.setFont(new java.awt.Font("宋体", 1, 24));
        jLabel1.setText("螺距补偿测定");
        jLabel1.setPreferredSize(new java.awt.Dimension(80, 20));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(660, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.setFont(new java.awt.Font("宋体", 0, 18));
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(100, 100));
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(869, 544));

        jPanel2.setFont(new java.awt.Font("宋体", 0, 24));
        jPanel2.setPreferredSize(new java.awt.Dimension(869, 500));

        jPanel4.setPreferredSize(new java.awt.Dimension(869, 380));

        jPanel13.setPreferredSize(new java.awt.Dimension(869, 380));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1412, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        //java.awt.Color [] bls = {java.awt.Color.gray,java.awt.Color.red,java.awt.Color.green};
        //for(int j=0;j<3;j++){
            for(int i=1 ;i<19+1;i++){
                jPanel13.add(new CoordState(""+10*i,java.awt.Color.gray));
            }//}

            jPanel5.setPreferredSize(new java.awt.Dimension(869, 120));

            jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "测量选择", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
            jPanel6.setPreferredSize(new java.awt.Dimension(420, 80));

            jLabel2.setFont(new java.awt.Font("宋体", 0, 24));
            jLabel2.setText("起始坐标");

            jTextField1.setFont(new java.awt.Font("宋体", 0, 24));
            jTextField1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
            jTextField1.setText("10");

            jButton1.setFont(new java.awt.Font("宋体", 0, 24));
            jButton1.setText("开始");
            jButton1.setPreferredSize(new java.awt.Dimension(75, 25));
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
            jPanel6.setLayout(jPanel6Layout);
            jPanel6Layout.setHorizontalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(39, 39, 39)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(31, 31, 31))
            );
            jPanel6Layout.setVerticalGroup(
                jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                            .addContainerGap())
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jTextField1)
                            .addGap(53, 53, 53))))
            );

            jButton2.setFont(new java.awt.Font("宋体", 0, 24));
            jButton2.setText("下一个");
            jButton2.setEnabled(false);
            jButton2.setPreferredSize(new java.awt.Dimension(75, 25));
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
            jPanel5.setLayout(jPanel5Layout);
            jPanel5Layout.setHorizontalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(480, 480, 480)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(347, Short.MAX_VALUE))
            );
            jPanel5Layout.setVerticalGroup(
                jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(44, 44, 44)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );

            javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1402, Short.MAX_VALUE))
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1412, Short.MAX_VALUE))
                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                    .addGap(11, 11, 11)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(63, 63, 63))
            );

            jTabbedPane1.addTab("前后", jPanel2);

            jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
            jPanel3.setPreferredSize(new java.awt.Dimension(869, 500));

            jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            jPanel8.setPreferredSize(new java.awt.Dimension(430, 400));

            jPanel10.setPreferredSize(new java.awt.Dimension(430, 380));
            jPanel10.setLayout(new java.awt.GridLayout(1, 0));

            javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
            jPanel8.setLayout(jPanel8Layout);
            jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
            );
            jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
            );

            //java.awt.Color [] bls = {java.awt.Color.gray,java.awt.Color.red,java.awt.Color.green};
            //for(int j=0;j<3;j++){
                for(int i=1 ;i<19+1;i++){
                    jPanel10.add(new CoordState(""+10*i,java.awt.Color.gray));
                }//}

                jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                jPanel11.setPreferredSize(new java.awt.Dimension(430, 400));

                jPanel25.setPreferredSize(new java.awt.Dimension(430, 380));
                jPanel25.setLayout(new java.awt.GridLayout(1, 0));

                javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
                jPanel11.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                    jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
                );
                jPanel11Layout.setVerticalGroup(
                    jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                );

                //java.awt.Color [] bls = {java.awt.Color.gray,java.awt.Color.red,java.awt.Color.green};
                //for(int j=0;j<3;j++){
                    for(int i=1 ;i<19+1;i++){
                        jPanel25.add(new CoordState(""+10*i,java.awt.Color.gray));
                    }//}

                    jPanel14.setPreferredSize(new java.awt.Dimension(869, 120));

                    jButton4.setFont(new java.awt.Font("宋体", 0, 24));
                    jButton4.setText("下一个");
                    jButton4.setEnabled(false);
                    jButton4.setPreferredSize(new java.awt.Dimension(75, 25));
                    jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton4ActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
                    jPanel14.setLayout(jPanel14Layout);
                    jPanel14Layout.setHorizontalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addGap(781, 781, 781)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(513, Short.MAX_VALUE))
                    );
                    jPanel14Layout.setVerticalGroup(
                        jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel14Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, Short.MAX_VALUE))
                    );

                    jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "测量选择", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
                    jPanel15.setPreferredSize(new java.awt.Dimension(420, 80));

                    jLabel3.setFont(new java.awt.Font("宋体", 0, 24));
                    jLabel3.setText("起始坐标");
                    jLabel3.setPreferredSize(new java.awt.Dimension(40, 15));

                    jTextField2.setFont(new java.awt.Font("宋体", 0, 18));
                    jTextField2.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
                    jTextField2.setText("10");

                    jButton3.setFont(new java.awt.Font("宋体", 0, 24));
                    jButton3.setText("开始");
                    jButton3.setPreferredSize(new java.awt.Dimension(75, 25));
                    jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jButton3ActionPerformed(evt);
                        }
                    });

                    jRadioButton1.setFont(new java.awt.Font("宋体", 0, 18));
                    jRadioButton1.setSelected(true);
                    jRadioButton1.setText("X11");
                    jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jRadioButton1ActionPerformed(evt);
                        }
                    });

                    jRadioButton2.setFont(new java.awt.Font("宋体", 0, 18));
                    jRadioButton2.setText("Y11");
                    jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            jRadioButton2ActionPerformed(evt);
                        }
                    });

                    javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
                    jPanel15.setLayout(jPanel15Layout);
                    jPanel15Layout.setHorizontalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jRadioButton2)
                                .addComponent(jRadioButton1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap(23, Short.MAX_VALUE))
                    );
                    jPanel15Layout.setVerticalGroup(
                        jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jRadioButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jRadioButton2))
                    );

                    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                    jPanel3.setLayout(jPanel3Layout);
                    jPanel3Layout.setHorizontalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addContainerGap(512, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(488, 488, 488))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGap(0, 20, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 1400, Short.MAX_VALUE)
                                .addContainerGap()))
                    );
                    jPanel3Layout.setVerticalGroup(
                        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(656, Short.MAX_VALUE)
                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(96, 96, 96)))
                    );

                    jTabbedPane1.addTab("左右和上下", jPanel3);

                    javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
                    jPanel7.setLayout(jPanel7Layout);
                    jPanel7Layout.setHorizontalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1407, Short.MAX_VALUE)
                            .addGap(10, 10, 10))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1427, Short.MAX_VALUE)
                    );
                    jPanel7Layout.setVerticalGroup(
                        jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
                    );

                    jTabbedPane1.getAccessibleContext().setAccessibleName("");

                    jScrollPane1.setViewportView(jPanel7);

                    getContentPane().add(jScrollPane1);

                    pack();
                }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            jButton3.setEnabled(true);
            jButton4.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed
    //bed
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        checkCurrentBedCoordState(currentBedCoord, Color.blue);
        currentBedCoord = ++currentBedCoord >= coordStates_bed.size() ? 0 : currentBedCoord;
        if (currentBedCoord >= coordStates_bed.size()) {
            currentBedCoord = 0;
        }
        checkCurrentBedCoordState(currentBedCoord, Color.green);
        ctrlSvcImplObj.sendCommand(Constant.MANUL_SCREW_NEXT, currentBedCoord, Constant.ADDR_WYS_TBD);
        jButton1.setEnabled(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String textValue = null;
        textValue = jTextField1.getText().trim();
        boolean inputValid = CommonMethod.checkIntFromTextField(textValue, null);
        if (!inputValid || textValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "错误，请输入正整数！");
            return;
        } 
        //else
        int startNum = Integer.valueOf(textValue);
        if (startNum < 0) {
            startNum = 0;
        }
        
        currentBedCoord = currentXXCoord(startNum, coordStates_bed_num);
        checkCurrentBedCoordState(currentBedCoord, Color.green);
        jButton1.setEnabled(false);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private int currentXXCoord(int firstxxCoord_num, List coordStates_XX_num) {
        int count = coordStates_XX_num.size();
        int c_index = coordStates_XX_num.indexOf(firstxxCoord_num);
        if (c_index < 0) {
            coordStates_XX_num.add(firstxxCoord_num);
            Collections.sort(coordStates_XX_num);
            c_index = coordStates_XX_num.indexOf(firstxxCoord_num);
            coordStates_XX_num.remove(c_index);
        }
        if (c_index >= count) {
            c_index = 0;
        }
        return c_index;
    }

    //head
    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            jButton3.setEnabled(true);
            jButton4.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String textValue = null;
        textValue = jTextField2.getText().trim();
        boolean inputValid = CommonMethod.checkIntFromTextField(textValue, null);
        if (!inputValid || textValue.isEmpty()) {
            JOptionPane.showMessageDialog(this, "错误，请输入正整数！");
            return;
        } 
        //else
        int startNum = Integer.valueOf(textValue);
        if (startNum < 0) {
            startNum = 0;
        }

        if (jRadioButton1.isSelected()) {
            currentHeadCoord = currentXXCoord(startNum, coordStates_head_x11_num);
        } else if (jRadioButton2.isSelected()) {
            currentHeadCoord = currentXXCoord(startNum, coordStates_head_y11_num);
        }
        checkCurrentHeadCoordState(currentHeadCoord, Color.green);
        jButton3.setEnabled(false);
        jButton4.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        checkCurrentHeadCoordState(currentHeadCoord, Color.blue);
        currentHeadCoord = ++currentHeadCoord >= coordStates_head_x11.size() ? 0 : currentHeadCoord;
        if (currentHeadCoord >= coordStates_head_x11.size()) {
            currentHeadCoord = 0;
        }

        checkCurrentHeadCoordState(currentHeadCoord, Color.green);
        jButton3.setEnabled(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        manualScrew = null;
    }//GEN-LAST:event_formWindowClosing

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NutOffSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NutOffSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NutOffSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NutOffSet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new NutOffSet().setVisible(true);
                } catch (Throwable ex) {
                    Logger.getLogger(NutOffSet.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "本地数据库访问出错,程序将退出!");
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
    private List<CoordState> coordStates_bed;
    private List<CoordState> coordStates_head_x11;
    private List<CoordState> coordStates_head_y11;
    private int currentBedCoord = 0;
    private int currentHeadCoord = 0;
    //private int currentHeadCoord_y11 = 0;
    private static ControllerSvcImpl ctrlSvcImplObj = ControllerSvcImpl.getInstance();
    private static ParameterService paraSvc = ServiceLocator.getParameterService();
}