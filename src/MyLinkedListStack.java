import java.util.EmptyStackException;

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
}
