import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to generate its table: ");
        int number = scanner.nextInt();

        // Array to store results from multiplier 1 to 10
        int[] table = new int[10];

        for (int i = 1; i <= 10; i++) {
            table[i - 1] = number * i;
        }

        // Displaying results
        System.out.println("\nMultiplication Table for " + number + ":");
        for (int i = 0; i < table.length; i++) {
            int multiplier = i + 1;
            System.out.println(number + " * " + multiplier + " = " + table[i]);
        }

        scanner.close();
    }
}
