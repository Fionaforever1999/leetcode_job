package BinarySearch;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class SwimInRisingWatter {
  // Dijkstra 解法1
  public int swimInWater(int[][] grid) {
    int n = grid.length;
    boolean visited[][] = new boolean[n][n];
    int res = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>((k1, k2) -> grid[k1 / n][k1 % n] - grid[k2 / n][k2 % n]);
    pq.offer(0);
    int[] dirs = {-1, 0, 1, 0, -1};
    while (!pq.isEmpty()) {
      int pos = pq.poll();
      int curX = pos / n;
      int curY = pos % n;
      res = Math.max(grid[curX][curY], res);
      if (curX == n - 1 && curY == n - 1) return res;
      for (int i = 0; i < 4; i++) {
        int x = curX + dirs[i];
        int y = curY + dirs[i + 1];
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] == true) continue;
        visited[x][y] = true;
        pq.offer(x * n + y);
      }
    }
    return -1;
  }

  //解法2 binary search
  public int swimInWaterII(int[][] grid) {
    int n = grid.length;
    int lo = grid[0][0], hi = n * n;


    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      if (!isPass(mid, grid)) {
        lo = mid + 1;
      } else hi = mid;
    }
    return hi; // it can be hi?
  }

  public boolean isPass(int T, int[][] grid) {
    int n = grid.length;
    Set<Integer> visited = new HashSet();
    visited.add(0);
    Stack<Integer> stack = new Stack();
    stack.add(0);
    int[] dirs = {-1, 0, 1, 0, -1};
    while (!stack.isEmpty()) {
      int wei = stack.pop();
      int x = wei / n, y = wei % n;
      if (x == n - 1 && y == n - 1) return true;
      for (int i = 0; i < 4; i++) {
        int new_x = x + dirs[i];
        int new_y = y + dirs[i + 1];
        int new_wei = new_x * n + new_y;
        if (new_x < n && new_y < n && new_x >= 0 && new_y >= 0 && grid[new_x][new_y] <= T && !visited.contains(new_wei)) {
          visited.add(new_wei);
          stack.add(new_wei);
        }
      }
    }
    return false;
  }
}
