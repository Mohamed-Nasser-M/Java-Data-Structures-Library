package ds;

class LinkedListProcedural {

    // Node class representing each element in the linked list
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the Linked List
    static Node head = null;

    // Add a new node to the end of the list
    public static void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the end of the list
            }
            temp.next = newNode; // Add the new node at the end
        }
    }

    // Remove a node by value
    public static boolean delete(int value) {
        if (head == null) {
            return false; // List is empty
        }

        if (head.data == value) {
            head = head.next; // Remove the head node
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
}
