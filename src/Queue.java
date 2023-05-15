import java.util.NoSuchElementException;

public class Queue<T> extends LinkedList<T> {
    public void enqueue(T item) { // Adding a method for enqueuing elements to later be added to the list
        add(item); // Adding the item to the end of the queue
    }

    public T dequeue() { // Adding a method for dequeueing elements from the queue and adding them to the list
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty"); // Throwing an exception if the queue is empty
        }
        return removeAndGet(); // Removing and returning the first item from the queue
    }

    public boolean isEmpty() { //
        return getSize() == 0; // Checking if the queue is empty based on the size of the linked list
    }

    private T removeAndGet() {
        T element = get(0); // Getting the element at 0, so the first element to be removed
        remove(0); // Removing the element at index 0
        return element; // Returning the removed element
    }

    public static void main(String[] args) {
        Queue<String> Queue = new Queue<>(); // Creating a new queue

        // Enqueueing elements
        Queue.enqueue("A");
        Queue.enqueue("B");
        Queue.enqueue("C");

        // Dequeueing elements
        System.out.println(Queue.dequeue());
        System.out.println(Queue.dequeue());

        // Enqueueing more elements
        Queue.enqueue("D");
        Queue.enqueue("E");

        // Dequeueing elements
        System.out.println(Queue.dequeue());
        System.out.println(Queue.dequeue());
        System.out.println(Queue.dequeue());

        // Trying to dequeue from an empty queue
        try {
            System.out.println(Queue.dequeue());
        } catch (NoSuchElementException e) {
            System.out.println("Queue is empty");
        }
    }
}