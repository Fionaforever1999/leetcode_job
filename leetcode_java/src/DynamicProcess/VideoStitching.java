package DynamicProcess;

public class VideoStitching {
  public int videoStitching(int[][] clips, int T) {
    int kinf = 101;
    int[][] dp = new int[T + 1][T + 1];
    for (int m = 0; m < T + 1; m++) {
      for (int n = 0; n < T + 1; n++) {
        dp[m][n] = kinf;
      }
    }

    for (int[] nums : clips) {
      int s = nums[0];
      int e = nums[1];
      for (int l = 1; l <= T; l++) {
        for (int i = 0; i <= T - l; i++) {
          int j = i + l;
          if (s > j || e < i) continue;
          if (s <= i && e >= j) dp[i][j] = 1;
          else if (e >= j) dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1);
          else if (s <= i) dp[i][j] = Math.min(dp[i][j], dp[e][j] + 1);
          else {
            dp[i][j] = Math.min(dp[i][j], dp[i][s] + 1 + dp[e][j]);
          }
        }
      }
    }
    return dp[0][T] == kinf ? -1 : dp[0][T];
  }
}
