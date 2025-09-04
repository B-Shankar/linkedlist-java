package linkedlist.questions;

public class SplitOddEvenList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode[] splitOddEven(ListNode head) {
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-1);
        ListNode odd = oddDummy, even = evenDummy;

        while (head != null) {
            if (head.val % 2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
        }

        // terminate lists
        even.next = null;
        odd.next = null;

        return new ListNode[]{oddDummy.next, evenDummy.next};
    }

    // helper to display a list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        // build linked list 1->2->3...->10
        ListNode head = new ListNode(1);
        ListNode curr = head;
        for (int i = 2; i <= 10; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }

        ListNode[] res = splitOddEven(head);

        System.out.println("Odd List:");
        printList(res[0]);

        System.out.println("Even List:");
        printList(res[1]);
    }
}
