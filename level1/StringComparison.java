import java.util.Scanner;

public class StringComparison {

    // User-defined method to compare two strings character by character
    public static boolean compareStrings(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String text1 = scanner.next();
        System.out.print("Enter second string: ");
        String text2 = scanner.next();

        // Comparison using user-defined method
        boolean customResult = compareStrings(text1, text2);

        // Comparison using built-in equals() method
        boolean builtInResult = text1.equals(text2);

        System.out.println("\nCustom charAt() comparison result: " + customResult);
        System.out.println("Built-in equals() comparison result: " + builtInResult);

        if (customResult == builtInResult) {
            System.out.println("Both methods produced the same result.");
        } else {
            System.out.println("The methods produced different results.");
        }

        scanner.close();
    }
}
