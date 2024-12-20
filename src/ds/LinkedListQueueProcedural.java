package ds;

class LinkedListQueueProcedural {

    // Enqueue an element to the rear of the queue
    public static void enqueue(int data) {
        LinkedListProcedural.add(data); // Add to the end of the linked list
    }

    // Dequeue an element from the front of the queue
    public static int dequeue() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Queue underflow: The queue is empty.");
        }

        int value = LinkedListProcedural.head.data; // Get the head value
        LinkedListProcedural.head = LinkedListProcedural.head.next; // Remove the head
        return value;
    }

    // Peek at the front element of the queue
    public static int peek() {
        if (LinkedListProcedural.head == null) {
            throw new IllegalStateException("Queue underflow: The queue is empty.");
        }
        return LinkedListProcedural.head.data; // Return the head's value
    }

    // Display the queue
    public static void display() {
        LinkedListProcedural.display();
    }
}
