package DynamicProcess;

public class UniquePaths62 {
  //https://leetcode.wang/leetCode-62-Unique-Paths.html
  public int uniquePaths(int m, int n) {
    int[] dp = new int[m];
    for (int i = 0; i < m; i++) {
      dp[i] = 1;
    }
    for (int i = n - 2; i >= 0; i--) {
      for (int j = m - 2; j >= 0; j--) {
        dp[j] = dp[j] + dp[j + 1];
      }
    }
    return dp[0];
  }
}
