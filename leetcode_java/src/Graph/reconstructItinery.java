package Graph;
import java.util.*;
public class reconstructItinery {
    public List<String> findItinerary(List<List<String>> tickets) {
      List<String> ans = new LinkedList<>(); // 链表维护最终结果
      if (tickets == null || tickets.size() == 0){
        return ans;
      }
      Map<String, PriorityQueue<String>> grapth = new HashMap<>();

      for (List<String> pair:tickets){
        // Java 中对应 computerIfAbsent 的 介绍 如果pair.get(0) 不在graphmap中 创建一个链表来存储这个key的value
        PriorityQueue<String> nbr = grapth.computeIfAbsent(pair.get(0),k->new PriorityQueue<>());
        nbr.add(pair.get(1)); //Java list的对应类应该是get(索引值)
      }
      // 利用 优先队列来存储字符
      visted(grapth, ans, "JFK");
      return ans;
    }
    private void visted(Map<String,PriorityQueue<String>> grapth, List<String> ans, String src){
      PriorityQueue<String> nbr = grapth.get(src); // 根据src值获取对应value值 是这个航班能发往地区的pq列表
      while(nbr!=null && nbr.size()>0){
        String dst = nbr.poll();
        visted(grapth, ans, dst);
      }
      ans.add(0, src);
    }

  public static void main(String[] args) {
    return ;
  }
}

