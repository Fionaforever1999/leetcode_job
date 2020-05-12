package DFS;

public class MaxPathSum {

//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


    public int max_sum = Integer.MIN_VALUE; // 将所属值设置为最小值
    public int maxGain(TreeNode node){
      if (node==null)return 0;
      int leftGain = Math.max(maxGain(node.left), 0);
      int rightGain = Math.max(maxGain(node.right), 0);
      int price = node.val + leftGain + rightGain;
      max_sum = Math.max(max_sum, price);
      return Math.max(leftGain, rightGain) + node.val;
    }
    public int maxPathSum(TreeNode root) {
      maxGain(root);
      return max_sum;
    }
}

