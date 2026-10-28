class Person {
    // Private data member
    private String name;

    // Protected data member
    protected int age;

    // Base class constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }

    // Public getter
    public String getName() {
        return name;
    }

    // Common method inherited by subclasses
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Single inheritance: Student inherits Person
class Student extends Person {
    private int rollNo;

    public Student(String name, int age, int rollNo) {
        super(name, age);
        this.rollNo = rollNo;
        System.out.println("Student constructor called");
    }

    public void displayStudent() {
        displayInfo(); // Reusing inherited method
        System.out.println("Roll Number: " + rollNo);
    }
}

// Multilevel inheritance: Faculty inherits Person
// (This is single inheritance; multilevel is shown below.)
class Faculty extends Person {
    protected String department;

    public Faculty(String name, int age, String department) {
        super(name, age);
        this.department = department;
        System.out.println("Faculty constructor called");
    }

    public void displayFaculty() {
        displayInfo(); // Reusing inherited method
        System.out.println("Department: " + department);
    }
}

// A further derived class demonstrates multilevel inheritance
class Professor extends Faculty {
    private String subject;

    public Professor(String name, int age,
                     String department, String subject) {
        super(name, age, department);
        this.subject = subject;
        System.out.println("Professor constructor called");
    }

    public void displayProfessor() {
        displayFaculty(); // Reuses Faculty and Person methods
        System.out.println("Subject: " + subject);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Student Details ---");
        Student s = new Student("Rahul", 20, 101);
        s.displayStudent();

        System.out.println("\n--- Faculty Details ---");
        Faculty f = new Faculty("Priya", 40, "Computer Science");
        f.displayFaculty();

        System.out.println("\n--- Professor Details ---");
        Professor p = new Professor(
            "Amit", 45, "Information Technology", "Java"
        );
        p.displayProfessor();
    }
}
