package ds;

public class QueueArrayLibrary {
    private ArrayLibrary arrayLib;

    public QueueArrayLibrary(int capacity) {
        arrayLib = new ArrayLibrary(capacity);
    }

    public boolean enqueue(int element) {
        return arrayLib.add(element);
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int frontElement = arrayLib.search(0);
        arrayLib.delete(0);
        return frontElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        return arrayLib.search(0);
    }

    public boolean isEmpty() {
        return arrayLib.getSize() == 0;
    }

    public boolean isFull() {
        return arrayLib.getSize() == arrayLib.getCapacity();
    }
}
