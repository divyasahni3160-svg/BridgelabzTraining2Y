import java.util.Scanner;

public class FirstNonRepeatingCharacter {

    // Method to find the first non-repeating character using an ASCII frequency array
    public static char findFirstNonRepeating(String text) {
        int[] frequency = new int[256];

        // First pass: compute frequencies
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Second pass: find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0'; // Return null character if no non-repeating character exists
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a text: ");
        String text = scanner.nextLine();

        char result = findFirstNonRepeating(text);

        if (result != '\0') {
            System.out.println("The first non-repeating character is: '" + result + "'");
        } else {
            System.out.println("No non-repeating character found.");
        }

        scanner.close();
    }
}
