
import java.io.*;
import java.net.*;

public class chatServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5000);
        System.out.println("Server waiting for client");

        Socket socket = server.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);
        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        String message;

        while ((message = input.readLine()) != null) {
            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Client: " + message);
            System.out.print("Server: ");
            output.println(keyboard.readLine());
        }

        socket.close();
        server.close();
        System.out.println("Chat ended");
    }
}
