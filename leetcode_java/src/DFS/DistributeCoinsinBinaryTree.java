package DFS;

public class DistributeCoinsinBinaryTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  int ans;

  public int distributeCoins(TreeNode root) {
    ans = 0;
    balance(root);
    return ans;
  }

  public int balance(TreeNode node) {
    if (node == null) return 0;
    ans += Math.abs(balance(node.left)) + Math.abs(balance(node.right));
    return node.val + balance(node.left) + balance(node.right) - 1;
  }
}
