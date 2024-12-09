package 每日一题;

import java.util.Arrays;

public class 最小元素和最大元素的最小平均值3194 {
    public static void main(String[] args) {
        最小元素和最大元素的最小平均值3194 test = new 最小元素和最大元素的最小平均值3194();
        System.out.println(test.minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
        System.out.println(test.minimumAverage(new int[]{1, 9, 8, 3, 10, 5}));
    }
    public double minimumAverage(int[] nums){
        int n=nums.length; //n为偶数
        //每次从nums中移除最小和最大的元素。，找到最小和最大数之和的最小元素
        Arrays.sort(nums);
        double min=Double.MAX_VALUE;
        int i=0,j=n-1;
        while (i<j){
            min=Math.min(min,nums[i]+nums[j]);
            i++;
            j--;
        }
        return min/2;
    }
}
