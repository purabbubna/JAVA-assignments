class Main {
    public static void main(String[] args) {
        String m1 = "85";
        String m2 = "90";
        String m3 = "78";

        Integer mark1 = Integer.valueOf(m1);
        Integer mark2 = Integer.valueOf(m2);
        Integer mark3 = Integer.valueOf(m3);

        int total = mark1 + mark2 + mark3;

        System.out.println("Total Marks = " + total);
    }
}