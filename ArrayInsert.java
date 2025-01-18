import java.util.Scanner;
public class ArrayInsert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] LA = {5, 10, 15, 20, 25, 30};
        int n = LA.length;
        System.out.println("Initial Array: ");
        for (int value : LA) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.print("Enter the index (K) where you want to insert: ");
        int K = scanner.nextInt();
        if (K < 0 || K >= n) {
            System.out.println("Error: Index K is out of range.");
            return;
        }
        System.out.print("Enter the ITEM (must be a positive integer): ");
        int ITEM = scanner.nextInt();

        if (ITEM <= 0) {
            System.out.println("Error: ITEM must be a positive integer.");
            return;
        }
        if (ITEM < LA[K]) {
            int[] newLA = new int[n + 1];
            for (int i = 0; i < K; i++) {
                newLA[i] = LA[i];
            }
            newLA[K] = ITEM;
            for (int i = K; i < n; i++) {
                newLA[i + 1] = LA[i];
            }
            System.out.println("Updated Array: ");
            for (int value : newLA) {
                System.out.print(value + " ");
            }
            System.out.println();
        } else {
            System.out.println("ITEM at index " + K + " is greater than user's entered ITEM.");
        }
        scanner.close();
    }
}

