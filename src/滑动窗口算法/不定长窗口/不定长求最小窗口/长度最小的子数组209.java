package 滑动窗口算法.不定长窗口.不定长求最小窗口;

public class 长度最小的子数组209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int target=7;
        int[] nums={2,3,1,2,4,3};
        System.out.println(solution209.minSubArrayLen(target, nums));
    }
}
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right;
        int count=nums.length+1;
        int sum=0;
        for (right=0;right<nums.length;right++){
            sum+=nums[right];
            //判断是否大于等于target，如果大于等于target，则右移左
            while (sum-nums[left]>=target){
                sum-=nums[left];
                left++;
            }
            if (sum>=target){
            count=Math.min(count,right-left+1);

            }
        }
        return count== nums.length+1?0:count;
    }
}