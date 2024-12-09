package 卡马网.背包问题;

public class 携带研究材料46 {
    public static void main(String[] args) {

    }
    public static void testWeightBagProblem(int[] weight,int[] value,int bagSize){
        int M=weight.length; //物品的种类数
        int N=bagSize; //背包的最大容量
        int[][] dp=new int[M][N+1]; //dp[i][j]表示容量为j时从0-i-1个物品中取的最大价值
        //dp[][0]=0;
        for (int i=0;i<M;i++){
            for (int j=1;j<=N;j++){
                //无法取第i-1个物品
                if (j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]])+value[i];
                }
            }
        }
    }
}
