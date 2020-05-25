package List;

public class SortList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public ListNode sortList(ListNode head) {
    return mergeSort(head);
  }

  // merge sort <-> divide conquer
  public ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode dummey = new ListNode(0);
    dummey.next = head;

    ListNode fast = dummey;
    ListNode slow = dummey;

    // use the slow and fast pointer to find the mid of the linked list
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode head2 = slow.next;
    slow.next = null;
    head = mergeSort(head);
    head2 = mergeSort(head2);
    return merge(head, head2);
  }

  public ListNode merge(ListNode node1, ListNode node2) {
    // 21
    ListNode head = new ListNode(0);
    ListNode ans = head;
    while (node1 != null && node2 != null) {
      if (node1.val < node2.val) {
        head.next = node1;
        node1 = node1.next;
        head = head.next;
      } else {
        head.next = node2;
        node2 = node2.next;
        head = head.next;
      }
    }
    if (node1 == null) {
      head.next = node2;
    }
    if (node2 == null) {
      head.next = node1;
    }
    return ans.next;
  }
}
