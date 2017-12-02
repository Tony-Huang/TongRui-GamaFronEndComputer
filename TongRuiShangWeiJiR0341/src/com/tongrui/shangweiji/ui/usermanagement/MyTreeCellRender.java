/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.usermanagement;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreePath;

/**
 *
 * @author Administrator
 */
public class MyTreeCellRender  extends DefaultTreeCellRenderer {
    
    public Component getTreeCellRendererComponent(
                        JTree tree,
                        Object value,
                        boolean sel,
                        boolean expanded,
                        boolean leaf,
                        int row,
                        boolean hasFocus) {

        JLabel label=  (JLabel) super.getTreeCellRendererComponent(
                        tree, value, sel,
                        expanded, leaf, row,
                        hasFocus);
        DefaultMutableTreeNode node =  (DefaultMutableTreeNode)value;
        TreePath selpath = tree.getSelectionPath();
        if(selpath!=null){
          Object[] path =  selpath.getPath();
       // DefaultMutableTreeNode[]  path = (DefaultMutableTreeNode[]) selpath.getPath();
        for(int i=0;i<path.length ;i++){
          if(node==path[i]){
          label.setBackground(Color.blue);
          }
        }
        }
        return this;
    }
    
}
