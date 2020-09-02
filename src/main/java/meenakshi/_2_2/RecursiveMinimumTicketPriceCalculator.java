package meenakshi._2_2;

import lombok.Setter;

/**
 * 역 사이 최소 비용 계산기.
 */
public class RecursiveMinimumTicketPriceCalculator {
  @Setter
  private int cost[][];

  /**
   * 출발역에서 도착역까지의 최소 요금을 계산해 리턴합니다.
   *
   * @param s 출발역 인덱스
   * @param d 도착역 인덱스
   * @return 출발역에서 도착역까지의 최소 요금
   */
  public int minCost(int s, int d) {
    if (s == d || s == d - 1) {
      return cost[s][d];
    }
    int minValue = cost[s][d];

    for (int i = s + 1; i < d; i++) {
      // s 역에서 i 역까지의 최소 요금과 i 역에서 d 역까지 최소 요금의 합
      int temp = minCost(s, i) + minCost(i, d);
      if (temp < minValue) {
        minValue = temp;
      }
    }
    return minValue;
  }
}
