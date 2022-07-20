import java.util.Scanner;
public class Fibonacci {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please enter the number you would like to go up to: ");
        long input = getSafeLong(); // long to allow for higher values before overflow
        System.out.println();
        int fib0 = 0; // start conditions for fib sequence
        int fib1 = 1;
        for(int i = 0; i < input; i++) {
            System.out.print(Long.toUnsignedString(fib0) + " "); // allows for higher values.
            int total = fib1 + fib0; //fib sequence is a,b, a+b (=c), b+c=(d), etc
            fib0 = fib1;
            fib1 = total;
        }
    }
    public static long getSafeLong() { // error proof int input from user
        boolean invalidInput = true;
        long num = 0;

        while (invalidInput) {
            invalidInput = false; // if remains false we break
            try {
                num = scan.nextLong(); //asks user for input
                scan.nextLine();
                if (num < 0){ // if input is out of bounds throw exception
                    throw new Primes.InputOutOfBoundsException();
                }
            } catch (Primes.InputOutOfBoundsException e) {
                System.out.print("Input Not In Range, Please Enter a Value >= 0: "); // what user sees if they aren't in bounds
                scan.nextLine(); // prevent errors
                invalidInput = true; // so we can reloop
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
