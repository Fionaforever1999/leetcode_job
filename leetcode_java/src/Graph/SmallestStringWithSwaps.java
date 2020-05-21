//package Graph;
//
//import java.util.*;
//
//public class SmallestStringWithSwaps {
//    public List<Integer> index = new ArrayList<>();
//    public String temp="";
//    public List<List<Integer>> graph = new LinkedList<>();//图为邻接链表
//
//  public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
//      Set<Integer> visit = new HashSet<>();
//
//      for(List<Integer> l :pairs){
//        //设置无向图
//        System.out.println(l.get(0));
////        graph.get(l.get(0)) = l.get(1);
////        graph[l.get(1)]= l.get(0);
//      }
//      for(int i=0;i<s.length();i++){
//        if(visit.contains(i)) continue;
//        index = new ArrayList<>();
//        temp = "";
//        dfs(i,visit, s,pairs);
//        index.sort((k1,k2) -> k1-k2);
////        temp.sort((k1,k2) ->k1-k2);
//        for(int k=0;k<index.size();k++){
//          s[index.get(k)] = temp.charAt(k);
//        }
//      }
//    }
//    public void dfs(int cur, Set<Integer> visit, String s, List<List<Integer>> pairs){
//      if(visit.contains(cur))return;
//      visit.add(cur);
//      index.add(cur);
//      temp +=  s.charAt(cur); //收集substring
//      for(int i: graph.get(cur)){
//        dfs(i, visit, s, pairs);
//      }
//    }
//
//  public static void main(String[] args) {
//    SmallestStringWithSwaps s = new SmallestStringWithSwaps();
//
//  }
//}
