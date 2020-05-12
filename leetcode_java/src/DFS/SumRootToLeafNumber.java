package DFS;

public class SumRootToLeafNumber {
  /**
   * Definition for a binary tree node.
   */
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  class Solution {
    public int sum = 0;

    public int sumNumbers(TreeNode root) {
      dfs(0, root);
      return sum;
    }

    public void dfs(int temp, TreeNode node) {
      if (node == null) return;
      if (node.left == null && node.right == null) {
        sum += (temp * 10 + node.val);
        return;
      }
      temp = temp * 10 + node.val;
      dfs(temp, node.left);
      dfs(temp, node.right);
    }
  }
}
