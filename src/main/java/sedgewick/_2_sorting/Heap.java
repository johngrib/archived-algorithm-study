package sedgewick._2_sorting;

/**
 * 힙을 사용한 정렬. 힙 정렬.
 */
public class Heap {
  /**
   * 주어진 배열을 정렬한다.
   *
   * @param array 정렬 대상 배열
   */
  public static void sort(Comparable[] array) {
    final int n = array.length;

    for (int k = n / 2; k >= 1; k--) {
      sink(array, k, n);
    }

    int k = n;
    while (k > 1) {
      exchange(array, 1, k--);
      sink(array, 1, k);
    }
  }

  /**
   * k 인덱스 노드를 인덱스 n 지점까지 sink 시킨다.
   *
   * @param array 힙 노드가 보관되어 있는 배열
   * @param k     sink 대상 노드 인덱스
   * @param n     sink 대상이 되는 부분 힙의 경계 인덱스
   */
  private static void sink(Comparable[] array, int k, int n) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && less(array, j, j + 1)) {
        j++;
      }
      if (!less(array, k, j)) {
        break;
      }
      exchange(array, k, j);
      k = j;
    }
  }

  private static boolean less(Comparable[] array, int i, int j) {
    return array[i - 1].compareTo(array[j - 1]) < 0;
  }

  private static void exchange(Comparable[] array, int i, int j) {
    Comparable swap = array[i - 1];
    array[i - 1] = array[j - 1];
    array[j - 1] = swap;
  }
}
