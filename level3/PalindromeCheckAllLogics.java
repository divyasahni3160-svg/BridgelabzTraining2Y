import java.util.Scanner;

public class PalindromeCheckAllLogics {

    // Logic 1: Two-pointer iteration
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // Logic 2: Recursive approach
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Logic 3: Character arrays with reversal
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word to test: ");
        String word = scanner.next();

        boolean check1 = isPalindromeIterative(word);
        boolean check2 = isPalindromeRecursive(word, 0, word.length() - 1);
        boolean check3 = isPalindromeArrayReversal(word);

        System.out.println("\nPalindrome Check Results:");
        System.out.println("Logic 1 (Two Pointers)   : " + check1);
        System.out.println("Logic 2 (Recursion)      : " + check2);
        System.out.println("Logic 3 (Array Reversal) : " + check3);

        scanner.close();
    }
}
