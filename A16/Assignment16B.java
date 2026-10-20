import java.util.Scanner;

class InvalidLicenseAgeException extends Exception {
    InvalidLicenseAgeException(String message) {
        super(message);
    }
}

public class Assignment16B {
    static void checkAge(int age)
            throws InvalidLicenseAgeException {
        if (age < 18) {
            throw new InvalidLicenseAgeException(
                "You must be at least 18 to apply for a driving license"
            );
        }

        System.out.println("Eligible to apply for a driving license");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        try {
            int age = sc.nextInt();
            checkAge(age);
        } catch (InvalidLicenseAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Enter a valid age");
        }

        sc.close();
    }
}
