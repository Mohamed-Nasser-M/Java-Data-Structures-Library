package ds;

public class DequeArrayLibrary {
    private ArrayLibrary arrayLib;

    public DequeArrayLibrary(int capacity) {
        arrayLib = new ArrayLibrary(capacity);
    }

    public boolean addFront(int element) {
        if (isFull()) {
            System.out.println("Deque is full. Cannot add to front.");
            return false;
        }
        for (int i = arrayLib.getSize(); i > 0; i--) {
            arrayLib.update(i, arrayLib.search(i - 1));
        }
        arrayLib.update(0, element);
        return true;
    }

    public boolean addRear(int element) {
        return arrayLib.add(element);
    }

    public int removeFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from front.");
            return -1;
        }
        int frontElement = arrayLib.search(0);
        arrayLib.delete(0);
        return frontElement;
    }

    public int removeRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty. Cannot remove from rear.");
            return -1;
        }
        int rearElement = arrayLib.search(arrayLib.getSize() - 1);
        arrayLib.delete(arrayLib.getSize() - 1);
        return rearElement;
    }

    public int peekFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return arrayLib.search(0);
    }

    public int peekRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty.");
            return -1;
        }
        return arrayLib.search(arrayLib.getSize() - 1);
    }

    public boolean isEmpty() {
        return arrayLib.getSize() == 0;
    }

    public boolean isFull() {
        return arrayLib.getSize() == arrayLib.getCapacity();
    }
}