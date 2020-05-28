package sedgewick._1_fundamentals;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {
  private Node first; // 스택의 꼭대기 (가장 최근에 추가된 노드)
  private int N;      // 항목 개수

  private class Node {
    T item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return N;
  }

  public void push(T item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    N++;
  }

  public T pop() {
    T item = first.item;
    first = first.next;
    N--;
    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator();
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
