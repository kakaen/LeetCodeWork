package 动态规划算法.网格dp;

import java.util.Scanner;

public class 珠宝的最高价值166 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        int n=scanner.nextInt();
        int[][] frame=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                frame[i][j]=scanner.nextInt();
            }
        }
        Solution166 solution166 = new Solution166();
        System.out.println(solution166.jewelleryValue2(frame));
    }
}
class Solution166 {
    public int jewelleryValue(int[][] frame) {
        int m=frame.length;
        int n=frame[0].length;
        //dp[i][j]表示到达第i，j处的最大价值
        int[][] dp=new int[m][n];
        //初始化
        dp[0][0]=frame[0][0];
        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+frame[i][0];
        }
        for (int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+frame[0][j];
        }
        //dp递推公式 dp[i][j]=Math.max(dp[i-1][j]，dp[i][j-1])
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i-1][j]+frame[i][j],dp[i][j-1]+frame[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
    public int jewelleryValue2(int[][] frame){
        //每次可以移动到右侧或下册
        int m=frame.length;
        int n=frame[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=frame[0][0];
        //dp[i][j]=dp[i][j-1],dp[i-1][j]
        //如果是第一行的话 即i=0的话，则dp[i][j]=dp[i][j-1]+frame
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (i==0&&j==0){
                    dp[i][j]=frame[i][j];
                }else if (j==0){
                    dp[i][j]=dp[i-1][j]+frame[i][j];
                }else if (i==0){
                    dp[i][j]=dp[i][j-1]+frame[i][j];
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+frame[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }
    public int jewelleryValue3(int[][] frame){
        //只能从架子的左上角开始拿珠宝，每次移动到右侧或下侧的相邻位置
        int m=frame.length;
        int n=frame[0].length;
        int[][]dp=new int[m][n]; //dp[i][j]表示到达第i,j处可以拿取到的最高价值珠宝
        //初始化状态
        dp[0][0]=frame[0][0];
        for (int i=1;i<m;i++){
            dp[i][0]=dp[i-1][0]+frame[i][0];
        }
        for (int j=1;j<n;j++){
            dp[0][j]=dp[0][j-1]+frame[0][j];
        }
        //dp[i][j]=dp[i][j-1]+dp[i-1][j]
        for (int i=1;i<m;i++){
            for (int j=1;j<n;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        //到达珠宝架子的右下角时，停止拿取
        return dp[m-1][n-1];
    }
}