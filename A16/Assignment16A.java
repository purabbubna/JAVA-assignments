
import java.util.Scanner;

class InvalidVotingAgeException extends Exception {
    InvalidVotingAgeException(String message) {
        super(message);
    }
}

public class Assignment16A {
    static void checkEligibility(int age)
            throws InvalidVotingAgeException {
        if (age < 18) {
            throw new InvalidVotingAgeException(
                "You must be at least 18 to vote"
            );
        }

        System.out.println("You are eligible to vote");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");

        try {
            int age = sc.nextInt();
            checkEligibility(age);
        } catch (InvalidVotingAgeException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Enter a valid age");
        }

        sc.close();
    }
}
