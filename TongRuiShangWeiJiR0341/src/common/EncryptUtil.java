/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;

/**
 *
 * @author Administrator
 */
public class EncryptUtil {

    private static byte[] keybytes = new byte[16];
    static {
        byte key = 0x31;
        for(short i = 0 ; i< 16;i++){
         keybytes[i] = key;
          key++;
       }
    }
    //=================

    public static String encryptToMD5(String info) {
        byte[] digesta = null;
        try {
            // 得到一个md5的消息摘要  
            MessageDigest alga = MessageDigest.getInstance("MD5");
            // 添加要进行计算摘要的信息  
            alga.update(info.getBytes());
            // 得到该摘要  
            digesta = alga.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 将摘要转为字符串  
        String rs = byte2hex(digesta);
        return rs;
    }

    private static String byte2hex(byte[] b) {
        String hs = "";
        String stmp = "";
        for (int n = 0; n < b.length; n++) {
            stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
            if (stmp.length() == 1) {
                hs = hs + "0" + stmp;
            } else {
                hs = hs + stmp;
            }
        }
        return hs.toUpperCase();
    }

    //================================
    /*
     * 加密 @param value @return
     */
    public static String encrypt(String value) {

        String s = null;

        int mode = Cipher.ENCRYPT_MODE;

        try {
            Cipher cipher = initCipher(mode);

            byte[] outBytes = cipher.doFinal(value.getBytes());

            s = String.valueOf(Hex.encodeHex(outBytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }

    public static String decrypt(String value) {

        String s = null;

        int mode = Cipher.DECRYPT_MODE;

        try {
            Cipher cipher = initCipher(mode);

            byte[] outBytes = cipher.doFinal(Hex.decodeHex(value.toCharArray()));

            s = new String(outBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
    
    private static Cipher initCipher(int mode) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        Key key = new SecretKeySpec(keybytes, "AES");
        cipher.init(mode, key);
        return cipher;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String pwd = "AW";
        String md = EncryptUtil.encryptToMD5(pwd);
        String md2 = EncryptUtil.encryptToMD5(pwd);
        System.out.println("md for        " + pwd + " is :" + md);
        System.out.println("decrypted for " + pwd + " is :" + md2);
        
        
    }

    
}
