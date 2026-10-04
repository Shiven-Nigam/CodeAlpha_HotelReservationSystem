import java.util.Scanner;

public class Payment {

    public static void processPayment(double amount) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\nPayment Amount : ₹" + amount);

        System.out.println("Choose Payment Method");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Cash");

        int choice = sc.nextInt();

        switch(choice){

            case 1:
                System.out.println("UPI Payment Successful!");
                break;

            case 2:
                System.out.println("Card Payment Successful!");
                break;

            case 3:
                System.out.println("Cash Payment Received!");
                break;

            default:
                System.out.println("Invalid Payment Method");
        }
    }
}