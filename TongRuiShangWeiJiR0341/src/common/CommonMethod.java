/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import com.tongrui.shangweiji.data.CatDeviceparamValue;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class CommonMethod {
    
    //k是小数点后位数, k >= 1
    public static String dobuleToPointsString(double data, int k) {
        NumberFormat f = NumberFormat.getInstance();
        f.setMaximumFractionDigits(k);
        String textValue = f.format(data);
        int dotAt = textValue.indexOf(".");//得到小数点的位置
        if (dotAt == -1) { //如果只有整数,无小数点
            textValue += ".";
            while (k-- > 0) {
                textValue += "0";
            }
        } else {
            while (textValue.length() < dotAt + k + 1) {//如果小数位不够则补0   
                textValue += "0";
            }
        }

        return textValue;
    }

    public static boolean checkDoubleFromTextField(String value, boolean displayDlg) {
        boolean res = false;
        try {
            float floatValue = Float.parseFloat(value);
            res = true;
        } catch (Exception e) {
            if (displayDlg) {
                JOptionPane.showMessageDialog(null, "错误，请输入有效值！");
            }
        }
        return res;
    }
    
    public static boolean checkIntFromTextField(String value, JFrame parent) {
        boolean res = true;
        
        for (int k = 0; k < value.length(); k++) {
            if (value.charAt(k) < '0' || value.charAt(k) > '9') {
                res = false;
                break;
            }
        }
        
        if ((res == false) && (parent != null)) {
                JOptionPane.showMessageDialog(parent, "错误，请输入整数！");
            }
        
        return res;
    }
    

    public static boolean isDateStringValid(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //    DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);   //这个的功能是不把1996-13-3 转换为1997-1-3
    //    dateTimeFormat.setLenient(false);

        if (dateStr == null || dateStr.isEmpty()) {
            return true;
        } 
        else if(dateStr.trim().isEmpty()) {
            return false;  //如果输入日期字符为空格
        }
        
        dateStr = dateStr.trim();
        Date date = null;
        try {
            if (dateStr.length() <= 10) {
                date = dateFormat.parse(dateStr);
            } else {
                return false;
//                date = dateTimeFormat.parse(dateStr);
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static Date parseStringToDate(String dateStr) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        dateFormat.setLenient(false);   //这个的功能是不把1996-13-3 转换为1997-1-3
        dateTimeFormat.setLenient(false);

        if (dateStr == null || dateStr.trim().equals("")) {
            return null;
        }
        dateStr = dateStr.trim();
        Date date = null;
        try {
            if (dateStr.length() <= 10) {
                date = dateFormat.parse(dateStr);
            } else {
                date = dateTimeFormat.parse(dateStr);
            }
        } catch (Exception e) {
            return null;
        }
        return date;
    }
    
    public static boolean tableCheckValid(DefaultTableModel tableModel, int colum) {
        int rowCount = tableModel.getRowCount();
        for (int i = 0; i < rowCount; i++) {
            String currNewValue = "";
            if (tableModel.getValueAt(i, colum) != null) {
                currNewValue = (String) tableModel.getValueAt(i, colum);
            }
            boolean inputValid = CommonMethod.checkDoubleFromTextField(currNewValue,true);
            if (!inputValid) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean tableCheckRange(DefaultTableModel tableModel, int colum, List<CatDeviceparamValue> paramList) {
        int rowCount = tableModel.getRowCount();
        CatDeviceparamValue param = null;
        
        String currNewValue = null;
        Float value = null;
        for (int i = 0; i < rowCount; i++) {
            if (tableModel.getValueAt(i, colum) != null) {
                currNewValue = (String) tableModel.getValueAt(i, colum);
                value = Float.parseFloat(currNewValue);
            }
      
            param = paramList.get(i);
            if (param.getLowlimit() == null || param.getUplimit() == null || param.getLowlimit() >= param.getUplimit()) {
                JOptionPane.showMessageDialog(null, "数据范围设定有误,没有进行范围检查！");
            } else {
                if (value == null || param.getLowlimit() > value || param.getUplimit() < value) {
                    return false;
                }
            }
        }
        return true;
    }
}
