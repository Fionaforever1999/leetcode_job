package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridges {
  // queue 标记坐标
  private Queue<int[]> queue;
  // 是否找到
  private boolean found = false;

  public int shortestBridge(int[][] A) {
    queue = new LinkedList<>();
    int row = A.length;
    int col = A[0].length;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        // 遍历 行列 找到第一个小岛 将第一个小岛周围标记为2
        if (A[i][j] == 1) {
          dfs(A, i, j, queue);
          found = true;
          break;
        }
      }
      if (found) break;//跳出循环 否则会找到第二个岛
    }
    // BFS 向外扩展 当遇到第二个岛 走过的step 也就是层数
    int step = 0;
    int[] dir = new int[]{0, 1, 0, -1, 0};
    while (!queue.isEmpty()) {
      //按层扩展每层走一步
      int size = queue.size();
      while (size-- > 0) {
        // System.out.println(queue.peek()[0]);
        int[] temp = queue.poll();

        int x = temp[0];
        int y = temp[1];

        for (int i = 0; i < 4; i++) {
          int tx = x + dir[i];
          int ty = y + dir[i + 1];
          if (tx < 0 || ty < 0 || tx >= A.length || ty >= A[0].length || A[tx][ty] == 2) continue;
          if (A[tx][ty] == 1) return step;
          A[tx][ty] = 2;
          queue.offer(new int[]{tx, ty});
        }
      }
      ++step;
    }
    return -1;

  }

  public void dfs(int[][] A, int i, int j, Queue<int[]> queue) {
    if (i < 0 || j < 0 || i >= A.length || j >= A[0].length || A[i][j] != 1) {
      return;
    }
    A[i][j] = 2;

    queue.offer(new int[]{i, j});
    dfs(A, i - 1, j, queue);
    dfs(A, i + 1, j, queue);
    dfs(A, i, j - 1, queue);
    dfs(A, i, j + 1, queue);
  }
}
