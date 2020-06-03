package BinarySearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight {
  List<Integer> psum = new ArrayList<>();
  int trot;
  Random rand = new Random();

  public RandomPickWithWeight(int[] w) {
    trot = 0;
    for (int i : w) {
      trot += i;
      psum.add(trot);
    }
  }

  public int pickIndex() {
    int target = rand.nextInt(trot);
    int lo = 0, hi = psum.size() - 1;
    while (lo != hi) {
      int mid = (lo + hi) / 2;
      if (psum.get(mid) <= target) {
        lo = mid + 1;
      } else hi = mid;
    }
    return lo;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

