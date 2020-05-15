/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        sum -= root.val;
        if ((root.left == null)&&(root.right == null)){
            return (sum == 0);
        }
        return hasPathSum(root.right, sum) || hasPathSum(root.left, sum);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        LinkedList<TreeNode> nodeStack = new LinkedList<>();
        LinkedList<Integer> sumStack = new LinkedList<>();
        
        nodeStack.add(root);
        sumStack.add(sum - root.val);

        TreeNode node;
        int currVal;
        while(!nodeStack.isEmpty()){
            currVal = sumStack.pollLast();
            node = nodeStack.pollLast();
            if((node.left==null)&&(node.right == null)&&(currVal == 0))
                return true;
            if(node.left!=null){
                sumStack.add(currVal - node.left.val);
                nodeStack.add(node.left);
            }
            if(node.right!=null){
                sumStack.add(currVal - node.right.val);
                nodeStack.add(node.right);
            }
        }
        return false;
    }
}