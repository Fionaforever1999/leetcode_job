package Tree;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeLevelOrderTraversal429 {

  // Definition for a Node.
  class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, List<Node> _children) {
      val = _val;
      children = _children;
    }
  }

  ;


  List<List<Integer>> res;

  public List<List<Integer>> levelOrder(Node root) {
    res = new ArrayList<>();
    dfs(root, 0);
    return res;

  }

  public void dfs(Node node, int depth) {
    if (node == null) return;
    if (res.size() <= depth) {
      res.add(new ArrayList<>());
    }
    res.get(depth).add(node.val);
    for (Node i : node.children) {
      dfs(i, depth + 1);
    }
  }
}
