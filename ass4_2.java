import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salary = sc.nextLine();

        System.out.print("Enter Bonus: ");
        String bonus = sc.nextLine();

        Integer basic = Integer.valueOf(salary);
        Integer bonusAmt = Integer.valueOf(bonus);

        if (basic < 0 || bonusAmt < 0) {
            System.out.println("Invalid Salary");
        } else {
            int netSalary = basic + bonusAmt;
            System.out.println("Employee ID: " + id);
            System.out.println("Net Salary: " + netSalary);
        }

        sc.close();
    }
}