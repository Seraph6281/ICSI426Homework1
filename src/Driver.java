import java.util.Arrays;
import java.util.Scanner;

public class Driver {

    public static void start(){
        encrypt(plainTextInput(), hillKeyMatrixInput());
    }

    public static String plainTextInput(){
        System.out.println("Please enter a plaintext: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

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
