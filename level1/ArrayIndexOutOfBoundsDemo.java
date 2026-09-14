import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {

    // Method to generate the exception
    public static void generateException(String[] names) {
        // Accessing index equal to array length throws ArrayIndexOutOfBoundsException
        System.out.println("Accessing invalid index: " + names[names.length]);
    }

    // Method to demonstrate and handle the exception
    public static void handleException(String[] names) {
        try {
            System.out.println("Accessing invalid index: " + names[names.length]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught generic RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("How many names do you want to enter? ");
        int size = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] names = new String[size];
        for (int i = 0; i < names.length; i++) {
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = scanner.nextLine();
        }

        System.out.println("\nHandling Exception:");
        handleException(names);

        // Uncomment below to test abrupt program termination:
        // generateException(names);

        scanner.close();
    }
}
