package BinarySearch;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeandDeserializeBinaryTree {

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {
    return reserialize(root, "");
  }

  private String reserialize(TreeNode root, String str) {
    if (root == null) {
      str += "null,";
    } else {
      str += String.valueOf(root.val) + ",";
      str = reserialize(root.left, str);
      str = reserialize(root.right, str);
    }
    return str;
  }

  private TreeNode redeserialize(List<String> l) {
    if (l.get(0).equals("null")) {
      l.remove(0);
      return null;
    }
    TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
    l.remove(0);
    root.left = redeserialize(l);
    root.right = redeserialize(l);
    return root;
  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {
    String[] dataArray = data.split(",");
    List<String> dataList = new LinkedList<>(Arrays.asList(dataArray));
    return redeserialize(dataList);
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
