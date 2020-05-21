package BinarySearch;

public class findPeekElement {
  public int findPeakElement(int[] nums) {
    // for (int i = 0; i < nums.length - 1; i++) {
    //     if (nums[i] > nums[i + 1])
    //         return i;
    // }
    // return nums.length - 1;
    int start = 0;
    int end = nums.length-1;
    while(start<end){
      int mid = (start + end) /2;
      if(nums[mid] > nums[mid +1]){
        end = mid;
      }else {
        start = mid + 1;
      }
    }
    return start;
  }
}

