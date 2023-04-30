import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();

        // pushing elements to the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println();

        // checking size
        System.out.println("Size of queue: " + stack.size());

        // peeking at the top element
        System.out.println("Top element: " + stack.peek());

        // popping elements from the stack
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        // checking if the stack is empty
        System.out.println("Is stack empty? " + stack.isEmpty());

        // trying to pop from an empty stack (should throw an exception)
        System.out.println("Trying to pop from an empty stack:");
        try {
            stack.pop();
            System.out.println("Success");
        } catch (EmptyStackException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }

        System.out.println();

        MyLinkedListQueue<Integer> queue = new MyLinkedListQueue<>();

        // enqueueing elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(12);

        // checking size
        System.out.println("Size of queue: " + queue.size());

        // peeking at the front element
        System.out.println("Front element: " + queue.peek());

        // dequeueing elements from the queue
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Dequeued element: " + queue.dequeue());

        // checking if the queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // trying to dequeue from an empty queue (should throw an exception)
        System.out.print("Trying to dequeue from an empty queue: ");
        try {
            queue.dequeue();
            System.out.println("Success");
        } catch (NoSuchElementException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}