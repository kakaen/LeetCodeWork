package 动态规划算法.矩阵;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 三角形最小路径和120 {
    public static void main(String[] args) {
        三角形最小路径和120 test = new 三角形最小路径和120();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        l1.add(2);
        List<Integer> l2=new ArrayList<>();
        l2.add(3); l2.add(4);
        List<Integer> l3=new ArrayList<>();
        l3.add(6);l3.add(5);l3.add(7);
        List<Integer> l4=new ArrayList<>();
        l4.add(4);l4.add(1);l4.add(8);l4.add(3);
        res.add(l1);res.add(l2);res.add(l3);res.add(l4);
        System.out.println(test.minimumTotal(res));
    }
    public int minimumTotal(List<List<Integer>> triangle){
       int n=triangle.size(); //总共有n层，
        int[][] dp=new int[n][n]; //dp[i][j]表示到达第i，j位置的最小路径和
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j]=dp[i-1][j]+triangle.get(i).get(j);
                }else if (j==i){
                    dp[i][j]=dp[i-1][j-1]+triangle.get(i).get(j);
                }else{
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j])+triangle.get(i).get(j);
                }
            }
        }
        int min=dp[n-1][0];
        for (int num:dp[n-1]){
            if (num<min){
                min=num;
            }
        }
        return min;
    }
    //空间状态压缩的方法
    public int minimumTotal2(List<List<Integer>> triangle){
        int n=triangle.size(); //总共有多少层
        //定义dp数组
        int[] dp=new int[n];
        dp[0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            dp[i]=dp[i-1]+triangle.get(i).get(i);
            for (int j=i-1;j>0;j--){
                dp[j]=Math.min(dp[j-1],dp[j])+triangle.get(i).get(j);
            }
        }
        return 0;

    }
    public int minimumToTal3(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] dp=new int[n][n]; //dp[i][j]表示到达(i,j)处的最小路径
        dp[0][0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            for (int j=0;j<=i;j++){
                if (j==0){
                    dp[i][j]=dp[i-1][j];
                } else if (j==i) {
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i-1][j]);
                }
                dp[i][j]=dp[i][j]+triangle.get(i).get(j);
            }
        }
        int minRes=dp[n-1][0];
        for (int num:dp[n-1]){
            if (num<minRes) minRes=num;
        }
        return minRes;
    }
    //空间优化
    public int minimumToTal4(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] f=new int[2][n];
        f[0][0]=triangle.get(0).get(0);

        for (int i=1;i<n;i++){
            int cur=i%2;
            int pre=1-cur;
            f[cur][0]=f[pre][0]+triangle.get(i).get(0);
            for (int j=1;j<i;j++){
                f[cur][j]=Math.min(f[pre][j],f[pre][j-1])+triangle.get(i).get(j);
            }
            f[cur][i]=f[pre][i-1]+triangle.get(i).get(i);

        }
        int min=f[(n-1)%2][0];
        for (int num:f[(n-1)%2]){
            if (min>num) min=num;
        }
        return min;
    }
    //再次优化内存空间占比
    public int minimumToTal5(List<List<Integer>> triangle){
        int n=triangle.size();
        int[] f=new int[n];
        f[0]=triangle.get(0).get(0);
        for (int i=1;i<n;i++){
            f[i]=f[i-1]+triangle.get(i).get(i);
            for (int j=i-1;j>0;j--){
                f[j]=Math.min(f[j-1],f[j])+triangle.get(i).get(j);
            }
            f[0]=f[0]+triangle.get(i).get(0);
        }
        int min=f[0];
        for (int num:f){
            if (min>num) min=num;
        }
        return min;
    }
}
