package List;

public class InsertSortList147 {

  //    Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  public ListNode insertionSortList(ListNode head) {
    if (head == null) return null;
    ListNode dummey = new ListNode(0); // dummy as the start for tempH
    while (head != null) {
      ListNode tempH = dummey;
      ListNode headNext = head.next;
      // head is current node
      head.next = null;
      while (tempH.next != null) {
        // find the place where the current point is larger to the next point
        if (tempH.next.val > head.val) {
          // where point could insert
          head.next = tempH.next;
          tempH.next = head;
          break;
        }
        tempH = tempH.next;
      }
      // when there is no need to insert, add current to the end of tempH
      if (tempH.next == null) {
        tempH.next = head;
      }
      head = headNext;

    }
    return dummey.next;
  }
}

