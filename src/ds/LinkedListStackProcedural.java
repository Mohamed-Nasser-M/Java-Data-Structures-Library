package ds;

public class LinkedListStackProcedural {

    // Push a new element onto the stack
    public static void push(int data) {
        LinkedListProcedural.add(data); // Add to the end of the linked list
    }

    // Pop an element from the stack
    public static int pop() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Stack underflow: The stack is empty.");
        }

        // Traverse to the second-to-last element
        LinkedListProcedural.Node temp = LinkedListProcedural.head;
        if (temp.next == null) { // Only one element in the list
            int value = temp.data;
            LinkedListProcedural.head = null;
            return value;
        }

        while (temp.next.next != null) {
            temp = temp.next;
        }

        int value = temp.next.data; // Get the last element's value
        temp.next = null; // Remove the last element
        return value;
    }

    // Peek at the top element of the stack
    public static int peek() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Stack underflow: The stack is empty.");
        }

        LinkedListProcedural.Node temp = LinkedListProcedural.head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp.data; // Return the last element's value
    }

    // Display the stack
    public static void display() {
        LinkedListProcedural.display();
    }
}