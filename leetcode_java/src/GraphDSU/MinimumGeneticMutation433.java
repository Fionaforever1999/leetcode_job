package GraphDSU;

import java.util.HashSet;

public class MinimumGeneticMutation433 {
  int minStep = Integer.MAX_VALUE;

  public int minMutation(String start, String end, String[] bank) {
    dfs(new HashSet<String>(), start, end, bank, 0);
    return minStep == Integer.MAX_VALUE ? -1 : minStep;
  }

  public void dfs(HashSet<String> step, String cur, String end, String[] bank, int stepCount) {
    if (cur.equals(end)) {
      minStep = Math.min(minStep, stepCount);
    }
    for (String str : bank) {
      int diff = 0;
      for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) != cur.charAt(i)) diff++;
        if (diff > 1) break;
      }
      if (diff == 1 && !step.contains(str)) {
        // 如果 bank中的值和当前值差1位 而且step也就是存储之前值的set中不包含 这个 str说明这个str是下一个要改变的值
        step.add(str);
        dfs(step, str, end, bank, stepCount + 1);
        step.remove(str);
      }
    }
  }
}
