import java.util.Scanner;

public class WordLengthTable {

    // Method to find length without using built-in length()
    public static int getLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (IndexOutOfBoundsException e) {
            return count;
        }
    }

    // Method to split text into words using charAt()
    public static String[] extractWords(String text) {
        int len = getLength(text);
        int spaceCount = 0;

        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        String[] words = new String[spaceCount + 1];
        StringBuilder currentWord = new StringBuilder();
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[index++] = currentWord.toString();
                currentWord.setLength(0);
            } else {
                currentWord.append(ch);
            }
        }
        words[index] = currentWord.toString();

        return words;
    }

    // Method to return a 2D String array containing each word and its length
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordData = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            int length = getLength(words[i]);
            wordData[i][1] = String.valueOf(length);
        }

        return wordData;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a line of text: ");
        String text = scanner.nextLine();

        String[] words = extractWords(text);
        String[][] wordTable = getWordsWithLengths(words);

        // Display results in a tabular format
        System.out.println("\n-----------------------------");
        System.out.printf("%-15s | %-10s\n", "Word", "Length");
        System.out.println("-----------------------------");
        for (int i = 0; i < wordTable.length; i++) {
            String word = wordTable[i][0];
            int length = Integer.parseInt(wordTable[i][1]);
            System.out.printf("%-15s | %-10d\n", word, length);
        }
        System.out.println("-----------------------------");

        scanner.close();
    }
}
