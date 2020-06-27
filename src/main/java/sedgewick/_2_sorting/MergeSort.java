package sedgewick._2_sorting;

/**
 * 병합 정렬.
 */
public class MergeSort {

  /**
   * 주어진 a 배열의 sub 배열 a[lo..mid]와 sub 배열 a[mid+1..hi]를 병합합니다.
   *
   * @param a   배열
   * @param lo  첫번째 sub 배열 시작 인덱스
   * @param mid 첫번째 sub 배열 마지막 인덱스
   * @param hi  두번째 sub 배열 마지막 인덱스
   */
  void merge(int[] a, int lo, int mid, int hi) {
    int[] aux = new int[a.length];

    //  a[lo..hi]를 aux[lo..hi]에 복제
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo;       // sub 배열 1 인덱스
    int j = mid + 1;  // sub 배열 2 인덱스

    // 다시 a[lo..hi]로 병합
    for (int k = lo; k <= hi; k++) {
      if (i > mid) {
        // sub 배열 1 인덱스가 마지막까지 갔다면 sub 배열 2의 값을 선택해 넣는다
        a[k] = aux[j++];
      } else if (j > hi) {
        // sub 배열 2 인덱스가 마지막까지 갔다면 sub 배열 1의 값을 선택해 넣는다
        a[k] = aux[i++];
      } else if (aux[j] < aux[i]) {
        // 두 sub 배열 헤드 중 작은 값을 선택해 넣는다
        a[k] = aux[j++];
      } else {
        // 두 sub 배열 헤드 중 작은 값을 선택해 넣는다
        a[k] = aux[i++];
      }
    }
  }
}
