package List;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesfromSortedListII82 {

  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
  public ListNode deleteDuplicates(ListNode head) {
    Map<Integer, Integer> map = new HashMap<>();
    ListNode dummey = new ListNode(0);
    dummey.next = head;
    while (head != null) {
      map.put(head.val, map.getOrDefault(head.val, 0) + 1);
      // System.out.println(map.get(head.val));
      head = head.next;
    }
    head = dummey.next;
    // System.out.println(1);

    ListNode pre = dummey;
    while (head != null && head.next != null) {
      // System.out.println(cur.val);
      if (map.get(head.val) > 1) {
        ListNode cur = head;
        int len = map.get(head.val);//获取重复的有几个
        while (len > 0) {
          cur = cur.next;
          len--;
        }
        head = cur;
        pre.next = cur;
      } else {
        pre = head;
        head = head.next;
      }
    }
    return dummey.next;
  }
}
