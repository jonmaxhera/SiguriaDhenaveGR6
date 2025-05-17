package TOTPapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 1234;

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Welcome to TOTP Authentication System.");
            System.out.print("Enter your username: ");
            String username = scanner.nextLine();

            String secret = new String(Files.readAllBytes(Paths.get("C:\\Users\\jonma\\IdeaProjects\\Siguri\\src\\main\\resources\\shared_secret.txt"))).trim();
            String totp = TOTPUtil.generateTOTP(secret);

            System.out.println("Generated TOTP: " + totp);

            writer.println(username);
            writer.println(totp);

            String response = reader.readLine();
            System.out.println(response);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
