import java.util.Scanner;

public class PermutationCipher {

    // Encrypt the message using the given key
    public static String encrypt(String message, int[] key) {
        int blockSize = key.length;

        while (message.length() % blockSize != 0) {
            message += "X";
        }

        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < message.length(); i += blockSize) {
            for (int j = 0; j < blockSize; j++) {
                encrypted.append(message.charAt(i + key[j]));
            }
        }

        return encrypted.toString();
    }

    // Decrypt the encrypted message using the inverse key
    public static String decrypt(String encryptedMessage, int[] key) {
        int blockSize = key.length;
        StringBuilder decrypted = new StringBuilder();

        // Calculate inverse key
        int[] inverseKey = new int[blockSize];
        for (int i = 0; i < blockSize; i++) {
            inverseKey[key[i]] = i;
        }

        for (int i = 0; i < encryptedMessage.length(); i += blockSize) {
            char[] block = new char[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[inverseKey[j]] = encryptedMessage.charAt(i + j);
            }
            decrypted.append(block);
        }

        return decrypted.toString().replaceAll("X+$", ""); // Remove trailing 'X's
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] key = {2, 0, 1}; // You can customize this key

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        if (choice == 1) {
            System.out.print("Enter the message to encrypt: ");
            String message = scanner.nextLine().toUpperCase(); 
            String encrypted = encrypt(message, key);
            System.out.println("Encrypted message: " + encrypted);
        } else if (choice == 2) {
            System.out.print("Enter the message to decrypt: ");
            String encryptedMessage = scanner.nextLine().toUpperCase();
            String decrypted = decrypt(encryptedMessage, key);
            System.out.println("Decrypted message: " + decrypted);
        } else {
            System.out.println("Invalid choice. Please restart the program.");
        }

        scanner.close();
    }
}
