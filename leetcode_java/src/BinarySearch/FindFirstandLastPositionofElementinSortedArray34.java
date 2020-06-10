package BinarySearch;

public class FindFirstandLastPositionofElementinSortedArray34 {
  public int[] searchRange(int[] nums, int target) {
    boolean flag = false;
    int start = -1;
    int end = -1;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == target && flag == false) {
        flag = true;
        start = i;
      } else if (nums[i] == target && flag == true) {
        end = i;
      }
    }
    if (end == -1 && start != -1) {
      return new int[]{start, start};
    }
    return new int[]{start, end};
  }
}
