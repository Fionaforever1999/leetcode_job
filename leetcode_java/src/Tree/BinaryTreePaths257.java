package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {

  //   Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }


  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    if (root == null) return res;
    findNext(root, "", res);
    return res;
  }

  public void findNext(TreeNode node, String cur, List<String> res) {
    if (node == null) return;
    cur += node.val;
    if (node.left == null && node.right == null) {
      // 当为叶子节点的时候才将之前的从底到顶的字符串 加入res
      res.add(cur);
    } else {
      findNext(node.left, cur + "->", res);
      findNext(node.right, cur + "->", res);
    }
  }
}
