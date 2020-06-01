package Tree;

public class BinaryTreePruning {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public TreeNode pruneTree(TreeNode root) {
    return containOne(root) ? root : null;
  }

  public boolean containOne(TreeNode node) {
    if (node == null) return false;
    boolean left = containOne(node.left);
    boolean right = containOne(node.right);
    if (!left) node.left = null;
    if (!right) node.right = null;
    return node.val == 1 || left || right;

  }
}
