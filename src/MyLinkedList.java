import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {

    public static class Node<E> {
        public E element;
        public Node<E> next;
        private Node<E> prev;

        public Node(E element, Node<E> next, Node<E> previous) {
            this.element = element;
            this.next = next;
            this.prev = previous;
        }

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public Node(E element) {
            this.element = element;
            this.next = null;
        }

        public Node() {
            this.element = null;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;


    /**
     * Returns the number of elements in the linked list.
     *
     * @return the number of elements in the linked list
     */
    public int size() {
        Node<E> current = head; // create temporary reference to update
        int count = 0; // initialize count to zero
        while (current != null) { // continue loop until end of list
            count++; // increment count for each node
            current = current.next; // move to next node
        }
        return count; // return final count
    }


    /**
     * Returns true if the linked list contains the specified element.
     *
     * @param o the element to search for
     * @return true if the element is found, false otherwise
     */
    public boolean contains(Object o) {
        return indexOf(o) != -1; // use indexOf() method to search for element
    }


    /**
     * Adds the specified element to the end of the linked list.
     *
     * @param item the element to add
     */
    public void add(E item) {
        addLast(item); // call addLast() method to add item to end of list
    }

    /**
     * Inserts the specified element at the specified position in the linked list.
     *
     * @param item the element to insert
     * @param index the position at which to insert the element
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(E item, int index) {
        checkIndex(index); // check if index is valid
        if (index == size) { // if index is at end of list
            addLast(item); // add element to end of list
        } else {
            addBefore(item, node(index)); // add element before the node at the specified index
        }
    }


    public E removeFirst() {
        if (isEmpty()) { // check if the list is empty
            throw new NoSuchElementException("Cannot remove from an empty list");
        }

        E item = head.element; // get the element at the head of the list
        remove(item); // remove the first occurrence of the element
        return item; // return the removed element
    }

    /**
     * Removes the first occurrence of the specified element from the linked list.
     *
     * @param item the element to remove
     * @return true if the element was found and removed, false otherwise
     */
    public boolean remove(E item) {
        Node<E> currentNode = head; // create temporary reference to update

        // traverse the list to find the first occurrence of the element
        while (currentNode != null && !currentNode.element.equals(item)) {
            currentNode = currentNode.next;
        }

        if (currentNode == null) { // if element not found
            return false; // return false
        }

        // update the references of the previous and next nodes to remove the node
        if (currentNode.prev != null) {
            currentNode.prev.next = currentNode.next;
        } else {
            head = currentNode.next;
        }

        if (currentNode.next != null) {
            currentNode.next.prev = currentNode.prev;
        } else {
            tail = currentNode.prev;
        }

        size--; // decrement size
        return true; // return true to indicate that element was found and removed
    }


    /**
     * Removes the element at the specified position in the linked list.
     *
     * @param index the position of the element to remove
     * @return the element that was removed
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E remove(int index) {
        checkIndex(index); // check if index is valid
        return unInsert(node(index)); // remove and return the element at the specified index
    }

    /**
     * Removes all elements from the linked list.
     */
    public void clear() {
        head = null; // set the head node to null
        tail = null; // set the tail node to null
        size = 0; // set the size to 0
    }


    /**
     * Returns the element at the specified position in the linked list.
     *
     * @param index the position of the element to return
     * @return the element at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public E get(int index) {
        checkIndex(index); // check if index is valid
        return (E) getNode(index).element; // get and return the element at the specified index
    }

    public E getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("LinkedList is empty");
        }
        return getNode(0).element;
    }


    /**
     * Returns the index of the first occurrence of the specified element in the linked list,
     * or -1 if the linked list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the element, or -1 if not found
     */
    public int indexOf(Object o) {
        int index = 0; // initialize the index to 0
        Node<E> currentNode = head; // start at the head node
        while (currentNode != null && !currentNode.element.equals(o)) { // traverse the linked list until we find the element or reach the end
            currentNode = currentNode.next; // move to the next node
            index++; // increment the index
        }
        if (currentNode == null) { // if the element is not found, return -1
            return -1;
        }
        return index; // otherwise, return the index of the element
    }


    /**
     * Returns the index of the last occurrence of the specified element in the linked list,
     * or -1 if the linked list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the element, or -1 if not found
     */
    public int lastIndexOf(Object o) {
        int index = size - 1; // initialize the index to the last element
        Node<E> currentNode = tail; // start at the tail node
        while (currentNode != null && !currentNode.element.equals(o)) { // traverse the linked list backwards until we find the element or reach the beginning
            currentNode = currentNode.prev; // move to the previous node
            index--; // decrement the index
        }
        if (currentNode == null) { // if the element is not found, return -1
            return -1;
        }
        return index; // otherwise, return the index of the element
    }

    /**
     * Throws exception that this method does not available
     *
     * @throws UnsupportedOperationException if this method called
     */
    @Override
    public void sort() {
        throw new UnsupportedOperationException();
    }

    //Helper methods


    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Returns the node at the specified index in the list.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range (index < 0 || index >= size())
     */
    Node<E> node(int index) {

        if(index < (size >> 1)) { // if the index is in the first half of the list
            Node<E> indexFirstHalf = head;
            for (int i = 0; i < index; i++) { // iterate through the list from the head to the index node
                indexFirstHalf = indexFirstHalf.next;
            }
            return indexFirstHalf; // return the node at the index
        }
        else { // if the index is in the second half of the list
            Node<E> indexLastHalf = tail;
            for (int i = size - 1; i > index ; i--) { // iterate through the list from the tail to the index node
                indexLastHalf = indexLastHalf.prev;
            }
            return indexLastHalf; // return the node at the index
        }
    }

    /**
     * Adds the specified element before the specified node in the list.
     *
     * @param element the element to add
     * @param such the node to add the element before
     */
    public void addBefore(E element, Node<E> such) {
        Node<E> preSuch = such.prev; // reference to the previous node of the node to add before
        Node<E> newNode = new Node<>(element, such, preSuch); // create new node with references to such and preSuch
        such.prev = newNode; // update such's previous reference to the new node
        if (preSuch == null)
            such = newNode; // if preSuch is null, set such to the new node
        else
            preSuch.next = newNode; // otherwise, update preSuch's next reference to the new node
        size++; // increment the size of the list
    }

    /**
     * Adds the specified element to the end of the list.
     *
     * @param element the element to be added to the list
     */
    public void addLast(E element) {
        Node<E> lastNode = tail;
        Node<E> newNode = new Node<>(element, null, lastNode);
        tail = newNode;
        if (lastNode == null)
            head = newNode;
        else {
            lastNode.next = newNode;
        }
        size++;
    }

    /**
     * Adds the specified element to the beginning of this linked list.
     *
     * @param element the element to add
     */
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            // if the list is empty, set the head and tail to the new node
            head = newNode;
            tail = newNode;
        } else {
            // otherwise, set the new node as the head and update the links
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++; // increment size
    }

    /**
     * Returns the node at the specified index.
     *
     * @param index the index of the node to retrieve
     * @return the node at the specified index
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private Node<E> getNode(int index) {
        Node<E> currentNode;
        // check if the given index is within the valid range of indices
        if (index < size / 2) {
            // if the given index is in the first half of the list, start from the head node
            currentNode = head;
            for (int i = 0; i < index; i++) {
                // move to the next node in the list until reaching the desired index
                currentNode = currentNode.next;
            }
        } else {
            // if the given index is in the second half of the list, start from the tail node
            currentNode = tail;
            for (int i = size - 1; i > index; i--) {
                // move to the previous node in the list until reaching the desired index
                currentNode = currentNode.prev;
            }
        }
        return currentNode;
    }

    /**
     * Checks whether the given index is valid for the current size of the list.
     *
     * @param index The index to check
     * @throws IndexOutOfBoundsException if the index is less than zero or greater than or equal to the size of the list.
     */
    private void checkIndex(int index) {

        if (index < 0 || index > size) {
            try {
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns a string representation of this doubly linked list.
     * The string representation consists of a list of the elements enclosed in square brackets ("[]").
     * Adjacent elements are separated by the comma character (',') and a space.
     *
     * @return a string representation of this doubly linked list
     */
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append("[ ");
        Node<E> temp = head;
        while (temp.next != null) {
            str.append(temp.element + ", ");
            temp = temp.next;
        }
        str.append(temp.element + " ]");
        return str.toString();
    }

    /**
     * Removes the given node from the list and returns its element.
     *
     * @param lastNode the node to remove from the list
     * @return the element of the removed node
     */
    private E unInsert(Node<E> lastNode) {
        // Store the element of the node to be removed
        E element = lastNode.element;
        // Store the next and previous nodes of the node to be removed
        Node<E> next = lastNode.next;
        Node<E> prev = lastNode.prev;

        // If the previous node is null, set the head to the next node
        if (prev == null)
            head = next;
        else {
            // Set the next node of the previous node to the next node of the node to be removed
            prev.next = next;
            // Set the previous node of the node to be removed to null
            lastNode.prev = null;
        }

        // If the next node is null, set the tail to the previous node
        if (next == null)
            tail = prev;
        else {
            // Set the previous node of the next node to the previous node of the node to be removed
            next.prev = prev;
            // Set the next node of the node to be removed to null
            lastNode.next = null;
        }
        // Set the element of the node to be removed to null
        lastNode.element = null;
        // Decrement the size of the list
        size--;
        // Return the element of the removed node
        return element;
    }
}
