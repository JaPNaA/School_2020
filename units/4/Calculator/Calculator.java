import java.util.Scanner;

// Note: this program, including most other programs in the past, should produce the exact same output as the teacher's example outputs.
// Inconsistant capitalization and bad spacing can all be blamed on the teacher. :)

class Calculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            mainLoop();

            if (shouldQuit()) {
                break;
            }
        }

        System.out.println("Goodbye");
    }

    private static void mainLoop() {
        System.out.println("please enter the first number:");
        double firstNum = scanner.nextDouble();

        System.out.println("please enter the second number:");
        double secondNum = scanner.nextDouble();

        System.out.println(firstNum + " + " + secondNum + " = " + add(firstNum, secondNum));
        System.out.println(firstNum + " - " + secondNum + " = " + subtract(firstNum, secondNum));
        System.out.println(firstNum + " * " + secondNum + " = " + multiply(firstNum, secondNum));
        
        if (secondNum == 0) {
            System.out.println("Division by zero is undefined");
        } else {
            System.out.println(firstNum + " / " + secondNum + " = " + divide(firstNum, secondNum));
        }
    }

    private static double multiply(double a, double b) { return a * b; }
    private static double add(double a, double b) { return a + b; }
    private static double subtract(double a, double b) { return a - b; }
    private static double divide(double a, double b) { return a / b; }

    private static boolean shouldQuit() {

        scanner.nextLine(); // clear a line

        while (true) {
            System.out.println("Enter C to continue or Q to quit");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() > 0) {
                if (input.charAt(0) == 'q') {
                    return true;
                } else if (input.charAt(0) == 'c') {
                    return false;
                }
            }

            System.out.println("Invalid");
        }
    }

}
