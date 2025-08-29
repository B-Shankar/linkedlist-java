package linkedlist.questions;

public class LinkedListCycleII {

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

    public ListNode detectCycle(ListNode head) {
        int length = 0;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;          // move 1 step
            fast = fast.next.next;     // move 2 steps

            if (slow == fast) {
                length = cycleLength(slow);
                break;
            }
        }

        if (length == 0)
            return null;

        //find the start node

        ListNode s = head;
        ListNode f = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        //keep moving both forward and they will meet at start of cycle
        while (f != s) {
            f = f.next;
            s = s.next;
        }

        return s;
    }

}

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        LinkedListCycleII solution = new LinkedListCycleII();

        // Example 1: List with cycle [3,2,0,-4] where tail connects to node index 1
        System.out.println("=== Example 1: Cycle exists ===");
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4 -> (back to 2)
        head1.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2;  // Creates a cycle pointing back to node2

        ListNode cycleStart1 = solution.detectCycle(head1);
        if (cycleStart1 != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart1.val);
            System.out.println("Cycle length: " + solution.cycleLength(head1));
        } else {
            System.out.println("No cycle detected");
        }

        // Example 2: List with cycle [1,2] where tail connects to node index 0
        System.out.println("\n=== Example 2: Cycle exists ===");
        ListNode head2 = new ListNode(1);
        ListNode node2_2 = new ListNode(2);

        head2.next = node2_2;
        node2_2.next = head2;  // Creates a cycle pointing back to head2

        ListNode cycleStart2 = solution.detectCycle(head2);
        if (cycleStart2 != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart2.val);
            System.out.println("Cycle length: " + solution.cycleLength(head2));
        } else {
            System.out.println("No cycle detected");
        }

        // Example 3: List without cycle [1]
        System.out.println("\n=== Example 3: No cycle ===");
        ListNode head3 = new ListNode(1);

        ListNode cycleStart3 = solution.detectCycle(head3);
        if (cycleStart3 != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart3.val);
            System.out.println("Cycle length: " + solution.cycleLength(head3));
        } else {
            System.out.println("No cycle detected");
        }

        // Example 4: Empty list
        System.out.println("\n=== Example 4: Empty list ===");
        ListNode cycleStart4 = solution.detectCycle(null);
        if (cycleStart4 != null) {
            System.out.println("Cycle detected at node with value: " + cycleStart4.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
