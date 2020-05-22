package UnionFind;

public class RegionsCutBySlash {
  public int regionsBySlashes(String[] grid) {
    int n = grid.length;
    DSU dsu = new DSU(4 * n * n); // 每个方块中包含的四种状态
    for (int row = 0; row < n; row++) {
      for (int col = 0; col < n; col++) {
        int index = 4 * (row * n + col);
        char val = grid[row].charAt(col);
        if (val == '/') {
          dsu.union(index + 0, index + 3);
          dsu.union(index + 1, index + 2);
        }
        if (val == '\\') {
          dsu.union(index + 0, index + 1);
          dsu.union(index + 2, index + 3);
        }
        if (val == ' ') {
          dsu.union(index + 0, index + 1);
          dsu.union(index + 1, index + 2);
          dsu.union(index + 2, index + 3);
        }
        if (row + 1 < n) {
          dsu.union(index + 2, index + 4 * n + 0);
        }
        if (col + 1 < n) {
          dsu.union(index + 1, index + 4 + 3);
        }
      }

    }
    int ans = 0;
    for (int m = 0; m < 4 * n * n; m++) {
      if (dsu.find(m) == m) {
        ans += 1;
      }
    }
    return ans;
  }
}

class DSU {
  public int[] parent;

  public DSU(int n) {
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }
  }

  public int find(int x) {
    if (parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    // 将y的root赋给 x的root
    parent[find(x)] = find(y);
  }
}
