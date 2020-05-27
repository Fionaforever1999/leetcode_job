package BinarySearch;

public class KokoEatingBananas875 {
  public int minEatingSpeed(int[] piles, int H) {
    int lo = 1;
    int hi = 1_000_000_000;
    while (lo < hi) {
      int mid = (lo + hi) / 2;
      if (!possible(piles, H, mid)) {
        lo = mid + 1;
      } else hi = mid;
    }
    return lo;
  }

  public boolean possible(int[] piles, int H, int K) {
    int time = 0;
    for (int i : piles) {
      time += (i - 1) / K + 1;
    }
    return time <= H;
  }
}
