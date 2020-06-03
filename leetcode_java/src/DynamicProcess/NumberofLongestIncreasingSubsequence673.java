package DynamicProcess;

import java.util.Arrays;
/*

这道题 不懂动态规划的意思！！！
 */

public class NumberofLongestIncreasingSubsequence673 {
  public int findNumberOfLIS(int[] nums) {
    if (nums.length == 0) return 0;
    int[] dp = new int[nums.length];
    // 相对于 300 题 多了一个数组来记录组合数
    int[] combination = new int[nums.length];
    Arrays.fill(dp, 1);
    Arrays.fill(combination, 1);
    int max = 1, res = 0;

    for (int i = 1; i < nums.length; i++) {

      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[j] + 1 > dp[i]) {
            // TODO 为什么这里dp[j] + 1 == dp[i] 就表示可以有多个解?
            dp[i] = dp[j] + 1;
            combination[i] = combination[j];
          } else if (dp[j] + 1 == dp[i]) {
            combination[i] += combination[j];
          }
        }
      }
      max = Math.max(max, dp[i]);
    }
    for (int i = 0; i < nums.length; i++) {
      if (dp[i] == max) res += combination[i];
    }
    return res;
  }
}
