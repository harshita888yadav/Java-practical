
import java.util.ArrayList;
import java.util.List;

class Teacher {
    String name;

    Teacher(String name) {
        this.name = name;
    }
}

class Course {
    String title;

    Course(String title) {
        this.title = title;
    }
}

class Student {
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String name) {
        this.name = name;
    }

    // Association: student studies courses
    void enroll(Course course) {
        courses.add(course);
    }

    void showCourses() {
        System.out.println(name + "'s courses:");
        for (Course c : courses) {
            System.out.println(c.title);
        }
    }
}

class Department {
    String name;
    List<Teacher> teachers = new ArrayList<>();

    Department(String name) {
        this.name = name;
    }

    // Aggregation: teachers can exist independently
    void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    void showTeachers() {
        System.out.println("Department: " + name);
        for (Teacher t : teachers) {
            System.out.println(t.name);
        }
    }
}

class College {
    String name;
    List<Department> departments = new ArrayList<>();

    College(String name) {
        this.name = name;
    }

    // Composition-style ownership of departments
    Department createDepartment(String name) {
        Department d = new Department(name);
        departments.add(d);
        return d;
    }

    void showDepartments() {
        System.out.println("College: " + name);
        for (Department d : departments) {
            System.out.println(d.name);
        }
    }
}

public class RelationshipsDemo {
    public static void main(String[] args) {
        College college = new College("ABC College");

        Department cs = college.createDepartment("Computer Science");

        Teacher t1 = new Teacher("Mr. Sharma");
        cs.addTeacher(t1);

        Student s = new Student("Aman");
        Course c1 = new Course("Java");
        Course c2 = new Course("Database");

        s.enroll(c1);
        s.enroll(c2);

        college.showDepartments();
        cs.showTeachers();
        s.showCourses();
    }
}

