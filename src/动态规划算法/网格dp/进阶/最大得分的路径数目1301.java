package 动态规划算法.网格dp.进阶;

import java.util.List;

public class 最大得分的路径数目1301 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int maxScore = 0;
        int count = 0;
        //就是从（0,0）出发到达最右下角的路径和，以及方案最大得分的方案数
        //每次移动可以向右，向下，向右下移动
        int n = board.size();
        char[][] chars = new char[n][n];
        int[][] dp = new int[n][n]; //dp[i][j]表示到达i,j处的最大得分
        //dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j],dp[i-1][j-1]);
        //三个方向，初始状态
        for (int j = 0; j < n; j++) {
            char ch = chars[0][j];
            if (ch >= '0' && ch <= '9')
                dp[0][j] += 0;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(0, 0);
            }
        }
        return new int[]{2, 2};
    }
}

