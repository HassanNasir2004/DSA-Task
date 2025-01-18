import java.util.Scanner;
public class ArraySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] LA = {5, 10, 15, 20, 25, 30};
        System.out.println("Initial Array: ");
        for (int value : LA) {
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.print("Enter the ITEM to search: ");
        int ITEM = scanner.nextInt();
        boolean found = false;
        int index = -1;
        for (int i = 0; i < LA.length; i++) {
            if (LA[i] == ITEM) {
                found = true;
                index = i;
                break;
            }
        }
        if (found) {
            System.out.println("ITEM found at index " + index);
            if (index + 1 < LA.length) {
                System.out.print("Right neighbors: " + LA[index + 1]);
                if (index + 2 < LA.length) {
                    System.out.print(", " + LA[index + 2]);
                }
                System.out.println();
            } else {
                System.out.println("No right neighbor");
            }
            if (index - 1 >= 0) {
                System.out.print("Left neighbors: " + LA[index - 1]);
                if (index - 2 >= 0) {
                    System.out.print(", " + LA[index - 2]);
                }
                System.out.println();
            } else {
                System.out.println("No left neighbor");
            }
        } else {
            System.out.println("ITEM not found in the array.");
        }
        scanner.close();
    }
}
