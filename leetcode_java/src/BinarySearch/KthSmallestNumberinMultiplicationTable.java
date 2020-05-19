package BinarySearch;

public class KthSmallestNumberinMultiplicationTable {

  public int findKthNumber(int m, int n, int k) {
    // 左闭右开二分搜索模板
    // 数组中利用binary search 解题
    int lo = 1, hi = m * n;
    while (lo < hi) {
      int x = lo + (hi - lo) / 2;
      if (lex(m, n, x) >= k) {
        hi = x;
      } else lo = x + 1;
    }
    return lo;
  }

  //找出这一行中小于x的数字数量
  public int lex(int m, int n, int x) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
      count += Math.min(n, x / i);
    }
    return count;
  }
}

