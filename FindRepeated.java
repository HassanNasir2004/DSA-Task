import java.util.HashMap;
import java.util.Map;
public class FindRepeated {
    public static int findSingleRepeated(int[] A) {
        int n = A.length;
        boolean[] seen = new boolean[n];
        for (int num : A) {
            if (seen[num]) {
                return num;
            }
            seen[num] = true;
        }
        return -1;
    }
    public static int[] findMultipleRepeated(int[] B) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int[] repeated = new int[5];
        int index = 0;
        for (int num : B) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                repeated[index++] = entry.getKey();
                if (index == 5) break;
            }
        }
        return repeated;
    }
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 2};
        int singleRepeated = findSingleRepeated(A);
        System.out.println("Single repeated number in A: " + singleRepeated);
        int[] B = {1, 2, 3, 4, 5, 2, 3, 6, 4, 5, 7};
        int[] multipleRepeated = findMultipleRepeated(B);
        System.out.print("Five repeated numbers in B: ");
        for (int num : multipleRepeated) {
            System.out.print(num + " ");
        }
    }
}
