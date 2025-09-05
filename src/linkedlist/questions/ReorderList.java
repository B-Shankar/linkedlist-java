package linkedlist.questions;

public class ReorderList {
    private ListNode head;

    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Insert at last (traverse each time)
    public void insertAtLast(int value) {
        ListNode node = new ListNode(value);
        if (head == null) {
            head = node;
            return;
        }
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed list
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle node
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode headFirst = head;

        while (headFirst != null && headSecond != null) {
            ListNode temp1 = headFirst.next;
            ListNode temp2 = headSecond.next;

            headFirst.next = headSecond;
            if (temp1 == null) break; // to avoid cycle in odd length lists
            headSecond.next = temp1;

            headFirst = temp1;
            headSecond = temp2;
        }

        if (headFirst != null) {
            headFirst.next = null; // terminate the list
        }
    }

    public static void main(String[] args) {
        ReorderList list = new ReorderList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);
        list.insertAtLast(6);
        list.insertAtLast(7);

        list.display();
        list.reorderList(list.head);
        list.display();
    }
}
