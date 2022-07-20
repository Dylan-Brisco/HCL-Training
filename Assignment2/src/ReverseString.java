import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please enter a word to reverse: ");
        String input = scan.nextLine();
        String rev = ""; // create a new string to add input char in reverse
        for (int i = input.length()-1; i >= 0; i--) { // start at end of rev and put char into rev
            rev = rev + input.charAt(i);
        }
        input = rev; // changes contents of input
        System.out.println("Your reversed word is " + input);
    }

}
