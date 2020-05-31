package BinaryTree;

public class DeleteNodeInABST {

   // Definition for a binary tree node.
   public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }
  // public TreeNode deleteNode(TreeNode root, int key) {
  // 将m的值放到 已找到的key上 会浪费空间
  //     if(root == null)return root;
  //     if(key > root.val){
  //         root.right = deleteNode(root.right, key);
  //     }else if(key< root.val){
  //         root.left = deleteNode(root.left, key);
  //     }
  //     else{
  //         if(root.left !=null && root.right!=null){
  //             // 两个孩子都存在
  //             TreeNode min = root.right;
  //             // 找到右子树中最小的节点
  //             while(min.left!=null)min = min.left;
  //             root.val = min.val;
  //             // 删除最小值
  //             root.right = deleteNode(root.right, min.val);
  //         }
  //         else{
  //             // 两个子树有一个不为空 就将这个子树设为新的root
  //             TreeNode new_root = root.left==null?root.right:root.left;
  //             root.left = null;
  //             root.right = null;
  //             root = null;
  //             return new_root;
  //         }
  //     }
  //     return root;
  // }
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return root;
    if (key > root.val) {
      root.right = deleteNode(root.right, key);
    } else if (key < root.val) {
      root.left = deleteNode(root.left, key);
    } else {
      TreeNode new_root = null;
      if (root.left == null) {
        new_root = root.right;
      } else if (root.right == null) {
        new_root = root.left;
      } else {
        // 定义当前右子树 根节点
        TreeNode parent = root;
        new_root = root.right;
        // 找到当前节点的最小值
        while (new_root.left != null) {
          parent = new_root;
          new_root = new_root.left;
        }
        if (parent != root) {
          parent.left = new_root.right;
          // 接操作
          new_root.right = root.right;
        }
        new_root.left = root.left;
      }
      root = null;
      return new_root;
    }
    return root;
  }
}
