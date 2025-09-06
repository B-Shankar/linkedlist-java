package linkedlist.questions;

//25. Reverse Nodes in k-Group
public class ReverseKGroups {

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

    public static void main(String[] args) {
        ReverseKGroups list = new ReverseKGroups();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(5);

        System.out.println("Original List:");
        list.display();

        int k = 7; // Example group size
        list.head = list.reverseKGroup(list.head, k); // must update head

        System.out.println("List after reversing in groups of " + k + ":");
        list.display();
    }

    private ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;

        // Step 1: check if there are at least k nodes left
        ListNode node = head;
        int count = 0;
        while (node != null && count < k) {
            node = node.next;
            count++;
        }
        if (count < k) return head; // not enough nodes, return as is

        // Step 2: reverse exactly k nodes
        ListNode prev = null;
        ListNode curr = head;
        for (int i = 0; i < k; i++) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: connect with next reversed groups
        head.next = reverseKGroup(curr, k);

        // prev is the new head of this reversed group
        return prev;
    }
}
