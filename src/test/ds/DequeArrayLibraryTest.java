package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DequeArrayLibraryTest {

    private DequeArrayLibrary deque;

    @BeforeEach
    void setUp() {
        deque = new DequeArrayLibrary(5); // Initialize deque with capacity 5
    }

    @Test
    void testAddFront() {
        assertTrue(deque.addFront(10)); // Add elements to the front
        assertTrue(deque.addFront(20));
        assertEquals(20, deque.peekFront()); // Check front element

        assertTrue(deque.addFront(30));
        assertEquals(30, deque.peekFront());

        assertFalse(deque.addFront(40)); // Should fail when deque is full
    }

    @Test
    void testAddRear() {
        assertTrue(deque.addRear(10)); // Add elements to the rear
        assertTrue(deque.addRear(20));
        assertEquals(10, deque.peekFront()); // Front should remain the same

        assertTrue(deque.addRear(30));
        assertEquals(30, deque.peekRear()); // Check rear element

        assertFalse(deque.addRear(40)); // Should fail when deque is full
    }

    @Test
    void testRemoveFront() {
        deque.addRear(10);
        deque.addRear(20);
        deque.addRear(30);

        assertEquals(10, deque.removeFront()); // Remove from the front
        assertEquals(20, deque.removeFront());
        assertEquals(30, deque.removeFront());

        assertEquals(-1, deque.removeFront()); // Should fail when deque is empty
    }

    @Test
    void testRemoveRear() {
        deque.addRear(10);
        deque.addRear(20);
        deque.addRear(30);

        assertEquals(30, deque.removeRear()); // Remove from the rear
        assertEquals(20, deque.removeRear());
        assertEquals(10, deque.removeRear());

        assertEquals(-1, deque.removeRear()); // Should fail when deque is empty
    }

    @Test
    void testPeekFront() {
        assertEquals(-1, deque.peekFront()); // Peek on an empty deque

        deque.addRear(10);
        deque.addRear(20);
        assertEquals(10, deque.peekFront()); // Check front element

        deque.removeFront();
        assertEquals(20, deque.peekFront()); // Front should update after removal
    }

    @Test
    void testPeekRear() {
        assertEquals(-1, deque.peekRear()); // Peek on an empty deque

        deque.addRear(10);
        deque.addRear(20);
        assertEquals(20, deque.peekRear()); // Check rear element

        deque.removeRear();
        assertEquals(10, deque.peekRear()); // Rear should update after removal
    }

    @Test
    void testIsEmpty() {
        assertTrue(deque.isEmpty()); // Initially empty

        deque.addRear(10);
        assertFalse(deque.isEmpty()); // After adding an element

        deque.removeFront();
        assertTrue(deque.isEmpty()); // After removing all elements
    }

    @Test
    void testIsFull() {
        assertFalse(deque.isFull()); // Initially not full

        deque.addRear(10);
        deque.addRear(20);
        deque.addRear(30);
        assertFalse(deque.isFull());

        deque.addRear(40);
        deque.addRear(50);
        assertTrue(deque.isFull()); // Should be full now

        deque.removeRear();
        assertFalse(deque.isFull()); // After removing an element
    }

    @Test
    void testMixedOperations() {
        deque.addFront(10); // Add to front
        deque.addRear(20); // Add to rear
        deque.addFront(30); // Add to front

        assertEquals(30, deque.peekFront()); // Front element
        assertEquals(20, deque.peekRear()); // Rear element

        assertEquals(30, deque.removeFront()); // Remove from front
        assertEquals(10, deque.removeFront());
        assertEquals(20, deque.removeRear()); // Remove from rear

        assertTrue(deque.isEmpty()); // Deque should now be empty
    }
}