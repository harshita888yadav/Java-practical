
interface Payable {
    double getPayment();
}

interface Printable {
    void printDetails();
}

abstract class Employee implements Payable, Printable {
    protected String name;

    Employee(String name) {
        this.name = name;
    }

    abstract double calculateSalary();

    void greet() {
        System.out.println("Employee: " + name);
    }

    @Override
    public double getPayment() {
        return calculateSalary();
    }
}

class FullTimeEmployee extends Employee {
    private double monthlySalary;

    FullTimeEmployee(String name, double monthlySalary) {
        super(name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }

    @Override
    public void printDetails() {
        greet();
        System.out.println("Monthly salary: " + calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    private int hours;
    private double rate;

    PartTimeEmployee(String name, int hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    double calculateSalary() {
        return hours * rate;
    }

    @Override
    public void printDetails() {
        greet();
        System.out.println("Part-time salary: " + calculateSalary());
    }
}

public class AbstractionDemo {
    public static void main(String[] args) {
        Employee e1 = new FullTimeEmployee("Aman", 40000);
        Employee e2 = new PartTimeEmployee("Priya", 80, 200);

        e1.printDetails();
        System.out.println("Payment: " + e1.getPayment());

        e2.printDetails();
        System.out.println("Payment: " + e2.getPayment());
    }
}

