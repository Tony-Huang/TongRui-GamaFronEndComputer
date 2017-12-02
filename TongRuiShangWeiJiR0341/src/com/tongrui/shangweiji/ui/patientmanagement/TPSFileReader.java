/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrator
 */
public class TPSFileReader {
    
    public  List<String> readFile(File file)  throws Exception{
       BufferedReader brd = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
       List<String> allLines = new ArrayList<String>();
       String aLine = brd.readLine();
       while(aLine != null) {
           allLines.add(aLine);
           aLine = brd.readLine();
       }
       
       brd.close();
       
       return allLines;
    }
    
    public static void main(String[] args)  throws Exception{
      TPSFileReader tf = new TPSFileReader();
      File f = new File("C:/Documents and Settings/Administrator/桌面/同锐/TPS说明/09001@HeadSphere@0900109.out");
      tf.readFile(f);
    }
    
    
}
