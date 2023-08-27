package sangram.dsa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
  Stack<String> stack;

  @BeforeEach
  public void init() {
    stack = new Stack<>();
  }

  @Test
  public void initTest() {
    assertEquals(0, stack.size());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void pushShouldAddElementToTopOfStack() {
    stack.push("sangram barge");
    stack.push("anushree datarkar");
    stack.push("sudhakar barge");
    assertEquals(3, stack.size());
    assertEquals("sudhakar barge", stack.peek());
  }

  @Test
  public void popShouldPopLastAddedElementFromStack() {
    stack.push("sangram barge");
    stack.push("anushree datarkar");
    stack.push("sudhakar barge");
    assertEquals("sudhakar barge", stack.pop());
    assertEquals(2, stack.size());
  }

  @Test
  public void popOnEmptyStackShouldThrowException() {
    assertThrows(RuntimeException.class, () -> {
      stack.pop();
    });
  }
}
