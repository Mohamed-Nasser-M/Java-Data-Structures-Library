import ds.ArrayLibrary;
import ds.StackArrayLibrary;
import ds.QueueArrayLibrary;
import ds.DequeArrayLibrary;

public class Main {
        public static void main(String[] args) {
                System.out.println("=== Testing Array Library ===");
                testArrayLibrary();

                System.out.println("\n=== Testing Stack Library ===");
                testStackLibrary();

                System.out.println("\n=== Testing Queue Library ===");
                testQueueLibrary();

                System.out.println("\n=== Testing Deque Library ===");
                testDequeLibrary();
        }

        public static void testArrayLibrary() {
                ArrayLibrary array = new ArrayLibrary(5);
                array.add(10);
                array.add(20);
                array.add(30);
                System.out.print("After adding elements: ");
                array.display();
                array.update(1, 25);
                System.out.print("After updating index 1 to 25: ");
                array.display();
                array.delete(0);
                System.out.print("After deleting element at index 0: ");
                array.display();
                System.out.println("Element at index 1: " + array.search(1));
                System.out.println("Array capacity: " + array.getCapacity());
                System.out.println("Array size: " + array.getSize());
        }

        public static void testStackLibrary() {
                StackArrayLibrary stack = new StackArrayLibrary(3);
                stack.push(10);
                stack.push(20);
                stack.push(30);
                System.out.println("Pushed 10, 20, 30.");
                System.out.println("Peek: " + stack.peek());
                System.out.println("Popped: " + stack.pop());
                System.out.println("Peek after pop: " + stack.peek());
                System.out.println("Is stack empty? " + stack.isEmpty());
                System.out.println("Is stack full? " + stack.isFull());
                stack.push(40);
                System.out.println("Pushed 40.");
                System.out.println("Peek: " + stack.peek());
        }

        public static void testQueueLibrary() {
                QueueArrayLibrary queue = new QueueArrayLibrary(3);
                queue.enqueue(10);
                queue.enqueue(20);
                queue.enqueue(30);
                System.out.println("Enqueued 10, 20, 30.");
                System.out.println("Peek: " + queue.peek());
                System.out.println("Dequeued: " + queue.dequeue());
                System.out.println("Peek after dequeue: " + queue.peek());
                System.out.println("Is queue empty? " + queue.isEmpty());
                System.out.println("Is queue full? " + queue.isFull());
                queue.enqueue(40);
                System.out.println("Enqueued 40.");
                System.out.println("Peek: " + queue.peek());
        }

        public static void testDequeLibrary() {
                DequeArrayLibrary deque = new DequeArrayLibrary(3);
                deque.addRear(10);
                deque.addRear(20);
                deque.addRear(30);
                System.out.println("Added 10, 20, 30 to the rear.");
                System.out.println("Peek front: " + deque.peekFront());
                System.out.println("Peek rear: " + deque.peekRear());
                deque.removeFront();
                System.out.println("Removed from front.");
                System.out.println("Peek front: " + deque.peekFront());
                deque.addFront(5);
                System.out.println("Added 5 to the front.");
                System.out.println("Peek front: " + deque.peekFront());
                deque.removeRear();
                System.out.println("Removed from rear.");
                System.out.println("Peek rear: " + deque.peekRear());
        }
}
