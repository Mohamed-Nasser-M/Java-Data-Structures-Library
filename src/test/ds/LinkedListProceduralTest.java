package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListProceduralTest {

    @BeforeEach
    void setUp() {
        // Clear the linked list before each test
        LinkedListProcedural.clear();
    }

    @Test
    void testAdd() {
        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        LinkedListProcedural.add(30);

        // Verify the size of the list
        assertEquals(3, LinkedListProcedural.getSize());

        // Verify the values of the head and tail
        assertEquals(10, LinkedListProcedural.head.data);
        assertEquals(30, LinkedListProcedural.tail.data);
    }

    @Test
    void testDelete() {
        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        LinkedListProcedural.add(30);

        // Delete a value in the middle
        assertTrue(LinkedListProcedural.delete(20));
        assertEquals(2, LinkedListProcedural.getSize());
        assertFalse(LinkedListProcedural.search(20));

        // Delete the head
        assertTrue(LinkedListProcedural.delete(10));
        assertEquals(1, LinkedListProcedural.getSize());
        assertEquals(30, LinkedListProcedural.head.data);

        // Delete the tail
        assertTrue(LinkedListProcedural.delete(30));
        assertEquals(0, LinkedListProcedural.getSize());
        assertNull(LinkedListProcedural.head);
        assertNull(LinkedListProcedural.tail);

        // Attempt to delete a value from an empty list
        assertFalse(LinkedListProcedural.delete(40));
    }

    @Test
    void testSearch() {
        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        LinkedListProcedural.add(30);

        // Verify that existing elements are found
        assertTrue(LinkedListProcedural.search(10));
        assertTrue(LinkedListProcedural.search(20));
        assertTrue(LinkedListProcedural.search(30));

        // Verify that a non-existing element is not found
        assertFalse(LinkedListProcedural.search(40));
    }

    @Test
    void testDisplay() {
        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        LinkedListProcedural.add(30);

        // Display the list (manual verification for output: "10 -> 20 -> 30 -> null")
        LinkedListProcedural.display();

        // Edge case: display an empty list
        LinkedListProcedural.clear();
        LinkedListProcedural.display(); // Output: "The list is empty."
    }

    @Test
    void testGetSize() {
        assertEquals(0, LinkedListProcedural.getSize()); // Initially empty

        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        assertEquals(2, LinkedListProcedural.getSize());

        LinkedListProcedural.delete(10);
        assertEquals(1, LinkedListProcedural.getSize());

        LinkedListProcedural.clear();
        assertEquals(0, LinkedListProcedural.getSize());
    }

    @Test
    void testClear() {
        LinkedListProcedural.add(10);
        LinkedListProcedural.add(20);
        LinkedListProcedural.add(30);

        // Clear the list
        LinkedListProcedural.clear();
        assertEquals(0, LinkedListProcedural.getSize());
        assertNull(LinkedListProcedural.head);
        assertNull(LinkedListProcedural.tail);
    }

    @Test
    void testEdgeCases() {
        // Delete from an empty list
        assertFalse(LinkedListProcedural.delete(10));

        // Search in an empty list
        assertFalse(LinkedListProcedural.search(10));

        // Display an empty list
        LinkedListProcedural.display(); // Output: "The list is empty."

        // Add and delete the same value
        LinkedListProcedural.add(10);
        assertTrue(LinkedListProcedural.delete(10));
        assertEquals(0, LinkedListProcedural.getSize());
        assertNull(LinkedListProcedural.head);
        assertNull(LinkedListProcedural.tail);
    }
}