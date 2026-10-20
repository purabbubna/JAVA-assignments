
import java.util.Scanner;

public class Assignment15A {
    static void login(String password) throws Exception {
        if (!password.equals("java123")) {
            throw new Exception("Invalid password");
        }

        System.out.println("Login successful");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        try {
            login(password);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Login process completed");
        }

        sc.close();
    }
}
