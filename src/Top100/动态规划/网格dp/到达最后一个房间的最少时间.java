package Top100.动态规划.网格dp;

public class 到达最后一个房间的最少时间 {
    public static void main(String[] args) {
        到达最后一个房间的最少时间 test = new 到达最后一个房间的最少时间();
        System.out.println(test.minTimeToReach(new int[][]{{0, 4}, {0, 4}}));
        System.out.println(test.minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}));
        System.out.println(test.minTimeToReach(new int[][]{{94, 79, 62,27,69,84}, {6, 32, 11,82,42,30}}));
    }
    public int minTimeToReach(int[][] moveTime) {
        int n=moveTime.length;
        int m=moveTime[0].length;
        int[][] dp=new int[n][m]; //dp[i][j]表示移动出i,j处的最少时间
        //dp[i][j]=Math.min(dp[i-1][j]+,dp[i][j-1])+1+;
        dp[0][0]=0;
//        for (int j=1;j<m;j++){
//            dp[0][j]=Math.max(dp[0][j-1],moveTime[0][j])+1;
//        }
//        for (int i=1;i<n;i++){
//            dp[i][0]=Math.max(dp[i-1][0],moveTime[i][0])+1;
//        }
        for (int i=1;i<n-1;i++){
            for (int j=1;j<m;j++){
                //到达i,j出的最小时间
                dp[i][j]=Math.max(Math.min(dp[i+1][j],Math.min(dp[i-1][j],dp[i][j-1])),moveTime[i][j])+1;

            }
        }
        return dp[n-1][m-1];
    }
}
