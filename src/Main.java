import linkedlist.LinkedListImpl;

public class Main {

    public static void main(String[] args) {

        LinkedListImpl linkedList = new LinkedListImpl();

        linkedList.insertAtFirst(10);
        linkedList.insertAtFirst(20);
        linkedList.insertAtFirst(30);
        linkedList.insertAtFirst(40);
        linkedList.insertAtFirst(50);

        linkedList.insertAtLast(60);

        linkedList.insertAtIndex(100, 2);

        linkedList.display();

    }
}
