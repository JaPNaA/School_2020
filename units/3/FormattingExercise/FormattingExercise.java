import java.text.*;

// teacher doesn't allow use of methods yet; i have to suffer

public class FormattingExercise {

    public static void main(String[] args) {

        double price1 = 99.99;
        double price2 = 249.99;
        double subtotal = price1 + price2;
        double hst = 0.13 * subtotal;
        double total = hst + subtotal;

        String bigLine = "-".repeat(49);

        DecimalFormat currencyFormat = new DecimalFormat("$0.00");
        DecimalFormat percision100Format = new DecimalFormat("0.00");
        
        
        System.out.printf("%-9s%-30s%10s\n", "", "  CANADA COMPUTERS INC.", "");
        System.out.printf("%-9s%-30s%10s\n", "", "-------------------------", "");
        System.out.printf("%-9s%-30s%10s\n", "", "DATE:\tJune 24, 2011", "");
        System.out.printf("%-9s%-30s%10s\n", "", "NAME:\tJack Black", "");
        System.out.printf("%-9s%-30s%10s\n", "", "PHONE:\t905-967-1234", "");

        System.out.println("");

        System.out.printf("%-9s%-30s%10s\n", "QTY", "ITEM", "PRICE");
        System.out.println(bigLine);

        System.out.printf("%-9s%-30s%10s\n", "1", "WD 2TB External Hard Drive", currencyFormat.format(price1));
        System.out.printf("%-9s%-30s%10s\n", "1", "ASUS 24\" LED Monitor", currencyFormat.format(price2));

        System.out.println(bigLine);
        
        System.out.printf("%-9s%-30s%10s\n", "", "SUBTOTAL:", currencyFormat.format(subtotal));

        // not using 'currencyFormat', because example doesn't. Just following the specs.
        System.out.printf("%-9s%-30s%10s\n", "", "HST:", percision100Format.format(hst));
        
        System.out.printf("%-9s%-30s%10s\n", "", "GRAND TOTAL:", currencyFormat.format(total));

        System.out.println(""); // empty line for aesthetics

    }

}

