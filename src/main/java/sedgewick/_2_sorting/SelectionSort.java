package sedgewick._2_sorting;

/**
 * 선택 정렬.
 * 길이 N인 배열에 대해 ~N^2 / 2 번의 비교와 N 번의 교환을 수행한다.
 */
public class SelectionSort {
  /**
   * 선택 정렬 알고리즘을 사용해 a를 오름차순으로 정렬한다.
   *
   * @param a 정렬 대상 배열
   */
  public static void sort(int[] a) {
    final int n = a.length;
    for (int i = 0; i < n; i++) {
      // 가장 작은 항목의 인덱스를 찾는다
      int min = i;
      for (int j = i + 1; j < n; j++) {
        if (a[j] < a[min]) {
          min = j;
        }
      }
      // 인덱스의 앞부분부터 가장 작은 항목으로 바꿔 나간다
      int temp = a[i];
      a[i] = a[min];
      a[min] = temp;
    }
  }
}
