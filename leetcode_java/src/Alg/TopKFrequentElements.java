package Alg;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
class TopKFrequentElements {

  public List<Integer> topKFrequent(int[] nums, int k) {
    List<Integer> ans = new ArrayList<>();
    if(nums == null)return ans;
    Map<Integer,Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }
    List<Integer>[] tmp = new List[nums.length + 1];
    for(int key: map.keySet()){// 获取每一个value 的 key的值
      int i = map.get(key);// 通过出现的key也就是数字的值到map中获得出现频率
      if(tmp[i]==null){// 如果在这个频率下的 桶中没有则该桶中加入列表存nums中数字的值
        tmp[i] = new ArrayList();
      }
      tmp[i].add(key);
    }
    for(int i=tmp.length-1; i>=0&&ans.size()<k;i--){// ans长度小于k而不是小于等于因为在之前已经执行ans.add
      if (tmp[i] == null)continue;// 如果在这个频率桶中没有值 跳出if循环 i--
      ans.addAll(tmp[i]);
    }
    return ans;
  }
}
