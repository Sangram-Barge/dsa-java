package sangram.dsa;

public class Stack <T> {
  private DoublyLinkedList<T> list;
  public Stack(T element) {
    list = new DoublyLinkedList<>();
    list.addLast(element);
  }

  public Stack(){
    this.list = new DoublyLinkedList<>();
  }

  public int size() {
    return this.list.size();
  }

  public boolean isEmpty() {
    return this.list.isEmpty();
  }

  public void push(T element) {
    this.list.addLast(element);
  }

  public T peek() {
    return this.list.getTail().data;
  }

  public T pop() {
    if (this.list.isEmpty()) throw new RuntimeException("empty list");
    return this.list.removeLast();
  }

}
