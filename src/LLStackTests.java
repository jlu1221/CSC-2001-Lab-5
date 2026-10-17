import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class LLStackTests {
    @Test void emptyStackIsEmptyAndHasSizeZero() {
        assertTrue(LLStack.emptyStack().isEmpty());
        assertEquals(0, LLStack.emptyStack().size());
    }
    @Test void pushAddsValuesAndChangesSize() {
        LLStack stack = LLStack.emptyStack(); stack.push("first"); stack.push("second");
        assertEquals(2, stack.size()); assertFalse(stack.isEmpty());
    }
    @Test void popUsesLastInFirstOutOrder() {
        LLStack stack = LLStack.emptyStack(); stack.push("a"); stack.push("b");
        assertEquals("b", stack.pop()); assertEquals("a", stack.pop());
    }
    @Test void popOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> LLStack.emptyStack().pop());
    }
    @Test void peekDoesNotRemoveTop() {
        LLStack stack = LLStack.emptyStack(); stack.push("top");
        assertEquals("top", stack.peek()); assertEquals(1, stack.size());
    }
    @Test void peekOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> LLStack.emptyStack().peek());
    }
    @Test void equalityComparesValues() {
        LLStack left = LLStack.emptyStack(); LLStack right = LLStack.emptyStack();
        left.push("a"); right.push("a"); assertEquals(left, right);
        right.push("b"); assertNotEquals(left, right);
    }
}
