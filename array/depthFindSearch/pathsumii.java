/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//113
import java.util.ArrayList;
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        int val = sum;
        findDFS(root, val, res, tmp);
        return res;
    }
    public void findDFS(TreeNode node, int val, List<List<Integer>> res, List<Integer> tmp){
        if(node==null)return;
        val-=node.val;
        tmp.add(node.val);
        if((node.right==null) && (node.left==null) &&(val==0)){
            res.add(new ArrayList<>(tmp));// 如果直接放进去，其实是放了个引用，不new一个放进去的话，后续修改所有的都会同步被修改
        }
        findDFS(node.left, val, res, tmp);
        findDFS(node.right, val, res, tmp);
        tmp.remove(tmp.size()-1);
    }
}