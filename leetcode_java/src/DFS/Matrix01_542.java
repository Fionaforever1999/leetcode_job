package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class Matrix01_542 {
  int[] dir = {0, 1, 0, -1, 0};

  public int[][] updateMatrix(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    Queue<int[]> queue = new LinkedList<>();
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] != 0) matrix[i][j] = -1;
        else queue.add(new int[]{i, j});
      }
    }
    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = cur[0] + dir[i];
        int ny = cur[1] + dir[i + 1];
        if (nx < row && nx >= 0 && ny < col && ny >= 0 && matrix[nx][ny] == -1) {
          queue.add(new int[]{nx, ny});
          matrix[nx][ny] = matrix[cur[0]][cur[1]] + 1;
        }
      }
    }
    return matrix;
  }

}
