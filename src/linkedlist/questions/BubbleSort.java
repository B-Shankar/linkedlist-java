package linkedlist.questions;

import linkedlist.singly.LinkedListImpl;

//148. Sort List using Bubble Sort
public class BubbleSort {

    // Inner Node class (only one definition needed)
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    // Constructor
    public BubbleSort() {
        this.size = 0;
    }

    // Insert methods
    public void insertAtLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public Node get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }

        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    // Bubble sort method
    public void bubbleSort() {
        if (size <= 1) return;
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // Swap values
                swapValues(first, second);
            }

            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // Simple value swap method
    private void swapValues(Node node1, Node node2) {
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public static void main(String[] args) {
        System.out.println("=== Bubble Sort LinkedList Examples ===");

        // Example 1: Random unsorted list
        System.out.println("\n--- Example 1: Random Numbers ---");
        BubbleSort list1 = new BubbleSort();
        int[] values1 = {64, 34, 25, 12, 22, 11, 90};

        for (int val : values1) {
            list1.insertAtLast(val);
        }

        System.out.print("Before sorting: ");
        list1.display();

        list1.bubbleSort();

        System.out.print("After sorting:  ");
        list1.display();

        // Example 2: Already sorted list
        System.out.println("\n--- Example 2: Reverse Sorted ---");
        BubbleSort list2 = new BubbleSort();
        int[] values2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        for (int val : values2) {
            list2.insertAtLast(val);
        }

        System.out.print("Before sorting: ");
        list2.display();

        list2.bubbleSort2();

        System.out.print("After sorting:  ");
        list2.display();
    }

    public void bubbleSort2() {
        if (size == 0) return;
        bubbleSort2(size - 1, 0);
    }

    private void bubbleSort2(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    tail = first;
                    prev.next = second;
                    first.next = null;
                    second.next = first;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }

            bubbleSort2(row, col + 1);
        } else {
            bubbleSort2(row - 1, 0);
        }
    }

}
