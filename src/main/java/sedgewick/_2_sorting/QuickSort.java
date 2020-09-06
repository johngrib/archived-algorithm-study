package sedgewick._2_sorting;

import java.util.Arrays;
import java.util.Collections;

public class QuickSort {
  /**
   * 주어진 배열을 정렬합니다.
   *
   * @param array 정렬 대상 배열
   */
  public static void sort(Comparable[] array) {
    // 입력 특성에 대한 종속성을 제거한다.
    Collections.shuffle(Arrays.asList(array));
    sort(array, 0, array.length -1);
  }

  /**
   * 주어진 배열의 부분 집합을 정렬합니다.
   *
   * @param array 전체 배열
   * @param left 정렬 대상 부분 집합의 시작 인덱스
   * @param right 정렬 대상 부분 집합의 마지막 인덱스
   */
  private static void sort(Comparable[] array, int left, int right) {
    if (right <= left) {
      return;
    }
    // 분할해 정렬한 다음, 새로운 기준을 얻는다.
    final int j = partition(array, left, right);
    sort(array, left, j -1 ); // 새로운 기준의 왼쪽 배열을 정렬한다.
    sort(array, j+1 , right); // 새로운 기준의 오른쪽 배열을 정렬한다.
  }

  /**
   * 배열의 부분 집합을 분할해 정렬하고, 분할 인덱스를 리턴한다.
   *
   * @param array 전체 배열
   * @param left 정렬 대상 부분 집합(왼쪽) 시작 인덱스
   * @param right 정렬 대상 부분 집합(오른쪽) 마지막 인덱스
   * @return
   */
  private static int partition(Comparable[] array, int left, int right) {
    int i = left;     // i 는 왼쪽부터 시작
    int j = right+1;  // j 는 오른쪽부터 시작
    final Comparable v = array[left];  // 기준: 가장 왼쪽 원소

    while (true) {
      // 기준보다 큰 원소를 찾는다
      while (less(array[++i], v)) {
        if (i == right) {
          break;
        }
      }
      // 기준보다 작은 원소를 찾는다
      while (less(v, array[--j])) {
        if (j == left) {
          break;
        }
      }
      if (i >= j) {
        break;
      }
      // 기준보다 큰 원소를 기준의 오른쪽으로 보내고,
      // 기준보다 작은 원소를 기준의 왼쪽으로 보낸다.
      exchange(array, i, j);
    }
    // i, j 가 만나면 기준을 왼쪽 부분의 마지막으로 옮긴다.
    // 이로 인해 기준 아이템 하나의 정렬이 완료된다. (기준 왼쪽은 모두 기준보다 작고, 기준 오른쪽은 모두 기준보다 크다)
    exchange(array, left, j);
    return j;
  }

  /**
   * 두 아이템의 위치를 교환한다.
   */
  private static void exchange(Comparable[] array, int i, int j) {
    Comparable temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  /**
   * a 가 b 보다 작다면 true를 리턴하고, 그 외의 경우 false를 리턴합니다.
   */
  private static boolean less(Comparable a, Comparable b) {
    return a.compareTo(b) < 0;
  }
}

