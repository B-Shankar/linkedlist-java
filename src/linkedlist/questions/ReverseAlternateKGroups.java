package linkedlist.questions;

//25. Reverse Alternate k-Group
public class ReverseAlternateKGroups {

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
        ReverseAlternateKGroups list = new ReverseAlternateKGroups();
        for (int i = 1; i <= 10; i++) list.insertAtLast(i);

        System.out.println("Original List:");
        list.display();

        int k = 3;
        list.head = list.reverseAlternateKGroup(list.head, k, true);

        System.out.println("List after reversing alternate groups of " + k + ":");
        list.display();
    }

    private ListNode reverseAlternateKGroup(ListNode head, int k, boolean shouldReverse) {
        if (head == null) return null;

        ListNode curr = head;
        ListNode prev = null;
        int count = 0;

        if (shouldReverse) {
            // Reverse k nodes
            while (curr != null && count < k) {
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            // head is now the end of this reversed block
            head.next = reverseAlternateKGroup(curr, k, !shouldReverse);
            return prev; // new head of this block
        } else {
            // Skip k nodes without reversing
            while (curr != null && count < k - 1) {
                curr = curr.next;
                count++;
            }
            if (curr != null) {
                curr.next = reverseAlternateKGroup(curr.next, k, !shouldReverse);
            }
            return head; // no reversal, keep as is
        }
    }
}
