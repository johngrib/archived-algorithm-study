package sedgewick._1_fundamentals._1_5_unionfind;

/**
 * 알고리즘 1.5 유니온-파인드 구현. 220쪽.
 */
public class UnionFind {
  private int[] id;   // 컴포넌트 식별자를 저장
  private int count;  // 컴포넌트 개수

  public UnionFind(int count) {
    this.count = count;
    id = new int[count];
    for (int i = 0; i < count; i++) {
      id[i] = i;
    }
  }

  public int count() {
    return count;
  }

  public boolean connected(int p, int q) {
    return find(p) == find(q);
  }

  public int find(int p) {
    return id[p];
  }

  /** p와 q를 같은 컴포넌트에 속하게 한다. */
  public void union(int p, int q) {
    int pID = find(p);
    int qID = find(q);

    if (pID == qID) {
      // p, q 가 같은 컴포넌트에 속해 있다면 아무것도 하지 않는다.
      return;
    }

    for (int i = 0; i < id.length; i++) {
      // p 가 속한 컴포넌트가 q 에 통합된다.
      if (id[i] == pID) {
        id[i] = qID;
      }
    }
    // p와 q가 같은 컴포넌트에 속하게 되면 컴포넌트 수는 1개 줄어들게 된다.
    count--;
  }
}
