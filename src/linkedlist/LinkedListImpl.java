package linkedlist;

public class LinkedListImpl {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListImpl() {
        this.size = 0;
    }

    public void insertAtFirst (int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;

        if(tail == null) {
            tail = head;
        }

        size += 1;
    }

    public void insertAtLast (int value) {
        if (tail == null) {
            insertAtFirst(value);
            return;
        }

        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size += 1;
    }

    public void display () {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public void insertAtIndex (int value, int index) {
        if (index == 0) {
            insertAtFirst(value);
            return;
        }

        if (index == size) {
            insertAtLast(value);
            return;
        }

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node temp = head; //index 0
        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        Node node = new Node(value, temp.next);
        temp.next = node;
        size += 1;
    }

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
