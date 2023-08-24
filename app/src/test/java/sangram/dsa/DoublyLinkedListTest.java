package sangram.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoublyLinkedListTest {
  DoublyLinkedList<String> lst = new DoublyLinkedList<>();

  @BeforeEach
  public void init() {
    lst = new DoublyLinkedList<>();
  }

  @Test
  public void counstructionShouldCreateEmptyLinkedList() {
    assertEquals(0, lst.size());
    assertNull(lst.getHead());
    assertNull(lst.getTail());
  }

  @Test
  public void addShouldAddElementToEndOfList() {
    lst.add("sangram");
  }

  @Test
  public void print() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    lst.add("kusum");
    lst.print();
  }
}