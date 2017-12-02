/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CureHeadState.java
 *
 * Created on 2012-9-28, 11:07:09
 */
package com.tongrui.shangweiji.ui.treatmentcontrol;

import com.tongrui.shangweiji.comm.CurePolar;
import common.CommonMethod;
import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class CureHeadState extends javax.swing.JPanel {

    /** Creates new form CureHeadState */
    public CureHeadState() {
        initComponents();
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

        jTextField2 = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new ColorLight(Color.GREEN, true, 18);
        jPanel1 = new ColorLight(Color.GREEN, true, 18);
        jPanel3 = new ColorLight(Color.GREEN, false, 18);
        jPanel4 = new ColorLight(Color.GREEN, false, 18);

        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "治疗头状态", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 18))); // NOI18N
        setLayout(new java.awt.GridBagLayout());

        jTextField2.setEditable(false);
        jTextField2.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("10.76'");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextField2, gridBagConstraints);

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("宋体", 0, 24));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("10.76'");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jTextField1, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("resources_cn"); // NOI18N
        jLabel1.setText(bundle.getString("treatment.control.head.source")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel2.setText(bundle.getString("treatment.control.head.collimator")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel3.setText(bundle.getString("treatment.control.head.position")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel4.setText(bundle.getString("treatment.control.head.rotation")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel5.setText(bundle.getString("treatment.control.head.shieldpostion")); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jLabel5, gridBagConstraints);

        jPanel2.setMinimumSize(new java.awt.Dimension(45, 45));
        jPanel2.setPreferredSize(new java.awt.Dimension(45, 45));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel2, gridBagConstraints);

        jPanel1.setMinimumSize(new java.awt.Dimension(45, 45));
        jPanel1.setPreferredSize(new java.awt.Dimension(45, 45));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel1, gridBagConstraints);

        jPanel3.setMinimumSize(new java.awt.Dimension(45, 45));
        jPanel3.setPreferredSize(new java.awt.Dimension(45, 45));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel3, gridBagConstraints);

        jPanel4.setMinimumSize(new java.awt.Dimension(45, 45));
        jPanel4.setPreferredSize(new java.awt.Dimension(45, 45));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 45, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    public void update_date(CurePolar curePolar) {
        jTextField1.setText(CommonMethod.dobuleToPointsString(curePolar.getSourcePosition_T2(),2));
        jTextField2.setText(CommonMethod.dobuleToPointsString(curePolar.getCollimatorPosition_Z2(),2));

        //T2 rotate state-light
        int state = curePolar.getSourceROState_T2();
        if(state == 0) { //stop state
            ((ColorLight)jPanel1).setArrowCycle(false);
            ((ColorLight)jPanel1).setClockColor(Color.gray);
        } else {        //rotating
            ((ColorLight)jPanel1).setArrowCycle(true);
            ((ColorLight)jPanel1).setClockColor(Color.green);
        }
        
        //Z2 rotate state-light
        state = curePolar.getCollimatorROState_Z2();
        if(state == 0) { //stop state
            ((ColorLight)jPanel2).setArrowCycle(false);
            ((ColorLight)jPanel2).setClockColor(Color.gray);
        } else {        //rotating
            ((ColorLight)jPanel2).setArrowCycle(true);
            ((ColorLight)jPanel2).setClockColor(Color.green);
        }
        
        //T2 shield state-light
        state = curePolar.getSourceShieldPosState_T2();
        if(state == 0) { //stop state
            ((ColorLight)jPanel3).setClockColor(Color.green);
        } else {        //radio
            ((ColorLight)jPanel3).setClockColor(Color.red);
        }
        
        //Z2 shield state-light
        state = curePolar.getCollShieldPosState_Z2();
        if(state == 0) { //stop state
            ((ColorLight)jPanel4).setClockColor(Color.green);
        } else {        //radio
            ((ColorLight)jPanel4).setClockColor(Color.red);
        }
    }
}