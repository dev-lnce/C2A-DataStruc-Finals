package Try;

public class MyLinkedList {

    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    public MyLinkedList() {
        head = null;
    }

    public void addEnd(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        showAll();
    }
    
    public void addStart(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    public void addAtIndex(int index, int value) {
        if (index < 0) return;
        if (index == 0) {
            addStart(value);
            return;
        }

        Node newNode = new Node(value);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            if (current == null) return;
            current = current.next;
        }

        if (current == null) return;

        newNode.next = current.next;
        current.next = newNode;

        showAll();
    }

    public static void removeByIndex(int index) {
        if (index < 0) {
            System.out.println("Invalid index.");
            return;
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
        showAll();
    }
    
    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void sort() {
        if (head == null) return;

        boolean wasSwapped;
        do {
            wasSwapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    wasSwapped = true;
                }
                current = current.next;
            }
        } while (wasSwapped);
        System.out.println("Array sorted.");
        showAll();
    }

    public void clear() {
        head = null;
        System.out.println("All items are now cleared.");
    }

    public static void showAll() {
        Node temp = head;
        System.out.print("Items: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}





