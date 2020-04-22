package Heap;
 import java.util.PriorityQueue;
public class kTHLargestNumInAStream {

    private PriorityQueue<Integer> queue;
    private int limit;
    public void KthLargest(int k, int[] nums) {
      limit = k;
      queue = new PriorityQueue<>(k);//queue定义容纳数据量方式
      for(int num: nums){
        queue.add(num);//为什么不是 queue.add()?一个方法中调用了本类或其父类的方法,没有指明对象,                                 // 就是相当于this(当前对象)在调用;
      }
      while (queue.size()>k)queue.poll();
    }
    public int add(int val) {
      if (queue.size() < limit) {
        queue.add(val);
      } else if (val > queue.peek()) {
        queue.poll();
        queue.add(val);
      }
      return queue.peek();
    }




}
