package DynamicProcess;

public class InterleavingString97 {
  public boolean isInterleave(String s1, String s2, String s3) {
    int len1 = s1.length();
    int len2 = s2.length();
    boolean dp[] = new boolean[len2 + 1];
    if (len1 + len2 != s3.length()) return false;
    for (int i = 0; i <= len1; i++) {
      for (int j = 0; j <= len2; j++) {
        if (i == 0 && j == 0) dp[j] = true; // 在这里定义是为了在每次循环中 后面的下标不越界
        else if (i == 0) dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        else if (j == 0) dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i - 1);
        else {
          dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(j + i - 1) || dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        }
      }
    }
    return dp[len2];
  }
}
