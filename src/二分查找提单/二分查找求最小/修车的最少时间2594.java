package 二分查找提单.二分查找求最小;

import java.util.Arrays;
import java.util.Map;

public class 修车的最少时间2594 {
}
class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        //ranki是第i位机械工的能力值，能力值 r*n^2可以修好n辆车
//        Arrays.sort(ranks);
        int n=ranks.length;
        long result=0;
        //rank值越大修理速度越慢。能力值越强（rank值最小的人），修的应该越多
        //如何分配每个人修的车数呢？ n^2,因此每个人
        //在预估的时间内能不能修好
        //将时间作为二分法，最少时间为1，最大时间为 能力值最弱的*car*car
        int maxRank=0;
        for (int rank:ranks){
            if (rank>maxRank) maxRank=rank;
        }
        long left=1,right=maxRank*cars*cars;
        while (left<=right){
            long time=left+(right-left)/2;
            //check函数，判断是否能在当前时间完成n辆车的组装
            if (check(time,ranks,cars)) {
                result =time;
                right = time - 1;
            }else {
                left=time+1;
            }
        }
        return result;
    }
    //判断在指定时间内，能否完成n辆车的组装
    public boolean check(long time,int[] rank,int cars){
        //根据time来反推所有人在指定时间能够组装的车辆
        long count=0;
        for (int i=0;i<rank.length;i++){
            count=count+ (long)Math.sqrt((double) time/rank[i]);
        }
        if (count<cars) return false;
        return true;
    }
}