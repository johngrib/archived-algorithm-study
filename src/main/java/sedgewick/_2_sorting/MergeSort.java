package sedgewick._2_sorting;

/**
 * 병합 정렬.
 */
public class MergeSort {
  private int[] aux;

  /**
   * 주어진 a 배열을 정렬한다.
   */
  void topDownMergeSort(int[] a) {
    aux = new int[a.length];
    topDownMergeSort(a, 0, a.length - 1);
  }

  /**
   * 주어진 a 배열의 a[lo..hi] 구간을 정렬한다.
   *
   * @param a  배열
   * @param lo 정렬 대상 시작 인덱스
   * @param hi 정렬 대상 마지막 인덱스
   */
  void topDownMergeSort(int[] a, int lo, int hi) {
    if (hi <= lo) {
      return;
    }
    int mid = lo + (hi - lo) / 2;
    topDownMergeSort(a, lo, mid);     // 왼쪽 절반 정렬
    topDownMergeSort(a, mid + 1, hi); // 오른쪽 절반 정렬
    merge(a, lo, mid, hi);            // 결과 병합
  }

  /**
   * 주어진 a 배열을 정렬한다.
   */
  void bottomUpMergeSort(int[] a) {
    int N = a.length;
    aux = new int[N];
    for (int size = 1; size < N; size = size + size) {
      // size: 서브 배열의 크기
      for (int lo = 0; lo < N - size; lo += size + size) {
        // lo: 서브 배열의 인덱스
        merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
      }
    }
  }

  /**
   * 주어진 a 배열의 sub 배열 a[lo..mid]와 sub 배열 a[mid+1..hi]를 병합합니다.
   *
   * @param a   배열
   * @param lo  첫번째 sub 배열 시작 인덱스
   * @param mid 첫번째 sub 배열 마지막 인덱스
   * @param hi  두번째 sub 배열 마지막 인덱스
   */
  void merge(int[] a, int lo, int mid, int hi) {
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
