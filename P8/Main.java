
class MyStack {
    int[] arr = new int[5];
    int top = -1;

    void push(int value) {
        if (top == arr.length - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = value;
        System.out.println(value + " pushed");
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println(arr[top--] + " popped");
    }

    void display() {
        System.out.print("Stack: ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

class MyQueue {
    int[] arr = new int[5];
    int front = 0, rear = -1, size = 0;

    void enqueue(int value) {
        if (size == arr.length) {
            System.out.println("Queue Overflow");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        size++;
        System.out.println(value + " enqueued");
    }

    void dequeue() {
        if (size == 0) {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println(arr[front] + " dequeued");
        front = (front + 1) % arr.length;
        size--;
    }

    void display() {
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[(front + i) % arr.length] + " ");
        }
        System.out.println();
    }
}

public class Practical8 {
    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(10);
        s.push(20);
        s.push(30);
        s.display();
        s.pop();
        s.display();

        MyQueue q = new MyQueue();
        q.enqueue(100);
        q.enqueue(200);
        q.enqueue(300);
        q.display();
        q.dequeue();
        q.display();
    }
}

