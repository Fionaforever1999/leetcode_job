package DFS;
//https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
import java.util.HashSet;
import java.util.Set;

public class BinaryTreeCameras968 {
  //    Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public int ans;
  public Set<TreeNode> coverd;

  public int minCameraCover(TreeNode root) {
    coverd = new HashSet<>();
    coverd.add(null);
    ans = 0;
    dfs(root, null);
    return ans;
  }

  public void dfs(TreeNode node, TreeNode par) {
    // dfs表示能够监视的范围
    if (node != null) {
      dfs(node.left, node);
      dfs(node.right, node);
      if (par == null && !coverd.contains(node) || !coverd.contains(node.left) || !coverd.contains(node.right)) {
        // 如果 子节监视范围 或者 点和本节点和父节点不在监视范围内
        ans++;
        coverd.add(node);
        coverd.add(node.right);
        coverd.add(node.left);
        coverd.add(par);
      }
    }

  }
}
