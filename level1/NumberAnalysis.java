import java.util.Scanner;

public class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        // Input 5 numbers
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nAnalysis of each number:");
        for (int i = 0; i < numbers.length; i++) {
            int val = numbers[i];
            if (val > 0) {
                if (val % 2 == 0) {
                    System.out.println(val + " is positive and even.");
                } else {
                    System.out.println(val + " is positive and odd.");
                }
            } else if (val < 0) {
                System.out.println(val + " is negative.");
            } else {
                System.out.println(val + " is zero.");
            }
        }

        // Compare first and last elements
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        System.out.println("\nComparison of first (" + first + ") and last (" + last + ") element:");
        if (first == last) {
            System.out.println("First element is equal to the last element.");
        } else if (first > last) {
            System.out.println("First element is greater than the last element.");
        } else {
            System.out.println("First element is less than the last element.");
        }

        scanner.close();
    }
}
