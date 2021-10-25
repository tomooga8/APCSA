public class main {
    public static void main(String[] args) {
        // Calculate total owed, assuming 8% tax / 15% tip
        System.out.println("Subtotal:");
        int subtotal = 38 + 50+ 30;
        System.out.println(subtotal);

        System.out.println("Tax:");
        double tax = (38 + 40 + 30) * 0.08;
        System.out.println(tax);

        System.out.println("Tip:");
        double tip = ((38 + 40 + 30) * .15);
        System.out.println(tip);
        System.out.println("Total:");
        System.out.println(subtotal + tax + tip);
    }
}
