package Model;

import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PasswordSalt {

    private static final Logger logger = Logger.getLogger(PasswordSalt.class);

    public final static String algorithm = "MD5";

    public static String generateHash(String password, byte[] salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        digest.update(salt);
        byte[] hash = digest.digest(password.getBytes());
        return bytesToStringHex(hash);
    }

    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToStringHex(byte[] hash) {
        char[] hexChars = new char[hash.length*2];
        for (int i=0;i<hash.length;i++){
            int q = hash[i] & 0xFF;
            hexChars[i * 2] = hexArray[q >>> 4];
            hexChars[i*2+1] = hexArray[q & 0x0F];
        }

        return new String(hexChars);
    }

    public byte[] createSalt(){
        byte[] bytes = new byte[20];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(bytes);
        logger.info("Salt was generated!");
        return bytes;
    }
}
