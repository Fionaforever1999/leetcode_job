package TwoPoniters;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections986 {
  public int[][] intervalIntersection(int[][] A, int[][] B) {
    int lenA = A.length;
    int lenB = B.length;
    int i = 0, j = 0;
    List<int[]> ans = new ArrayList<>();

    while (i < lenA && j < lenB) {
      int max = Math.max(A[i][0], B[j][0]);
      int min = Math.min(A[i][1], B[j][1]);
      if (max <= min) ans.add(new int[]{max, min});

      if (A[i][1] < B[j][1]) i++;
      else j++;
    }
    return ans.toArray(new int[ans.size()][]);
  }
}
