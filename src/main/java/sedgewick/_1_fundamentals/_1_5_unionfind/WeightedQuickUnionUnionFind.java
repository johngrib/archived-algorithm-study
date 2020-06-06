package sedgewick._1_fundamentals._1_5_unionfind;

/**
 * 알고리즘 1.5(계속) 유니온-파인드 구현(가중 퀵-유니온). 227쪽.
 */
public class WeightedQuickUnionUnionFind {
  private int[] id; // 부모 링크 (노드가 인덱스로 사용됨)
  private int[] sz; // 각 뿌리 노드가 속한 트리의 노드 개수(컴포넌트 크기. 노드가 인덱스로 사용됨)
  private int count;  // 컴포넌트 개수

  public WeightedQuickUnionUnionFind(int count) {
    this.count = count;
    id = new int[count];
    for (int i = 0; i < count; i++) {
      id[i] = i;
    }
    sz = new int[count];
    for (int i = 0; i < count; i++) {
      sz[i] = 1;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    // 부모를 탐색한다.
    while (p != id[p]) {
      p = id[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int i = find(p);
    int j = find(q);
    if (i == j) {
      // 두 노드의 루트 노드가 같다면 합치지 않아도 된다.
      return;
    }
    // 작은 트리의 뿌리가 큰 트리에 링크되도록 한다.
    if (sz[i] < sz[j]) {
      id[i] = j;
      sz[j] += sz[i];
    } else {
      id[j] = i;
      sz[i] += sz[j];
    }
    count--;
  }
}
