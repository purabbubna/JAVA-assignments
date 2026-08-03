import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Study Java");
        tasks.add("Complete Assignment");
        tasks.add("Go for Walk");

        StringBuffer sb = new StringBuffer();

        for (String task : tasks) {
            sb.append(task).append("\n");
        }

        System.out.println("To-Do List:");
        System.out.println(sb);
    }
}