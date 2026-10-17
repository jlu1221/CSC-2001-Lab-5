import java.util.NoSuchElementException;

public class LLStack {
    private static class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    private Node top;
    private int size;

    public LLStack(Node top, int size) {
        this.top = top;
        this.size = size;
    }
    // emptyStack method
    // purpose: this method takes no arguments and return an empty stack
    // example: LLStack.emptyStack() -> s[] null value
    // template: create an LLstack, set top to null, set size to 0, return new stack
    public static LLStack emptyStack() {
        return new LLStack(null, 0);
    }

    // push method
    // purpose: this method accepts a String and pushes it into the stack
    // example: s[], push("String") -> (s["String"], size: 1)
    // template: create a new node containing a value, linked the node to top, update top to new node, increase size +1
    public void push(String value) {
        top = new Node(value, top);
        size++;
    }
    // pop method
    // purpose: this method remove and return the top element, raises a NoSuchElement if there is no such element
    // example: s["a", "b"], pop() -> s["a"], size 1
    // template: if stack is empty, throw an exception, otherwise, save value to top node, move top to next node, decrease size and return value.

    public String pop(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        String removed = top.value;
        top = top.next;
        size--;
        return removed;
    }

    // peek method
    // purpose: returns the top element but does not remove it, raises a NoSuchElement if there is no such element
    // example: s['a', 'b'], peek() -> 'b' list stay the same
    // template: if the stack is empty, throw an exception, else return the value at the top node
    public String peek(){
        if (size == 0){
            throw new NoSuchElementException();
        }
        return top.value;
    }

    // size method
    // purpose: return the number of element in the stack
    // example: s['a', 'b', 'c'], size() -> 3
    // template: return size of list
    public int size() {
        return size;
    }
    // isEmpty method
    // purpose: a boolean that returns true when the stack contains no elements and false if otherwise
    // example: s['a'] -> false; s[] -> true
    // template: return true if size is 0, else false

    public boolean isEmpty() {
        return size == 0;
    }

    // Method: equals
    // Purpose: returns true if two LLStacks have the same size and values in the same order.
    // Example: s[a, b].equals(S[a, b]) -> true.
    // Template:If both references are the same, return true. If obj is not an LLStack, return false.
    // Compare sizes. Walk through both linked lists together. Compare the values in corresponding Nodes.
    // Return true if all values match.

    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (!(obj instanceof LLStack)) {
            return false;
        }
        LLStack other = (LLStack) obj;
        if(this.size != other.size) {
            return false;
        }
        Node current1 = this.top;
        Node current2 = other.top;
        while (current1 != null){
            if (!current1.value.equals(current2.value))
            {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return true;
    }
}
