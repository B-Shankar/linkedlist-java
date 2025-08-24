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

    public Node find(int value) {
        Node node = head;

        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insertAfter(int after, int value) {
        Node p = find(after);

        if (p == null) {
            System.out.println("does not exits");
            return;
        }

        Node node = new Node(value);
        node.next = p.next;
        p.next = node;
        node.prev = p;

        if (node.next != null)
            node.next.prev = node;

    }

    public void display() {
        Node node = head;
        Node last = null;
        System.out.print("Forward: ");
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
        System.out.println("Start" + '\n');
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
