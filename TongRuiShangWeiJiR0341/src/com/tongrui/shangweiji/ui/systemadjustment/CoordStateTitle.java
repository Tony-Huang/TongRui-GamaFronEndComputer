/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.systemadjustment;

import java.awt.Color;

/**
 *
 * @author Administrator
 */
public class CoordStateTitle extends javax.swing.JPanel {

    /**
     * Creates new form CoordState
     */
    public CoordStateTitle() {
        initComponents();
    }
    
    public CoordStateTitle(Color bgColor) {
        initComponents();
        //jLabel1.setText(lbname);
        //jLabel2.setText(lbname2);
        jLabel2.setBackground(bgColor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(130, 30));

        jLabel1.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel1.setText("坐标");
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 15));

        jLabel2.setFont(new java.awt.Font("宋体", 0, 24));
        jLabel2.setText("指示灯");
        jLabel2.setPreferredSize(new java.awt.Dimension(60, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
