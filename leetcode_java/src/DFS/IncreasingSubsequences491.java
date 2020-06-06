package DFS;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences491 {
  List<List<Integer>> res = new ArrayList<>();

  public List<List<Integer>> findSubsequences(int[] nums) {
    dfs(nums, 0, new ArrayList<>());

    return res;
  }

  public void dfs(int[] nums, int index, List<Integer> list) {
    if (index >= nums.length) {
      if (list.size() >= 2)
        // System.out.println(list);
        res.add(new ArrayList(list));// 因为在这里加入的list只是list需要new ArrayList

      return;
    }
    if (list.isEmpty() || list.get(list.size() - 1) <= nums[index]) {
      list.add(nums[index]);

      dfs(nums, index + 1, list);
      list.remove(list.size() - 1);
    }
    if (index > 0 && !list.isEmpty() && nums[index] == list.get(list.size() - 1)) {
      return;
    }

    dfs(nums, index + 1, list);

  }
}
