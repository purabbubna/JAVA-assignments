class Calculator {
    static int count = 0;

    int add(int a, int b) {
        count++;
        return a + b;
    }

    double add(double a, double b) {
        count++;
        return a + b;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator c = new Calculator();

        System.out.println("Integer Addition: " + c.add(10, 20));
        System.out.println("Decimal Addition: " + c.add(10.5, 20.5));
        System.out.println("Total Calculations: " + Calculator.count);
    }
}