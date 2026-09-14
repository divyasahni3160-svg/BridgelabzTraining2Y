import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.err.println("Invalid input. Enter a non-negative number.");
            scanner.close();
            return;
        }

        // Count digits
        int count = 0;
        int temp = number;
        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }

        // Store digits
        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        // Reverse into a second array
        int[] reversedDigits = new int[count];
        for (int i = 0; i < count; i++) {
            reversedDigits[i] = digits[i];
        }

        System.out.print("Reversed number: ");
        for (int i = 0; i < reversedDigits.length; i++) {
            System.out.print(reversedDigits[i]);
        }
        System.out.println();

        scanner.close();
    }
}
