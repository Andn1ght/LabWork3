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
    private MyLinkedList<E> myLinkedList; // the linked list to implement the stack

    /**
     * Constructs a new empty stack based on a linked list.
     */
    public MyLinkedListStack(){
        myLinkedList = new MyLinkedList<>();
    }

    /**
     * Pushes the specified element onto the top of the stack.
     *
     * @param element the element to be pushed onto the stack
     */
    @Override
    public void push(E element) {
        myLinkedList.addFirst(element); // add the element to the front of the linked list
    }

    /**
     * Removes and returns the element at the top of the stack.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E pop() {
        if (isEmpty()) { // if the stack is empty
            throw new EmptyStackException(); // throw an exception
        }
        return myLinkedList.removeFirst(); // remove and return the first element in the linked list
    }

    /**
     * Returns the element at the top of the stack without removing it.
     *
     * @return the element at the top of the stack
     * @throws EmptyStackException if the stack is empty
     */
    @Override
    public E peek() {
        if (isEmpty()) { // if the stack is empty
            throw new EmptyStackException(); // throw an exception
        }
        return myLinkedList.getFirst(); // return the first element in the linked list
    }

    /**
     * Returns true if the stack contains no elements.
     *
     * @return true if the stack contains no elements, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty(); // return whether the linked list is empty
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int size() {
        return myLinkedList.size(); // return the size of the linked list
    }
}
