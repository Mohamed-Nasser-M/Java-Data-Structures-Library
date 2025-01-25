package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayLibraryTest {

    private StackArrayLibrary stack;

    @BeforeEach
    void setUp() {
        stack = new StackArrayLibrary(5); // Initialize stack with a capacity of 5
    }

    @Test
    void testPush() {
        assertTrue(stack.push(10)); // Push elements onto the stack
        assertTrue(stack.push(20));
        assertTrue(stack.push(30));

        assertEquals(30, stack.peek()); // Verify top element
        assertFalse(stack.isFull());

        stack.push(40);
        stack.push(50);
        assertTrue(stack.isFull()); // Stack should now be full

        assertFalse(stack.push(60)); // Pushing onto a full stack should fail
    }

    @Test
    void testPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop()); // Pop elements and verify the order
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        assertTrue(stack.isEmpty()); // Stack should now be empty
        assertEquals(-1, stack.pop()); // Popping from an empty stack should return -1
    }

    @Test
    void testPeek() {
        assertEquals(-1, stack.peek()); // Peeking on an empty stack should return -1

        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.peek()); // Verify the top element without removal

        stack.pop();
        assertEquals(10, stack.peek()); // Top element should update after popping
    }

    @Test
    void testIsEmpty() {
        assertTrue(stack.isEmpty()); // Stack should be empty initially

        stack.push(10);
        assertFalse(stack.isEmpty()); // Stack is no longer empty after pushing an element

        stack.pop();
        assertTrue(stack.isEmpty()); // Stack should be empty after popping all elements
    }

    @Test
    void testIsFull() {
        assertFalse(stack.isFull()); // Stack should not be full initially

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50); // Push elements to fill the stack

        assertTrue(stack.isFull()); // Stack should now be full

        stack.pop();
        assertFalse(stack.isFull()); // Stack should no longer be full after popping an element
    }

    @Test
    void testMixedOperations() {
        stack.push(10); // Push elements onto the stack
        stack.push(20);
        stack.push(30);

        assertEquals(30, stack.pop()); // Pop the top element
        assertEquals(20, stack.peek()); // Peek at the top element

        stack.push(40); // Push a new element
        assertEquals(40, stack.peek()); // Verify the new top element

        stack.pop();
        stack.pop();
        assertEquals(10, stack.pop()); // Pop all elements

        assertTrue(stack.isEmpty()); // Stack should be empty now
    }
}