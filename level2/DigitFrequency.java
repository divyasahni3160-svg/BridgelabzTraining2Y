import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // a. Take input for a number
        System.out.print("Enter a number: ");
        long number = scanner.nextLong();

        // Validate user input
        if (number < 0) {
            System.err.println("Invalid input. Please enter a positive number.");
            scanner.close();
            return;
        }

        // b. Find the count of digits in the number
        int count = 0;
        long temp = number;

        if (temp == 0) {
            count = 1;
        } else {
            while (temp > 0) {
                count++;
                temp /= 10;
            }
        }

        // c. Find the digits in the number and save them in an array
        int[] digits = new int[count];
        temp = number;

        if (temp == 0) {
            digits[0] = 0;
        } else {
            for (int i = 0; i < count; i++) {
                digits[i] = (int) (temp % 10);
                temp /= 10;
            }
        }

        // d. Define a frequency array of size 10 (for digits 0 through 9)
        int[] frequency = new int[10];

        // Loop through the digits array and increment frequency
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i];
            frequency[digit]++;
        }

        // e. Display the frequency of each digit that appears in the number
        System.out.println("\n--- Digit Frequency Table ---");
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " occurs " + frequency[i] + " time(s)");
            }
        }

        scanner.close();
    }
}
