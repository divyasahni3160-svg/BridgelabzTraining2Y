import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        // 2D Array: rows = students, cols = 3 (0: Physics, 1: Chemistry, 2: Maths)
        int[][] marks = new int[n][3];
        double[] percentages = new double[n];
        char[] grades = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + " (out of 100):");
            System.out.print("Physics: ");
            int p = scanner.nextInt();
            System.out.print("Chemistry: ");
            int c = scanner.nextInt();
            System.out.print("Maths: ");
            int m = scanner.nextInt();

            if (p < 0 || c < 0 || m < 0 || p > 100 || c > 100 || m > 100) {
                System.out.println("Invalid marks. Please enter values between 0 and 100.");
                i--;
                continue;
            }

            marks[i][0] = p;
            marks[i][1] = c;
            marks[i][2] = m;

            percentages[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percentages[i] >= 80) {
                grades[i] = 'A';
            } else if (percentages[i] >= 70) {
                grades[i] = 'B';
            } else if (percentages[i] >= 60) {
                grades[i] = 'C';
            } else if (percentages[i] >= 50) {
                grades[i] = 'D';
            } else if (percentages[i] >= 40) {
                grades[i] = 'E';
            } else {
                grades[i] = 'R';
            }
        }

        System.out.println("\n--- Student Results (2D Array) ---");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("Student %d -> Physics: %d, Chemistry: %d, Maths: %d | Percentage: %.2f%% | Grade: %c\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }

        scanner.close();
    }
}
