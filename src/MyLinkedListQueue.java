import java.util.NoSuchElementException;

public class MyLinkedListQueue<E> implements QueueInterface<E> {
    private MyLinkedList<E> queue;

    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }

    @Override
    public void enqueue(E element) {
        queue.addLast(element);
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return queue.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public int size() {
        return queue.size();
    }
}
