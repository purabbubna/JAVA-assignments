class Restaurant {
    static int totalOrders = 0;

    double bill(double amount) {
        totalOrders++;
        return amount;
    }

    double bill(double amount, double packing) {
        totalOrders++;
        return amount + packing;
    }

    double bill(double amount, double packing, double delivery) {
        totalOrders++;
        return amount + packing + delivery;
    }
}

public class Main {
    public static void main(String[] args) {
        Restaurant r = new Restaurant();

        System.out.println("Dine-in Bill: " + r.bill(500));
        System.out.println("Takeaway Bill: " + r.bill(500, 20));
        System.out.println("Delivery Bill: " + r.bill(500, 20, 50));

        System.out.println("Total Orders: " + Restaurant.totalOrders);
    }
}