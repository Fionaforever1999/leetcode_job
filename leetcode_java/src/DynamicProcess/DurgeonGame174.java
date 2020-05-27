package DynamicProcess;

public class DurgeonGame174 {

  public int DurgeonGame(int[][] dungeon) {
    int row = dungeon.length;
    int col = dungeon[0].length;
    // dp means the min hp that K need from top to bottom
    int[][] dp = new int[row + 1][col + 1];//dp  => dp[i][j + 1] and dp[i+1][j]
    int max = Integer.MAX_VALUE;

    // 最后的值要保证 minHP - dungeon[-1][-1] == 1
    dp[row - 1][col - 1] = dungeon[row - 1][col - 1] > 0 ? 1 : -dungeon[row - 1][col - 1] + 1;

    // set all edge value as max_value
    for (int i = 0; i <= row; i++) {
      dp[i][col] = max;
    }
    for (int j = 0; j < col; j++) {
      dp[row][j] = max;
    }

    for (int i = row - 1; i >= 0; i--) {
      for (int j = col - 1; j >= 0; j--) {
        if (i == row - 1 && j == col - 1) continue; // 如果是最后一个值跳过
        dp[i][j] = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j]; // 倒过来思考 找出向右或者向下走哪个最小
        if (dp[i][j] <= 0) dp[i][j] = 1;
      }
    }
    return dp[0][0];
  }
}
