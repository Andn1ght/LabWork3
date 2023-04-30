public interface StackInterface<E> {

    // Returns the number of elements in the stack.
    int size();

    // Returns the number of elements in the stack.
    boolean isEmpty();

    // Pushes the specified element onto the top of the stack.
    void push(E element);

    // Removes and returns the element at the top of the stack.
    E pop();

    // Returns the element at the top of the stack without removing it.
    E peek();
}
