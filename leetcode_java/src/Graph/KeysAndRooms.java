package Graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
  class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
      Set<Integer> visit = new HashSet<>();
      dfs(rooms, 0, visit);
      if (visit.size() == rooms.size()) return true;
      return false;

    }

    public void dfs(List<List<Integer>> rooms, int cur, Set<Integer> visit) {
      if (visit.contains(cur)) return;
      visit.add(cur);
      for (int i : rooms.get(cur)) {
        dfs(rooms, i, visit);
      }
    }
  }
}
