package Top100二刷.二分查找.二分法求最小;

import java.util.Arrays;

public class 完成旅途的最少时间2187 {
    public long minimumTime(int[] time,int totalTrips){
        //times[i]
        Arrays.sort(time);
        //最大要大於等於time[0]*totalTrips
        long l=0;
        long r=(long)time[0]*totalTrips;
        System.out.println(r);
        while (l<=r){
            long m=l+(r-l)/2;
            long sum=0;
            for (long t:time){
                sum+=m/t;
            }
            if (sum<totalTrips){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        完成旅途的最少时间2187 test = new 完成旅途的最少时间2187();
        int[] time=new int[]{1,2,3};
        int[] time2=new int[]{2};
        int[] time3=new int[]{1000};

        System.out.println(test.minimumTime(time, 5));
        System.out.println(test.minimumTime(time2, 1));
        System.out.println(test.minimumTime(time3, 10000000));
    }
}
