package 每日一题;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 执行操作可获得的最大总奖励I3180 {
    public int maxTotalReward(int[] rewardValues){
        //从区间[0,n-1]选择一个未标记的下标i
        //将rewardValues[i]大于当前x的总奖励
        int n=rewardValues.length;
        int[][] dp=new int[n][2]; //记录当前第i个下标是否被标记
        int x=0;
        Arrays.sort(rewardValues); //先将数组进行排序
        for (int i=2;i<n;i++){

        }

        return 0;
    }
}
