import java.util.Arrays;

public class MyArrayList<T> implements MyList<T>{
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
            size = 0;
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Returns true if this list contains the specified element.
     *
     * @param o the element to search for
     * @return true if this list contains the specified element
     */
    public boolean contains(Object o) {
        // Iterate over all elements in the list
        for (int i = 0; i < size; i++) {

            // If the current element equals the search element, return true
            if (list[i].equals(o)) {
                return true;
            }
        }
        // If the search element was not found, return false
        return false;
    }

    /**
     * Adds the specified element to the end of this list.
     *
     * @param item the element to add
     */
    public void add(T item) {
        // Check if the buffer is full
        if (isFull()) {
            // Increase the buffer size
            increaseBuffer();
        }
        // Add the element to the end of the list and increment the size
        list[size++] = item;
    }

    /**
     * Adds the specified item to this list at the specified index.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     *
     * @param item the item to add to the list
     * @param index the index at which to add the item
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(T item, int index) {
        // Check valid index
        checkIndex(index);
        // Check if the buffer is full
        if (isFull()) {
            // Increase the buffer size
            increaseBuffer();
        }
        // Shift the elements from index to size-1 one position to the right
        for (int i = size - 1; i >= index; i--) {
            list[i + 1] = list[i];
        }
        // Insert the item at the specified index
        list[index] = item;
        size++;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param item the element to be removed from this list, if present
     * @return true if this list contained the specified element, false otherwise
     */
    public boolean remove(T item) {
        // Iterate over the array
        for (int i = 0; i < size; i++) {
            // Check if the current element is equal to the item to be removed
            if (list[i].equals(item)) {
                // If the element is found, call the remove method with the index and
                // remove the element from the list
                remove(i);
                // Return true to indicate that the element has been removed
                return true;
            }
        }
        // If the element is not found, return false to indicate that nothing was removed
        return false;
    }

    /**
     * Removes and returns the element at the specified index in this list.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T remove(int index) {
        // check if index is valid
        checkIndex(index);
        // get the item to be removed
        T removedItem = (T) list[index];
        // shift elements to the left
        for (int i = index; i < size - 1; i++) {
            list[i] = list[i + 1];
        }
        // decrement the size of the list
        size--;
        // set the last element to null
        list[size] = null;
        // return the removed item
        return removedItem;
    }


    /**
     * Removes all elements from the list, and sets the size to zero.
     */
    public void clear() {
        // Create a new array with the default capacity and assign it to the list variable
        this.list = (T[]) new Object[DEFAULT_CAPACITY];
        // Set the size to zero
        this.size = 0;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public T get(int index) {
        checkIndex(index);
        return (T) list[index];
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    public int indexOf(Object o) {
        // Iterate over the array
        for (int i = 0; i < size; i++) {
            // Check if the current element is equal to the given object
            if (list[i].equals(o)) {
                // Return the index if the object is found
                return i;
            }
        }
        // Return -1 if the object is not found
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this list
     * or -1 if this list does not contain the element.
     *
     * @param o the element to search for
     * @return the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element
     */
    public int lastIndexOf(Object o) {
        // Iterate from the end of the list to the beginning
        for (int i = size - 1; i >= 0; i--) {
            // If the current element matches the specified element, return its index
            if (list[i].equals(o)) {
                return i;
            }
        }
        // The specified element was not found in the list, return -1
        return -1;
    }

    /**
     * Sorts the elements of the list in ascending order.
     * Uses the Arrays.sort() method to perform the sorting.
     * The range to be sorted starts from index 0 (inclusive)
     * and ends at index size (exclusive).
     */
    public void sort() {
        Arrays.sort(list, 0, size);
    }


    // Helpers--------------------------------------

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    public String toString() {

        // If the list is empty, return an empty string representation
        if(size == 0) {
            return "[]";
        }

        // Start building the string representation with an opening square bracket
        String result = "[";

        // Iterate over the elements in the list
        for(int i=0; i < size; i++) {
            // Add the current element to the string representation, followed by a comma and a space
            result = result + list[i] + ", ";
        }

        // Remove the final comma and space from the string representation
        result = result.substring(0,result.length()-2);

        // Add a closing square bracket to the string representation
        result = result + "]";

        // Return the final string representation of the list
        return result;
    }

    /**
     * Doubles the size of the list buffer by creating a new array and copying the elements from the old list
     * to the new one.
     */
    private void increaseBuffer(){

        T[] newArr = (T[]) new Object[list.length * 2]; // Create a new array with double the size of the current list buffer.

        for (int i = 0; i < list.length; i++) {
            newArr[i] = (T) list[i]; // Copy the elements from the old list to the new one.
        }

        list = newArr;  // Update the list reference to the new array.
    }

    /**
     * Checks if the given index is valid or not.
     * Throws an IndexOutOfBoundsException if the index is invalid.
     *
     * @param index the index to check
     */
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns a boolean indicating whether the list is full.
     *
     * @return true if the list is full, false otherwise
     */
    private boolean isFull() {
        // check if the size of the list is equal to the length of the array
        if(size == list.length)
            // if it is, return true
            return true;
        else
            // if it is not, return false
            return false;
    }
}
