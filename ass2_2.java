class Mobile {
    String brand;
    String model;
    int price;

    Mobile() {
        brand = "Samsung";
        model = "A16";
        price = 15000;
    }

    Mobile(String b, String m, int p) {
        brand = b;
        model = m;
        price = p;
    }

    Mobile(Mobile m) {
        brand = m.brand;
        model = m.model;
        price = m.price;
    }

    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Mobile m1 = new Mobile();
        Mobile m2 = new Mobile("Apple", "iPhone 16", 80000);
        Mobile m3 = new Mobile(m2);

        m1.display();
        System.out.println();
        m2.display();
        System.out.println();
        m3.display();
    }
}