import java.util.Scanner;
public class MatrixDiagonalSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix (n x n): ");
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Element at (" + i + ", " + j + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Original Matrix:");
        printMatrix(matrix, n);
        int leftDiagonalSum = calculateLeftDiagonalSum(matrix, n);
        int rightDiagonalSum = calculateRightDiagonalSum(matrix, n);
        System.out.println("Left Diagonal Sum: " + leftDiagonalSum);
        System.out.println("Right Diagonal Sum: " + rightDiagonalSum);
        scanner.close();
    }
    private static int calculateLeftDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }
    private static int calculateRightDiagonalSum(int[][] matrix, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += matrix[i][n - 1 - i];
        }
        return sum;
    }
    private static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
