package com.hcl.assignment4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LinkedIterate {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("List is: " + list.toString());
        System.out.print("Enter index you would like to start from: ");
        int index = getSafeIntBounds(0, list.size());
        System.out.println("List from index to end is: ");
        for (int i = index; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
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
                    throw new InputOutOfBoundsException();
                }
            } catch (InputOutOfBoundsException e) {
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