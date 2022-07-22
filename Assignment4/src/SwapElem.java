import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class SwapElem {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("Before Swap " + list.toString());
        System.out.print("Enter your first index to switch: ");
        int index1= getSafeIntBounds(0, list.size());
        System.out.print("Enter your second index to switch: ");
        int index2 = getSafeIntBounds(0, list.size());

        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);

        System.out.println("After swap " + list.toString());
    }
    public static int getSafeIntBounds(int start, int end) { // error proof int input from user
        boolean invalidInput = true;
        int num = 0;

        while (invalidInput) {
            invalidInput = false; // if remains false we break
            try {
                num = scan.nextInt(); //asks user for input
                scan.nextLine();
                if (num < start || num > end) { // if input is out of bounds throw exception
                    throw new SwapElem.InputOutOfBoundsException();
                }
            } catch (SwapElem.InputOutOfBoundsException e) {
                System.out.print("Input Not In Range "); // what user sees if they aren't in bounds
                scan.nextLine(); // prevent errors
                System.out.print("Re-enter Input: ");
                invalidInput = true; // so we can reloop
            } catch (Exception e) {
                System.out.print("Invalid Input, Integers Only."); //if they enter double/string/etc.
                scan.nextLine(); //prevent errors
                System.out.println();
                System.out.print("Re-enter input: ");
                invalidInput = true; //reloop
            }
        }
        return num;
    }
    public static class InputOutOfBoundsException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}
