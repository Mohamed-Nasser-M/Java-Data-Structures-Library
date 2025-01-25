package ds;

public class LinkedListProcedural {

    // Node class representing each element in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head and Tail of the Linked List
    static Node head = null;
    static Node tail = null; // Added a tail reference for efficiency

    // Size of the Linked List
    static int size = 0;

    // Add a new node to the end of the list
    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode; // If the list is empty, set both head and tail
        } else {
            tail.next = newNode; // Add the new node after tail
            tail = newNode; // Update the tail
        }
        size++;
    }

    // Remove a node by value
    public static boolean delete(int value) {
        if (head == null) {
            return false; // List is empty
        }

        if (head.data == value) {
            head = head.next; // Remove the head node
            if (head == null) { // If the list becomes empty
                tail = null;
            }
            size--;
            return true;
        }

        Node temp = head;
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next; // Traverse to find the node
        }

        if (temp.next == null) {
            return false; // Value not found
        }

        temp.next = temp.next.next; // Remove the node
        if (temp.next == null) { // If the removed node was the tail
            tail = temp;
        }
        size--;
        return true;
    }

    // Search for a value in the list
    public static boolean search(int value) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                return true; // Value found
            }
            temp = temp.next;
        }
        return false; // Value not found
    }

    // Display all the elements in the list
    public static void display() {
        Node temp = head;
        if (temp == null) {
            System.out.println("The list is empty.");
            return;
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Get the size of the list
    public static int getSize() {
        return size;
    }

    // Clear the list
    public static void clear() {
        head = tail = null;
        size = 0;
    }
}