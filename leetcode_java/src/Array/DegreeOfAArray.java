package Array;

import java.util.Collections;
import java.util.HashMap;

public class DegreeOfAArray {
  public int findShortestSubArray(int[] nums) {
    int ans = nums.length;
    HashMap<Integer, Integer> left = new HashMap<>(), right = new HashMap<>(), count = new HashMap<>();
    for (int i = 0; i < ans; i++) {
      int x = nums[i];
      if (left.get(x) == null) left.put(x, i);
      right.put(x, i);
      count.put(x, count.getOrDefault(x, 0) + 1);
    }
    int degree = Collections.max(count.values());
    for (int x : count.keySet()) {
      if (count.get(x) == degree) {
        ans = Math.min(ans, right.get(x) - left.get(x) + 1);
      }
    }

    return ans;
  }
}


