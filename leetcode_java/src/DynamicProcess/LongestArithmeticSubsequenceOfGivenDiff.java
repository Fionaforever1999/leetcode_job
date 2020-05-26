package DynamicProcess;

import java.util.HashMap;

public class LongestArithmeticSubsequenceOfGivenDiff {
  public int longestSubsequence(int[] arr, int difference) {
    HashMap<Integer, Integer> dp = new HashMap<>();
    int ans = 1;
    for (int num : arr) {
      int temp = dp.getOrDefault(num - difference, 0) + 1;
      dp.put(num, temp);
      ans = Math.max(temp, ans);
    }
    return ans;
  }
}
