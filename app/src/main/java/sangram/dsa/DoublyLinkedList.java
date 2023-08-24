package sangram.dsa;

@SuppressWarnings("hiding")
public class DoublyLinkedList<T> {
  class Node <T> {
    Node(T data, Node <T> next, Node <T> prev) {
      this.data = data;
      this.next = next;
      this.prev = prev;
    }

    Node<T> prev;
    Node<T> next;
    T data;
  }
  private Integer size = 0;
  private Node<T> head;
  private Node<T> tail;

  public DoublyLinkedList() {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public Integer size() {
    return this.size;
  }
  
  public T addLast(T data) {
    if (this.isEmpty()) this.head = this.tail = new Node<T>(data, null, null);
    else {
      this.tail.next = new Node<T>(data, null, this.tail);
      this.tail = this.tail.next;
    }
    size++;
    return data;
  }

  public T add(T data) {
    return addLast(data);
  }
 
  public T addFirst(T data) {
    if (this.isEmpty()) this.head = this.tail = new Node<T>(data, null, null);
    else {
      this.head.prev = new Node<T>(data, this.head, null);
      head = head.prev;
    }
    size++;
    return data;
  }

  public T peekFirst() {
    if (isEmpty()) throw new RuntimeException("list is empty");
    return this.head.data;
  }

  public T peekLast() {
    if (isEmpty()) throw new RuntimeException("list is empty");
    return this.tail.data;
  }
 
  public T removeFirst() {
    if (this.isEmpty()) throw new RuntimeException("list is empty");
    T data = this.head.data;
    this.head = this.head.next;
    size--;
    if (this.isEmpty()) this.tail = null;
    else this.head.prev = null;
    return data;
  }
  
  public T removeLast() {
    if (isEmpty()) throw new RuntimeException("list is empty");
    T data = this.tail.data;
    this.tail = this.tail.prev;
    size--;

    if(isEmpty()) this.head = null;
    else tail.next = null;
    return data;
  }

  public T removeNode(Node<T> n) {
    if (n.prev == null) return removeFirst();
    if (n.next == null) return  removeLast();
    n.next.prev = n.prev;
    n.prev.next = n.next;
    n.prev = n.next = null;
    T data = n.data;
    n.data = null;
    size--;
    return data;
  }
 
  public void setSize(Integer size) {
    this.size = size;
  }
  public Node<T> getHead() {
    return head;
  }
  public void setHead(Node<T> head) {
    this.head = head;
  }
  public Node<T> getTail() {
    return tail;
  }
  public void setTail(Node<T> tail) {
    this.tail = tail;
  }

  public void print() {
    Node<T> trav = head;
    while(trav != null) {
      System.out.println(trav.data);
      trav = trav.next;
    }
  }
}