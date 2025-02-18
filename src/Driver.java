public class Driver {
    public static String encrypt(String plaintext, String vigenereKey, Integer[] rowKey, int[][] hillKeyMatrix) {
        // Step 1: Vigenère Cipher Encryption
        String vigenereEncrypted = VigenereCipher.encrypt(plaintext, vigenereKey);
        System.out.println("Vigenère Cipher Encryption: " + vigenereEncrypted);

        // Step 2: Row Transposition Cipher Encryption
        String rowTransEncrypted = RowTrans.encrypt(vigenereEncrypted, rowKey);
        System.out.println("Row Transposition Cipher Encryption: " + rowTransEncrypted);

        // Step 3: Hill Cipher Encryption
        String finalEncrypted = HillCipher.encrypt(rowTransEncrypted, hillKeyMatrix);
        System.out.println("Hill Cipher Encryption: " + finalEncrypted);

        return finalEncrypted;
    }
}
