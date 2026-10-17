import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;


public class LLQueue {
    private Node front;
    private Node rear;
    private int size;


    public LLQueue(Node front, Node rear, int size) {
        this.front = front;
        this.rear = rear;
        this.size = size;
        if (size == 0 && (front != null || rear != null)) {
            throw new IllegalArgumentException("empty queue list");
        }
    }

    // Constructs an empty queue
    public LLQueue() {
        this(null, null, 0);
    }

    // Purpose: make an empty linked-list queue.
    public static LLQueue emptyQueue() {
        return new LLQueue();
    }

    // Purpose: add value at the rear of this queue.
    public void enqueue(String value) {
        this.rear = new Node(value, this.rear);
        this.size++;
    }

    // Purpose: remove and return the front value.
    public String dequeue() {
        this.moveRearToFrontIfNeeded();
        if (this.front == null) {
            throw new NoSuchElementException("cannot dequeue an empty queue");
        }
        String answer = this.front.value;
        this.front = this.front.next;
        this.size--;
        return answer;
    }

    // Purpose: return, without removing, the front value.
    public String peek() {
        this.moveRearToFrontIfNeeded();
        if (this.front == null) {
            throw new NoSuchElementException("cannot peek at an empty queue");
        }
        return this.front.value;
    }

    // Purpose: count the values in this queue.
    public int size() {
        return this.size;
    }

    // Purpose: determine whether this queue has no values.
    public boolean isEmpty() {
        return this.size == 0;
    }

    // Purpose: if necessary, iteratively reverse rear so the oldest item is first.
    private void moveRearToFrontIfNeeded() {
        if (this.front != null || this.rear == null) {
            return;
        }
        Node reversed = null;
        Node cursor = this.rear;
        while (cursor != null) {
            reversed = new Node(cursor.value, reversed);
            cursor = cursor.next;
        }
        this.front = reversed;
        this.rear = null;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof LLQueue)) {
            return false;
        }
        LLQueue that = (LLQueue) other;
        if (this.size != that.size) {
            return false;
        }
        return this.valuesInQueueOrder().equals(that.valuesInQueueOrder());
    }

    private ArrayList<String> valuesInQueueOrder() {
        ArrayList<String> result = new ArrayList<>();
        for (Node cursor = this.front; cursor != null; cursor = cursor.next) {
            result.add(cursor.value);
        }
        Node reversedRear = null;
        for (Node cursor = this.rear; cursor != null; cursor = cursor.next) {
            reversedRear = new Node(cursor.value, reversedRear);
        }
        for (Node cursor = reversedRear; cursor != null; cursor = cursor.next) {
            result.add(cursor.value);
        }
        return result;
    }


    public static class Node {
        private final String value;
        private final Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Node)) { return false; }
            Node that = (Node) other;
            return Objects.equals(this.value, that.value) && Objects.equals(this.next, that.next);
        }
    }
}
