
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class Practical7 {

    public static <T> void display(T data) {
        System.out.println("Value: " + data);
    }

    public static double sumNumbers(
            java.util.List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }

    public static void main(String[] args) {
        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Integer Box: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Hello Java");
        System.out.println("String Box: " + b2.get());

        display(50);
        display("Generics");

        java.util.List<Integer> nums =
            java.util.Arrays.asList(10, 20, 30);

        System.out.println("Sum: " + sumNumbers(nums));
    }
}

