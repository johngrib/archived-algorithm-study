package meenakshi._2_2;

import java.util.Objects;

/**
 * 역 사이 최소 비용 계산기(메모 전략 사용).
 */
public class MemoizeMinimumTicketPriceCalculator implements MinimumTicketPriceCalculator {
  private int cost[][];
  private int memo[][];

  @Override
  public void setCost(int[][] cost) {
    this.cost = cost;

    Objects.nonNull(cost);
    Objects.nonNull(cost[0]);
    this.memo = new int[cost.length][cost[0].length];
  }

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

    if (memo[s][d] == 0) {
      // 미리 계산된 값이 없다면, 새로 계산한다
      int minValue = cost[s][d];

      for (int i = s + 1; i < d; i++) {
        int temp = minCost(s, i) + minCost(i, d);
        if (temp < minValue) {
          minValue = temp;
        }
      }
      memo[s][d] = minValue;
    }
    return memo[s][d];
  }
}
