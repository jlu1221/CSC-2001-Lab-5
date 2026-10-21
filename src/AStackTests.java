import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;


public class AStackTests {
    @Test void emptyStack() {
        assertTrue(AStack.emptyStack().isEmpty()); assertEquals(0, AStack.emptyStack().size());
    }
    @Test void push() {
        AStack stack = AStack.emptyStack(); stack.push("a"); stack.push("b");
        assertEquals(2, stack.size()); assertFalse(stack.isEmpty());
    }
    @Test void pop() {
        AStack stack = AStack.emptyStack(); stack.push("a"); stack.push("b");
        assertEquals("b", stack.pop()); assertEquals("a", stack.pop());
    }
    @Test void popOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> AStack.emptyStack().pop());
    }

    @Test void peek() {
        AStack stack = AStack.emptyStack(); stack.push("top");
        assertEquals("top", stack.peek()); assertEquals(1, stack.size());
    }
    @Test void peekOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> AStack.emptyStack().peek());
    }

    @Test void equalityComparesValues() {
        AStack left = AStack.emptyStack(); AStack right = AStack.emptyStack();
        left.push("a"); right.push("a"); assertEquals(left, right);
        right.push("b"); assertNotEquals(left, right);
    }
}
