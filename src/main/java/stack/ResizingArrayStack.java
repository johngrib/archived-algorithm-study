package stack;

import java.util.Iterator;

/**
 * 후입선출(LIFO) 스택(배열 크기 변경 구현).
 *
 * @param <T>
 */
public class ResizingArrayStack<T> implements Iterable<T> {
  private T[] a = (T[]) new Object[1];
  private int N = 0;

  public boolean isEmpty() {
    return N == 0;
  }

  public int size() {
    return N;
  }

  private void resize(int max) {
    // 크기가 max인 새로운 배열로 스택을 이동한다.
    T[] temp = (T[]) new Object[max];
    for (int i = 0; i < N; i++) {
      temp[i] = a[i];
    }
    a = temp;
  }

  public void push(T item) {
    if (N == a.length) {
      resize(2 * a.length);
    }
    a[N++] = item;
  }

  public T pop() {
    N = N - 1;
    T item = a[N];
    a[N] = null;
    if (N > 0 && N == a.length / 4) {
      resize(a.length / 2);
    }
    return item;
  }

  @Override
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }

  private class ReverseArrayIterator implements Iterator<T> {
    private int i = N;

    @Override
    public boolean hasNext() {
      return i > 0;
    }

    @Override
    public T next() {
      i = i - 1;
      return a[i];
    }

    @Override
    public void remove() {

    }
  }
}
