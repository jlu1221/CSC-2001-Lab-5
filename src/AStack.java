import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Objects;

public class AStack {
    private final ArrayList<String> values;

    public AStack(ArrayList<String> values) {
        this.values = new ArrayList<>(values);
    }

    public AStack() {
        this(new ArrayList<>());
    }

    // Purpose: make an empty array-list stack.
    public static AStack emptyStack() {
        return new AStack();
    }

    // Purpose: add value to the top of this stack.
    public void push(String value) {
        this.values.add(value);
    }

    // Purpose: remove and return the top value.
    public String pop() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("cannot pop an empty stack");
        }
        return this.values.remove(this.values.size() - 1);
    }

    // Purpose: return, without removing, the top value.
    public String peek() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("cannot peek at an empty stack");
        }
        return this.values.get(this.values.size() - 1);
    }

    // Purpose: count the values in this stack.
    public int size() {
        return this.values.size();
    }

    // Purpose: determine whether this stack has no values.
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof AStack && this.values.equals(((AStack) other).values);
    }
}
