public interface QueueInterface<E> {

    // Adds an element to the end of the queue.
    void enqueue(E element);

    // Removes and returns the element at the front of the queue.
    // Throws a NoSuchElementException if the queue is empty.
    E dequeue();

    // Returns the element at the front of the queue without removing it.
    // Throws a NoSuchElementException if the queue is empty.
    E peek();

    // Returns true if the queue is empty, false otherwise.
    boolean isEmpty();

    // Returns the number of elements in the queue.
    int getSize();
}