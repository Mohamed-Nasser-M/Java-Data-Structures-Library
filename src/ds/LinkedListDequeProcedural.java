package ds;

public class LinkedListDequeProcedural {

    private static LinkedListProcedural.Node head = null; // Head of the deque
    private static LinkedListProcedural.Node tail = null; // Tail of the deque
    private static int size = 0; // Track the size of the deque

    public static boolean isEmpty() {
        return size == 0;
    }
    // Add an element to the front of the deque
    public static void addFront(int data) {
        LinkedListProcedural.Node newNode = new LinkedListProcedural.Node(data);
        if (head == null) { // If deque is empty
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Add an element to the rear of the deque
    public static void addRear(int data) {
        LinkedListProcedural.Node newNode = new LinkedListProcedural.Node(data);
        if (tail == null) { // If deque is empty
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Remove an element from the front of the deque
    public static int removeFront() {
        if (head == null) {
            throw new IllegalStateException("Deque underflow: The deque is empty.");
        }

        int value = head.data;
        head = head.next;
        if (head == null) { // If the deque becomes empty
            tail = null;
        }
        size--;
        return value;
    }

    // Remove an element from the rear of the deque
    public static int removeRear() {
        if (head == null) {
            throw new IllegalStateException("Deque underflow: The deque is empty.");
        }

        if (head == tail) { // Only one element in the deque
            int value = head.data;
            head = tail = null;
            size--;
            return value;
        }

        LinkedListProcedural.Node temp = head;
        while (temp.next != tail) { // Traverse to the second-to-last node
            temp = temp.next;
        }

        int value = tail.data;
        tail = temp;
        tail.next = null;
        size--;
        return value;
    }

    // Display the deque
    public static void display() {
        LinkedListProcedural.Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) {
                System.out.print(" -> ");
            }
            temp = temp.next;
        }
        System.out.println(" -> null");
    }

    // Get the size of the deque
    public static int size() {
        return size;
    }

    // Clear the deque
    public static void clear() {
        head = null;
        tail = null;
        size = 0;
    }
}