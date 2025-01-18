
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
    public static void reverseFirstKElements(Queue<Integer> queue, int k) {
        if (queue == null || k <= 0 || k > queue.size()) {
            throw new IllegalArgumentException("Invalid value for k or queue is empty");
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            queue.offer(queue.poll());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Add elements to the queue
        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println("Original Queue: " + queue);


        int k = 3;
        reverseFirstKElements(queue, k);
        System.out.println("Queue after reversing first " + k + " elements: " + queue);
    }
}