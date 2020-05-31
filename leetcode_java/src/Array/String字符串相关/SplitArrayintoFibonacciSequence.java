package Array.String字符串相关;

import java.util.ArrayList;
import java.util.List;

public class SplitArrayintoFibonacciSequence {

  public List<Integer> nums;//全局变量存储 最后的解

  public List<Integer> splitIntoFibonacci(String S) {
    int len = S.length();
    nums = new ArrayList<>();
    dfs(0, S, len);
    return nums;
  }

  public boolean dfs(int pos, String S, int len) {
    if (pos == len)
      // 已经到了最后一个点
      return nums.size() >= 3;
    // 找到最大长度 如果这个位置的值为0 说明值能取一位 如果大于0 说明可以取10位 10位是由0 <= F[i] <= 2^31 - 1 所得
    // 10位 为整形上限
    int max_len = S.charAt(pos) == '0' ? 1 : 10;
    int num = 0;
    // pos 就是 pos+ max_len 和S长度的最小值 不越界
    for (int i = pos; i < Math.min(pos + max_len, len); i++) {
      // 从字符串转换为整形
      // 保证每次能够将前进一位
      num = num * 10 + S.charAt(i) - '0';
      // System.out.println(num);

      if (num > Integer.MAX_VALUE) break;
      if (nums.size() >= 2) {
        int sum = nums.get(nums.size() - 1);
        sum += nums.get(nums.size() - 2);
        // 当前两个的和 小于第三数的时候 剪枝
        if (num > sum) break;
          // 不剪枝 跳出这一层的循环
        else if (num < sum) continue;
        // System.out.println(sum);
      }
      nums.add(num);
      if (dfs(i + 1, S, len)) return true;
      else
        nums.remove(nums.size() - 1);
    }
    return false;
  }
}
