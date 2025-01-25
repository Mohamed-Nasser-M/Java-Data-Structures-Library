package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackProceduralTest {

    @BeforeEach
    void setUp() {
        // Clear the underlying linked list before each test
        LinkedListProcedural.clear();
    }

    @Test
    void testPush() {
        LinkedListStackProcedural.push(10);
        LinkedListStackProcedural.push(20);
        LinkedListStackProcedural.push(30);

        // Verify the stack size
        assertEquals(3, LinkedListProcedural.getSize());

        // Verify the top element (peek)
        assertEquals(30, LinkedListStackProcedural.peek());
    }

    @Test
    void testPop() {
        LinkedListStackProcedural.push(10);
        LinkedListStackProcedural.push(20);
        LinkedListStackProcedural.push(30);

        // Pop elements and verify values
        assertEquals(30, LinkedListStackProcedural.pop());
        assertEquals(20, LinkedListStackProcedural.pop());
        assertEquals(10, LinkedListStackProcedural.pop());

        // Verify the stack is empty
        assertEquals(0, LinkedListProcedural.getSize());
        assertThrows(IllegalStateException.class, LinkedListStackProcedural::pop);
    }

    @Test
    void testPeek() {
        LinkedListStackProcedural.push(10);
        LinkedListStackProcedural.push(20);
        LinkedListStackProcedural.push(30);

        // Peek at the top element without removing it
        assertEquals(30, LinkedListStackProcedural.peek());

        // Ensure the size of the stack remains the same
        assertEquals(3, LinkedListProcedural.getSize());

        // Peek multiple times to confirm behavior
        assertEquals(30, LinkedListStackProcedural.peek());
    }

    @Test
    void testDisplay() {
        LinkedListStackProcedural.push(10);
        LinkedListStackProcedural.push(20);
        LinkedListStackProcedural.push(30);

        // Display the stack for manual verification
        LinkedListStackProcedural.display(); // Expected output: "10 -> 20 -> 30 -> null"

        // Edge case: display an empty stack
        LinkedListProcedural.clear();
        LinkedListStackProcedural.display(); // Expected output: "The list is empty."
    }

    @Test
    void testEdgeCases() {
        // Pop from an empty stack
        assertThrows(IllegalStateException.class, LinkedListStackProcedural::pop);

        // Peek into an empty stack
        assertThrows(IllegalStateException.class, LinkedListStackProcedural::peek);

        // Add and remove a single element
        LinkedListStackProcedural.push(10);
        assertEquals(10, LinkedListStackProcedural.pop());
        assertEquals(0, LinkedListProcedural.getSize());
        assertThrows(IllegalStateException.class, LinkedListStackProcedural::pop);

        // Verify stack behaves as LIFO
        LinkedListStackProcedural.push(1);
        LinkedListStackProcedural.push(2);
        LinkedListStackProcedural.push(3);
        assertEquals(3, LinkedListStackProcedural.pop());
        assertEquals(2, LinkedListStackProcedural.pop());
        assertEquals(1, LinkedListStackProcedural.pop());
    }
}