package 滑动窗口算法.定长窗口;

import java.util.Arrays;

public class 学生分数的最小差值1984 {
    public static void main(String[] args) {
        Solution1984 solution1984 = new Solution1984();
        int[] nums={9,4,1,7};
        int k=2;
        System.out.println(solution1984.minimumDifference(nums, k));
    }
}
class Solution1984 {
    public int minimumDifference(int[] nums, int k) {
        int ans=Integer.MAX_VALUE;
        int temp=0;
        //把数组进行排序
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            //第一步，进入窗口
            int max=nums[i]; //最大值
            if (i<k-1){
                continue;
            }
            //第二步更新答案
            ans=Math.min(ans,max-nums[i-k+1]);
            //第三步出

        }
        return ans;
    }
}