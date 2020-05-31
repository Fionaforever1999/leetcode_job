package BinaryTree;

import java.util.LinkedList;
import java.util.List;

public class FindModeinBinarySearchTree501 {

  // Definition for a binary tree node.
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  private List<Integer> modes;
  private int cur;//当前数字
  private int curTime; // 当前数字出现频率
  private int lastTime; // 上一个数字出现的频率

  public int[] findMode(TreeNode root) {
    modes = new LinkedList<>();
    inOrder(root);
    int[] res = new int[modes.size()];
    for (int i = 0; i < modes.size(); i++) {
      res[i] = modes.get(i);
    }
    // return Arrays.toArray(new int[mode.size()]);
    return res;
  }

  public void inOrder(TreeNode root) {
    if (root == null) return;
    inOrder(root.left);
    if (lastTime == 0) lastTime = 1;
    if (root.val != cur) curTime = 0;
    cur = root.val;
    curTime++;
    if (curTime == lastTime) modes.add(cur);
    if (curTime > lastTime) {
      lastTime = curTime;
      modes.clear();
      modes.add(cur);
    }
    inOrder(root.right);
  }
}
