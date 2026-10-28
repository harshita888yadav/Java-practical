
class Student {
    // Private data members (Encapsulation)
    private int rollNo;
    private String name;
    private double marks;

    // Default constructor
    public Student() {
        rollNo = 0;
        name = "Unknown";
        marks = 0.0;
    }

    // Parameterized constructor
    public Student(int rollNo, String name, double marks) {
        setRollNo(rollNo);
        setName(name);
        setMarks(marks);
    }

    // Getter and setter for rollNo
    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        if (rollNo > 0) {
            this.rollNo = rollNo;
        } else {
            System.out.println("Invalid roll number!");
        }
    }

    // Getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Invalid student name!");
        }
    }

    // Getter and setter for marks
    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        if (marks >= 0 && marks <= 100) {
            this.marks = marks;
        } else {
            System.out.println("Marks must be between 0 and 100!");
        }
    }

    // Public method to display student details
    public void displayDetails() {
        System.out.println("Roll Number: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("--------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        // Object created using default constructor
        Student s1 = new Student();

        // Object created using parameterized constructor
        Student s2 = new Student(101, "Rahul", 85.5);

        // Display student details
        System.out.println("Student 1:");
        s1.displayDetails();

        System.out.println("Student 2:");
        s2.displayDetails();

        // Updating values using setters
        s1.setRollNo(102);
        s1.setName("Priya");
        s1.setMarks(92.0);

        System.out.println("Updated Student 1:");
        s1.displayDetails();

        // Demonstrating validation
        s2.setMarks(120);
    }
}



