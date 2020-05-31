package TwoPoniters;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class fourSums {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> res = new LinkedList<>();


    for (int j = 0; j < nums.length - 3; j++) {
      // 防止重复数字出现
      if (j == 0 || (j > 0 && nums[j] != nums[j - 1])) {
        for (int i = j + 1; i < nums.length - 2; i++) {
          //防止出现重复数字
          if (i == j + 1 || nums[i] != nums[i - 1]) {
            int sum = target - nums[i] - nums[j];
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
              if (nums[lo] + nums[hi] == sum) {
                res.add(Arrays.asList(nums[lo], nums[i], nums[j], nums[hi]));
                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                lo++;
                hi--;
              } else if (nums[lo] + nums[hi] > sum) {
                hi--;
              } else lo++;
            }
          }
        }
      }
    }
    return res;

  }
}

