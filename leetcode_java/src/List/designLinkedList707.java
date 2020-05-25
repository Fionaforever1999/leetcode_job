package List;

public class designLinkedList707 {
  int size;
  ListNode head;

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }

  /**
   * Initialize your data structure here.
   */
  public designLinkedList707() {
    size = 0;
    head = new ListNode(0);
  }

  /**
   * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
   */
  public int get(int index) {
    if (index < 0 || index >= size) return -1;
    ListNode cur = head;
    for (int i = 0; i < index + 1; ++i) {
      cur = cur.next;
    }
    return cur.val;

  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    addAtIndex(0, val);
  }

  /**
   * Append a node of value val to the last element of the linked list.
   */
  public void addAtTail(int val) {
    addAtIndex(size, val);
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index > size) return;
    if (index < 0) index = 0;
    size++;
    ListNode pre = head;
    ListNode toAdd = new ListNode(val);

    for (int i = 0; i < index; ++i) {
      pre = pre.next; // if index is 1 and size is 3  -> i=1 1,2
    }
    toAdd.next = pre.next;
    pre.next = toAdd;
  }

  /**
   * Delete the index-th node in the linked list, if the index is valid.
   */
  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) return;
    size--;

    ListNode pre = head;
    for (int i = 0; i < index; ++i) {
      pre = pre.next;
    }
    pre.next = pre.next.next;
  }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */


class MyLinkedList {
  public class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int x) {
      val = x;
    }
  }

  int size;
  // sentinel nodes as pseudo-head and pseudo-tail
  ListNode head, tail;

  public MyLinkedList() {
    size = 0;
    head = new ListNode(0);
    tail = new ListNode(0);
    head.next = tail;
    tail.prev = head;
  }

  /**
   * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
   */
  public int get(int index) {
    // if index is invalid
    if (index < 0 || index >= size) return -1;

    // choose the fastest way: to move from the head
    // or to move from the tail
    ListNode curr = head;
    if (index + 1 < size - index)
      for (int i = 0; i < index + 1; ++i) curr = curr.next;
    else {
      curr = tail;
      for (int i = 0; i < size - index; ++i) curr = curr.prev;
    }

    return curr.val;
  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    ListNode pred = head, succ = head.next;

    ++size;
    ListNode toAdd = new ListNode(val);
    toAdd.prev = pred;
    toAdd.next = succ;
    pred.next = toAdd;
    succ.prev = toAdd;
  }

  /**
   * Append a node of value val to the last element of the linked list.
   */
  public void addAtTail(int val) {
    ListNode succ = tail, pred = tail.prev;

    ++size;
    ListNode toAdd = new ListNode(val);
    toAdd.prev = pred;
    toAdd.next = succ;
    pred.next = toAdd;
    succ.prev = toAdd;
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    // If index is greater than the length,
    // the node will not be inserted.
    if (index > size) return;

    // [so weird] If index is negative,
    // the node will be inserted at the head of the list.
    if (index < 0) index = 0;

    // find predecessor and successor of the node to be added
    ListNode pred, succ;
    if (index < size - index) {
      pred = head;
      for (int i = 0; i < index; ++i) pred = pred.next;
      succ = pred.next;
    } else {
      succ = tail;
      for (int i = 0; i < size - index; ++i) succ = succ.prev;
      pred = succ.prev;
    }

    // insertion itself
    ++size;
    ListNode toAdd = new ListNode(val);
    toAdd.prev = pred;
    toAdd.next = succ;
    pred.next = toAdd;
    succ.prev = toAdd;
  }

  /**
   * Delete the index-th node in the linked list, if the index is valid.
   */
  public void deleteAtIndex(int index) {
    // if the index is invalid, do nothing
    if (index < 0 || index >= size) return;

    // find predecessor and successor of the node to be deleted
    ListNode pred, succ;
    if (index < size - index) {
      pred = head;
      for (int i = 0; i < index; ++i) pred = pred.next;
      succ = pred.next.next;
    } else {
      succ = tail;
      for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
      pred = succ.prev.prev;
    }

    // delete pred.next
    --size;
    pred.next = succ;
    succ.prev = pred;
  }
}

