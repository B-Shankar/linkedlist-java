package linkedlist.questions;

// 234. Palindrome Linked List
public class PalindromeLinkedList {
    private ListNode head;

    public class ListNode {
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

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode mid = middleNode(head);
        ListNode headSecond = reverseList(mid);
        ListNode reReverseNode = headSecond; // save to restore later

        ListNode first = head;
        boolean palindrome = true;

        while (headSecond != null) {
            if (first.val != headSecond.val) {
                palindrome = false;
                break;
            }
            first = first.next;
            headSecond = headSecond.next;
        }

        reverseList(reReverseNode); // restore second half (optional)
        return palindrome;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev; // new head of reversed list
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // middle node
    }

    public static void main(String[] args) {
        PalindromeLinkedList list = new PalindromeLinkedList();
        list.insertAtLast(1);
        list.insertAtLast(2);
        list.insertAtLast(3);
        list.insertAtLast(4);
        list.insertAtLast(2);
        list.insertAtLast(1);

        list.display();
        System.out.println("Is Palindrome: " + list.isPalindrome(list.head));
    }
}
