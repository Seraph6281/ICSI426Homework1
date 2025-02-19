import java.util.Arrays;
import java.util.Scanner;

/**
 * The main entry point and controller for the encryption process.
 * @author Yingzhao (Seraph) Ma
 * @version 1.1
 */
public class Driver {

    /**
     * Initiates the encryption process
     */
    public static void start(){
        encrypt(plainTextInput(), hillKeyMatrixInput());
    }

    /**
     * Prompts the user to input a plaintext message and captures the input.
     * @return a string containing the plaintext entered by the user
     */
    public static String plainTextInput(){
        System.out.println("Please enter a plaintext: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    /**
     * Prompts the user to input the size of a square key matrix and the matrix values
     * for use in the Hill Cipher encryption.
     * Supports 2x2 or 3x3 matrices.
     *
     * @return a two-dimensional integer array representing the Hill Cipher key matrix
     */
    public static int[][] hillKeyMatrixInput(){
        System.out.println("Support 2*2 or 3*3 Hill Cipher square key matrix. Please indicate the size: ");
        Scanner scanSize = new Scanner(System.in);
        int size = scanSize.nextInt();

        System.out.println("Please enter a Hill Cipher key matrix: ");
        Scanner scanMatrix = new Scanner(System.in);
        int[][] hillKeyMatrix = new int[size][size];

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                hillKeyMatrix[i][j] = scanMatrix.nextInt();
            }
        }
        return hillKeyMatrix;
    }

    /**
     * Encrypts the provided plaintext using a combination of the three encryption methods:
     * @param plaintext the plaintext to be encrypted
     * @param hillKeyMatrix the key matrix to be used in the Hill Cipher encryption
     */
    public static void encrypt(String plaintext, int[][] hillKeyMatrix) {
        // Vigenère Cipher Encryption
        String vigenereKey = VigenereCipher.generateRandomKey(plaintext);
        String vigenereEncrypted = VigenereCipher.encrypt(plaintext, vigenereKey);
        System.out.println("Vigenère Cipher Key: " + vigenereKey);
        System.out.println("Vigenère Cipher Encryption: " + vigenereEncrypted);

        // Row Transposition Cipher Encryption
        Integer[] rowTransKey = RowTrans.generateRandomKey(vigenereEncrypted);
        String rowTransEncrypted = RowTrans.encrypt(vigenereEncrypted, rowTransKey);
        System.out.println("Row Transposition Cipher Key: " + Arrays.toString(rowTransKey));
        System.out.println("Row Transposition Cipher Encryption: " + rowTransEncrypted);

        // Hill Cipher Encryption
        String finalEncrypted = HillCipher.encrypt(rowTransEncrypted, hillKeyMatrix);
        System.out.println("Hill Cipher Encryption: " + finalEncrypted);

        //return finalEncrypted;
    }
}
