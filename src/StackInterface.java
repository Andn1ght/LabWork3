public interface StackInterface<E> {
    int getSize();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();
}
