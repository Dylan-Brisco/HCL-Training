import java.util.Scanner;

public class Primes {

    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Please Enter the number you would like to go up to: ");
        int input = getSafeInt();
        System.out.println();
        for(int i = 0; i < input; i++) {
            if(isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) { // 0 and 1 not prime
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            // only have to go up to sqrt n. If we don't have a factor before sqrt n, we won't have one after
            if (n % i == 0) { // check for all factors from 2 -> sqrt(n)
                return false;
            }
        }
        return true; // no factors -> n is prime
    }

    public static int getSafeInt() { // error proof int input from user
        boolean invalidInput = true;
        int num = 0;

        while (invalidInput) {
            invalidInput = false; // if remains false we break
            try {
                num = scan.nextInt(); //asks user for input
                scan.nextLine();
                if (num < 0){ // if input is out of bounds throw exception
                    throw new InputOutOfBoundsException();
                }
            } catch (InputOutOfBoundsException e) {
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
