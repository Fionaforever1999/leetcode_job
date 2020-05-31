package DFS;

import java.util.*;

public class CutOffTreesforGolfEvent {
  int[] dr = {0, 1, 0, -1, 0};

  public int cutOffTree(List<List<Integer>> forest) {
    List<int[]> trees = new ArrayList<>();

    int row = forest.size();
    int col = forest.get(0).size();
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        int v = forest.get(r).get(c);
        if (v > 1) {
          // 当遇到树时
          trees.add(new int[]{v, r, c});
        }
      }
    }
    // 利用Collection
    Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));
    //public static int compare(int x, int y) {
    //     return (x < y) ? -1 : ((x == y) ? 0 : 1);
    // }
    int ans = 0;
    int sr = 0, sc = 0;
    for (int[] tree : trees) {
      int dist = bfs(forest, sr, sc, tree[1], tree[2]);
      if (dist < 0) return -1;
      ans += dist;
      sr = tree[1];
      sc = tree[2];
    }
    return ans;
  }

  public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
    int row = forest.size();
    int col = forest.get(0).size();
    Queue<int[]> queue = new LinkedList<>();

    // queue存储 目的地的坐标以及到目标点的层次
    queue.add(new int[]{sr, sc, 0});
    // 判断是不是已经被遍历过
    boolean[][] seen = new boolean[row][col];
    seen[sr][sc] = true;
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      if (cur[0] == tr && cur[1] == tc) {
        // 找到最后的点
        return cur[2];
      }
      for (int i = 0; i < 4; i++) {
        int new_x = cur[0] + dr[i];
        int new_y = cur[1] + dr[i + 1];
        if (new_x >= 0 && new_y >= 0 && new_x < row && new_y < col && !seen[new_x][new_y] && forest.get(new_x).get(new_y) > 0) {
          queue.add(new int[]{new_x, new_y, cur[2] + 1});
          seen[new_x][new_y] = true;
        }
      }
    }
    return -1;
  }

}
