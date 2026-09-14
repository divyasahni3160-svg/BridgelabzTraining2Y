import java.util.Scanner;

public class TeamMeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11];

        System.out.println("Enter the height of 11 football players:");
        for (int i = 0; i < heights.length; i++) {
            System.out.print("Height of player " + (i + 1) + " (in cm or ft): ");
            heights[i] = scanner.nextDouble();
        }

        double sum = 0.0;
        for (int i = 0; i < heights.length; i++) {
            sum += heights[i];
        }

        double mean = sum / heights.length;
        System.out.printf("\nMean height of the football team: %.2f\n", mean);

        scanner.close();
    }
}
