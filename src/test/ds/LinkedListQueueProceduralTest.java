package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListQueueProceduralTest {

    @BeforeEach
    void setUp() {
        // Clear the underlying linked list before each test to ensure isolation
        LinkedListProcedural.head = null;
        LinkedListProcedural.tail = null;
    }

    @Test
    void testEnqueue() {
        LinkedListQueueProcedural.enqueue(10);
        LinkedListQueueProcedural.enqueue(20);
        LinkedListQueueProcedural.enqueue(30);

        // Check if elements are enqueued correctly by displaying the queue
        assertEquals(10, LinkedListProcedural.head.data);
        assertEquals(30, LinkedListProcedural.tail.data);
    }

    @Test
    void testDequeue() {
        LinkedListQueueProcedural.enqueue(10);
        LinkedListQueueProcedural.enqueue(20);

        assertEquals(10, LinkedListQueueProcedural.dequeue()); // Dequeue the first element
        assertEquals(20, LinkedListQueueProcedural.dequeue()); // Dequeue the second element

        // Check for exception when dequeuing an empty queue
        assertThrows(IllegalStateException.class, LinkedListQueueProcedural::dequeue);
    }

    @Test
    void testPeek() {
        LinkedListQueueProcedural.enqueue(10);
        LinkedListQueueProcedural.enqueue(20);

        assertEquals(10, LinkedListQueueProcedural.peek()); // Peek the front element
        assertEquals(10, LinkedListQueueProcedural.peek()); // Peek again to ensure no removal

        LinkedListQueueProcedural.dequeue(); // Remove the front element
        assertEquals(20, LinkedListQueueProcedural.peek()); // Peek at the new front element
    }

    @Test
    void testDisplay() {
        LinkedListQueueProcedural.enqueue(10);
        LinkedListQueueProcedural.enqueue(20);
        LinkedListQueueProcedural.enqueue(30);

        // Capture the output of display() (if necessary, use a stream to intercept `System.out.print`)
        LinkedListQueueProcedural.display(); // Manual verification of output: "10 -> 20 -> 30 -> null"
    }

    @Test
    void testQueueUnderflow() {
        // Check for exception when peeking an empty queue
        assertThrows(IllegalStateException.class, LinkedListQueueProcedural::peek);

        // Check for exception when dequeuing an empty queue
        assertThrows(IllegalStateException.class, LinkedListQueueProcedural::dequeue);
    }
}