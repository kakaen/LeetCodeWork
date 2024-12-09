package 动态规划算法;

import java.util.HashMap;

public class 使用最小花费爬楼梯746 {

}
class Solution746 {
    public int minCostClimbingStairs(int[] cost) {
        return dfs(cost.length,cost);
    }
    public int dfs(int i,int[] cost){
        if (i<=1) return 0;
        int res1=dfs(i-1,cost)+cost[i-1];
        int res2=dfs(i-2,cost)+cost[i-2];
        return Math.min(res1,res2);
    }
}