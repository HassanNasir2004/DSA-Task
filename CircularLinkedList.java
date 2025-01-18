class CircularLinkedList {
    Node head;
    class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; this.next = null; }
    }
    public void deleteAtPosition(int position) {
        if (head == null) { System.out.println("List is empty"); return; }
        Node current = head;
        if (position == 0) {
            if (head.next == head) { head = null; return; }
            Node last = head;
            while (last.next != head) { last = last.next; }
            head = head.next;
            last.next = head;
            return;
        }
        Node previous = null;
        int count = 0;
        do {
            if (count == position) {
                previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
            count++;
        } while (current != head);
        System.out.println("Position out of bounds");
    }
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node current = head;
        while (current.next != head) { current = current.next; }
        current.next = newNode;
        newNode.next = head;
    }
    public void printList() {
        if (head == null) { System.out.println("List is empty"); return; }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(head)");
    }
    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();
        list.append(10); list.append(20); list.append(30); list.append(40);
        System.out.println("Original List:");
        list.printList();
        list.deleteAtPosition(2);
        System.out.println("List after deleting node at position 2:");
        list.printList();
        list.deleteAtPosition(0);
        System.out.println("List after deleting head node:");
        list.printList();
    }
}
