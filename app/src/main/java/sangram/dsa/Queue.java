package sangram.dsa;

public class Queue <T> {
  DoublyLinkedList<T> list;

  public Queue() {
    this.list = new DoublyLinkedList<>();
  }
  public Queue(T element) {
    this.list = new DoublyLinkedList<>();
    list.add(element);
  }

  public int size() {
    return this.list.size();
  }

  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  public void offer(T element) {
    this.list.addLast(element);
  }

  public T poll() {
    if (list.isEmpty()) throw new RuntimeException("empty list");
    return this.list.removeFirst();
  }

  public T peek() {
    if (list.isEmpty()) throw new RuntimeException("empty list");
    return this.list.getTail().data;
  }
}
