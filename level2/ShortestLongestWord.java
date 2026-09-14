import java.util.Scanner;

public class ShortestLongestWord {

    // Calculate length without length()
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

    // Split text into words using charAt()
    public static String[] extractWords(String text) {
        int len = getLength(text);
        int spaces = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaces++;
            }
        }

        String[] words = new String[spaces + 1];
        StringBuilder current = new StringBuilder();
        int index = 0;

        for (int i = 0; i < len; i++) {
            char ch = text.charAt(i);
            if (ch == ' ') {
                words[index++] = current.toString();
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        words[index] = current.toString();
        return words;
    }

    // Create 2D array of word and length
    public static String[][] getWordsWithLengths(String[] words) {
        String[][] wordData = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            wordData[i][0] = words[i];
            wordData[i][1] = String.valueOf(getLength(words[i]));
        }
        return wordData;
    }

    // Returns 1D array with [shortestIndex, longestIndex]
    public static int[] findShortestAndLongest(String[][] wordData) {
        int shortestIdx = 0;
        int longestIdx = 0;

        int minLen = Integer.parseInt(wordData[0][1]);
        int maxLen = Integer.parseInt(wordData[0][1]);

        for (int i = 1; i < wordData.length; i++) {
            int currentLen = Integer.parseInt(wordData[i][1]);
            if (currentLen < minLen) {
                minLen = currentLen;
                shortestIdx = i;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
                longestIdx = i;
            }
        }
        return new int[]{shortestIdx, longestIdx};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = extractWords(text);
        String[][] wordData = getWordsWithLengths(words);
        int[] resultIndexes = findShortestAndLongest(wordData);

        System.out.println("\nShortest word: " + wordData[resultIndexes[0]][0] + " (Length: " + wordData[resultIndexes[0]][1] + ")");
        System.out.println("Longest word : " + wordData[resultIndexes[1]][0] + " (Length: " + wordData[resultIndexes[1]][1] + ")");

        scanner.close();
    }
}
