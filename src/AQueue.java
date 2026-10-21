import java.util.NoSuchElementException;
import java.util.Objects;

public class AQueue {

    private String[] values;
    private int front;
    private int size;


    public AQueue(String[] values, int front, int size) {
        if (values == null || values.length == 0 || size < 0 ) {
            throw new IllegalArgumentException("invalid  queue");
        }
        this.values = values;
        this.front = front;
        this.size = size;
    }

    // Purpose: construct an empty fixed-capacity queue.
    public static AQueue emptyQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity must be positive");
        }
        return new AQueue(new String[capacity], 0, 0);
    }

    // Purpose: add value at the rear of this queue. Throws IllegalStateException when the fixed-capacity queue is full.
    public void enqueue(String value) {
        // check empty queue
        if (this.size == this.values.length) {
            throw new IllegalStateException("queue is full");
        }
        // circular indexing
        int back = (this.front + this.size) % this.values.length;
        this.values[back] = value;
        this.size++;
    }

    // Purpose: remove and return the front value.
    public String dequeue() {
        // check empty queue
        if (this.isEmpty()) {
            throw new NoSuchElementException("cannot dequeue an empty queue");
        }
        String end = this.values[this.front];
        this.values[this.front] = null;
        this.front = (this.front + 1) % this.values.length;
        this.size--;
        return end;
    }

    // Purpose: return, without removing, the front value.
    public String peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("cannot peek at an empty queue");
        }
        return this.values[this.front];
    }

    // Purpose: count the values in this queue.
    public int size() {
        return this.size;
    }

    // Purpose: determine whether this queue has no values.
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof AQueue)) {
            return false;
        }
        AQueue that = (AQueue) other;
        if (this.size != that.size) {
            return false;
        }
        for (int i = 0; i < this.size; i++) {
            if (!Objects.equals(this.values[(this.front + i) % this.values.length],
                    that.values[(that.front + i) % that.values.length])) {
                return false;
            }
        }
        return true;
    }
}
