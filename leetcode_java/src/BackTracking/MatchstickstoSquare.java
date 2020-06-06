package BackTracking;

import java.util.Arrays;

public class MatchstickstoSquare {
  public boolean ans = false;

  public boolean makesquare(int[] nums) {
    if (nums.length == 0) return false;
    int len = nums.length;
    int sum = 0;
    for (int i = 0; i < len; i++) {
      sum += nums[i];
    }
    if (sum % 4 != 0) return false;
    int limit = sum / 4;
    for (int i : nums) {
      if (i > limit) return false;
    }
    Arrays.sort(nums);
    backTracking(len - 1, nums, limit, new int[4]);
    return ans;


  }

  public void backTracking(int len, int[] nums, int limit, int[] temp) {
    // limit表示一条边能够容纳的最大长度
    if (ans) return;
    if (len == -1) {
      // 到达最后
      for (int i : temp) {
        // 如果有一条边超过了最大值 剪枝
        if (i != limit) return;
      }
      ans = true;
      return;
    }
    for (int i = 0; i < temp.length; i++) {
      int last = temp[i];
      temp[i] += nums[len];
      if (temp[i] <= limit) {
        backTracking(len - 1, nums, limit, temp);
      }
      temp[i] = last;
    }

  }
}
