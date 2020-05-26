package Array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
  public List<Integer> spiralOrder(int[][] matrix) {
    List ans = new ArrayList();
    if (matrix.length == 0) return ans;
    int row = matrix.length;
    int col = matrix[0].length;
    int[] d_row = {0, 1, 0, -1};
    int[] d_col = {1, 0, -1, 0};
    boolean[][] seen = new boolean[row][col];
    int r = 0, c = 0, di = 0, cc = 0, cr = 0;

    for (int i = 0; i < row * col; i++) {
      ans.add(matrix[r][c]);
      seen[r][c] = true;
      // cr and cc is the next step
      cr = r + d_row[di];
      cc = c + d_col[di];
      if (cc >= 0 && cc < col && cr >= 0 && cr < row && !seen[cr][cc]) {
        r = cr;
        c = cc;
      } else {
        // change direction
        di = (di + 1) % 4;
        c += d_col[di];
        r += d_row[di];
      }
    }
    return ans;
  }
}
