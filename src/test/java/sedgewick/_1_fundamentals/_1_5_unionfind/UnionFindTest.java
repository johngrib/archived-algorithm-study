package sedgewick._1_fundamentals._1_5_unionfind;

import static org.junit.jupiter.api.Assertions.*;


import java.util.List;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sedgewick._1_fundamentals._1_5_unionfind.UnionFind;

@DisplayName("UnionFind 클래스")
class UnionFindTest {

  @RequiredArgsConstructor
  private static class Pair {
    private final int p, q;

    private static Pair of(int p, int q) {
      return new Pair(p, q);
    }
  }

  final List<Pair> givenPairs = List.of(
      Pair.of(4, 3),
      Pair.of(3, 8),
      Pair.of(6, 5),
      Pair.of(9, 4),
      Pair.of(2, 1),
      Pair.of(5, 0),
      Pair.of(7, 2),
      Pair.of(6, 1),
      Pair.of(1, 0),
      Pair.of(6, 7)
  );

  @Test
  void test() {
    final int N = givenPairs.size();
    UnionFind uf = new UnionFind(N);

    for (Pair pair : givenPairs) {
      int p = pair.p;
      int q = pair.q;
      if (uf.connected(p, q)) {
        continue;
      }
      uf.union(p, q);
      System.out.println(p + " - " + q + " : connected");
    }
    assertEquals(2, uf.count());
  }
}