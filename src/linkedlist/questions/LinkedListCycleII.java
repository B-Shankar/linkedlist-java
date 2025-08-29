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