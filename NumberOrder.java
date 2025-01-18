import java.util.Scanner;

class NumberOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        System.out.print("Enter the third number: ");
        int num3 = scanner.nextInt();

        System.out.println(determineOrder(num1, num2, num3));

        scanner.close();
    }

    public static String determineOrder(int num1, int num2, int num3) {
        if (num1 < num2 && num2 < num3) {
            return "Increasing";
        } else if (num1 > num2 && num2 > num3) {
            return "Decreasing";
        } else {
            return "Neither increasing nor decreasing order";
        }
    }
}

