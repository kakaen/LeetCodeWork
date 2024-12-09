package 滑动窗口算法.不定长窗口.不定长求最大;

public class 最大连续1的个数III1004 {
    public static void main(String[] args) {
        Solution1004 solution1004 = new Solution1004();
        int[] nums={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(solution1004.longestOnes(nums, 2));
    }
}
class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int result=0;
        int left=0;
        int zeroCount=0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right]==0) zeroCount++;
            while (zeroCount>k){
                if (nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            //更新答案
            result=Math.max(result,right-left+1);
        }
        return result;
    }
}
