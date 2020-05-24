package TwoPoniters;

public class SortColor {
  public void sortColors(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    int count_one = 0;
    int count_zero = 0;
    for (int i = 0; i < n; i++) {
      if (nums[i] == 0) count_zero += 1;
      if (nums[i] == 1) count_one += 1;
    }
    for (int j = 0; j < n; j++) {
      if (j < count_zero) {
        nums[j] = 0;
      } else if (j < (count_zero + count_one)) nums[j] = 1;
      else nums[j] = 2;
    }
  }
}
