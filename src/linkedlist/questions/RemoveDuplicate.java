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

    // Helper: print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Helper: create list from array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: Standard case with duplicates [1,1,2]
        System.out.println("=== Example 1: Standard Case ===");
        ListNode head1 = createList(new int[]{1, 1, 2});

        System.out.print("Original:  ");
        printList(head1);

        ListNode result1 = solution.deleteDuplicates(head1);
        System.out.print("After:     ");
        printList(result1);

        // Example 2: Multiple duplicates [1,1,2,3,3]
        System.out.println("\n=== Example 2: Multiple Duplicates ===");
        ListNode head2 = createList(new int[]{1, 1, 2, 3, 3});

        System.out.print("Original:  ");
        printList(head2);

        ListNode result2 = solution.deleteDuplicates(head2);
        System.out.print("After:     ");
        printList(result2);

        // Example 3: All same values [1,1,1,1,1]
        System.out.println("\n=== Example 3: All Same Values ===");
        ListNode head3 = createList(new int[]{1, 1, 1, 1, 1});

        System.out.print("Original:  ");
        printList(head3);

        ListNode result3 = solution.deleteDuplicates(head3);
        System.out.print("After:     ");
        printList(result3);

        // Example 4: No duplicates [1,2,3,4,5]
        System.out.println("\n=== Example 4: No Duplicates ===");
        ListNode head4 = createList(new int[]{1, 2, 3, 4, 5});

        System.out.print("Original:  ");
        printList(head4);

        ListNode result4 = solution.deleteDuplicates(head4);
        System.out.print("After:     ");
        printList(result4);

        // Example 5: Single node [1]
        System.out.println("\n=== Example 5: Single Node ===");
        ListNode head5 = createList(new int[]{1});

        System.out.print("Original:  ");
        printList(head5);

        ListNode result5 = solution.deleteDuplicates(head5);
        System.out.print("After:     ");
        printList(result5);

        // Example 6: Empty list
        System.out.println("\n=== Example 6: Empty List ===");
        ListNode head6 = null;

        System.out.print("Original:  ");
        printList(head6);

        ListNode result6 = solution.deleteDuplicates(head6);
        System.out.print("After:     ");
        printList(result6);

        // Example 7: Consecutive groups [1,1,2,2,3,3]
        System.out.println("\n=== Example 7: Consecutive Groups ===");
        ListNode head7 = createList(new int[]{1, 1, 2, 2, 3, 3});

        System.out.print("Original:  ");
        printList(head7);

        ListNode result7 = solution.deleteDuplicates(head7);
        System.out.print("After:     ");
        printList(result7);

        // Example 8: Long consecutive duplicates [0,0,0,1,1,2,3,3,3,3]
        System.out.println("\n=== Example 8: Long Consecutive Duplicates ===");
        ListNode head8 = createList(new int[]{0, 0, 0, 1, 1, 2, 3, 3, 3, 3});

        System.out.print("Original:  ");
        printList(head8);

        ListNode result8 = solution.deleteDuplicates(head8);
        System.out.print("After:     ");
        printList(result8);
    }
}
