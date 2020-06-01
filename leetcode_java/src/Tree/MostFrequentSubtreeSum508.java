package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MostFrequentSubtreeSum508 {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  Map<Integer, Integer> map = new HashMap<>();
  int max = 0;

  public int[] findFrequentTreeSum(TreeNode root) {
    if (root == null) return new int[0];
    findSum(root);
    ArrayList<Integer> list = new ArrayList<>();
    for (int i : map.keySet()) {
      if (map.get(i) == max) {
        list.add(i);
      }
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = list.get(i);
    }
    return result;

  }

  public int findSum(TreeNode root) {
    if (root == null) return 0;
    int left = findSum(root.left);
    int right = findSum(root.right);
    int sum = left + right + root.val;
    map.put(sum, map.getOrDefault(sum, 0) + 1);
    max = Math.max(map.get(sum), max);
    return sum;
  }
}
