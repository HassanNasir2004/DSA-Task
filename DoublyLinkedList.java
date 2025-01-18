import java.util.Scanner;
class Node {
    char data;
    Node prev;
    Node next;
    public Node(char data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class DoublyLinkedList {
    private Node head;
    private Node tail;
    private Node cursor;
    public DoublyLinkedList() {
        head = null;
        tail = null;
        cursor = null;
    }
    public void insert(char data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = cursor = newNode;
        } else if (cursor == null) {
            cursor = head;
            cursor.next = newNode;
            newNode.prev = cursor;
            cursor = newNode;
        } else if (cursor.next == null) {
            cursor.next = newNode;
            newNode.prev = cursor;
            tail = cursor = newNode;
        } else {
            newNode.next = cursor.next;
            newNode.prev = cursor;
            cursor.next.prev = newNode;
            cursor.next = newNode;
            cursor = newNode;
        }
    }
    public void delete() {
        if (cursor == null) {
            System.out.println("Nothing to delete.");
            return;
        }
        if (cursor == head && cursor == tail) {
            head = tail = cursor = null;
        } else if (cursor == head) {
            head = cursor.next;
            head.prev = null;
            cursor = head;
        } else if (cursor == tail) {
            tail = cursor.prev;
            tail.next = null;
            cursor = tail;
        } else {
            cursor.prev.next = cursor.next;
            cursor.next.prev = cursor.prev;
            cursor = cursor.prev;
        }
    }
    public void moveLeft() {
        if (cursor != null && cursor.prev != null) {
            cursor = cursor.prev;
        } else {
            System.out.println("Cursor is at the beginning.");
        }
    }
    public void moveRight() {
        if (cursor != null && cursor.next != null) {
            cursor = cursor.next;
        } else {
            System.out.println("Cursor is at the end.");
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            if (temp == cursor) {
                System.out.print("|" + temp.data + "|");
            } else {
                System.out.print(temp.data);
            }
            temp = temp.next;
        }
        System.out.println();
    }
}
class TextEditor {
    public static void main(String[] args) {
        DoublyLinkedList editor = new DoublyLinkedList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Commands: insert <char>, delete, left, right, display, exit");
        while (running) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            if (command.startsWith("insert")) {
                char toInsert = command.split(" ")[1].charAt(0);
                editor.insert(toInsert);
            } else if (command.equals("delete")) {
                editor.delete();
            } else if (command.equals("left")) {
                editor.moveLeft();
            } else if (command.equals("right")) {
                editor.moveRight();
            } else if (command.equals("display")) {
                editor.display();
            } else if (command.equals("exit")) {
                running = false;
            } else {
                System.out.println("Unknown command.");
            }
        }
        scanner.close();
    }
}
