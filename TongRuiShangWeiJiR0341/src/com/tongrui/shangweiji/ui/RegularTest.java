/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tongrui.shangweiji.ui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularTest {

    static void test() {
        Pattern p = null;
        Matcher m = null;

        boolean b = false;

        //正则表达式表示首字母是a，中间是任意多个a，结尾以b结束
        //不匹配的结果 
        p = Pattern.compile("[a-zA-Z]\\w{5,}");
        m = p.matcher("_ab999a");
        b = m.matches();
        System.out.println("匹配结果：" + b); //输出：false 
        
        //匹配的结果 
      //  p = Pattern.compile("[a-zA-Z _0-9]{6,}");
        p = Pattern.compile("[a-zA-Z][\\w ]+");
        m = p.matcher("a2a hh");
        b = m.matches();
        System.out.println("匹配结果：" + b); //输出：true 

        //匹配的结果 
        p = Pattern.compile("\\w+");
        m = p.matcher("_aaeab");
        b = m.matches();
        System.out.println("匹配结果：" + b); //输出：false  
    }

    public static void main(String argus[]) {
        test();
    }
}
