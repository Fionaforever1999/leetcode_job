/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        while(root!=null){
            if (root.left==null){
                root = root.right;
            }
            else{
                TreeNode pre;
                pre = root.left;
                while(pre.right!=null){
                    pre = pre.right;//找到左子树的右节点 
                }
                pre.right = root.right;//将右子树移到左子树的右节点的下一个节点
                root.right = root.left;//将左子树替换到右子树的位置上
                root.left = null;
                root = root.right;//向下移动节点
            }
        }
    }
    public void flatten2(TreeNode root) {
        TreeNode cur = root;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();

        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.peek();
            if(cur.left == null || cur.left==pre){
                //在不存在左节点或者右节点已经访问过的情况下，访问根节点

                stack.pop();//当前节点为栈中最新值 表示最右边的节点
                cur.right = pre;
                cur.left = null;
                pre = cur;
                cur = null;
            }
            else{
                cur = cur.left;//左节点还没有访问过就先访问左节点
            }
        }
    }
    public void flatten2(TreeNode root) {
        if (root == null){
                return;
        }
        TreeNode pre = null;      
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if (pre!=null){
                pre.right = temp;
                pre.left = null;
            }
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
            pre = temp;
        }
    }
}