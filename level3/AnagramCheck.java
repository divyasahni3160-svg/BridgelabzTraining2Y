import java.util.Scanner;

public class AnagramCheck {

    // Method to check if two strings are anagrams using ASCII frequency arrays
    public static boolean checkAnagram(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for (int i = 0; i < str1.length(); i++) {
            freq1[str1.charAt(i)]++;
            freq2[str2.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (freq1[i] != freq2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String text1 = scanner.next().toLowerCase();
        System.out.print("Enter second text: ");
        String text2 = scanner.next().toLowerCase();

        boolean isAnagram = checkAnagram(text1, text2);

        System.out.println("\nAre both texts anagrams? " + isAnagram);

        scanner.close();
    }
}
