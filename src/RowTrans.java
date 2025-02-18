import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 
 */
public class RowTrans {


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
}

