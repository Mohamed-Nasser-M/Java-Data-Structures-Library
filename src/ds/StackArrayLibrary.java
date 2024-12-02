package ds;

public class StackArrayLibrary {
    private ArrayLibrary arrayLib;

    public StackArrayLibrary(int capacity) {
        arrayLib = new ArrayLibrary(capacity);
    }

    public boolean push(int element) {
        return arrayLib.add(element);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int topElement = arrayLib.search(arrayLib.getSize() - 1);
        arrayLib.delete(arrayLib.getSize() - 1);
        return topElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
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
