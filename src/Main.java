import linkedlist.circular.CircularLinkedList;
import linkedlist.doubly.DoublyLinkedList;
import linkedlist.singly.LinkedListImpl;

public class Main {

    public static void main(String[] args) {
//        singlyLL();

//        doublyLL();

//        circularLL();

        singlyLLRecursion();
    }

    public static void singlyLL() {
        LinkedListImpl linkedList = new LinkedListImpl();

        linkedList.insertAtFirst(60);
        linkedList.insertAtFirst(50);
        linkedList.insertAtFirst(40);
        linkedList.insertAtFirst(30);
        linkedList.insertAtFirst(10);

        linkedList.insertAtLast(70);

        linkedList.insertAtIndex(200, 1);

        linkedList.display();

        System.out.println("Value Removed first: " + linkedList.deleteFirst());

        linkedList.display();

        System.out.println("Value Removed last: " + linkedList.deleteLast());

        linkedList.display();

        System.out.println("Value Removed at index 2: " + linkedList.delete(2));

        linkedList.display();

        linkedList.insertRecursion(88, 3);

        linkedList.display();
    }

    public static void singlyLLRecursion() {
        LinkedListImpl linkedList = new LinkedListImpl();
        linkedList.insertAtFirst(5);
        linkedList.insertAtFirst(2);
        linkedList.insertAtFirst(9);
        linkedList.insertAtFirst(7);

        linkedList.display();

        linkedList.insertRecursion(21, 2);

        linkedList.display();
    }

    public static void doublyLL() {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.insertFirst(40);
        doublyLinkedList.insertFirst(30);
        doublyLinkedList.insertFirst(20);
        doublyLinkedList.insertFirst(10);

        doublyLinkedList.display();

        doublyLinkedList.insertLast(50);

        doublyLinkedList.display();

        doublyLinkedList.insertAtIndex(1, 2);

        doublyLinkedList.display();

        doublyLinkedList.insertAfter(50, 60);

        doublyLinkedList.display();
    }

    public static void circularLL() {
        CircularLinkedList circularLinkedList = new CircularLinkedList();

        circularLinkedList.insert(10);
        circularLinkedList.insert(20);
        circularLinkedList.insert(30);

        circularLinkedList.display();

        circularLinkedList.delete(20);

        circularLinkedList.display();
    }
}
