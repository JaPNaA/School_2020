import java.util.Scanner;
import java.text.DecimalFormat;

// teacher doesn't allow use of methods yet; i have to suffer (#2)

class Cafeteria {

    static final double burgerCost = 2.99;
    static final double friesCost = 1.99;
    static final double popCost = 0.99;

    static final Scanner scanner = new Scanner(System.in);
    static final DecimalFormat dollarFormat = new DecimalFormat("$0.00");


    public static void main(String[] args) {
        
        System.out.printf("%-30s ", "Enter the number of burgers:");
        int numBurgers = scanner.nextInt();

        System.out.printf("%-30s ", "Enter the number of fries:");
        int numFries = scanner.nextInt();

        System.out.printf("%-30s ", "Enter pop quantity:");
        int numPop = scanner.nextInt();

        System.out.println();


        double subtotal = numBurgers * burgerCost + numFries * friesCost + numPop * popCost;
        double hst = subtotal * 0.13;
        double totalCost = subtotal + hst;

        System.out.printf("%-20s %11s\n", "SUBTOTAL:", dollarFormat.format(subtotal));
        System.out.printf("%-20s %11s\n", "HST:", dollarFormat.format(hst));
        System.out.printf("%-20s %11s\n", "GRAND TOTAL:", dollarFormat.format(totalCost));

        System.out.println();


        System.out.printf("%-26s ", "AMOUNT TENDERED:");
        double tendered = scanner.nextDouble();
        
        double change = tendered - totalCost;
        System.out.printf("%-20s %11s\n", "CHANGE:", dollarFormat.format(change));


        System.out.println(); // extra line for _aesthetics_
    }
}

