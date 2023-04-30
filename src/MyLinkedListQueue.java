public class MyLinkedListQueue<E> implements QueueInterface<E> {
    private MyLinkedList<E> queue;

    public MyLinkedListQueue() {
        queue = new MyLinkedList<>();
    }
}
