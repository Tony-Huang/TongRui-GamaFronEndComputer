/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class TableUtil {
    
    public static void clearModelData(DefaultTableModel model){
        for(int i = model.getRowCount()-1;i >-1 ; i--){
         model.removeRow(i);
        }
    }
    
     public static void clearTableData(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        clearModelData(model);
    }
    
    
}
