package sedgewick._2_sorting;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("MergeSort")
class MergeSortTest {
  private final MergeSort mergeSort = new MergeSort();

  @Nested
  @DisplayName("merge 메소드는")
  class Describe_merge {
    @Nested
    @DisplayName("두 개의 정렬된 서브 배열이 포함된 배열과, 두 서브 배열의 경계값이 주어지면")
    class Context_with_sorted_two_sub_arrays {
      final int[] givenArray = new int[] {
          2, 6, 8,  // sub array 1
          3, 7      // sub array 2
      };
      final int sub1start = 0;  // 2의 인덱스
      final int mid = 2;        // 8의 인덱스
      final int sub2end = 4;    // 7의 인덱스

      @Test
      @DisplayName("두 서브 배열을 병합한다")
      void it_merges_sub_arrays() {
        mergeSort.merge(givenArray, sub1start, mid, sub2end);

        assertArrayEquals(new int[] {2, 3, 6, 7, 8}, givenArray);
      }
    }
  }
}