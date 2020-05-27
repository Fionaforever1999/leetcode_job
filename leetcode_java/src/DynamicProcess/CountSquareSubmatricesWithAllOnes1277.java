package DynamicProcess;

public class CountSquareSubmatricesWithAllOnes1277 {
  public int countSquares(int[][] matrix) {
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] dp = new int[row][col];
    // HashMap<Integer, Integer> res = new HashMap<>();
    int ans = 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (i == 0 || j == 0) dp[i][j] = matrix[i][j];
        else if (matrix[i][j] == 0) dp[i][j] = 0;
        else {
          dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
        }
        ans += dp[i][j];
      }
    }
    return ans;
  }
}
