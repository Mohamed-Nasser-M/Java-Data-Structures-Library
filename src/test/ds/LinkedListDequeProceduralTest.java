package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListDequeProceduralTest {

    @BeforeEach
    void setUp() {
        LinkedListDequeProcedural.clear(); // Reset the deque state before each test
    }

    @Test
    void testAddFront() {
        LinkedListDequeProcedural.addFront(10);
        assertEquals(1, LinkedListDequeProcedural.size());

        LinkedListDequeProcedural.addFront(20);
        assertEquals(2, LinkedListDequeProcedural.size());
    }

    @Test
    void testAddRear() {
        LinkedListDequeProcedural.addRear(30);
        assertEquals(1, LinkedListDequeProcedural.size());

        LinkedListDequeProcedural.addRear(40);
        assertEquals(2, LinkedListDequeProcedural.size());
    }

    @Test
    void testRemoveFront() {
        LinkedListDequeProcedural.addFront(10);
        LinkedListDequeProcedural.addRear(20);

        assertEquals(10, LinkedListDequeProcedural.removeFront());
        assertEquals(1, LinkedListDequeProcedural.size());
        assertEquals(20, LinkedListDequeProcedural.removeFront());
        assertEquals(0, LinkedListDequeProcedural.size());
        assertThrows(IllegalStateException.class, LinkedListDequeProcedural::removeFront);
    }

    @Test
    void testRemoveRear() {
        LinkedListDequeProcedural.addRear(10);
        LinkedListDequeProcedural.addRear(20);

        assertEquals(20, LinkedListDequeProcedural.removeRear());
        assertEquals(1, LinkedListDequeProcedural.size());
        assertEquals(10, LinkedListDequeProcedural.removeRear());
        assertEquals(0, LinkedListDequeProcedural.size());
        assertThrows(IllegalStateException.class, LinkedListDequeProcedural::removeRear);
    }

    @Test
    void testIsEmpty() {
        assertTrue(LinkedListDequeProcedural.isEmpty()); // Initially empty
        LinkedListDequeProcedural.addFront(10);
        assertFalse(LinkedListDequeProcedural.isEmpty()); // After adding an element
        LinkedListDequeProcedural.removeFront();
        assertTrue(LinkedListDequeProcedural.isEmpty()); // After removing all elements
    }

    @Test
    void testClear() {
        LinkedListDequeProcedural.addFront(10);
        LinkedListDequeProcedural.addRear(20);
        assertFalse(LinkedListDequeProcedural.isEmpty());
        LinkedListDequeProcedural.clear();
        assertTrue(LinkedListDequeProcedural.isEmpty());
        assertEquals(0, LinkedListDequeProcedural.size());
    }
}
