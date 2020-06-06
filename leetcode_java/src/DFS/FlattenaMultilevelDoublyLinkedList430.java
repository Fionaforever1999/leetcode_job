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

//  首先，我们定义递归函数 flatten_dfs(prev, curr)，它接收两个指针作为函数参数并返回扁平化列表中的尾部指针。
//  curr 指针指向我们要扁平化的子列表，prev 指针指向 curr 指向元素的前一个元素。
//  在函数 flatten_dfs(prev, curr)，我们首先在 prev 和 curr 节点之间建立双向连接。
//  然后在函数中调用 flatten_dfs(curr, curr.child) 对左子树（curr.child 即子列表）进行操作，
//  它将返回扁平化子列表的尾部元素 tail，再调用 flatten_dfs(tail, curr.next) 对右子树进行操作。
//  为了得到正确的结果，我们还需要注意两个重要的细节：
//  在调用 flatten_dfs(curr, curr.child) 之前我们应该复制 curr.next 指针，因为 curr.next 可能在函数中改变。
//  在扁平化 curr.child 指针所指向的列表以后，我们应该删除 child 指针，因为我们最终不再需要该指针。



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
