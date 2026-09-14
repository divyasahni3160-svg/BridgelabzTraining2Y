import java.util.Scanner;

public class CustomToCharArray {

    // User-defined method to extract characters without using toCharArray()
    public static char[] extractCharacters(String text) {
        char[] chars = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            chars[i] = text.charAt(i);
        }
        return chars;
    }

    // Method to compare two character arrays
    public static boolean compareCharArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.next();

        // Extraction using user-defined method
        char[] customArray = extractCharacters(text);

        // Extraction using built-in method
        char[] builtInArray = text.toCharArray();

        // Comparison
        boolean matches = compareCharArrays(customArray, builtInArray);

        System.out.print("Custom Array: ");
        for (char c : customArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.print("Built-in Array: ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }
        System.out.println();

        System.out.println("Arrays match: " + matches);

        scanner.close();
    }
}
