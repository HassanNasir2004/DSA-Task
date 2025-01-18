class SinglyLinkedList {
    private Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void findMiddle() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle Node: " + slow.data);
    }

    public void reverseList() {
        Node previous = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }
        head = previous;
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public static SinglyLinkedList mergeLists(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList newList = new SinglyLinkedList();
        Node l1 = list1.head;
        Node l2 = list2.head;
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                newList.addNode(l1.data);
                l1 = l1.next;
            } else {
                newList.addNode(l2.data);
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            newList.addNode(l1.data);
            l1 = l1.next;
        }
        while (l2 != null) {
            newList.addNode(l2.data);
            l2 = l2.next;
        }
        return newList;
    }

    public void deleteList() {
        head = null;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        list.addNode(4);
        list.addNode(5);
        System.out.println("Original List:");
        list.printList();
        System.out.println("Number of Nodes: " + list.countNodes());
        list.findMiddle();
        list.reverseList();
        System.out.println("Reversed List:");
        list.printList();
        list.addNode(5);
        list.removeDuplicates();
        System.out.println("After Removing Duplicates:");
        list.printList();
        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.addNode(0);
        list2.addNode(2);
        list2.addNode(6);
        SinglyLinkedList mergedList = mergeLists(list, list2);
        System.out.println("Merged List:");
        mergedList.printList();
        list.deleteList();
        System.out.println("List after deletion:");
        list.printList();
    }
}
