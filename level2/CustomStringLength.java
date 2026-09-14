import java.util.Scanner;

public class CustomStringLength {

    // Method to find length using an infinite loop and catching the runtime exception
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Exception thrown when index reaches text length
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        // Custom length calculation
        int customLength = findLength(text);

        // Built-in length calculation
        int builtInLength = text.length();

        System.out.println("Custom calculated length : " + customLength);
        System.out.println("Built-in length() result : " + builtInLength);

        scanner.close();
    }
}
