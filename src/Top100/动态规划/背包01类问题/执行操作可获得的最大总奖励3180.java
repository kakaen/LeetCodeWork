package Top100.动态规划.背包01类问题;

import java.util.Arrays;

public class 执行操作可获得的最大总奖励3180 {
    public static void main(String[] args) {
        执行操作可获得的最大总奖励3180 test = new 执行操作可获得的最大总奖励3180();
        System.out.println(test.maxTotalReward2(new int[]{1, 6, 4, 3, 2}));
        System.out.println(test.maxTotalReward2(new int[]{1, 1, 3, 3}));
        System.out.println(test.maxTotalReward2(new int[]{1}));
    }
    //使用动态规划的方法来实现
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int max=0;
        int maxCount = 0;
        for (int num:rewardValues){
            maxCount+=num;
        }
        //先取消的
        Arrays.sort(rewardValues);
       //dp[i][j]表示能否从前i个元素中构造出count奖励
        boolean [][] dp=new boolean[n+1][maxCount+1];
        dp[0][0]=true;
        //dp[i][j]的递推公式,dp[i][j]= //选当前元素dp[i-1][]，不选当前元素 dp[i-1][j]
        for (int i=1;i<=n;i++){
            int num=rewardValues[i-1]; //第i个数字的奖励
            for (int j=0;j<=maxCount;j++){
                if (num<=j&&j<2*num){ //如果num的值大于j，则i肯定不是选择的
                    dp[i][j]=dp[i-1][j-num]||dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
       for (int i=0;i<=maxCount;i++){
           if (dp[n][i]){
               max=Math.max(max,i);
           }
       }
        return max;
    }
    //进行状态空间压缩
    public int maxTotalReward2(int[] rewardValues){
        Arrays.sort(rewardValues);
        int n=rewardValues.length;
        int maxNum=0;
        for (int num:rewardValues){
            maxNum=Math.max(maxNum,num);
        }
        boolean[] dp=new boolean[2*maxNum-1];
        dp[0]=true;
        for (int num:rewardValues){
            for (int j=2*maxNum-1;j>=0;j--){
                if (num<=j&&2*num>j){
                    dp[j]=dp[j-num]||dp[j];
                }
            }
        }
        int max=0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]){
                max=i;
            }
        }
        return max;
    }
}

//使用暴力回溯的方法
class Solution3180 {

    public static int max = 0;
    public static int path = 0;

    //暴力回溯的方法，会超时，这里的时间复杂度太高。
    public int maxTotalReward(int[] rewardValues) {
        int n = rewardValues.length;
        int count = 0;
        Arrays.sort(rewardValues);
        int max=0; //存储最大值
        int path=0;
        dfs(rewardValues,0);
       return max;
    }
    public void dfs(int[] rewardValues, int start) {
        if (start == rewardValues.length) {
           return;
        }
        for (int i = start; i < rewardValues.length; i++) {
            if (rewardValues[i] > path) {
                path += rewardValues[i];
                dfs(rewardValues, i + 1);
                path -= rewardValues[i];
            }
        }
    }
}


