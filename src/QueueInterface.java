public interface QueueInterface<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int getSize();
}