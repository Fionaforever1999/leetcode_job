package BinarySearch;
/*
binary *************** important !!!!
 */

public class MinSizeSubarraySum {

  public int minSubArrayLen(int s, int[] nums) {
    int n = nums.length;
    if (n == 0) return 0;
    int[] sums = new int[n];
    sums[0] = nums[0];
    // create sums list represent the list of all sums
    for (int i = 1; i < n; i++) {
      sums[i] = sums[i - 1] + nums[i];
    }
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      int s2 = s - nums[i];
      int k = binarySearch(i, n - 1, sums, s2 + sums[i]);
      if (k != -1) {
        min = Math.min(min, k - i + 1);
      }
    }
    return min != Integer.MAX_VALUE ? min : 0;
  }

  public int binarySearch(int start, int end, int[] sums, int target) {
    int mid = -1;
    while (start <= end) {
      mid = (start + end) >>> 1;
      if (sums[mid] == target) return mid;
      else if (sums[mid] < target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return sums[mid] > target ? mid : -1;
  }
}
