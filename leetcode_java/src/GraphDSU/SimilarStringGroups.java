package GraphDSU;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  这道题没有做对 请再做时对照答案好好看看哪里错了
 *  2020 5 28
 */
class SimilarStringGroups {
  public int numSimilarGroups(String[] A) {
    int row = A.length;
    int col = A[0].length();
    // add parents depend on how many strings
    DSU dsu = new DSU(row);
    if(row < col * col){
      // small String
      for(int i=0;i< row;i++){
        for(int j=i+1;j<row;j++){
          if(smailiar(A[i], A[j]))
            dsu.union(i, j);
        }
      }
    }
    else{
      Map<String, List<Integer>> map = new HashMap<>();
      for(int i=0;i<row;i++){
        // change the type of A[i]
        char[] L = A[i].toCharArray();

        for(int j=0;j<L.length;j++){
          for(int j_=j+1;j_<L.length;j_++){
            swap(L, j, j_);
            StringBuilder s = new StringBuilder();
            for(char c : L) s.append(c);
            map.computeIfAbsent(s.toString(), k->new ArrayList<>()).add(i);
            swap(L, j, j_);
          }
        }
        for(int i_=0;i_<row;i++){
          if (map.containsKey(A[i_]))
            for (int i__: map.get(A[i_]))
              dsu.union(i_, i__);
        }
      }
    }
    int ans = 0;
    for(int i = 0;i< row;i++){
      if(dsu.parent[i]==i)ans++;
    }
    return ans;
  }
  public boolean smailiar(String word1, String word2){
    // make sure two words is
    int diff = 0;
    for(int i=0;i<word1.length();i++){
      if(word1.charAt(i) != word2.charAt(i)){
        diff++;
      }
    }
    return diff<=2;
  }
  public void swap(char[] word, int i, int j){
    char temp = word[i];
    word[i] = word[j];
    word[j] = temp;
  }
}
class DSU{
  int[] parent;
  public DSU(int n){
    parent = new int[n];
    for(int i=0;i< n;i++){
      parent[i] = i;
    }
  }
  public int find(int x){
    if(parent[x] != x) parent[x] = find(parent[x]);
    return parent[x];
  }
  public void union(int x, int y){
    parent[find(x)] = find(y); // set y's parent as x's
  }
}
