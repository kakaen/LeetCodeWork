package 每日一题;

public class 超级饮料的最大强化能量3259 {
    public static void main(String[] args) {
        超级饮料的最大强化能量3259 test = new 超级饮料的最大强化能量3259();
        System.out.println(test.maxEnergyBoost(new int[]{1, 3, 1}, new int[]{3, 1, 1}));
        System.out.println(test.maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }
    public long maxEnergyBoost(int[] energyDrinkA,int[] energyDrinkB) {
        int n = energyDrinkA.length;
        //返回在接下来n小时内你能获得到的最大总强化能量
        //每小时提供的能力，切换饮料会等待一小时
        //什么时候需要进行切换饮料呢？使用动态规划
        //int[] dp=new int[]  //dp[i]表示第i个小时可以喝到的最大值。
        // dpA[i]=Math.max(dpA[i-1],dpB[i-2])+energyDrinkA[i];
        long[] dpA = new long[n]; //表示第i个小时我们选择喝A的最大值
        long[] dpB = new long[n]; //表示第i个小时，我们喝B的最大值
        dpA[0] = energyDrinkA[0];
        dpB[0] = energyDrinkB[0];
        dpA[1] = dpA[0] + energyDrinkA[1];
        dpB[1] = dpB[0] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            dpA[i] = Math.max(dpA[i - 1], dpB[i - 2]) + energyDrinkA[i];
            dpB[i] = Math.max(dpB[i - 1], dpA[i - 2]) + energyDrinkB[i];
        }
        return Math.max(dpA[n - 1], dpB[n - 1]);
    }
}
