import java.util.EmptyStackException;

/**
 * A stack implementation using a linked list data structure.
 * The elements are stored in a singly linked list and operations
 * are performed on the head of the list.
 * The stack follows LIFO (Last In, First Out) principle.
 *
 * @param <E> the type of elements stored in the stack
 */
public class MyLinkedListStack<E> implements StackInterface<E> {
    private MyLinkedList<E> myLinkedList;

    public MyLinkedListStack(){
        myLinkedList = new MyLinkedList<>();
    }

    @Override
    public void push(E element) {
        myLinkedList.addFirst(element);
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return myLinkedList.removeFirst();
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return myLinkedList.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }

    @Override
    public int size() {
        return myLinkedList.size();
    }
}
