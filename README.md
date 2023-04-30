# LabWork3 🚀

### Laboratory work for assignment 3 in AITU. This project contains Java classes that implement ***`Stack`*** and ***`Queue`*** data structures. It implemented by ***`MyLinkedList`*** class🎯:

## `Stack` implementation [module src](https://github.com/Andn1ght/LabWork3/blob/master/src/MyLinkedListStack.java) 📈:
*The program provides `stack` implementation by using ***[`MyLinkedList`](https://github.com/Andn1ght/LabWork2/blob/master/src/MyLinkedList.java)*** from previous ***[`LabWork`](https://github.com/Andn1ght/LabWork2)***.*
* ***[`StackInterface`](https://github.com/Andn1ght/LabWork3/blob/master/src/StackInterface.java)*** that declares methods for the `MyLinkedListStack` implementation
```java
public interface StackInterface<E> {
    int size();
    boolean isEmpty();
    void push(E element);
    E pop();
    E peek();
}
```
* ***[`MyLinkedListStack`](https://github.com/Andn1ght/LabWork3/blob/master/src/MyLinkedListStack.java)*** that uses a linked list to store the elements
```java
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
```
## 📜 *Usage*:
***To use a stack implementation***, you need to create an instance of the implementation class and then call the methods ***`push`***, ***`pop`***, ***`peek`***, ***`isEmpty`***, and ***`size`*** as needed. 
### *Example*:
```java
MyLinkedListStack<Integer> stack = new MyLinkedListStack<>();
stack.push(1);
stack.push(2);
System.out.println(stack.peek()); // prints 2
stack.pop();
System.out.println(stack.peek()); // prints 1
System.out.println(stack.isEmpty()); // prints false
System.out.println(stack.size()); // prints 1
```

## `Queue` implementation [module src](https://github.com/Andn1ght/LabWork3/blob/master/src/MyLinkedListQueue.java) 📈:

*The program provides `queue` implementation by using ***[`MyLinkedList`](https://github.com/Andn1ght/LabWork2/blob/master/src/MyLinkedList.java)*** from previous ***[`LabWork`](https://github.com/Andn1ght/LabWork2)***.*
* ***[`QueueInterface`](https://github.com/Andn1ght/LabWork3/blob/master/src/QueueInterface.java)*** that declares methods for the `MyLinkedListQueue` implementation
```java
public interface QueueInterface<E> {
    void enqueue(E element);
    E dequeue();
    E peek();
    boolean isEmpty();
    int size();
}
```
* ***[`MyLinkedListQueue`](https://github.com/Andn1ght/LabWork3/blob/master/src/MyLinkedListQueue.java)*** that uses a linked list to store the elements
```java
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
```
## 📜 *Usage*:
***To use a queue implementation***, you need to create an instance of the implementation class and then call the methods ***`enqueue`***, ***`dequeue`***, ***`peek`***, ***`isEmpty`***, and ***`size`*** as needed.
### *Example*:
```java
MyLinkedListQueue<String> queue = new MyLinkedListQueue<>();
queue.enqueue("A");
queue.enqueue("B");
System.out.println(queue.peek()); // prints A
queue.dequeue();
System.out.println(queue.peek()); // prints B
System.out.println(queue.isEmpty()); // prints false
System.out.println(queue.size()); // prints 1
```





