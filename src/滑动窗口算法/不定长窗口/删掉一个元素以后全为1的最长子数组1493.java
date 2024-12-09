package 滑动窗口算法.不定长窗口;

public class 删掉一个元素以后全为1的最长子数组1493 {
}
class Solution {
    public int longestSubarray(int[] nums) {
        int start=0,end=0;
        int result=Integer.MIN_VALUE;
        //记录窗口
        int zeroCount=0;
        int zeroIndex=-1;
        for (end=0;end<nums.length;end++){
            //说明有一个0了，又来一个0
            if (zeroCount==1&&nums[end]==0){
                //需要进行修改初始位置
                start=zeroIndex+1;
            } else if (nums[end]==0) {
                //如果是第一个0
                zeroCount++;
                zeroIndex=end;
            }else {
                result=Math.max(result,end-start+1);
            }
        }

        return result==Integer.MIN_VALUE?0:result;
    }
}