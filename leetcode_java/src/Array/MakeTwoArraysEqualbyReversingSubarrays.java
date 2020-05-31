package Array;

import java.util.Arrays;

public class MakeTwoArraysEqualbyReversingSubarrays {
  public boolean canBeEqual(int[] target, int[] arr) {
    int[] res = new int[1001];
    Arrays.fill(res, 0);
    for (int i = 0; i < target.length; i++) {
      res[target[i]]++;
      res[arr[i]]--;
    }
    for (int i = 1; i <= 1000; i++) {
      if (res[i] != 0) return false;
    }
    return true;
  }
}
