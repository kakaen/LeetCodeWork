package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 最长优雅子数组2401 {
}
class Solution2401 {
    public int longestNiceSubarray(int[] nums) {
        //不同位置的每对元素按位与(AND)运算的结果等于0，则称该子数组为优雅子数组
        int left=0,right=0;
        int result=0;
        List<Integer> list=new ArrayList<>();
        for (right=0;right<nums.length;right++){
            list.add(nums[right]);
            while (!isYouya(list)){
                list.remove(left);
                left++;
            }
            result= Math.max(result,right-left+1);
        }
        return result;
    }
    public boolean isYouya(List<Integer> list){
        if (list.size()==1) return true; //说明是优雅子数组
        int lastNumber=list.get(list.size()-1);
        for (int i=0;i<list.size()-1;i++){
            if ((lastNumber& list.get(i))!=0){
                return false;
            }
        }
        return true;
    }
}