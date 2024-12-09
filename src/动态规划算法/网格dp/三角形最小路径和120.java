package 动态规划算法.网格dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class 三角形最小路径和120 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt();
        List<List<Integer>> triangle=new ArrayList<>();
        //消耗掉换行符
        scanner.nextLine();
        for (int i=0;i<m;i++){
            List<Integer> row=new ArrayList<>();
            String line=scanner.nextLine();
            String[] number=line.split(" ");
            for (String num:number){
                row.add(Integer.parseInt(num));
            }
            triangle.add(row);
        }
        for (List<Integer> list : triangle) {
            for (Integer i : list) {
                System.out.print(i+" ");
            }
            System.out.println("------");
        }
        Solution120 solution120 = new Solution120();
        System.out.println(solution120.minimumTotal(triangle));
    }
}
class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        //自顶向下的最小路径和，每一步只能移动到下一行中相邻的节点上，
        int m= triangle.size();
        int n=triangle.get(m-1).size();
        int[][] dp=new int[m][n]; //到达第i层的最
        //dp[i][j]表示到达i，j所需的最小路径和，
        //初始化状态
        dp[0][0]=triangle.get(0).get(0);
        // 到达i，j有 dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle[i][j]
        for (int i=1;i<triangle.size();i++){
            //最左侧的只能来自
            dp[i][0]=dp[i-1][0]+triangle.get(i).get(0);
            List<Integer> list = triangle.get(i);
            for (int j=1;j<i;j++){
                dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+list.get(j);
            }
            dp[i][i]=dp[i-1][i-1]+triangle.get(i).get(i);
        }
        int min=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            if (dp[m-1][j]<min) min=dp[m-1][j];
        }
        return min;
    }
    public int minmumTotal2(List<List<Integer>> triangle){
        //每一步只能移动到下一行中相邻的节点上
        int n=triangle.size();
        int[][] dp=new int[n][n]; //dp[i][j]表示到达(i,j)的最小路径和
        //dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1]);
        // 这里需要判断该j是否为边界值，即j==0或j==i，则
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                } else if(j==i){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1])+triangle.get(i).get(j);
                }
            }
        }
        int res=Integer.MAX_VALUE;
        for (int j=0;j<n;j++){
            if (dp[n-1][j]<res) res=dp[n-1][j];
        }
        return res;
    }
}
