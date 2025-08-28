package linkedlist.questions;

//83. Remove Duplicates from Sorted List
public class Merge2SortedLists {

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
            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
                // Dummy node to simplify handling
                ListNode dummy = new ListNode(-1);
                ListNode current = dummy;

                // Traverse both lists
                while (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        current.next = list1;
                        list1 = list1.next;
                    } else {
                        current.next = list2;
                        list2 = list2.next;
                    }
                    current = current.next;
                }

                // Attach the remaining part (one of them will be null)
                if (list1 != null) {
                    current.next = list1;
                } else {
                    current.next = list2;
                }

                return dummy.next; // skip dummy head
            }
        }

    public static void main(String[] args) {
        // Example input
        int[] values = {1, 1, 2, 3, 3};
        int[] values1 = {1, 2, 3, 4, 8};

        // Build list
        ListNode first = buildList(values);
        ListNode second = buildList(values1);

        // Apply solution
        Solution sol = new Solution();
        ListNode result = sol.mergeTwoLists(first, second);

        System.out.print("After Removing Duplicates: ");
        printList(result);
    }

}
