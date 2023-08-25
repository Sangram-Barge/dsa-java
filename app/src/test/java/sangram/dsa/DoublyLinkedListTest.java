package sangram.dsa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
  public void removeFirstShouldRemoveFirstElement() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    var rmData = lst.removeFirst();
    assertEquals(rmData, "sangram");
    assertEquals(lst.size(), 2);
    assertNull(lst.getHead().prev);

  }

  @Test
  public void removeFirstWithSingleElementShouldEmptyList() {
    lst.add("sangram");
    var rmData = lst.removeFirst();
    assertEquals(rmData, "sangram");
    assertEquals(lst.size(), 0);
    assertNull(lst.getHead());
    assertNull(lst.getTail());
  }

  @Test
  public void removeFirstOnEmptyListShouldThrowException() {
    assertThrows(RuntimeException.class, () -> {
      lst.removeFirst();
    });  
  }

  @Test
  public void removeLastShouldRemoveLastElement() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    var rmData = lst.removeLast();
    assertEquals(rmData, "sudhakar");
    assertEquals(lst.getTail().data, "anushree");
    assertEquals(lst.size(), 2);
    assertNull(lst.getTail().next);
  }

  @Test
  public void removeLastEmptyShouldThrowException() {
    assertThrows(RuntimeException.class, () -> {
      lst.removeLast();
    });
  }

  @Test
  public void removeLastWithSingleElementShouldEmptyList() {
    lst.add("sangram");
    lst.removeLast();
    assertEquals(lst.size(), 0);
    assertNull(lst.getTail());
  }

  @Test
  public void print() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    lst.add("kusum");
    lst.print();
  }

  @Test
  public void removeNodeShouldRemoveNode() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("kusum");
    DoublyLinkedList<String>.Node<String> n = lst.getHead().next;
    var rNodeData = lst.removeNode(n);
    assertEquals("anushree", rNodeData);
    assertEquals(2, lst.size());
    assertEquals(lst.getHead().next.data, "kusum");
    assertEquals(lst.getHead().data, "sangram");
  }

  @Test
  public void removeAtShouldRemoveNodeAtIndex() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    lst.add("kusum");
    lst.add("gouri");
    lst.add("shreya");
    lst.add("shravani");
    lst.add("siddhi");
    lst.add("riddhi");
    lst.add("sami");

    assertEquals(10, lst.size());
    String data = lst.remove(8);
    assertEquals("riddhi", data);
    assertEquals(9, lst.size());
  }

  @Test
  public void removeObjectShouldRemoveObject() {
    lst.add("sangram");
    lst.add("anushree");
    lst.add("sudhakar");
    lst.add("kusum");
    lst.add("gouri");
    boolean isSangramRemoved = lst.remove("sangram");
    boolean isTestRemoved = lst.remove("test");
    assertTrue(isSangramRemoved);
    assertFalse(isTestRemoved);
  }

  @Test
  public void removeAtInvalidIndexShouldThrowExcpetion() {
    assertThrows(RuntimeException.class, () -> {
      lst.remove(5);
    });
  }
}