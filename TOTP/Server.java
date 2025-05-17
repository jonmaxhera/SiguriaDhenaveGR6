package TOTPapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Server {
    public static void main(String[] args) {
        final int PORT = 1234;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started and waiting for authentication...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    System.out.println("New client connected.");

                    String username = reader.readLine();
                    String receivedTOTP = reader.readLine();

                    System.out.println("Received authentication request for user: " + username);
                    System.out.println("TOTP provided: " + receivedTOTP);

                    String secret = new String(Files.readAllBytes(Paths.get("C:\\Users\\jonma\\IdeaProjects\\Siguri\\src\\main\\resources\\shared_secret.txt"))).trim();
                    String expectedTOTP = TOTPUtil.generateTOTP(secret);

                    if (expectedTOTP.equals(receivedTOTP)) {
                        writer.println("Authentication successful. You now have access to the system.");
                        System.out.println("Authentication successful for user: " + username);
                    } else {
                        writer.println("Authentication failed. Please try again.");
                        System.out.println("Authentication failed for user: " + username);
                    }

                } catch (Exception e) {
                    System.out.println("Error during client interaction: " + e.getMessage());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
