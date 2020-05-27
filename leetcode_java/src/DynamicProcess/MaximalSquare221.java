package DynamicProcess;
// similar with 1277
public class MaximalSquare221 {
  public int maximalSquare(char[][] matrix) {
    if (matrix.length == 0 || matrix[0].length == 0) return 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];
    int maxRes = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (matrix[i][j] == '1') {
          // 当坐标为两边的点时设置为1
          if (i == 0 || j == 0) dp[i][j] = 1;
            // Math.max 只能取两个数字之间最大值
          else dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
        maxRes = Math.max(maxRes, dp[i][j]);
      }
    }
    return maxRes * maxRes;
  }
}
