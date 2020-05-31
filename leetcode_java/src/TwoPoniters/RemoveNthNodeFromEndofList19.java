package TwoPoniters;

import java.util.HashMap;
import java.util.Map;

public class RemoveNthNodeFromEndofList19 {

  //    Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  public ListNode removeNthFromEndI(ListNode head, int n) {
    Map<Integer, ListNode> m = new HashMap<>();
    int index = 1;
    ListNode temp = head;
    while (temp != null) {
      m.put(index++, temp);
      temp = temp.next;
    }
    int len = m.size();

    if (len == 1) return null;
    if (n == 1) {
      m.get(len - 1).next = null;
    } else if (n == len) {
      head = head.next;
    } else {
      m.get(len - n).next = m.get(len - n + 2);
    }
    return head;
  }

  public ListNode removeNthFromEndII(ListNode head, int n) {
    ListNode dummey = new ListNode(0);
    dummey.next = head;
    ListNode first = dummey;
    ListNode second = dummey;
    for (int i = 1; i <= n + 1; i++) {
      first = first.next;
    }
    while (first != null) {
      first = first.next;
      second = second.next;
    }
    second.next = second.next.next;
    return dummey.next;
  }
}
