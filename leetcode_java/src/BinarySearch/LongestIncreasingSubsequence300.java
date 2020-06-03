package BinarySearch;

public class LongestIncreasingSubsequence300 {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) return 0;
    int maxans = 0;
    int[] dp = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int maxval = 0;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j])
          maxval = Math.max(maxval, dp[j]);
      }
      dp[i] = maxval + 1;
      maxans = Math.max(maxans, dp[i]);
    }
    return maxans;
  }
}
