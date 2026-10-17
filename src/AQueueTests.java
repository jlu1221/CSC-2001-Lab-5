import static org.junit.jupiter.api.Assertions.*;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class AQueueTests {
    @Test void emptyQueueIsEmptyAndHasSizeZero() {
        assertTrue(AQueue.emptyQueue(3).isEmpty()); assertEquals(0, AQueue.emptyQueue(3).size());
    }
    @Test void invalidCapacityThrows() {
        assertThrows(IllegalArgumentException.class, () -> AQueue.emptyQueue(0));
        assertThrows(IllegalArgumentException.class, () -> AQueue.emptyQueue(-2));
    }
    @Test void enqueueAddsValuesAndChangesSize() {
        AQueue queue = AQueue.emptyQueue(3); queue.enqueue("a"); queue.enqueue("b");
        assertEquals(2, queue.size()); assertFalse(queue.isEmpty());
    }
    @Test void enqueueOnFullQueueThrows() {
        AQueue queue = AQueue.emptyQueue(1); queue.enqueue("a");
        assertThrows(IllegalStateException.class, () -> queue.enqueue("b"));
    }
    @Test void dequeueUsesFirstInFirstOutOrder() {
        AQueue queue = AQueue.emptyQueue(3); queue.enqueue("a"); queue.enqueue("b");
        assertEquals("a", queue.dequeue()); assertEquals("b", queue.dequeue());
    }
    @Test void dequeueOnEmptyThrows() {
        assertThrows(NoSuchElementException.class, () -> AQueue.emptyQueue(2).dequeue());
    }
    @Test void peekDoesNotRemoveFrontAndQueueWraps() {
        AQueue queue = AQueue.emptyQueue(2); queue.enqueue("a"); queue.enqueue("b");
        assertEquals("a", queue.peek()); assertEquals("a", queue.dequeue()); queue.enqueue("c");
        assertEquals("b", queue.dequeue()); assertEquals("c", queue.dequeue());
    }
    @Test void peekOnEmptyThrowsAndEqualityUsesOrder() {
        assertThrows(NoSuchElementException.class, () -> AQueue.emptyQueue(2).peek());
        AQueue left = AQueue.emptyQueue(3); AQueue right = AQueue.emptyQueue(3);
        left.enqueue("a"); right.enqueue("a"); assertEquals(left, right);
        right.enqueue("b"); assertNotEquals(left, right);
    }
}
