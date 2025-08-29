package linkedlist.questions;

//21. Merge Two Sorted Lists
public class Merge2SortedLists {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
        Solution solution = new Solution();

        // Example 1: Standard merge
        System.out.println("=== Example 1: Standard Merge ===");
        ListNode list1 = createList(new int[]{1, 2, 4});
        ListNode list2 = createList(new int[]{1, 3, 4});

        System.out.print("List 1: ");
        printList(list1);
        System.out.print("List 2: ");
        printList(list2);

        ListNode merged1 = solution.mergeTwoLists(list1, list2);
        System.out.print("Merged: ");
        printList(merged1);

        // Example 2: Empty lists
        System.out.println("\n=== Example 2: Empty Lists ===");
        ListNode list3 = null;
        ListNode list4 = null;

        System.out.print("List 1: ");
        printList(list3);
        System.out.print("List 2: ");
        printList(list4);

        ListNode merged2 = solution.mergeTwoLists(list3, list4);
        System.out.print("Merged: ");
        printList(merged2);

        // Example 3: One empty list
        System.out.println("\n=== Example 3: One Empty List ===");
        ListNode list5 = null;
        ListNode list6 = createList(new int[]{0});

        System.out.print("List 1: ");
        printList(list5);
        System.out.print("List 2: ");
        printList(list6);

        ListNode merged3 = solution.mergeTwoLists(list5, list6);
        System.out.print("Merged: ");
        printList(merged3);

        // Example 4: Different lengths
        System.out.println("\n=== Example 4: Different Lengths ===");
        ListNode list7 = createList(new int[]{1, 3, 5, 7, 9});
        ListNode list8 = createList(new int[]{2, 4});

        System.out.print("List 1: ");
        printList(list7);
        System.out.print("List 2: ");
        printList(list8);

        ListNode merged4 = solution.mergeTwoLists(list7, list8);
        System.out.print("Merged: ");
        printList(merged4);

        // Example 5: Same values
        System.out.println("\n=== Example 5: Same Values ===");
        ListNode list9 = createList(new int[]{1, 1, 2});
        ListNode list10 = createList(new int[]{1, 2, 2});

        System.out.print("List 1: ");
        printList(list9);
        System.out.print("List 2: ");
        printList(list10);

        ListNode merged5 = solution.mergeTwoLists(list9, list10);
        System.out.print("Merged: ");
        printList(merged5);

        // Example 6: Single nodes
        System.out.println("\n=== Example 6: Single Nodes ===");
        ListNode list11 = createList(new int[]{-9});
        ListNode list12 = createList(new int[]{5});

        System.out.print("List 1: ");
        printList(list11);
        System.out.print("List 2: ");
        printList(list12);

        ListNode merged6 = solution.mergeTwoLists(list11, list12);
        System.out.print("Merged: ");
        printList(merged6);
    }
}
