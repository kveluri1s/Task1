import java.util.Scanner;
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    // Insert at the beginning
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Insert at the end
    public void insertAtEnd(int data) {
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

    // Insert at a specific position
    public void insertAtPosition(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            insertAtBeginning(data);
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.next;
                }
            }
            if (current != null) {
                newNode.next = current.next;
                current.next = newNode;
            } else {
                System.out.println("Position out of bounds");
            }
        }
    }

    // Delete from the beginning
    public void deleteFromBeginning() {
        if (head != null) {
            head = head.next;
        } else {
            System.out.println("List is empty");
        }
    }

    // Delete from the end
    public void deleteFromEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head.next == null) {
            head = null;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
    }

    // Delete from a specific position
    public void deleteFromPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (position == 0) {
            deleteFromBeginning();
        } else {
            Node current = head;
            for (int i = 0; i < position - 1; i++) {
                if (current != null) {
                    current = current.next;
                }
            }
            if (current != null && current.next != null) {
                current.next = current.next.next;
            } else {
                System.out.println("Position out of bounds");
            }
        }
    }

    // Traverse the list
    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }
}


public class LinkedListOperations {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Insert at a specific position");
            System.out.println("4. Delete from the beginning");
            System.out.println("5. Delete from the end");
            System.out.println("6. Delete from a specific position");
            System.out.println("7. Traverse the list");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at the beginning: ");
                    int valueBegin = scanner.nextInt();
                    list.insertAtBeginning(valueBegin);
                    break;

                case 2:
                    System.out.print("Enter value to insert at the end: ");
                    int valueEnd = scanner.nextInt();
                    list.insertAtEnd(valueEnd);
                    break;

                case 3:
                    System.out.print("Enter value to insert: ");
                    int valuePosition = scanner.nextInt();
                    System.out.print("Enter position: ");
                    int position = scanner.nextInt();
                    list.insertAtPosition(valuePosition, position);
                    break;

                case 4:
                    list.deleteFromBeginning();
                    break;

                case 5:
                    list.deleteFromEnd();
                    break;

                case 6:
                    System.out.print("Enter position to delete from: ");
                    int deletePosition = scanner.nextInt();
                    list.deleteFromPosition(deletePosition);
                    break;

                case 7:
                    System.out.println("Linked List:");
                    list.traverse();
                    break;

                case 8:
                    continueOperations = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }
}
