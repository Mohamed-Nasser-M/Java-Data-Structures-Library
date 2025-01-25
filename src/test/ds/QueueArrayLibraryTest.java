package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueArrayLibraryTest {

    private QueueArrayLibrary queue;

    @BeforeEach
    void setUp() {
        queue = new QueueArrayLibrary(5); // Initialize the queue with capacity 5
    }

    @Test
    void testEnqueue() {
        assertTrue(queue.enqueue(10)); // Enqueue elements
        assertTrue(queue.enqueue(20));
        assertTrue(queue.enqueue(30));
        assertTrue(queue.enqueue(40));
        assertTrue(queue.enqueue(50)); // Fill the queue
        assertFalse(queue.enqueue(60)); // Enqueue should fail when the queue is full
    }

    @Test
    void testDequeue() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.dequeue()); // Dequeue elements
        assertEquals(20, queue.dequeue());
        assertEquals(30, queue.dequeue());
        assertEquals(-1, queue.dequeue()); // Dequeue should fail when the queue is empty
    }

    @Test
    void testPeek() {
        assertEquals(-1, queue.peek()); // Peek on an empty queue

        queue.enqueue(10);
        queue.enqueue(20);
        assertEquals(10, queue.peek()); // Peek at the front element
        assertEquals(10, queue.peek()); // Peek should not remove the element
    }

    @Test
    void testIsEmpty() {
        assertTrue(queue.isEmpty()); // Initially empty

        queue.enqueue(10);
        assertFalse(queue.isEmpty()); // After enqueueing an element

        queue.dequeue();
        assertTrue(queue.isEmpty()); // After dequeueing all elements
    }

    @Test
    void testIsFull() {
        assertFalse(queue.isFull()); // Initially not full

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        assertTrue(queue.isFull()); // After filling the queue

        queue.dequeue();
        assertFalse(queue.isFull()); // After removing an element
    }

    @Test
    void testCircularEnqueueAndDequeue() {
        // Enqueue and dequeue in a circular manner
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        assertEquals(10, queue.dequeue());
        assertEquals(20, queue.dequeue());

        // Enqueue more elements, ensuring circular behavior
        assertTrue(queue.enqueue(60));
        assertTrue(queue.enqueue(70));

        assertEquals(30, queue.dequeue());
        assertEquals(40, queue.dequeue());
        assertEquals(50, queue.dequeue());
        assertEquals(60, queue.dequeue());
        assertEquals(70, queue.dequeue());
        assertEquals(-1, queue.dequeue()); // Queue should now be empty
    }
}