import java.util.EmptyStackException;
import java.util.Scanner;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class GenericStack_Q1<T> {
    private Node<T> top;
    private int size;

    public GenericStack_Q1() {
        top = null;
        size = 0;
    }

    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T item = top.data;
        top = top.next;
        size--;
        return item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Stack Size: ");
        int stackSize = scanner.nextInt();
        GenericStack_Q1<Object> stack = new GenericStack_Q1<>();
        System.out.println("Enter Stack Values");

        for (int i = 0; i < stackSize; i++) {
            String value = scanner.next();
            stack.push(value);
        }

        System.out.println("Perform Stack Operations");
        scanner.nextLine(); // Consume the newline character

        while (true) {
            String operation = scanner.nextLine();
            if (operation.equals("pop")) {
                try {
                    System.out.println("Popped: " + stack.pop());
                } catch (EmptyStackException e) {
                    System.out.println("Stack is empty. Cannot pop.");
                }
            } else if (operation.equals("size")) {
                System.out.println("Stack size: " + stack.size());
            } else if (operation.equals("isEmpty")) {
                if (stack.isEmpty()) {
                    System.out.println("Stack is empty.");
                } else {
                    System.out.println("Stack is not empty.");
                }
            } else if (operation.equals("Quit")) {
                break;
            }
        }

        System.out.println("Program Exited!");
    }
}
