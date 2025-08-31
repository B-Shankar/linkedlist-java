package linkedlist.questions;

//148. Sort List
public class SortList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        // find mid
        ListNode mid = getMid(head);

        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left, right);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                tail = tail.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
                tail = tail.next;
            }
        }

        if (list1 != null)
            tail.next = list1;

        if (list2 != null)
            tail.next = list2;

        return dummy.next;
    }

    private ListNode getMid(ListNode head) {
        ListNode midPrev = null;

        while (head != null && head.next != null) {
            midPrev = (midPrev == null) ? head : midPrev.next;
            head = head.next.next;
        }

        ListNode mid = midPrev.next;
        midPrev.next = null; // split the list into two halves
        return mid;
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
        SortList sorter = new SortList();

        // Example 1: Standard unsorted list [4,2,1,3]
        System.out.println("=== Example 1: Standard Case ===");
        ListNode head1 = createList(new int[]{4, 2, 1, 3});

        System.out.print("Original:  ");
        printList(head1);

        ListNode sorted1 = sorter.sortList(head1);
        System.out.print("Sorted:    ");
        printList(sorted1);

        // Example 2: List with negative numbers [-1,5,3,4,0]
        System.out.println("\n=== Example 2: With Negatives ===");
        ListNode head2 = createList(new int[]{-1, 5, 3, 4, 0});

        System.out.print("Original:  ");
        printList(head2);

        ListNode sorted2 = sorter.sortList(head2);
        System.out.print("Sorted:    ");
        printList(sorted2);

        // Example 3: Empty list
        System.out.println("\n=== Example 3: Empty List ===");
        ListNode head3 = null;

        System.out.print("Original:  ");
        printList(head3);

        ListNode sorted3 = sorter.sortList(head3);
        System.out.print("Sorted:    ");
        printList(sorted3);

        // Example 4: Single element [1]
        System.out.println("\n=== Example 4: Single Element ===");
        ListNode head4 = createList(new int[]{1});

        System.out.print("Original:  ");
        printList(head4);

        ListNode sorted4 = sorter.sortList(head4);
        System.out.print("Sorted:    ");
        printList(sorted4);

        // Example 5: Already sorted [1,2,3,4,5]
        System.out.println("\n=== Example 5: Already Sorted ===");
        ListNode head5 = createList(new int[]{1, 2, 3, 4, 5});

        System.out.print("Original:  ");
        printList(head5);

        ListNode sorted5 = sorter.sortList(head5);
        System.out.print("Sorted:    ");
        printList(sorted5);

        // Example 6: Reverse sorted [5,4,3,2,1]
        System.out.println("\n=== Example 6: Reverse Sorted ===");
        ListNode head6 = createList(new int[]{5, 4, 3, 2, 1});

        System.out.print("Original:  ");
        printList(head6);

        ListNode sorted6 = sorter.sortList(head6);
        System.out.print("Sorted:    ");
        printList(sorted6);

        // Example 7: With duplicates [3,1,4,1,5,9,2,6,5]
        System.out.println("\n=== Example 7: With Duplicates ===");
        ListNode head7 = createList(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5});

        System.out.print("Original:  ");
        printList(head7);

        ListNode sorted7 = sorter.sortList(head7);
        System.out.print("Sorted:    ");
        printList(sorted7);

        // Example 8: Two elements [2,1]
        System.out.println("\n=== Example 8: Two Elements ===");
        ListNode head8 = createList(new int[]{2, 1});

        System.out.print("Original:  ");
        printList(head8);

        ListNode sorted8 = sorter.sortList(head8);
        System.out.print("Sorted:    ");
        printList(sorted8);
    }
}
