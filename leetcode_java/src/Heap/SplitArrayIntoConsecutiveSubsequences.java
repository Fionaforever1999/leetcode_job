package Heap;

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();//<数字， 数字出现次数>
      for(int i: nums){
        map.put(i, map.getOrDefault(i,0) + 1);// 计算每个数字出现的次数
      }
      for(int i: nums){
        // 对num中出现的数字进行分类， 如果分出来的chain小于三个数字就返回
        int subNum = 0;
        int p = 1;//subNum 子数组元素个数  p表示标记 每个数组中的元素尽量少
        int next = i;//下个元素
        while(map.getOrDefault(next, 0)>=p){
          p = map.get(next);
          map.put(next, p-1);
          subNum++;
          next++;
        }
        if (subNum > 0 && subNum < 3){
          return false;//如果是少于3 而且subNum有值 说明不能完成三个数
        }
      }
      return true;
    }
  }

