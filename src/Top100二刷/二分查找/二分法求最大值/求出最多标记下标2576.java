package Top100二刷.二分查找.二分法求最大值;

import java.util.Arrays;

public class 求出最多标记下标2576 {
    public static void main(String[] args) {
        求出最多标记下标2576 test = new 求出最多标记下标2576();
        System.out.println(test.maxNumOfMarkedIndices(new int[]{3, 5, 2, 4}));
        System.out.println(test.maxNumOfMarkedIndices(new int[]{9,2,5,4}));
        System.out.println(test.maxNumOfMarkedIndices(new int[]{7,6,8}));
    }
    //选择两个互不相同且未标记的下标i和j，满足2*nums[i]<=nums[j]
    public int maxNumOfMarkedIndices(int[] nums) {
      //如果可以匹配k对，则也可以匹配小于k对，去掉一些数对即可
        //如果无法匹配k对，那也无法匹配大于k对
        //因此具有单调性,能否从nums中选出k个能匹配的数对
        Arrays.sort(nums);//将
        //nums[i]要和nums[n-k+i]进行匹配
        //二分法：left，right
        int n=nums.length;
        int left=0;
        int right=n/2; //我们是闭区间
        while (left<=right){
            int m=left+(right-left)/2;
            //找第一个不满足的l，那r就是最大满足的
            if (!check(nums,m)){
                right=m-1;
            }else{
                left=m+1;
            }
        }
        return right*2; //最多匹配right对
    }
    public boolean check(int[] nums,int m){
        int n=nums.length;
       //
        for (int i=0;i<m;i++){
            if (2*nums[i]>nums[n-m+i]) return false;
        }
        return true;
    }
}
