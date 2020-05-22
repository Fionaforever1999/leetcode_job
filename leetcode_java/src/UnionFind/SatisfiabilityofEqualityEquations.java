package UnionFind;

public class SatisfiabilityofEqualityEquations {
  // 类似于399 只要判断两个元素是不是在一个组里面
  // 遍历两遍 第一遍 找到x==y 第二遍 判断x!=y find(x)!=find(y) x, y的祖先不相同
  public int[] parents = new int[128];

  public boolean equationsPossible(String[] equations) {
    for (int m = 0; m < 128; m++) {
      // 128是ascall码表最大位
      parents[m] = m;
    }
    for (int i = 0; i < equations.length; i++) {
      String e = equations[i];
      if (e.charAt(1) == '=')
        // 如果x==y相等 a的parent是b的parent
        parents[find(e.charAt(0))] = find(e.charAt(3));
    }
    for (int j = 0; j < equations.length; j++) {
      String e1 = equations[j];
      if (e1.charAt(1) == '!' && find(e1.charAt(0)) == find(e1.charAt(3))) //如果x!=y 判断祖先是否相等
        return false;
    }
    return true;
  }

  public int find(int x) {
    // 两次循环 保证找到root
    if (x != parents[x]) {
      parents[x] = find(parents[x]);
    }
    return parents[x];
  }
}
