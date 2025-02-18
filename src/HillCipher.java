/**
 * Provides encryption using the Hill Cipher.
 * ** Requires a square matrix as the key. **
 * ** Supports 2 * 2 and 3 * 3 matrix **
 * The plaintext is divided into blocks matching the size of the key matrix.
 * Matrix multiplication is used to transform these blocks into ciphertext.
 * Non-multiples of the block size are padded before encryption.
 *
 * @author Yingzhao (Seraph) Ma
 */

public class HillCipher {

    /**
     * Maps a character to its corresponding numerical value.
     * The conversion maps 'A' to 0, 'B' to 1, ..., 'Z' to 25.
     * @param c the character to be converted
     * @return the numerical value of the character, with 'A' being 0 and 'Z' being 25
     */
    private static int charToNum(char c) {
        return c - 'A';
    }

    /**
     * Converts a number to its corresponding uppercase character.
     * The conversion uses a modular arithmetic operation to ensure the result
     * maps to a value within the range 'A' to 'Z'.
     *
     * @param num the numerical value to be converted
     * @return the uppercase alphabetical character corresponding to the given number
     */
    private static char numToChar(int num) {
        return (char) ('A' + (num % 26));
    }

    /**
     * Encrypts the given plaintext using a Hill Cipher approach with the provided key matrix.
     * The plaintext is divided into equal-sized blocks based on the dimensions of the key matrix.
     * If the length of the plaintext is not a multiple of the matrix size, padding is added.
     *
     * @param plaintext the input string to be encrypted, consisting of uppercase letters
     * @param keyMatrix a 2D square integer array representing the cipher's key matrix
     * @return the resulting ciphertext as a string, consisting of uppercase letters
     */
    public static String encrypt(String plaintext, int[][] keyMatrix) {
        int size = keyMatrix.length;
        if (plaintext.length() % size != 0) {
            plaintext = padPlaintext(plaintext, size);
        }

        StringBuilder cipherText = new StringBuilder();
        for (int i = 0; i < plaintext.length(); i += size) {
            int[] plainVector = new int[size];

            // Convert plaintext block to a numerical vector
            for (int j = 0; j < size; j++) {
                plainVector[j] = charToNum(plaintext.charAt(i + j));
            }

            // Matrix multiplication: CipherVector = KeyMatrix * PlainVector (mod 26)
            int[] cipherVector = new int[size];
            for (int row = 0; row < size; row++) {
                int sum = 0;
                for (int col = 0; col < size; col++) {
                    sum += keyMatrix[row][col] * plainVector[col];
                }
                cipherVector[row] = sum % 26;
            }

            // Convert cipher vector to text
            for (int num : cipherVector) {
                cipherText.append(numToChar(num));
            }
        }
        return cipherText.toString();
    }

    /**
     * Pads the given plaintext to ensure its length is a multiple of the specified size.
     * Padding is added using the character 'X'.
     *
     * @param text the plaintext string to be padded
     * @param size the block size to which the length of the text should be adjusted
     * @return the padded plaintext string
     */
    private static String padPlaintext(String text, int size) {
        int paddingNeeded = size - (text.length() % size);
        char paddingChar = 'X'; // Padding character
        return text + String.valueOf(paddingChar).repeat(paddingNeeded);
    }
}
