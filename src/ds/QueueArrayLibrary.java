package ds;

public class QueueArrayLibrary {
    private int[] array;
    private int front; // Index of the front element
    private int rear;  // Index where the next element will be added
    private int size;  // Current number of elements in the queue
    private int capacity; // Maximum capacity of the queue

    public QueueArrayLibrary(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    // Enqueue operation: Add an element to the queue
    public boolean enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return false;
        }
        // Move rear pointer in a circular manner
        rear = (rear + 1) % capacity;
        array[rear] = element;
        size++;
        return true;
    }

    // Dequeue operation: Remove and return the front element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int frontElement = array[front];
        // Move front pointer in a circular manner
        front = (front + 1) % capacity;
        size--;
        return frontElement;
    }

    // Peek operation: Return the front element without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return array[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }
}