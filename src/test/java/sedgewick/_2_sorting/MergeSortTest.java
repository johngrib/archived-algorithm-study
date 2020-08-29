package sedgewick._2_sorting;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("MergeSort")
class MergeSortTest {
  @Nested
  @DisplayName("topDownMergeSort 메소드는")
  class Describe_topDownMergeSort {
    @Nested
    @DisplayName("정렬되지 않은 배열이 주어지면")
    class Context_with_unsorted_array {
      final int[] givenArray = new int[] {4, 2, 9, 187, 3, 5, 98};

      @Test
      @DisplayName("주어진 배열을 정렬한다")
      void it_sorts_array() {
        new MergeSort().topDownMergeSort(givenArray);

        for (int i = 1; i < givenArray.length; i++) {
          assertTrue(givenArray[i - 1] < givenArray[i]);
        }
      }
    }
  }

  @Nested
  @DisplayName("bottomUpMergeSort 메소드는")
  class Describe_bottomUpMergeSort {
    @Nested
    @DisplayName("정렬되지 않은 배열이 주어지면")
    class Context_with_unsorted_array {
      final int[] givenArray = new int[] {4, 2, 9, 187, 3, 5, 98};

      @Test
      @DisplayName("주어진 배열을 정렬한다")
      void it_sorts_array() {
        new MergeSort().bottomUpMergeSort(givenArray);

        for (int i = 1; i < givenArray.length; i++) {
          assertTrue(givenArray[i - 1] < givenArray[i]);
        }
      }
    }
  }
}