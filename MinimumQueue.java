import java.util.LinkedList;
import java.util.Queue;

public class MinimumQueue {
    public static int getMinimum(Queue<Integer> queue) {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        int min = Integer.MAX_VALUE;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int current = queue.poll();
            min = Math.min(min, current);
            queue.offer(current);
        }

        return min;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(5);
        queue.offer(40);
        queue.offer(15);

        System.out.println("Queue: " + queue);
        int min = getMinimum(queue);
        System.out.println("Minimum element in the queue: " + min);
    }
}
