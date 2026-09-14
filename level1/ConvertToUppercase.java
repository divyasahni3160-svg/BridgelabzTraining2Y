import java.util.Scanner;

public class ConvertToUppercase {

    // User-defined method to convert lowercase characters to uppercase using ASCII difference (32)
    public static String toUpper(String text) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                // Subtract 32 from lowercase ASCII value to get uppercase
                result.append((char) (ch - 32));
            } else {
                result.append(ch);
            }
        }
        return result.toString();
    }

    // User-defined method to compare two strings using charAt()
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

        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();

        // Custom uppercase conversion
        String customUpper = toUpper(text);

        // Built-in toUpperCase() conversion
        String builtInUpper = text.toUpperCase();

        // Compare both strings
        boolean isIdentical = compareStrings(customUpper, builtInUpper);

        System.out.println("\nCustom Uppercase: " + customUpper);
        System.out.println("Built-in Uppercase: " + builtInUpper);
        System.out.println("Do both results match? " + isIdentical);

        scanner.close();
    }
}
