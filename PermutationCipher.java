import java.util.Scanner;

public class PermutationCipher {

    // Encrypts the message using the permutation key
    public static String encrypt(String message, int[] key) {
        int blockSize = key.length;

        // Pad with 'X' to make message length divisible by block size
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

    // Decrypts the encrypted message using the inverse of the key
    public static String decrypt(String encryptedMessage, int[] key) {
        int blockSize = key.length;
        StringBuilder decrypted = new StringBuilder();

        // Build inverse key
        int[] inverseKey = new int[blockSize];
        for (int i = 0; i < blockSize; i++) {
            inverseKey[key[i]] = i;
        }

        // Process encrypted message block by block
        for (int i = 0; i < encryptedMessage.length(); i += blockSize) {
            char[] block = new char[blockSize];
            for (int j = 0; j < blockSize; j++) {
                block[j] = encryptedMessage.charAt(i + inverseKey[j]);
            }
            decrypted.append(block);
        }

        // Remove padding 'X's added during encryption
        return decrypted.toString().replaceAll("X+$", "");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define a fixed key (you can modify it as needed)
        int[] key = {2, 0, 1};

        System.out.println("Permutation Cipher");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Zgjidh një opsion (1 ose 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) {
            System.out.print("Shkruaj mesazhin për shifrim: ");
            String message = scanner.nextLine();
            String encrypted = encrypt(message, key);
            System.out.println("Mesazhi i shifruar: " + encrypted);
        } else if (choice == 2) {
            System.out.print("Shkruaj mesazhin për deshifrim: ");
            String encryptedMessage = scanner.nextLine();
            String decrypted = decrypt(encryptedMessage, key);
            System.out.println("Mesazhi i deshifruar: " + decrypted);
        } else {
            System.out.println("Opsion i pavlefshëm.");
        }

        scanner.close();
    }
}
