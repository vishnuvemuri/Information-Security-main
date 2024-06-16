import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class des {
    public static void main(String[] argv) {
        try {
            System.out.println("Message Encryption Using DES Algorithm\n-------");
            
            // Generate a DES key
            KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
            SecretKey myDesKey = keygenerator.generateKey();
            
            // Create a DES cipher
            Cipher desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            
            // Encrypt the message
            desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
            byte[] plaintext = "Secret Information".getBytes();
            System.out.println("Message [Byte Format]: " + plaintext);
            System.out.println("Message: " + new String(plaintext));
            byte[] ciphertext = desCipher.doFinal(plaintext);
            System.out.println("Encrypted Message: " + ciphertext);
            
            // Decrypt the message
            desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
            byte[] decryptedtext = desCipher.doFinal(ciphertext);
            System.out.println("Decrypted Message: " + new String(decryptedtext));
            
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException |
                 IllegalBlockSizeException | BadPaddingException e) {
            e.printStackTrace();
        }
    }
}
