package 滑动窗口算法.不定长窗口.不定长求最大;

public class 将x减到0的最小操作数1658 {
    public static void main(String[] args) {
        Solution1658 solution1658 = new Solution1658();
        int[] nums={1,1}; int x=3;
        System.out.println(solution1658.minOperations(nums, x));
    }

}
class Solution1658 {
    public int minOperations(int[] nums, int x) {
        //移除数组nums最左边或最右边的元素，然后从x中减去该元素的值
        //需要使x恰好减到0，返回最小操作数
        //先统计数组nums的总和，然后
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if (sum<x) return -1;
        int result=nums.length+1;
        //找最少的次数，就是使窗口内的总和达到sum-x所需的最大长度
        int left=0,right;
        int count=0;
        for (right=0;right<nums.length;right++){
            //
            count+=nums[right];
            //count的值可能小于等于sum-x，那需要右扩窗口
            while ((count>sum-x)){
                count-=nums[left];
                left++;
            }
            //如果count==sum-x则进行更新参数
            if (count==sum-x){
                result=Math.min(result,nums.length-(right-left+1));
            }
        }
        return result==nums.length+1?-1:result;
    }
    public int minOperations2(int[] nums,int x){
        int target=-x;
        for (int num:nums) target+=num;
        if (target<0) return -1; //就是说所有的数
        return 0;
    }
}