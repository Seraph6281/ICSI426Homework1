## **How to Run This Program**
This guide provides instructions to run the program that encrypts plaintext using the Vigenère Cipher, Row Transposition Cipher, and Hill Cipher in sequence.
This repository is also available on [GitHub](https://github.com/Seraph6281/ICSI426Homework1).

### **Environment for Running**
1. Install Java Development Kit (JDK), (version 8 or higher).
2. Make sure the `java` command is available in your terminal/command prompt.
3. Ensure all related `.java` files (i.e., `Main.java`, `Driver.java`, `VigenereCipher.java`, `RowTrans.java`, `HillCipher.java`) are in the **same directory**.
4. If you are using an IDE, ignore the first three instructions. 

### **Steps to Compile and Run**
1. **Navigate to the Directory:** Open a terminal/command prompt and navigate to the folder where the `.java` files are located
2. **Compile the Files:** Compile all the `.java` files using the `javac` command. This will generate `.class` files for each `.java` file.
3. **Run the Program:** Execute the `Main` class using the `java` command.
4. Again: if you are using an IDE, ignore the first three instructions. Simply start by click and run the `Main` class. 

### **What to Expect**
1. **User Input:**
    - The program will prompt you to:
        - **Enter the plaintext** to be encrypted.
        - **Specify the size of the Hill Cipher square key matrix** (2x2 or 3x3).
        - **Enter the values of the Hill Cipher matrix**, row by row.
2. **Encryption Process:**
    - The plaintext will be encrypted in three steps:
        - **Vigenère Cipher**: Random key generation and encryption.
        - **Row Transposition Cipher**: Random key generation and encryption.
        - **Hill Cipher**: Encryption using the provided matrix.
3. **Output:**
    - The program will display:
        - Vigenère Cipher key and encryption result.
        - Row Transposition Cipher key and encryption result.
        - Final encrypted text after the Hill Cipher.



