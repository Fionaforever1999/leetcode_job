package TwoPoniters;

public class RemoveDuplicateFromSortedArray {
  public int removeDuplicates(int[] nums) {
    int i = 0, j = 1;
    while (j < nums.length) {
      if (nums[j] == nums[i]) {
        j++;
      } else {
        i++;
        nums[i] = nums[j];
        j++;
      }
    }
    return i + 1;
  }
}
