package List;

public class PartitionList86 {

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode partition(ListNode head, int x) {
    // why we need two heads here?
    ListNode max = new ListNode(0);
    ListNode max_head = max;
    ListNode min = new ListNode(0);
    ListNode min_head = min;
    while (head != null) {
      if (head.val < x) {
        min.next = head;
        min = min.next;
      } else {
        max.next = head;
        max = max.next;
      }

      head = head.next;
    }
    max.next = null;  //这步不要忘记，不然链表就出现环了
    //两个链表接起来
    min.next = max_head.next;
    return min_head.next;
  }
}
