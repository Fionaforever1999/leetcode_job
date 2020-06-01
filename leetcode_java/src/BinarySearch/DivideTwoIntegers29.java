package BinarySearch;

public class DivideTwoIntegers29 {
  public int divide(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }
    if (dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }
    boolean negative;
    // 异或来计算符号是否相异
    negative = (dividend ^ divisor) < 0;
    long t = Math.abs((long) dividend); // 被除数
    long d = Math.abs((long) divisor); // 除数
    int result = 0;
    for (int i = 31; i >= 0; i--) {
      if ((t >> i) >= d) {
        // 如果被除数 除以 2的i次方 大于等于 除数
        result += 1 << i;
        t -= d << i;
        // 这里的 <<i和 >>i 表示向前移i位 也就是 *2^i 和 /2^i
      }
    }
    return negative ? -result : result;
  }
}
