import java.util.HashMap;
import java.util.Map;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class FirstNonRepeatingStream_Q2 {
    private Node head;
    private Node tail;
    private Map<Character, Node> charToNode;
    private Map<Character, Integer> charCount;

    private static class Node {
        char value;
        Node prev;
        Node next;

        Node(char c) {
            this.value = c;
        }
    }

    public FirstNonRepeatingStream_Q2() {
        head = new Node('-'); 
        tail = new Node('-'); 
        head.next = tail;
        tail.prev = head;
        charToNode = new HashMap<>();
        charCount = new HashMap<>();
    }

    public void add(char c) {
        if (!charCount.containsKey(c)) {
            // Character is appearing for the the first time
            charCount.put(c, 1);
            Node newNode = new Node(c);
            charToNode.put(c, newNode);
            newNode.next = tail;
            newNode.prev = tail.prev;
            tail.prev.next = newNode;
            tail.prev = newNode;
        } else {
            // Character has appeared before, mark it as repeated
            charCount.put(c, charCount.get(c) + 1);
            Node node = charToNode.get(c);
            // Remove the repeated character from the linked list
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    public char getFirstNonRepeating() {
        Node firstNonRepeatingNode = head.next;
        if (firstNonRepeatingNode != tail && charCount.get(firstNonRepeatingNode.value) == 1) {
            return firstNonRepeatingNode.value;
        }
        return '-';
    }

    public static void main(String[] args) {
        FirstNonRepeatingStream_Q2 stream1 = new FirstNonRepeatingStream_Q2();
        stream1.add('a');
        stream1.add('b');
        stream1.add('d');
        stream1.add('c');
        System.out.println(stream1.getFirstNonRepeating()); 

        FirstNonRepeatingStream_Q2 stream2 = new FirstNonRepeatingStream_Q2();
        stream2.add('a');
        stream2.add('b');
        stream2.add('a');
        stream2.add('b');
        System.out.println(stream2.getFirstNonRepeating()); 

        FirstNonRepeatingStream_Q2 stream3 = new FirstNonRepeatingStream_Q2();
        stream3.add('a');
        stream3.add('c');
        stream3.add('b');
        System.out.println(stream3.getFirstNonRepeating()); 
    }
}
