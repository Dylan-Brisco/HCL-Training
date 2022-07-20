import java.util.Scanner;

public class Sum {
    static Scanner scan = new Scanner(System.in);
    public static void main(String args[]) {
        System.out.print("Enter the first number you would like to sum: ");
        int num1 = getSafeInt();

        System.out.print("Enter the second number you would like to sum: ");
        int num2 = getSafeInt();

        System.out.print("Enter your sum guess to check: ");
        int num3 = getSafeInt();

        System.out.println("Sum is " + (num1 + num2));
        System.out.println("Correct Guess: " + isCorrect(num1+num2, num3));
    }

    public static boolean isCorrect(int sum, int num3) {
        return sum == num3;
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
}
