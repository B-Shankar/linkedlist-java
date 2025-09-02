package linkedlist.questions;

//206. Reverse Linked List
public class ReverseLinkedListLeetcode {

    private ListNode head;

    // Insert at last without tail
    public void insertAtLast(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    // Definition for singly-linked list (same as LeetCode)
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ReverseLinkedListLeetcode list = new ReverseLinkedListLeetcode();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);

        System.out.println("Original List:");
        list.display();

        list.head = list.reverseList(list.head); // must update head

        System.out.println("Reversed List:");
        list.display();
    }

    // Iterative reversal (standard LeetCode solution)
    private ListNode reverseList(ListNode node) {
        if (node == null) return node;

        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next; // save next
            curr.next = prev;          // reverse pointer
            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head
    }
}
