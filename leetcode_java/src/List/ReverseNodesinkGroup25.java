package List;

public class ReverseNodesinkGroup25 {

  //Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null) return null;
    ListNode dummey = new ListNode(-1);
    dummey.next = head;
    ListNode tail = dummey;
    ListNode subHead = head;
    ListNode toNull = head;
    while (subHead != null) {
      int i = k;
      while (i - 1 > 0) {
        toNull = toNull.next;
        if (toNull == null) return dummey.next;
        i--;
      }
      ListNode temp = toNull.next;
      // 断开子链表
      toNull.next = null;
      ListNode newSubNode = reverse(subHead);
      tail.next = newSubNode;
      tail = subHead;
      subHead = temp;
      toNull = temp;
      tail.next = subHead;
    }
    return dummey.next;
  }

  public ListNode reverse(ListNode head) {
    ListNode curHead = null;
    while (head != null) {
      ListNode next = head.next;
      head.next = curHead;
      curHead = head;
      head = next;
    }
    return curHead;
  }
}
