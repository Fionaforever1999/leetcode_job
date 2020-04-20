package Alg;

public class ReverseLinkedList {
  public ListNode reverseList(ListNode head) {
      // 头结点一定指向Null
    ListNode prev = null;
    ListNode curr = head;
    while (curr!=null){
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    return prev;
  }
  public static void main(String[] args){
    ReverseLinkedList sol = new ReverseLinkedList();
    ListNode l1 = new ListNode(1);
    l1.next = new ListNode(2);
    l1.next.next = new ListNode(3);
    System.out.println(sol.reverseList(l1));
  }
}
