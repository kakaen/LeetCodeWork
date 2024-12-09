package 滑动窗口算法.不定长窗口二刷;

public class 和为K的子数组560 {
    public static void main(String[] args) {

    }
}
class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        int left=0,right=0;
        int sum=0;
        if (k==0) return 1;
        for (right=0;right<nums.length;right++){
            sum+=nums[right]; //右边界入窗口。
            while (sum>k){
                sum-=nums[left];
                left++;
            }
            if (sum==k) count++;
        }
        return count;
    }
}
