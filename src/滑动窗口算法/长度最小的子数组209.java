package 滑动窗口算法;

public class 长度最小的子数组209 {
}
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        //这个j一定是终止位置，如果是起始位置，那跟暴力算法没区别了
        //如何移动起始位置
        int sum=0;
        int left=0;
        int result=nums.length+1;
        for (int j=0;j<nums.length;j++){
            sum+=nums[j];
            //如果sum>=s，则更新子数组的最小长度
            while (sum>=target){
                    //终止位置已经满足了条件，开始更新初始位置
                    result=Math.min(result,j-left+1);
                    sum-=nums[left];
                    left++;
                }
            }
        return result==nums.length+1?0:result;
    }
}