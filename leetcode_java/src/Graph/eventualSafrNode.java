package Graph;

import java.util.List;
import java.util.ArrayList;

public class eventualSafrNode {
    //寻找一个safe的节点表示不会成环
    public List<Integer> eventualSafeNodes(int[][] graph) {
      int n = graph.length;
      String[] status = new String[n];
      for (int m=0;m<n;m++){
        status[m]="unknown";
      }
      List<Integer> ans = new ArrayList();

      for(int i=0;i<n;i++){
        if (dfs(i, status, graph)=="safe")
          ans.add(i);
      }
      return ans;

    }
    public String dfs(int i, String[] status, int[][] graph){
      if(status[i] == "visiting")return "unsafe";
      if(status[i]!="unknown") return status[i];
      status[i] = "visiting";
      for(int next: graph[i]){
        if(dfs(next, status, graph)=="unsafe"){
          return status[i] = "unsafe";
        }
      }
      return status[i]="safe";

    }
  }

