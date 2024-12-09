package 每日一题;

import java.util.Arrays;

public class 完成旅途的最少时间2187 {
    public static void main(String[] args) {

    }
}
class Solution2187{
    public long minimumTime(int[] time,int totalTrips){
        //time表示第i辆公交车完成一趟旅途所需要花费的时间
        Arrays.sort(time); //将time排序后
        if (totalTrips<=0) return 0;
        long totalTime=0;
        //从最小时间开始time[0]
        while (totalTrips!=0){
            for (int i=0;i<time.length;i++){

            }
        }
        for (int i=0;i<time.length;i++){

        }
        return 0;
    }
}
