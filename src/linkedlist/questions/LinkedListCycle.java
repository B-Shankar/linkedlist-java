package linkedlist.questions;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) { this.val = val; }

        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static public class Solution {

        public boolean hasCycle(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;          // move 1 step
                fast = fast.next.next;     // move 2 steps

                if (slow == fast) {
                    return true;           // cycle detected
                }
            }
            return false;                  // reached end, no cycle
        }

        public int cycleLength(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;          // move 1 step
                fast = fast.next.next;     // move 2 steps

                if (slow == fast) {
                    ListNode temp = slow;
                    int length = 0;
                    do {
                        temp = temp.next;
                        length++;
                    } while (temp != slow);
                    return length;           // cycle detected
                }
            }
            return 0;                  // reached end, no cycle
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example 1: List with cycle [3,2,0,-4] where tail connects to node index 1
        System.out.println("=== Example 1: List with Cycle ===");
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode nodeNeg4 = new ListNode(-4);

        // Create cycle: 3 -> 2 -> 0 -> -4 -> (back to 2)
        head1.next = node2;
        node2.next = node0;
        node0.next = nodeNeg4;
        nodeNeg4.next = node2;  // Creates cycle

        System.out.println("Has cycle: " + solution.hasCycle(head1));
        System.out.println("Cycle length: " + solution.cycleLength(head1));

        // Example 2: List with cycle [1,2] where tail connects to node index 0
        System.out.println("\n=== Example 2: Simple Cycle ===");
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);

        head2.next = node2_2;
        node2_2.next = head2;  // Creates cycle back to head

        System.out.println("Has cycle: " + solution.hasCycle(head2));
        System.out.println("Cycle length: " + solution.cycleLength(head2));

        // Example 3: List without cycle [1,2,3,4,5]
        System.out.println("\n=== Example 3: No Cycle ===");
        ListNode head3 = new ListNode(1);
        ListNode node2_3 = new ListNode(2);
        ListNode node3_3 = new ListNode(3);
        ListNode node4_3 = new ListNode(4);
        ListNode node5_3 = new ListNode(5);

        head3.next = node2_3;
        node2_3.next = node3_3;
        node3_3.next = node4_3;
        node4_3.next = node5_3;
        // node5_3.next = null (no cycle)

        System.out.println("Has cycle: " + solution.hasCycle(head3));
        System.out.println("Cycle length: " + solution.cycleLength(head3));

        // Example 4: Single node without cycle
        System.out.println("\n=== Example 4: Single Node ===");
        ListNode head4 = new ListNode(1);

        System.out.println("Has cycle: " + solution.hasCycle(head4));
        System.out.println("Cycle length: " + solution.cycleLength(head4));

        // Example 5: Single node with self-cycle
        System.out.println("\n=== Example 5: Self Cycle ===");
        ListNode head5 = new ListNode(1);
        head5.next = head5;  // Points to itself

        System.out.println("Has cycle: " + solution.hasCycle(head5));
        System.out.println("Cycle length: " + solution.cycleLength(head5));

        // Example 6: Empty list
        System.out.println("\n=== Example 6: Empty List ===");
        System.out.println("Has cycle: " + solution.hasCycle(null));
        System.out.println("Cycle length: " + solution.cycleLength(null));
    }
}
