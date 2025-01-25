package ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayLibraryTest {

    private ArrayLibrary arrayLibrary;

    @BeforeEach
    void setUp() {
        arrayLibrary = new ArrayLibrary(5); // Initialize with a capacity of 5
    }

    @Test
    void testAdd() {
        assertTrue(arrayLibrary.add(10)); // Add elements successfully
        assertTrue(arrayLibrary.add(20));
        assertTrue(arrayLibrary.add(30));
        assertEquals(3, arrayLibrary.getSize());

        // Fill the array to capacity
        arrayLibrary.add(40);
        arrayLibrary.add(50);
        assertFalse(arrayLibrary.add(60)); // Adding beyond capacity should fail
        assertEquals(5, arrayLibrary.getSize());
    }

    @Test
    void testDelete() {
        arrayLibrary.add(10);
        arrayLibrary.add(20);
        arrayLibrary.add(30);

        assertTrue(arrayLibrary.delete(1)); // Delete element at index 1
        assertEquals(2, arrayLibrary.getSize());
        assertEquals(30, arrayLibrary.search(1)); // Index 1 should now have the value 30

        assertFalse(arrayLibrary.delete(5)); // Invalid index
        assertFalse(arrayLibrary.delete(-1)); // Negative index

        // Delete all elements
        arrayLibrary.delete(0);
        arrayLibrary.delete(0);
        assertEquals(0, arrayLibrary.getSize());
        assertFalse(arrayLibrary.delete(0)); // Deleting from empty array
    }

    @Test
    void testUpdate() {
        arrayLibrary.add(10);
        arrayLibrary.add(20);
        arrayLibrary.add(30);

        assertTrue(arrayLibrary.update(1, 25)); // Update element at index 1
        assertEquals(25, arrayLibrary.search(1));

        assertFalse(arrayLibrary.update(5, 40)); // Invalid index
        assertFalse(arrayLibrary.update(-1, 50)); // Negative index
    }

    @Test
    void testSearch() {
        arrayLibrary.add(10);
        arrayLibrary.add(20);
        arrayLibrary.add(30);

        assertEquals(20, arrayLibrary.search(1)); // Search for element at index 1
        assertEquals(-1, arrayLibrary.search(5)); // Invalid index
        assertEquals(-1, arrayLibrary.search(-1)); // Negative index
    }

    @Test
    void testDisplay() {
        // Test display with elements
        arrayLibrary.add(10);
        arrayLibrary.add(20);
        arrayLibrary.add(30);
        System.out.print("Array contents: ");
        arrayLibrary.display(); // Expected output: "10 20 30"

        // Test display with an empty array
        arrayLibrary = new ArrayLibrary(5); // Reinitialize for an empty array
        System.out.print("Array contents: ");
        arrayLibrary.display(); // Expected output: "Array is empty."
    }

    @Test
    void testGetSize() {
        assertEquals(0, arrayLibrary.getSize()); // Initially empty
        arrayLibrary.add(10);
        arrayLibrary.add(20);
        assertEquals(2, arrayLibrary.getSize());
    }

    @Test
    void testGetCapacity() {
        assertEquals(5, arrayLibrary.getCapacity()); // Capacity should match initialization
    }
}