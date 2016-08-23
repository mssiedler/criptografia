/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package criptografia;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author marcelosiedler
 */
public class Criptografia {

   public static void main(String[] args) {
        String password1 = "Senha1";
        String password2 = "Senha2";
 
        try {
            String password1MD5 = convertPasswordToMD5(password1);
            String password2MD5 = convertPasswordToMD5(password2);
 
            String passwordCompareMD5 = convertPasswordToMD5(password1);
 
            System.out.println("Password1: " + password1MD5);
            System.out.println("Password2: " + password2MD5);
 
            System.out.println("passwordCompareMD5: " + passwordCompareMD5);
 
            if (password1MD5.equals(passwordCompareMD5)) {
                System.out.println("Compare OK");
            } else {
                System.out.println("Compare NOK");
            }
 
            if (password2MD5.equals(passwordCompareMD5)) {
                System.out.println("Compare OK");
            } else {
                System.out.println("Compare NOK");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
   
   public static String convertPasswordToMD5(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
 
        BigInteger hash = new BigInteger(1, md.digest(password.getBytes()));
 
        return String.format("%32x", hash);
    }
    
}
