package sangram.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueueTest {
  Queue<String> queue;

  @BeforeEach
  public void init() {
    queue = new Queue<>();
  }

  @Test
  public void emptyInitShouldInitEmptyQueue() {
    assertEquals(0, queue.size());
    assertTrue(queue.isEmpty());
  }

  @Test
  public void offerShouldAddElementToEndOfQueue() {
    queue.offer("sangram");
    queue.offer("anushree");
    assertEquals(queue.list.getTail().data, "anushree");
  }

  @Test
  public void pollShouldRemoveFirstElementInserted() {
    queue.offer("sangram");
    queue.offer("anushree");
    assertEquals("sangram", queue.poll());
    assertEquals(1, queue.size());
  }
}
