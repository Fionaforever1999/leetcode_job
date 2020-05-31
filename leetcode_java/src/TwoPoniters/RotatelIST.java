package TwoPoniters;

public class RotatelIST {


  // Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
    }
  }

  public ListNode rotateRight(ListNode head, int k) {
    if (head == null || k == 0) return head;
    ListNode h = head;
    ListNode tail = null;
    int len = 0;
    // 求链表长度
    while (h != null) {
      h = h.next;
      len++;
      if (h != null) tail = h;
    }
    int n = k % len; // 求出需要移动的点数
    if (n == 0) return head;

    // 快慢指针求解
    ListNode fast = head;
    ListNode slow = head;
    while (n >= 0) {
      fast = fast.next;
      n--;
    }
    // 快指针到 1->2->3->4->5 k = 2 从倒数第二个断开 fast 第一个循环到4
    // 随后 slow 到 3  两个平行slow 1->2->3  fast 4->5->null
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }
    tail.next = head; // 到这里已经成环了
    head = slow.next;
    slow.next = null;// 因为不能取head之前的值 所以这里把slow指针后面的值设为空 断掉
    return head;
  }


}

