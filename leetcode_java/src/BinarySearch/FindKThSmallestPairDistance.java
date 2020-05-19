package BinarySearch;

import java.util.Arrays;

public class FindKThSmallestPairDistance {

  public int smallestDistancePair(int[] nums, int k) {
    //数组排序
    Arrays.sort(nums);
    int n = nums.length;
    int lo = 0;
    int hi = nums[n - 1] - nums[0];
    while (lo <= hi) {
      int count = 0;
      int j = 0;// index
      int m = lo + (hi - lo) / 2;
      for (int i = 0; i < n; i++) {
        while (j < n && nums[j] - nums[i] <= m) ++j;
        count += j - i - 1;
      }
      if (count >= k) {
        hi = m - 1;
      } else lo = m + 1;
    }
    return lo;
  }
}
