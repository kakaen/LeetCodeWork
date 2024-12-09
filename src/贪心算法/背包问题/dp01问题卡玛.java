package 贪心算法.背包问题;

public class dp01问题卡玛 {
    public static void main(String[] args) {
        int[] weight= {2,2,3,1,5,2};
        int[] values={2,3,1,5,4,3};
        int bagSize=1;
        testWeightBagProblem(weight,values,bagSize);
    }
    public static void testWeightBagProblem(int[] weight, int[] value, int bagSize){
        //weight代表每个物品的重量
        //value代表每个物品的价值
        int n=weight.length;
        //创建dp[n][n]数组，每个代表从【0-i】
        //1.dp[i][j]：表示从0-i拿取物品，背包重量为j的最大价值
        int[][] dp=new int[n][bagSize+1];
        //2.初始化
        //2.1 当j=0时，即背包容量为0，则value=0
        for (int i=0;i<n;i++){
            dp[i][0]=0;
        }
        //2.2，当i=0时，即从0-0拿取物品，背包容量为j，可以获取的最大价值
        //如果j<weight[0] 那dp[0][j]=0.j>=weight[0] dp[0][j]=value[0]
        for (int j=weight[0];j<=bagSize;j++){
            dp[0][j]=value[0];
        }
        //3.状态转移方程
        for (int i=1;i<n;i++){
            for (int j=1;j<=bagSize;j++){
                if (j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[n-1][bagSize]);
    }

    public static void testWeightBagProblem2(int[] weight,int[] value,int bagSize){
        //在原有的基础上去除一维数组
        //dp[j]表示背包容量为j所能存放的最大价值
        int n=weight.length;
        int[] dp=new int[bagSize+1];
        //2.确定dp的推导公式
        //dp[j]可以有两个方向 dp[j-weight[i]]+value[i],此时有两个方向，一是不放i，二是放i
        //3.确定dp的初始化,dp[0]=0;
        dp[0]=0;
        for (int i=0;i<n;i++){  //遍历物品
            for (int j=weight[i];j<=bagSize;j++){

            }

        }

    }
}


