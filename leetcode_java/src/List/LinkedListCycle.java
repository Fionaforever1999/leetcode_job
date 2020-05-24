package List;

public class LinkedListCycle {

  //    Definition for singly-linked list.
  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    // method one
    // HashSet<ListNode> set = new HashSet<>();
    // while (head!=null){
    //     set.add(head);
    //     head = head.next;
    //     if(set.contains(head))return true;
    // }
    // return false;
    // method two fast and slow points
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null) {
      if (fast.next == null) {
        return false;
      }
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }
}
