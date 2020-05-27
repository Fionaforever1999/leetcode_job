package DynamicProcess;

import java.util.List;

public class Triangle120 {
  public int minimumTotal(List<List<Integer>> triangle) {
    int rows = triangle.size();
    int cols = triangle.get(rows - 1).size();
    int[][] dp = new int[rows][cols];
    dp[0][0] = triangle.get(0).get(0);
    for (int row = 1; row < rows; row++) {
      int col = 0;
      List<Integer> curTri = triangle.get(row);
      int size = curTri.size();
      dp[row][col] = dp[row - 1][col] + curTri.get(col);
      col++; // ++ 的原因是下面的循环需要从1 开始
      for (; col < size - 1; col++) {
        dp[row][col] = Math.min(dp[row - 1][col - 1], dp[row - 1][col]) + curTri.get(col);
      }
      dp[row][col] = dp[row - 1][col - 1] + curTri.get(col);
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < cols; i++) {
      min = Math.min(min, dp[rows - 1][i]);
    }
    return min;
  }
}
