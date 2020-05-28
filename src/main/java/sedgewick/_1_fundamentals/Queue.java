package sedgewick._1_fundamentals;

import java.util.Iterator;

/**
 * 선입선출 큐.
 *
 * @param <T>
 */
public class Queue<T> implements Iterable<T> {
  private Node first; // 가장 오래전에 추가된 노드에 대한 링크
  private Node last;  // 가장 최근에 추가된 노드에 대한 링크
  private int N;    // 큐에 저장된 항목의 개수

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

  // 리스트의 마지막에 항목 추가
  public void enqueue(T item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;

    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    N++;
  }

  // 리스트의 처음에서 항목 삭제
  public T dequeue() {
    T item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) {
      last = null;
    }
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
