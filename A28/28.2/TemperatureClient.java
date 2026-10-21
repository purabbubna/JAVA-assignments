import java.rmi.registry.*;
import java.util.Scanner;

public class TemperatureClient {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        Temperature service =
            (Temperature) registry.lookup("TemperatureService");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        double value = sc.nextDouble();

        System.out.print("Convert from Celsius or Fahrenheit (C/F): ");
        char choice = sc.next().toUpperCase().charAt(0);

        if (choice == 'C') {
            System.out.println("Fahrenheit: " +
                service.celsiusToFahrenheit(value));
        } else if (choice == 'F') {
            System.out.println("Celsius: " +
                service.fahrenheitToCelsius(value));
        } else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
