public class MyLinkedListStack<E> implements StackInterface<E> {
    private MyLinkedList<E> myLinkedList;

    public MyLinkedListStack(){
        myLinkedList = new MyLinkedList<>();
    }

    @Override
    public void push(E element) {
        myLinkedList.addFirst(element);
    }
}
