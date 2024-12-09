package 难度训练;

import 单调栈.商品折扣的最终价格1475;

import java.util.Arrays;

public class 子数组和排序后的区间和1508 {
    public static void main(String[] args) {
        Solution1508 solution1508 = new Solution1508();
        int[] nums=new int[]{1,2,3,4};
        int n=4,left=1,right=5;
        System.out.println(solution1508.rangeSum(nums, n, left, right));
    }
}
class Solution1508 {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] res=new int[n*(n+1)/2];
        int k=0;
        for (int j=0;j<n;j++){
            for (int i=j;i<n;i++){
                if (i==j){
                    res[k]=nums[i];
                }else{
                    res[k]=res[k-1]+nums[i];
                }
                k++;
            }
        }
        System.out.println(Arrays.toString(res));
        Arrays.sort(res);
        int sum=0;
        for (int i=left-1;i<right;i++){
           sum=(sum+res[i])%1000000007;
        }

        return sum;
    }
}
