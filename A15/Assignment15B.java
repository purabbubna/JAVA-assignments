
import java.util.Scanner;

public class Assignment15B {
    static void verifyPIN(int pin) throws Exception {
        if (pin != 1234) {
            throw new Exception("Invalid ATM PIN");
        }

        System.out.println("PIN verified successfully");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ATM PIN: ");
        int pin = sc.nextInt();

        try {
            verifyPIN(pin);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("PIN verification completed");
        }

        sc.close();
    }
}
