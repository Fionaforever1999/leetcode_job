package DFS;

public class FlattenaMultilevelDoublyLinkedList430 {

  class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int i, Object o, Node head, Object o1) {

    }
  }


  public Node flatten(Node head) {
    if (head == null) return head;
    // 伪装性的前置node保证node一直不为空
    Node psedoHead = new Node(0, null, head, null);
    flattenDFS(psedoHead, head);
    psedoHead.next.prev = null;
    return psedoHead.next;


  }

  public Node flattenDFS(Node pre, Node cur) {
    if (cur == null) return pre;
    cur.prev = pre;
    pre.next = cur;

    Node memo = cur.next;
    Node tail = flattenDFS(cur, cur.child);

    cur.child = null;

    return flattenDFS(tail, memo);
  }
}
