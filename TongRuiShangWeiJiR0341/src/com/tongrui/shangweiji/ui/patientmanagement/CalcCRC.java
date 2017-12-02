/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui.patientmanagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CalcCRC {
    private char[] crc_tb = {
        0x0000,
        0x1081,
        0x2102,
        0x3183,
        0x4204,
        0x5285,
        0x6306,
        0x7387,
        0x8408,
        0x9489,
        0xa50a,
        0xb58b,
        0xc60c,
        0xd68d,
        0xe70e,
        0xf78f
    };

    private char caluCRC(byte[] pByte) {
        int len = pByte.length;
        char crc;
        byte da;
        crc = 0x0;
        int i = 0;
        while (len-- != 0) {
            da = (byte) (crc / 256);
            crc <<= 8;
            int num = da ^ pByte[i];
            if (num < 0) {
                num += 256;
            }
            crc ^= crc_tb[num];
            ++i;
        }
        return crc;
    }
    
    private int caluCRC(List<String> lines) {
        char crc;
        byte dat8;
        crc = 0xffff;
        for (int k = 0; k < lines.size()-3; k++) {
            String aline = lines.get(k);
            byte[] bt = aline.getBytes();
            System.out.println(aline);

            for (int i = 0; i < aline.length(); i++) {
                dat8 = bt[i];
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
                dat8 >>= 4;
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
            }
            {
                dat8 = (byte)0x0d;
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
                dat8 >>= 4;
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
            }
            {
                dat8 = (byte)0x0a;
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
                dat8 >>= 4;
                crc = (char)(((crc >> 4) & 0x0fff) ^ crc_tb[((crc ^ dat8) & 0x000f)]);
            }
            System.out.println(~crc & 0x0ffff);
        }
        int result = ~crc & 0x0ffff;
        System.out.println("CRC十六进制字符串是:" + Integer.toHexString(result));
        System.out.println("CRC整数类型的数据是:" + result);
        return result;

    }

    public boolean isCrcCorrect(List<String> lines) {
        int result = caluCRC(lines);
        String raw = lines.get(lines.size()-1).substring(6); //The 5th is '='
        
        return result == Integer.parseInt(raw);
    }
    
    public static void main(String[] args)   throws Exception{
        CalcCRC crc = new CalcCRC();
        
        TPSFileReader tf = new TPSFileReader();
        File f = new File("D:/projects/12061301@ding jun he@1206130101-1.out");
        List<String> lines = tf.readFile(f);
         
        boolean b = crc.isCrcCorrect(lines);
        System.out.println(b);
    }
}
