import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        // Part 1.1

        LinkedList<Integer> list = new LinkedList<>(); // Creating a new LinkedList with Integer class objects
        // Testing the add method for adding elements to the first node in the list
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List after adding elements: " + list);

        // Testing the add method for adding elements to the specific index in the list
        list.add(1, 4);
        list.add(3, 5);
        System.out.println("List after inserting elements: " + list);

        // Testing the get method for getting the element at a given index
        System.out.println("Element at index 2: " + list.get(2));

        // Testing the remove method to remove the first element in the list that matches the given one
        list.remove(Integer.valueOf(4));
        System.out.println("List after removing element 15: " + list);

        // Testing the remove method for removing the element at a given index
        list.remove(2);
        System.out.println("List after removing element at index 2: " + list);

        // Testing the remove all method that removes all the elements that match the given element
        list.add(333);
        list.add(333);
        list.removeAll(333);
        System.out.println("List after removing all occurrences of 333: " + list);

        // Testing the addFirst method that adds an element at the beginning
        list.addFirst(5);
        System.out.println("List after adding element at the beginning: " + list); //

        // Testing the getSize method that gets the size of the list
        System.out.println("Size of the list: " + list.getSize());

        // Testing the toString method that turns the list into a string using a StringBuilder
        System.out.println("List as string: " + list);

        // Part 1.2

        // 1. What is the time complexity of adding element at the end of the list? Why?
        // The add() method adds an element at the end of the list with an O(1) or constant
        // complexity. This is due to the fact that adding an element at the end only
        // means updating the references of the previous node and the new node, the full
        // list does not need to be traversed.

        // 2. The add(int i, T e) method adds an element to the list at position i with an O(n)
        // time complexity, where n is the list's length. This is due to the fact that, in the
        // worst case scenario, adding an element at a certain index requires traversing the list
        // to identify the node at the requested position, which takes O(n) time. The method then
        // creates a new node and changes the references of the neighboring nodes after determining the
        // position, which takes constant time.

        // 3. The given code snippet has a time complexity of O(n),
        // where n is the length of the list. This is because the loop executes
        // actions such as retrieving the element at a given index using
        // list.get(i) during each of its n iterations. As a result, the overall
        // complexity is inversely correlated with the length of the list.
    }
}
