package sedgewick._1_fundamentals.example;

public class ThreeSum {

  /**
   * 합계가 0이 되는 트리플을 카운팅하여 리턴한다.
   *
   * @param numbers 입력 숫자 배열
   * @return
   */
  public static int count(int[] numbers) {
    int N = numbers.length;
    int cnt = 0;
    for (int i = 0; i < N; i++) {
      for (int j = i + 1; j < N; j++) {
        for (int k = j + 1; k < N; k++) {
          // 이 if 구문은 정확히 N(N-1)(N-2)/6 회 실행된다.
          if (numbers[i] + numbers[j] + numbers[k] == 0) {
            cnt++;
          }
        }
      }
    }
    return cnt;
  }
}
