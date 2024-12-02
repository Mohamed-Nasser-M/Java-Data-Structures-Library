package ds;

public class ArrayLibrary {
    private int[] array;
    private int size;

    public ArrayLibrary(int capacity) {
        this.array = new int[capacity];
        this.size = 0;
    }

    public boolean add(int element) {
        if (size == array.length) {
            System.out.println("Array is full, cannot add element.");
            return false;
        }
        array[size] = element;
        size++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Deletion failed.");
            return false;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return true;
    }

    public boolean update(int index, int newValue) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index. Update failed.");
            return false;
        }
        array[index] = newValue;
        return true;
    }

    public int search(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return -1;
        }
        return array[index];
    }

    public void display() {
        if (size == 0) {
            System.out.println("Array is empty.");
            return;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return array.length;
    }
}
