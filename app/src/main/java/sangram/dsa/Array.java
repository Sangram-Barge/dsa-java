package sangram.dsa;

import java.util.Iterator;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class Array <T> implements Iterable <T> {
  private int capacity;
  private int length;
  private T[] arr;

  public Array(int capacity) {
    this.capacity = capacity;
    this.length = 0;
    this.arr = (T[]) new Object[capacity];
  }

  public int size() {
    return this.length;
  }
  
  public boolean isEmpty() {
    return length == 0;
  }

  public T get(int idx) {
    return arr[idx];
  }

  public void set(int idx, T val) {
    arr[idx] = val;
    length++;
  }

  public void clear() {
    for (int i=0; i<capacity; i++) 
      arr[i] = null;
    this.length = 0;
  }

  public void add(T element) {
    if (length+1 >= capacity) {
      capacity *= 2;
      T[] tempArr = (T[]) new Object[capacity];
      for (int i = 0; i < this.length; i++) tempArr[i] = arr[i];
      arr = tempArr;
    }
    arr[length++] = element;
  }

  public void removeAt(int index) {
    if (index < 0 || index > capacity || index > length) throw new IllegalArgumentException("invalid index");
    for (int i = index + 1; i < length; i++) arr[i - 1] = arr[i];
    length--;
  }

  public boolean remove(T elem) {
    if (Objects.isNull(elem)) throw new IllegalArgumentException("null object");
    for (int i = 0; i < length; i++) 
      if (arr[i].equals(elem)) {
        removeAt(i);
        return true;
      }
    return false;
  }
  
  public int indexOf(T elem) {
    for (int i = 0; i < this.length; i++) if (arr[i].equals(elem)) return i;
    return -1;
  }

  public boolean contains(T elem) {
    return indexOf(elem) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int idx = 0;
      public boolean hasNext(){
        return idx < length;
      }
      public T next() {
        return arr[idx++];
      }
    };
  }
}
