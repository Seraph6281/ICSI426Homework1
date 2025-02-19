import java.security.SecureRandom;

/**
 * Provides Vigenere Cipher encryption.
 * generating random keys for encryption.
 * @author Yingzhao Ma
 * @version 1.1
 */
public class VigenereCipher {
    /**
     * Generates a random key of the same length as the provided plaintext.
     * The key consists of randomly selected uppercase English letters.
     * @param plainText the input text for which a random key is generated; its length determines the key size
     * @return a string representing the randomly generated key
     */
    public static String generateRandomKey(String plainText){

        int length = plainText.length(); // The length of the plaintext
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Upper case English letters
        SecureRandom random = new SecureRandom(); // Strong random number generator
        StringBuilder key = new StringBuilder(length);

        for (int index = 0; index < length; index++) {
            key.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }

        return key.toString();
    }

    /**
     * Encrypts the provided plaintext using the Vigenère Cipher method with the given key.
     * The encryption ensures that only uppercase alphabetic characters (A-Z) are encrypted.
     * Non-alphabetic characters in the plaintext remain unchanged.
     * @param plainText the input text to be encrypted
     * @param key the encryption key to be used; it should be of the same length as the plaintext
     * @return the resulting cipher text after encryption
     */
    public static String encrypt(String plainText, String key)
    {
        StringBuilder cipherText = new StringBuilder();
        int length = plainText.length();

        for (int index = 0; index < length; index ++) {
            char plainChar = Character.toUpperCase(plainText.charAt(index));
            char keyChar = key.charAt(index);

            // Ensures only A-Z characters are encrypted
            if (plainChar >= 'A' && plainChar <= 'Z') {
                int encryptedChar = ((plainChar - 'A') + (keyChar - 'A')) % 26;
                cipherText.append((char) ('A' + encryptedChar));
            } else {
                cipherText.append(plainChar); // Non-alphabet characters remain unchanged
            }
        }
        return cipherText.toString();
    }

}
