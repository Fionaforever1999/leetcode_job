package Tree;

import java.util.ArrayList;
import java.util.List;

public class CheckCompletenessofaBinaryTree958 {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
  public boolean isCompleteTree(TreeNode root) {
    List<ANode> node = new ArrayList<>();
    node.add(new ANode(root, 1));
    int i = 0;
    while(i<node.size()){
      ANode anode = node.get(i++);
      if(anode.node!=null){
        node.add(new ANode(anode.node.left, anode.code*2));
        node.add(new ANode(anode.node.right, anode.code*2+1));
      }
    }
    return node.get(i-1).code == node.size();

  }
  class ANode{
    // 对每个节点进行编号
    TreeNode node;
    int code;
    public ANode(TreeNode node, int code){
      this.node = node;
      this.code = code;
    }
  }
}
