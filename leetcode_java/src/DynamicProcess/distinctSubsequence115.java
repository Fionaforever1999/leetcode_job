package DynamicProcess;

public class distinctSubsequence115 {
  public int numDistinct(String s, String t) {
    int lenS = s.length();
    int lenT = t.length();

    int[][] dp = new int[lenT + 1][lenS + 1];
    for (int j = 0; j <= s.length(); j++) {
      dp[0][j] = 1;
    }
    for (int i = 1; i <= t.length(); i++) {
      for (int j = 1; j <= s.length(); j++) {
        if (t.charAt(i - 1) == s.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
        } else {
          dp[i][j] = dp[i][j - 1];
        }
      }
    }
    return dp[lenT][lenS];
  }
}
