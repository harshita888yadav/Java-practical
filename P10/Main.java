
import java.util.ArrayList;
import java.util.List;

// Interface
interface Printable {
    void printDetails();
}

// Abstract class
abstract class LibraryItem {
    protected int id;
    protected String title;

    LibraryItem(int id, String title) {
        this.id = id;
        this.title = title;
    }

    abstract void display();
}

// Inheritance and interface implementation
class Book extends LibraryItem implements Printable {
    private String author;

    Book(int id, String title, String author) {
        super(id, title);
        this.author = author;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public void printDetails() {
        display();
    }
}

// Generic repository
class Repository<T> {
    private List<T> items = new ArrayList<>();

    void add(T item) {
        items.add(item);
    }

    void showAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }

    int size() {
        return items.size();
    }
}

// Stack ADT
class MyStack<T> {
    private List<T> items = new ArrayList<>();

    void push(T item) {
        items.add(item);
    }

    T pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }
}

public class Practical10 {
    public static void main(String[] args) {
        Repository<Book> library = new Repository<>();

        Book b1 = new Book(101, "Java Basics", "James");
        Book b2 = new Book(102, "DBMS", "Korth");

        library.add(b1);
        library.add(b2);

        System.out.println("Library Book Details:");
        b1.printDetails();

        System.out.println("\nSecond Book:");
        b2.display();

        System.out.println("\nTotal Books: " + library.size());

        MyStack<String> history = new MyStack<>();
        history.push("Java");
        history.push("DBMS");

        System.out.println("\nStack Pop: " + history.pop());
    }
}

