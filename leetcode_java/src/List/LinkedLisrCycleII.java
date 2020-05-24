package List;

import java.util.HashSet;

public class LinkedLisrCycleII {
  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public ListNode detectCycle(ListNode head) {
    HashSet<ListNode> set = new HashSet<>();
    while (head != null) {
      set.add(head);
      head = head.next;
      if (set.contains(head)) {
        return head;
      }
    }
    return null;
  }
}

