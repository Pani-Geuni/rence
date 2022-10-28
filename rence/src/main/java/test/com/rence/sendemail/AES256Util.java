package test.com.rence.sendemail;

import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

@Component
public class AES256Util {

	  public String encryptAES(String keyString, String plainText, boolean bUrlSafe) {
	        String cipherText = "";
	        if ((keyString == null) || keyString.length() == 0 || (plainText == null) || plainText.length() == 0) {
	            return cipherText;
	        }
	       

	        // 키의 길이는 16, 24, 32 만 지원
	        if ((keyString.length() != 16) && (keyString.length() != 24) && (keyString.length() != 32)) {
	            return cipherText;
	        }
	       
	        try {
	            byte[] keyBytes = keyString.getBytes("UTF-8");
	            byte[] plainTextBytes = plainText.getBytes("UTF-8");

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            int bsize = cipher.getBlockSize();
	            IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(keyBytes, 0, bsize));
	           
	            SecretKeySpec secureKey = new SecretKeySpec(keyBytes, "AES");
	            cipher.init(Cipher.ENCRYPT_MODE, secureKey, ivspec);
	            byte[] encrypted = cipher.doFinal(plainTextBytes);

	            if (bUrlSafe) {
	                cipherText = Base64.encodeBase64URLSafeString(encrypted);
	            } else {
	                cipherText = new String(Base64.encodeBase64(encrypted), "UTF-8");
	            }
	           
	        } catch (Exception e) {
	            cipherText = "";
	            e.printStackTrace();
	        }

	        return cipherText;
	    }
	   
	   
	    public String decryptAES(String keyString, String cipherText) {
	        String plainText = "";
	        if ((keyString == null) || keyString.length() == 0 || (cipherText == null) || cipherText.length() == 0) {
	            return plainText;
	        }
	       
	        if ((keyString.length() != 16) && (keyString.length() != 24) && (keyString.length() != 32)) {
	            return plainText;
	        }

	        try {
	            byte[] keyBytes = keyString.getBytes("UTF-8");
	            byte[] cipherTextBytes = Base64.decodeBase64(cipherText.getBytes("UTF-8"));

	            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	            int bsize = cipher.getBlockSize();
	            IvParameterSpec ivspec = new IvParameterSpec(Arrays.copyOfRange(keyBytes, 0, bsize));
	           
	            SecretKeySpec secureKey = new SecretKeySpec(keyBytes, "AES");
	            cipher.init(Cipher.DECRYPT_MODE, secureKey, ivspec);
	            byte[] decrypted = cipher.doFinal(cipherTextBytes);

	            plainText = new String(decrypted, "UTF-8");
	           
	        } catch (Exception e) {
	            plainText = "";
	            e.printStackTrace();
	        }

	        return plainText;
	    }
	
}
