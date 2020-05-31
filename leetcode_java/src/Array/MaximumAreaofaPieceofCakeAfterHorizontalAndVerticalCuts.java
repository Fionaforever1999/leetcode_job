package Array;

import java.util.Arrays;

public class MaximumAreaofaPieceofCakeAfterHorizontalAndVerticalCuts {
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    int hor = 0;
    int ver = 0;
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    long maxh = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
    long maxv = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

    for (int i = 1; i < horizontalCuts.length; i++) {
      maxh = Math.max(maxh, horizontalCuts[i] - horizontalCuts[i - 1]);
    }
    for (int j = 1; j < verticalCuts.length; j++) {
      maxv = Math.max(maxv, verticalCuts[j] - verticalCuts[j - 1]);
    }
    long mod = (long) Math.pow(10, 9) + 7;
    return (int) ((maxh * maxv) % mod);
  }
}
