import java.util.Scanner;

public class Swap {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please Enter Num1: ");
        int num1 = getSafeInt();
        System.out.print("Please Enter Num2: ");
        int num2 = getSafeInt();
        int temp = num1;
        num1 = num2;
        num2 = temp;
        System.out.println("Num1 is now equal to " + num1);
        System.out.println("Num2 is now equal to " + num2);

    }

    public static int getSafeInt() { // error proof int input from user
        boolean invalidInput = true;
        int num = 0;

        while (invalidInput) {
            invalidInput = false; // if remains false we break
            try {
                num = scan.nextInt(); //asks user for input
                scan.nextLine();
            } catch (Exception e) {
                System.out.print("Invalid Input, Integers Only. Please Enter Again: "); //if they enter double/string/etc.
                scan.nextLine(); //prevent errors
                invalidInput = true; //reloop
            }
        }
        return num;
    }
    public static class InputOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}
