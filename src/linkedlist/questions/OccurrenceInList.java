package linkedlist.questions;

public class OccurrenceInList {
    private Node head;

    public void insertAtLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public int countOccurrences(int target) {
        return countHelper(head, target);
    }

    private int countHelper(Node node, int target) {
        if (node == null) {
            return 0;
        }
        int count = (node.value == target) ? 1 : 0;
        return count + countHelper(node.next, target);
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        OccurrenceInList list = new OccurrenceInList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(2);
        list.insertAtLast(4);
        list.insertAtLast(2);
        list.insertAtLast(5);

        System.out.println("List:");
        list.display();

        int target = 2;
        int occurrences = list.countOccurrences(target);
        System.out.println("Occurrences of " + target + ": " + occurrences);
    }
}
