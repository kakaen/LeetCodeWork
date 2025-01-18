package Top100二刷.滑动窗口.定长滑动窗口;

public class 子数组最大平均数I643 {
    public static void main(String[] args) {
        子数组最大平均数I643 test = new 子数组最大平均数I643();
        System.out.println(test.findMaxAverage(new int[]{-1}, 1));
    }
    public double findMaxAverage(int[] nums, int k) {
        //给你一个由n个元素组成的整数数组nums和一个整数k。
        //找出平均数最大且长度为k的连续子数组，并输出改最大平均数
        double ans=Double.MIN_VALUE;
        double count=0;
        int l=0;
        for (int r=0;r<nums.length;r++){
            //1.入窗口
            count+=nums[r];
            if (r<k-1) continue; //还未达到窗口长度
            //2.更新
            ans=Math.max(ans,count);
            //3.右移左指针
            count-=nums[l++];
        }
        return ans/k;
    }
}
