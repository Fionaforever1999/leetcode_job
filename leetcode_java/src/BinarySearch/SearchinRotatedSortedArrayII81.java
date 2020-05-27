package BinarySearch;

public class SearchinRotatedSortedArrayII81 {
  public boolean search(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (target == nums[mid]) return true;
      if (nums[left] < nums[mid]) {
        // 说明左边是递增
        if (nums[left] <= target && nums[mid] > target) {
          // 说明target在left - mid之间
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else if (nums[mid] == nums[left]) {
        left++;
      }
      // 右边递增的情况
      else {
        if (nums[right] >= target && nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }
    return false;
  }
}
