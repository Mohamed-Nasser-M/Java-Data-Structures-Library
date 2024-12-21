package ds;

class LinkedListDequeProcedural {

    // Add an element to the front of the deque
    public static void addFront(int data) {
        LinkedListProcedural.Node newNode = new LinkedListProcedural.Node(data);
        newNode.next = LinkedListProcedural.head; // Link the new node to the current head
        LinkedListProcedural.head = newNode; // Update the head to the new node
    }

    // Add an element to the rear of the deque
    public static void addRear(int data) {
        LinkedListProcedural.add(data); // Reuse the add method from LinkedListProcedural
    }

    // Remove an element from the front of the deque
    public static int removeFront() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Deque underflow: The deque is empty.");
        }

        int value = LinkedListProcedural.head.data; // Get the head value
        LinkedListProcedural.head = LinkedListProcedural.head.next; // Remove the head
        return value;
    }

    // Remove an element from the rear of the deque
    public static int removeRear() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Deque underflow: The deque is empty.");
        }

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

    // Display the deque
    public static void display() {
        LinkedListProcedural.display();
    }
}
