import java.util.Scanner;

public class StudentScorecard {

    // Generate random 2-digit marks (10 to 99) for Physics, Chemistry, Math
    public static int[][] generateScores(int studentCount) {
        int[][] scores = new int[studentCount][3];
        for (int i = 0; i < studentCount; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        return scores;
    }

    // Calculate total, average, and percentage rounded to 2 decimal places
    public static double[][] calculateMetrics(int[][] scores) {
        double[][] metrics = new double[scores.length][3]; // [0] = Total, [1] = Average, [2] = Percentage
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100.0;

            metrics[i][0] = total;
            metrics[i][1] = Math.round(avg * 100.0) / 100.0;
            metrics[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return metrics;
    }

    // Assign grades based on percentage
    public static String[] assignGrades(double[][] metrics) {
        String[] grades = new String[metrics.length];
        for (int i = 0; i < metrics.length; i++) {
            double pct = metrics[i][2];
            if (pct >= 80) grades[i] = "A";
            else if (pct >= 70) grades[i] = "B";
            else if (pct >= 60) grades[i] = "C";
            else if (pct >= 50) grades[i] = "D";
            else if (pct >= 40) grades[i] = "E";
            else grades[i] = "R";
        }
        return grades;
    }

    // Display scorecard table
    public static void displayScorecard(int[][] scores, double[][] metrics, String[] grades) {
        System.out.println("\n-------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-8s | %-8s | %-8s | %-8s | %-8s | %-12s | %-6s\n",
                "Student", "Physics", "Chem", "Math", "Total", "Average", "Percentage", "Grade");
        System.out.println("-------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s | %-8d | %-8d | %-8d | %-8.0f | %-8.2f | %-11.2f%% | %-6s\n",
                    "Student " + (i + 1),
                    scores[i][0], scores[i][1], scores[i][2],
                    metrics[i][0], metrics[i][1], metrics[i][2],
                    grades[i]);
        }
        System.out.println("-------------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[][] scores = generateScores(n);
        double[][] metrics = calculateMetrics(scores);
        String[] grades = assignGrades(metrics);

        displayScorecard(scores, metrics, grades);

        scanner.close();
    }
}
