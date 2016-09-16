/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Entity;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author MFEYET Daniel Steven
 */
public class MD5 {
    private static MessageDigest digester; 
    static {
        try {
            digester =MessageDigest.getInstance("MD5");
            
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MD5.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static String crypt (String str){
        
        if(str== null || str.length() == 0){
            throw new IllegalArgumentException("String to encrypt cannot be null or zero lengt");
            
        }
        digester.update(str.getBytes());
        byte[] hash =digester.digest();
        StringBuffer hexString = new StringBuffer();
        for(int i=0;i<hash.length;i++){
            if((0xff & hash[i] ) < 0x10){
                hexString.append("0"+ Integer.toHexString((0xFF & hash[i])));
                
            }
            else {
            hexString.append(Integer.toHexString((0xFF & hash[i])));    
            }
        }
        return hexString.toString();
        
    }
   
}
