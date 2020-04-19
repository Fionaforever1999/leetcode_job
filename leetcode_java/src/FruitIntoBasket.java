import java.util.Map;
import java.util.HashMap;
public class FruitIntoBasket {
  public static int totalFruit(int[] tree) {
    if(tree.length==0)return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int max = 0;
    int left = 0;
    for(int right=0;right < tree.length;right++){
      // 当map getOrDefault 表示 如果不是默认值就设置为0 +1
      map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
      while(map.size() > 2){
        if(map.get(tree[left])==1){
          map.remove(tree[left]);
        }else{
          map.put(tree[left], map.get(tree[left]) - 1); // 获得左指针的节点
        }
        left ++;
      }
      max = Math.max(max, right - left + 1);
    }
    return max;
  }
  public static void main(String[] args){
    System.out.println(FruitIntoBasket.totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
  }
}
