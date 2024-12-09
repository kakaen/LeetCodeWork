package 贪心算法;

import java.util.Arrays;

public class 无重叠区间435 {
    public static void main(String[] args) {

    }
}
class Solution435{
    public int eraseOverlapIntervals(int[][] intervals){
        int result=0;
        int count=0; //记录重叠区间个数
        //先把数组进行排序
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        for (int i=1;i<intervals.length;i++){
            //如果第二个区间的左侧值小于第一个区间的右边界，则重叠了
           if (intervals[i][0]<intervals[i-1][1]){
               count++;
               intervals[i][1]=Math.min(intervals[i-1][1],intervals[i][1]);
           }
        }
        return result;
    }
}
