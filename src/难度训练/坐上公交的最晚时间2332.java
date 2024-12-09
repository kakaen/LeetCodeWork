package 难度训练;

import java.util.Arrays;

public class 坐上公交的最晚时间2332 {
    public static void main(String[] args) {

    }
}
class Solution2332{
    public int latestTimeCatchTheBus(int[] buses,int[] passengers,int capacity){
        //下标从0开始长度为n的整数数组buses
        //passengers到达车站的时间。
        //把buses和乘客的时间进行排序，按照时间顺序
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int len1=buses.length;
        int len2=passengers.length;
        int maxTime=Integer.MIN_VALUE; //到达的最晚时间
        int j=0; //遍历乘客的到达时间
        //假设我没有上这辆车如果在y时刻到达，公交在x时刻出发
        //顺序访问车辆的到达时间
        for (int i=0;i<len1;i++){
            int busTime=buses[i]; //公交车的到达时间,假设我需要上这个车，那我的最大到达时间一定小于等于
            while (passengers[j]<busTime&&capacity>0){

            }
        }
        return 0;
    }
}
