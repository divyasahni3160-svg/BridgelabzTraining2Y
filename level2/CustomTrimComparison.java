import java.util.Scanner;

public class CustomTrimComparison {

    // Method to find start and end indices excluding leading and trailing spaces
    public static int[] findTrimIndices(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};
    }

    // Method to create substring using charAt()
    public static String createSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // Method to compare two strings using charAt()
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string with spaces: ");
        String text = scanner.nextLine();

        // Custom trim using charAt
        int[] bounds = findTrimIndices(text);
        String customTrimmed = createSubstring(text, bounds[0], bounds[1]);

        // Built-in trim
        String builtInTrimmed = text.trim();

        // Comparison
        boolean matches = compareStrings(customTrimmed, builtInTrimmed);

        System.out.println("\nCustom Trimmed   : \"" + customTrimmed + "\"");
        System.out.println("Built-in Trimmed : \"" + builtInTrimmed + "\"");
        System.out.println("Both results match: " + matches);

        scanner.close();
    }
}
