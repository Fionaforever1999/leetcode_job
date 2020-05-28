package GraphDSU;

import java.util.HashMap;

public class CopyListwithRandomPointer {

  // Definition for a Node.
  class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }


  public Node copyRandomList(Node head) {
    HashMap<Node, Node> map = new HashMap<>();
    Node h = head;
    while (h != null) {
      Node temp = new Node(h.val);
      map.put(h, temp);
      h = h.next;
    }
    h = head;
    while (h != null) {
      if (h.next != null)
        map.get(h).next = map.get(h.next);
      if (h.random != null)
        map.get(h).random = map.get(h.random);
      h = h.next;
    }
    return map.get(head);
  }
}
