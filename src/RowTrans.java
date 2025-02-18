import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Provides Row Transposition Cipher encryption.
 * Supports generating random keys for encryption.
 *
 * @author Yingzhao (Seraph) Ma
 */
public class RowTrans {

    /**
     * Generates a random key for row transposition cipher encryption based on the length of the given plaintext.
     * The key is a randomly shuffled sequence of integers ranging from 0 to the length of the plaintext, exclusive.
     *
     * @param plainText the plaintext for which the random key is generated; its length determines the key size
     * @return an array of integers representing the randomly shuffled key sequence for the row transposition cipher
     */
    public static Integer[] generateRandomKey(String plainText) {
        int length = plainText.length();
        List<Integer> keyList = IntStream.range(0, length).boxed().collect(Collectors.toList());
        Collections.shuffle(keyList, new Random());
        return keyList.toArray(new Integer[0]);
    }

    public static String encrypt(String plainText, Integer[] key) {
        int columns = key.length;
        int rows = (int) Math.ceil((double) plainText.length() / columns);
        char[][] grid = new char[rows][columns];

        // Fill grid row-wise
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (index < plainText.length()) {
                    grid[r][c] = plainText.charAt(index++);
                } else {
                    grid[r][c] = 'X'; // Padding if necessary
                }
            }
        }

        // Encrypt using column order from key
        StringBuilder cipherText = new StringBuilder();
        for (int col : key) {

            for (int r = 0; r < rows; r++) {
                cipherText.append(grid[r][col]);
            }
        }
        return cipherText.toString();
    }

    public static String decrypt(String cipherText, Integer[] key) {
        int columns = key.length;
        int rows = (int) Math.ceil((double) cipherText.length() / columns);
        char[][] grid = new char[rows][columns];

        int index = 0;
        // Reverse key mapping to restore original order
        Integer[] reverseKey = new Integer[key.length];
        for (int i = 0; i < key.length; i++) {
            reverseKey[key[i]] = i;
        }

        // Fill the grid column-wise based on key order
        for (int col : reverseKey) {
            for (int r = 0; r < rows; r++) {
                grid[r][col] = cipherText.charAt(index++);
            }
        }

        // Read plaintext row-wise
        StringBuilder plainText = new StringBuilder();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                plainText.append(grid[r][c]);
            }
        }
        return plainText.toString().replace("X", ""); // Remove padding
    }
}

