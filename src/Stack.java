import java.util.EmptyStackException;

public class Stack<T> extends LinkedList<T> {
    public void push(T item) { // Creating a method for pushing the elements to the top of the stack
        addFirst(item);
    }

    public T pop() { // Creating the element for popping the elements from the top of the stack
        if (getSize() == 0) { // Checking if the method call is valid by checking the size
            throw new EmptyStackException();
        }
        T item = get(0); // Setting the item to index 0
        remove(0); // Removing index 0
        return item; // Printing out the item that was removed
    }

    public static void main(String[] args) {
        Stack<Integer> Stack = new Stack<>();

        // Testing the push method
        Stack.push(1);
        Stack.push(2);
        Stack.push(3);
        System.out.println("The current stack is: " + Stack);

        // Testing the pop method
        int poppedElement = Stack.pop(); // Initializing the int that points to the element that was popped and returned
        System.out.println("The popped element is: " + poppedElement);
        System.out.println("The current stack is: " + Stack);
    }
}
