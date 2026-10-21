
import java.io.*;
import java.net.*;

public class chatClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);

        BufferedReader input = new BufferedReader(
    new InputStreamReader(socket.getInputStream()));

        PrintWriter output = new PrintWriter(
            socket.getOutputStream(), true);

        BufferedReader keyboard = new BufferedReader(
            new InputStreamReader(System.in));

        while (true) {
            System.out.print("Client: ");
            String message = keyboard.readLine();

            output.println(message);

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.println("Server: " + input.readLine());
        }

        socket.close();
    }
}
