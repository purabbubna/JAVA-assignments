import java.util.Scanner;
public class Assignment14B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double price = 100;

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter quantity: ");

        try {
            int quantity = sc.nextInt();

            if (quantity <= 0) {
                throw new IllegalArgumentException(
                    "Quantity must be greater than zero"
                );
            }

            double total = price * quantity;

            System.out.println("Product: " + name);
            System.out.println("Price per item: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Total amount: " + total);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: Quantity must be an integer");
        }

        sc.close();
    }
}
