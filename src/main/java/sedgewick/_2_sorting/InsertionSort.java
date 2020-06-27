package sedgewick._2_sorting;

/**
 * 삽입 정렬.
 * 길이 N인 배열에 대해 ~ N^2 / 2 번의 비교와 ~ N^2 / 2 번의 교환을 수행한다.
 * 최적의 조건에서는 N-1 번의 비교, 0 번의 교환을 수행한다.
 */
public class InsertionSort {

  /**
   * 삽입 정렬 알고리즘을 사용해 a를 오름차순으로 정렬한다.
   *
   * @param a 정렬 대상 배열
   */
  public static void sort(int[] a) {
    final int size = a.length;
    for (int i = 1; i < size; i++) {
      for (int j = i; j > 0 && a[j] < a[j - 1]; j--) {
        final int temp = a[j];
        a[j] = a[j-1];
        a[j-1] = temp;
      }
    }
  }
}
