import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();

        System.out.print("Enter course to add: ");
        courses.add(sc.nextLine());

        System.out.print("Enter another course to add: ");
        courses.add(sc.nextLine());

        System.out.print("Enter course to remove: ");
        courses.remove(sc.nextLine());

        StringBuffer sb = new StringBuffer();

        sb.append("Registered Courses:\n");

        for (String course : courses) {
            sb.append(course).append("\n");
        }

        System.out.println(sb);

        sc.close();
    }
}