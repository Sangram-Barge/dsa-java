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
    assertEquals(lst.getHead().data, "sangram");
  }

  @Test
  public void addFistShouldAddElementToBeginingOfList() {
    lst.addFirst("today is the day ");
    lst.addFirst("i am going to die");
    lst.print();
    assertEquals(lst.getHead().data,"i am going to die" );
    assertEquals(lst.getHead().next.data, "today is the day ");
    assertNull(lst.getHead().prev);
  }

  @Test
  public void peekFirstShouldGiveHeadData() {
    lst.add("sangram");
    assertEquals(lst.peekFirst(), "sangram");
  }

  @Test
  public void peekLstShouldGiveTailData() {
    lst.add("sangram");
    lst.add("anushree");
    assertEquals(lst.peekLast(), "anushree");
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