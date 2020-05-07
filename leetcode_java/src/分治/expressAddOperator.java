package 分治;
import java.util.List;
import java.util.ArrayList;
public class expressAddOperator {

    public List<String> addOperators(String num, int target) {
      List<String> ans = new ArrayList<>();
      dfs(num, target, 0,"",ans,0,0);
      return ans;
    }
    public void dfs(String num, int target, int pos, String exp,List<String> ans, long prev, long cur)
    {
      if (pos==num.length()){
        if ((long)target==cur)ans.add(exp);
        return;//当目标值和当前的值相同时return
      }
      for(int i=1;i<num.length()-pos;i++){
        String t = num.substring(pos,i+pos+1);//从pos取出i长度的字符串 ?
        if(t.substring(0,1) == "0" && t.length() >1)break;
        long a = Long.parseLong(t);
        if (a > Integer.MAX_VALUE)break;
        if(pos == 0){
          dfs(num, target, i, t,  ans,a, a);
          continue;
        }
        dfs(num, target,pos+i,exp+'+'+t,ans,a, a+cur);
        dfs(num, target,pos+i,exp+'-'+t,ans,-a, cur-a);
        dfs(num, target,pos+i,exp+'*'+t,ans,prev*a,cur-prev+prev*a);
      }
    }
    public static void main(String[] args){
      expressAddOperator e = new expressAddOperator();
      System.out.println(e.addOperators("123",6));
    }
  }

