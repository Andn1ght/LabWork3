import java.util.NoSuchElementException;

/**
 * Implementation of QueueInterface based on the MyLinkedList data structure.
 * The queue follows the FIFO (First In, First Out) principle.
 *
 * @param <E> the type of elements in the queue
 */
public class MyLinkedListQueue<E> implements QueueInterface<E> {
    private MyLinkedList<E> queue;

    /**
     * Constructs an empty stack based on linked list.
     */
    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }

    /**
     * Adds the specified element to the end of the queue.
     *
     * @param element the element to be added to the queue
     */
    @Override
    public void enqueue(E element) {
        queue.addLast(element);
    }

    /**
     * Removes and returns the element at the front of the queue.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     *
     * @return the element at the front of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    /**
     * Returns true if the queue contains no elements.
     *
     * @return true if the queue contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    @Override
    public int size() {
        return queue.size();
    }
}
