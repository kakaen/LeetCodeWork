package 滑动窗口算法.定长窗口二刷;

import java.util.HashMap;
import java.util.Map;

public class 最少交换次数来组合所有的1II2134 {
    public static void main(String[] args) {
        Solution2134 solution2134 = new Solution2134();
        int[] nums={0,1,1,1,0,0,1,1,0};
        int i = solution2134.minSwaps(nums);
        System.out.println(i);
    }
}
class Solution2134 {
    public int minSwap2(int[] nums){
        int cnt=0; //统计1的个数
        for (int num:nums){
            cnt+=num;
        }
        if (cnt==0) return 0;
        int cur=0;
        int n=nums.length;
        //统计0的个数
        int left=0,right=0;
       while (left<n){

       }
       return 0;
    }
    public int minSwaps(int[] nums) {
        //互不相同的位置进行交换，就是查看包含所有1的最少0元素
        //从-1开始枚举，其中-1对应为最后的元素
        //第一步先统计1的个数
        int oneCount=0;
        for (int num : nums) {
            if (num==1) oneCount++;
        }
        //第二步，一的个数就是窗口大小(oneCount)，然后从-1开始枚举
        int left=0,right=-1;
        int n=nums.length;
        int zeroCount=0;
        int result=Integer.MAX_VALUE;

        //进行滑动窗口的取值,窗口大小为OneCount
        while (left<n){
            //右边界进入窗口,right%n,是为了循环
            right++;
            int num=nums[right%n];
            if (num==0) zeroCount++;
            if ((left!=n-1)&&right<oneCount-1) continue;
            //更新答案值，最少0的个数
            result=Math.min(result,zeroCount);
            //左边界出
            if (nums[left]==0) {
                zeroCount--;
            }
            left++;
        }
        return result;
    }
}
