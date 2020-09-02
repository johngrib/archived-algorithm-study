package meenakshi._2_2;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("역 사이 최소 비용 계산기")
class MinimumTicketPriceCalculatorTest {

  @Value
  @RequiredArgsConstructor(staticName = "of")
  static class StationFact {
    int start;
    int destination;
    int expectPrice;
  }

  @Nested
  @DisplayName("요금표가 주어졌을 때")
  class ContextWithGivenStations {
    // i 역에서 j 역까지의 요금
    final int[][] cost = new int[][] {
        new int[] {0, 10, 75, 94},
        new int[] {-1, 0, 35, 50},
        new int[] {-1, -1, 0, 80},
        new int[] {-1, -1, -1, 0},
    };

    private int subject(StationFact fact) {
      final var calculator = new RecursiveMinimumTicketPriceCalculator();
      calculator.setCost(cost);
      return calculator.minCost(fact.start, fact.destination);
    }

    @Nested
    @DisplayName("재귀적 계산기는")
    class ContextWithRecursiveCalculator {
      @Nested
      @DisplayName("출발역과 도착역이 같다면")
      class ContextWithSameStations {
        final List<StationFact> givenFacts = List.of(
            StationFact.of(0, 0, 0),
            StationFact.of(1, 1, 0),
            StationFact.of(2, 2, 0),
            StationFact.of(3, 3, 0)
        );

        @Test
        @DisplayName("0원을 리턴한다")
        void it_returns_min_price() {
          for (var fact : givenFacts) {
            Assertions.assertEquals(0, subject(fact));
          }
        }
      }

      @Nested
      @DisplayName("같지 않은 출발역과 도착역이 주어지면")
      class ContextWithSameStationss {
        final List<StationFact> givenFacts = List.of(
            StationFact.of(0, 1, 10),
            StationFact.of(0, 2, 10 + 35),
            StationFact.of(0, 3, 10 + 50),
            StationFact.of(1, 2, 35)
        );

        @Test
        @DisplayName("최소 비용을 계산해 리턴한다")
        void it_returns_min_price() {
          for (var fact : givenFacts) {
            Assertions.assertEquals(fact.expectPrice, subject(fact));
          }
        }
      }
    }
  }
}
