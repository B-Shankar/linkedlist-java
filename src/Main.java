import linkedlist.LinkedListImpl;

public class Main {

    public static void main(String[] args) {

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
        
    }
}
