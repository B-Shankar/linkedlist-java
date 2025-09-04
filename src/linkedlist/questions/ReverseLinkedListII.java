package linkedlist.questions;

//206. Reverse Linked List
public class ReverseLinkedListII {

    private ListNode head;
    private ListNode tail;
    private int size;

    private ReverseLinkedListII() {
        this.size = 0;
    }

    public void insertAtLast(int value) {
        ListNode ListNode = new ListNode(value);
        if (head == null) {
            head = tail = ListNode;
        } else {
            tail.next = ListNode;
            tail = ListNode;
        }
        size++;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        ReverseLinkedListII list = new ReverseLinkedListII();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);

        System.out.println("Original List:");
        list.display();

        int right = 4;
        int left = 2;
        list.reverseBetween(list.head, left, right); // no return, just updates list internally

        System.out.println("Reversed List:");
        list.display();
    }

    private ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;

        ListNode pres = head;
        ListNode prev = null;

        for (int i = 0; pres != null && i < left - 1; i++) {
            prev = pres;
            pres = pres.next;
        }

        ListNode last = prev;
        ListNode newEnd = pres;
        ListNode next = pres.next;

        for (int i = 0; pres != null && i < right - left + 1; i++) {
            pres.next  = prev;
            prev = pres;
            pres = next;
            if (next != null) {
                next = next.next;
            }
        }

        if (last != null) {
            last.next = prev;
        } else {
            head = prev;
        }

        newEnd.next = pres;
        return head;
    }
}
