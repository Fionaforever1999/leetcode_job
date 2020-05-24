package TwoPoniters;

public class RemoveDuplicateFromSortedArrayII {
  public int removeDuplicates(int[] nums) {
    int fast = 1;
    int slow = 0;
    int count = 1; // count times
    int max = 2;// one number can show how many times
    for (; fast < nums.length; fast++) {
      if (nums[slow] != nums[fast]) {
        slow++;//move slow to next
        nums[slow] = nums[fast];// the next is equal to fast point
        count = 1; // set count as 1
      } else {
        if (count < max) {
          count++;//make sure the max number
          slow++;
          nums[slow] = nums[fast];
        }
      }
    }
    return slow + 1;
  }
}
