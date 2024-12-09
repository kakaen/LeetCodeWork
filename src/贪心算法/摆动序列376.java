package 贪心算法;

import sun.misc.Unsafe;

public class 摆动序列376 {
    public static void main(String[] args) {

    }
}

class Solution376 {
    public int wiggleMaxLength(int[] nums) {
       if(nums.length<=1) return nums.length;
       int curDiff=0;
       int preDiff=0;
       int result=1; //记录峰值个数，序列默认最右侧有
        for (int i=0;i<nums.length;i++){
            curDiff=nums[i+1]-nums[i]; //后一个减当前一个
            //出现峰值
            if ((preDiff<=0&&curDiff>0)||(preDiff>=0&&curDiff<0)){
                result++;
                preDiff=curDiff;
            }

        }
        return result;
    }
    public int wiggleMaxLength2(int[] nums){
        int down=1,up=1;
        for (int i=1;i<nums.length;i++){
            if (nums[i]>nums[i-1]){
                up=down+1;
            }
        }
        return 0;
    }
}
