
class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class MyLinkedList<T> {
    private Node<T> head;
    private int size = 0;

    void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    void delete(T data) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (java.util.Objects.equals(head.data, data)) {
            head = head.next;
            size--;
            return;
        }

        Node<T> current = head;
        while (current.next != null &&
               !java.util.Objects.equals(current.next.data, data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
        } else {
            System.out.println("Element not found");
        }
    }

    boolean search(T data) {
        Node<T> current = head;
        while (current != null) {
            if (java.util.Objects.equals(current.data, data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    int size() {
        return size;
    }
}

public class Practical9 {
    public static void main(String[] args) {
        MyLinkedList<Integer> numbers = new MyLinkedList<>();

        numbers.insert(10);
        numbers.insert(20);
        numbers.insert(30);

        System.out.print("Integer List: ");
        numbers.display();

        System.out.println("Search 20: " + numbers.search(20));
        numbers.delete(20);
        System.out.print("After deletion: ");
        numbers.display();
        System.out.println("Size: " + numbers.size());

        MyLinkedList<String> names = new MyLinkedList<>();
        names.insert("Aman");
        names.insert("Riya");

        System.out.print("String List: ");
        names.display();
    }
}

