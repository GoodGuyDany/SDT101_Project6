import java.util.Iterator;
import java.util.NoSuchElementException;
public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T e) { // Creating a method to add a new element at the beginning of the linked list
        Node<T> newNode = new Node<>(last, e, null);
        if (last != null) { // Checking if the last element exists, if so, the current last element is updated to point to newNode
            last.next = newNode;
        } else { // If the last element doesn't exist, the current first element is updated to point to the newNode
            first = newNode;
        }
        last = newNode; // Updates the last node to point to the newNode
        size++; // Increases the size after adding an element to the list
    }

    public void add(int i, T e) { // Creating a method to add a new element at the specified index
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException(); // Checking if the provided index is valid - if not, throwing an exception
        }
        if (i == size) { // Using the "default" add method that adds the element to the end of the list if the index is equal to size
            add(e);
            return; // Returning the list after adding the element
        }
        Node<T> current = getNode(i); // Setting the current node to the node at index i
        Node<T> newNode = new Node<>(current.prev, e, current); // Setting the prev reference to the previous reference of the new node at the index we want to add an element to
        if (current.prev != null) { // Checking if the previous reference is null or not, if not, it means there is a previous node, so the next reference of this node needs to be updated to the newNode that we just created
            current.prev.next = newNode; // Setting the current.prev.next of the previous node at the specified index to the newNode
        } else {
            first = newNode; // If there is no previous node, we simply set the first node to the newNode
        }
        current.prev = newNode; // Setting the prev reference of the current node at the specified index to the newNode
        size++;
    }

    public T get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(); // Checking if the given index is valid
        }
        Node<T> current = getNode(i); // Getting the node at the specified index and setting it to current
        return current.element; // Returning the found node
    }

    public void remove(T e) { // Creating a method for removing the first element that matches the given element
        Node<T> current = first; // Setting the current node to first element in the list to traverse the list
        while (current != null) { // Creating a while loop to traverse the list
            if (current.element.equals(e)) {
                unlink(current); // Unlinks the found elements that match the given element to remove
                return;
            }
            current = current.next; // Adds one to the current index each time the specified element is not found
        }
    }

    public void remove(int i) { // Creating a method for removing an element at the given index
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException(); // Checking if the index is valid
        }
        Node<T> current = getNode(i); // Setting the current node to node at index i
        unlink(current); // Removing the node at index i
    }

    public void removeAll(T e) { // Creating a method for removing all elements that match the given element
        Node<T> current = first; // Setting the current node to the first element in the list, used for traversing
        while (current != null) { // Creating a while loop to delete the elements
            if (current.element.equals(e)) { // Checking if the element at current is equal to the element we want to delete
                Node<T> next = current.next; // iIf the element is found, setting the next element to the current.next, so the next element after the one we are going to delete
                unlink(current); // Deleting the element at the current node
                current = next; // Setting current to next, traversing the list
            } else {
                current = current.next; // If the element doesn't match the one we want to delete, simply setting the current to next, traversing the list
            }
        }
    }

    public void addFirst(T e) { // Creating a method to add an element at the beginning of the given list
        Node<T> newNode = new Node<>(null, e, first); // Creating a new node that contains the element we want to add
        if (first != null) { // Checking if the list is empty or not to know where to put the node.
            first.prev = newNode; // If there is a first node, setting the one before it to newNode
        } else {
            last = newNode; // If there isn't a first node, setting the last node to the newNode, as it becomes both the first and the last one
        }
        first = newNode; // Setting the first node in the list to the newNode with element e
        size++; // Increasing the size after adding an element to the list
    }

    public int getSize() { // Creating a method for getting the size of the list
        return size;
    }

    public String toString() { // Creating a method to convert the list to strings
        StringBuilder sb = new StringBuilder(); // Initializing the stringbuilder
        sb.append("["); // Creating boundaries of the list, visual
        Node<T> current = first; // Setting the current node to the first node in the entire list
        while (current != null) { // Creating a while loop for traversing the list
            sb.append(current.element); // Adding the element at current after each pass of the loop
            if (current.next != null) { // Adding a comma each time when the next element in the list after the current one isn't null
                sb.append(", "); // Adding the comma
            }
            current = current.next; // Setting current node to the next node after it, traversing the list
        }
        sb.append("]"); // Creating boundaries of the list, visual
        return sb.toString(); // Returning the final string
    }

    private Node<T> getNode(int index) { // Getting a specific node at a given index
        Node<T> current; // Initializing the current node
        if (index < size / 2) { // Checks where the node is located, in the left or the right part
            current = first; // Setting the current node to first if the index we're searching for is located in the left part
            for (int i = 0; i < index; i++) { // Traversing the list
                current = current.next; // Traversing the list by changing the current to current.next index
            }
        } else { // Setting the current node to the last one as we're going to be traversing the right part of the list
            current = last;
            for (int i = size - 1; i > index; i--) // Going through the list backwards, starting from the last element
                current = current.prev; // Traversing the list by changing the current to current.prev index
        }
        return current;
    }

    private void unlink(Node<T> node) { // Method for removing specific nodes and adjusting the first, next and prev positions around it
        Node<T> prev = node.prev; // Setting the temporary prev
        Node<T> next = node.next; // Setting the temporary next

        if (prev != null) { // Checking if prev is null or not
            prev.next = next; // Updating the next reference if there is a previous node
        } else {
            first = next; // Updating the next reference if there is no previous node, so the list is empty
        }
        if (next != null) { // Checking if next is null or not
            next.prev = prev; // Updating the next reference to prev if there is a next node in the list
        } else {
            last = prev; // If not, updating prev to last, meaning the next node was the last one in the list
        }
        size--; // Reducing the size after removing a node
    }

    private static class Node<T> { // Initializing a representation class for each node in the list
        private Node<T> prev; // Setting the prev value
        private final T element; // Setting the element in the node
        private Node<T> next; // Setting the next value

        private Node(Node<T> prev, T element, Node<T> next) { // Creating a constructor for Node
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    private class ListIterator<t> implements Iterator<t> { // Creating a ListIterator class for iterating through the list
        private Node<t> current = (Node<t>) first; // Setting the current node to the first one in the entire list

        public boolean hasNext() { // Creating a method to check if there is a next element in the list or not
            return current != null;
        }

        public t next() { // Creating a method for returning the next element in the list
            if (!hasNext()) { // Checking if there is a next element in the list
                throw new NoSuchElementException(); // Throwing an exception if there isn't a next element in the list
            }
            t element = current.element; // Setting the t element to the current element
            current = current.next; // Iterating through the list by setting current to the next node after it
            return element; // Returning element
        }
    }

    public Iterator<T> iterator() { // Creating a method for returning a new ListIterator
        return new ListIterator<>(); // Returning a new ListIterator
    }
}