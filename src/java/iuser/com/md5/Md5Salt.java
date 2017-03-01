/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuser.com.md5;
/**
 *
 * @author �深夜徘徊
 */
import java.lang.reflect.Method;  
import java.security.NoSuchAlgorithmException;  
 
public class Md5Salt {  
    
    public static String getMD5(byte[] source) {  
        String s = null;  
        char hexDigits[] = { '0','a','9','J','4','c','7','W','2','v', 'R','3','h','7','I','5' };
        try {  
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");  
            md.update(source);  
            byte tmp[] = md.digest();
            char str[] = new char[16 * 2];
            int k = 0;
            for (int i = 0; i < 16; i++) {
                byte byte0 = tmp[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }  
            s = new String(str);
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
            //e.printStackTrace();
            System.out.println(e);
        }  
        return s;  
    } 
    
    public static String encodeBase64(byte[]input) throws Exception{  
        Class clazz=Class.forName("com.sun.org.apache.xerces.internal.impl.dv.util.Base64");  
        Method mainMethod= clazz.getMethod("encode", byte[].class);  
        mainMethod.setAccessible(true);  
         Object retObj=mainMethod.invoke(null, new Object[]{input});  
         return (String)retObj;  
    } 
    
    /*Test*/
    public static void main(String[] args) throws Exception{
        
        String name = "abc";
        String keya="@#$&*1029we";
        String keyb="})*vbks!1214";
        String password = "a123456";
        String str =keya+name+password+keyb;
        
        String test="$a&m|:p"+Md5Salt.getMD5(str.getBytes())+"4r0gf~!*^@j86";
        System.out.println(str);
        System.out.println(test);
        System.out.println(Md5Salt.getMD5(password.getBytes()));
        
        System.out.println(Md5Salt.encodeBase64(test.getBytes()));
        System.out.println("//*"+Md5Salt.encodeBase64(test.getBytes()).replaceAll("X","8").replaceAll("==","*//").replaceAll("R","|").replaceAll("2","e").replaceAll("m","c").replaceAll("J","Es").replaceAll("6","*").replaceAll("N","*"));
    }  
}
