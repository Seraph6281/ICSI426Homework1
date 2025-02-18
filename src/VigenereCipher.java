/**
 *
 */

import java.security.SecureRandom;

public class VigenereCipher {

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
