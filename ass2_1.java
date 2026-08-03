class Student {
    String name;
    int rollNo;

    Student() {
        name = "Unknown";
        rollNo = 0;
    }

    Student(String n, int r) {
        name = n;
        rollNo = r;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }
}

public class ass2_1 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Purab", 101);

        s1.display();
        System.out.println();
        s2.display();
    }
}