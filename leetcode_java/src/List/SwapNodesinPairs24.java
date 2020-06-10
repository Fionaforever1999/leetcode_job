package List;

public class SwapNodesinPairs24 {

  //Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode swapPairs(ListNode head) {

    ListNode dummey = new ListNode(-1);
    dummey.next = head;
    ListNode pre = dummey;


    while ((head != null) && (head.next != null)) {
      ListNode start = head;
      ListNode end = head.next;

      pre.next = end;
      start.next = end.next;
      end.next = start;

      pre = start;
      head = start.next;
    }
    return dummey.next;

  }
}
