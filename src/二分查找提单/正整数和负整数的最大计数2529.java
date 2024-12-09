package 二分查找提单;

public class 正整数和负整数的最大计数2529 {
    public static void main(String[] args) {
    }
}
class Solution2529 {
    public int maximumCount(int[] nums) {
        //统计正整数和负整数的数目中的最大值
        //如何统计负整数的个数,找到第一个大于-1的下标，那 0--left就是负整数的数目
        int left=lowerbound(nums,-1);
        int negativeCount=left+1;
        //如何统计正整数的个数呢，找到第一个大于0的下标
        int left2=lowerbound(nums,0);
        int count2=nums.length-left2;
        return Math.max(negativeCount,count2);
    }

    public int lowerbound(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}
