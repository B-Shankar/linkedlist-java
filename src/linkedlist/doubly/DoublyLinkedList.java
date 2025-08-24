package linkedlist.doubly;

public class DoublyLinkedList {

    private Node head;

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int value) {
        Node node = new Node(value);
        Node last = head;

        node.next = null;

        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = node;
        node.prev = last;
    }

    public void insertAtIndex(int value, int index) {
        if (index == 0) {
            insertFirst(value);
            return;
        }

        Node temp = head;
        int i = 0;

        while (temp != null && i < index - 1) {
            temp = temp.next;
            i++;
        }

        if (temp == null)
            throw new NullPointerException("Index out of bound.");

        Node node = new Node(value);
        node.prev = temp;
        node.next = temp.next;

        if (temp.next != null)
            temp.next.prev = node;

        temp.next = node;
    }

    public void display() {
        Node node = head;
        Node last = null;
        System.out.println("Forward: ");
        while (node != null) {
            System.out.print(node.value + " <=> ");
            last = node;
            node = node.next;
        }
        System.out.println("End");

        System.out.print("Reverse: ");
        while (last != null) {
            System.out.print(last.value + " <=> ");
            last = last.prev;
        }
        System.out.println("Start");
    }

    private class Node {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
