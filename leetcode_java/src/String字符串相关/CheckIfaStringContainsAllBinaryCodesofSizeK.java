package String字符串相关;

import java.util.HashSet;
import java.util.Set;

public class CheckIfaStringContainsAllBinaryCodesofSizeK {
  public boolean hasAllCodes(String s, int k) {
    int left = 0;
    int right = k;
    int len = s.length();
    Set<String> set = new HashSet<>();
    while (right <= len) {
      // 取前不取后所以可以把值赋给 right
      set.add(s.substring(left, right));
      left++;
      right++;
    }
    // 当能够形成的不相等的字符串个数和 长度为 2 的二进制串 有2的k次方个 说明可以成立
    if (set.size() == Math.pow(2, k)) return true;
    else return false;

  }
}
