package linkedlist.questions;

//83. Remove Duplicates from Sorted List
public class RemoveDuplicate {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Helper: build linked list from array
    public static ListNode buildList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper: print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode node = head;

            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    node = node.next;
                }
            }
            return head;
        }

    }

    public static void main(String[] args) {
        // Example input
        int[] values = {1, 1, 2, 3, 3};

        // Build list
        ListNode head = buildList(values);

        System.out.print("Original List: ");
        printList(head);

        // Apply solution
        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(result);
    }

}
