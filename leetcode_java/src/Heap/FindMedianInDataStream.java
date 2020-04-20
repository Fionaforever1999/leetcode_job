package Alg;
import java.util.PriorityQueue;
public class FindMedianInDataStream {
  /** initialize your data structure here. */
  class MedianFinder {
    private int count;
    private PriorityQueue<Integer> minheap;
    private PriorityQueue<Integer> maxheap;
    /** initialize your data structure here. */
    public MedianFinder() {
      count = 0;
      maxheap = new PriorityQueue<>((x, y) ->y-x);// 对于左边的小队列要以最小值为堆顶 升序
      minheap = new PriorityQueue<>();// 对于右边的队列以最大值作为堆顶 降序
    }

    public void addNum(int num) {
      // PriorityQueue 方法中.offer 用于将特定元素插入优先级队列
      maxheap.offer(num);// 左边队列加入
      minheap.add(maxheap.poll()); //右边队列加入 左边的最小值 即堆顶
      count ++;
      // 如果总共数字个数为奇数 将小顶堆中的值给大顶堆 即将右边的顶给左边
      if ((count & 1)!=0){
        maxheap.add(minheap.poll());
      }
    }

    public double findMedian() {
      if ((count & 1)==0){
        return (double)(minheap.peek() + maxheap.peek())/2;
      }
      else{
        return (double)maxheap.peek();//peek 和 poll 区别 peek 获取栈顶但是不删除 poll获取并删除
      }
    }
  }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
}
