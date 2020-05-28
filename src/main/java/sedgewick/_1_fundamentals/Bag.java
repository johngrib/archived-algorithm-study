package sedgewick._1_fundamentals;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {
  private Node first;

  private class Node {
    T item;
    Node next;
  }

  public void add(T item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
  }

  @Override
  public Iterator<T> iterator() {
    return null;
  }

  private class ListIterator implements Iterator<T> {
    private Node current = first;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T item = current.item;
      current = current.next;
      return item;
    }
  }
}
