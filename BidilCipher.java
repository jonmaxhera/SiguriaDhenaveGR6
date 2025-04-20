import java.util.Scanner;

public class BidilCipher {

    public static String bidilTransform(String message) {
        StringBuilder result = new StringBuilder();

        for (char ch : message.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                result.append((char) ('Z' - (ch - 'A'))); // Mirror uppercase
            } else if (Character.isLowerCase(ch)) {
                result.append((char) ('z' - (ch - 'a'))); // Mirror lowercase
            } else {
                result.append(ch); // Keep non-letters unchanged
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bidil Cipher Tool");
        System.out.println("-------------------");
        System.out.println("1. Encrypt a message");
        System.out.println("2. Decrypt a message");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter your message: ");
        String message = scanner.nextLine();

        if (choice == 1) {
            String encrypted = bidilTransform(message);
            System.out.println("Encrypted message: " + encrypted);
        } else if (choice == 2) {
            String decrypted = bidilTransform(message);
            System.out.println("Decrypted message: " + decrypted);
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }
}
