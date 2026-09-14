import java.util.Scanner;

public class Flatten2DArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // Initialize 1D array of size rows * cols
        int[] flatArray = new int[rows * cols];
        int flatIndex = 0;

        // Flatten row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                flatArray[flatIndex] = matrix[i][j];
                flatIndex++;
            }
        }

        System.out.print("\nFlattened 1D Array: ");
        for (int i = 0; i < flatArray.length; i++) {
            System.out.print(flatArray[i] + " ");
        }
        System.out.println();

        scanner.close();
    }
}
