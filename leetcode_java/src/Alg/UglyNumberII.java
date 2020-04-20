package Alg;
import java.util.HashSet;
import java.util.PriorityQueue;//option + enter

class Ugly{
  public int[] nums = new int[1690];
  Ugly(){
    HashSet<Long> seem = new HashSet();

    PriorityQueue<Long> heap = new PriorityQueue<Long>();//<>泛型意思表示只能输入<>里面加入的形式
    seem.add(1L);
    heap.add(1L); // 加入1 这个数为long型
    long curU, newU;
    int prims[] = {2, 3 ,5};//看看这样定义对不对
    for(int i=0; i < 1690;i++){
      curU = heap.poll();// 从数组中取出当前最大值
      nums[i] = (int)curU;// 将最大值放到i中
      for(int prim:prims){
        newU = curU * prim;
        if(!seem.contains(newU)){
          //判断之前的newU 值是否存在
          seem.add(newU);
          heap.add(newU);
        }
      }
    }
  }
}
class UglyNumberII {
  public static Ugly u = new Ugly();
  public static int nthUglyNumber(int n) {
    return u.nums[n - 1];
  }
  public static void main(String [] args){
    System.out.println(UglyNumberII.nthUglyNumber(10));
  }
}
