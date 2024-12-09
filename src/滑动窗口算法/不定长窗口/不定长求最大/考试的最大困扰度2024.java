package 滑动窗口算法.不定长窗口.不定长求最大;

import java.util.Map;

public class 考试的最大困扰度2024 {
    public static void main(String[] args) {
        Solution2024 solution2024 = new Solution2024();
        int i = solution2024.maxConsecutiveAnswers("TFFT", 1);
        System.out.println(i);
    }
}
class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        //最大化有连续相同结果的题数,不超过k次，
        char[] arr=answerKey.toCharArray();
        int left=0;
        int FCount=0;
        int TCount=0;
        int result=0;
        for (int right=0;right<answerKey.length();right++){
            //进入窗口,计算T或F的数量个数
            if (arr[right]=='F'){
                FCount++;
            }else {
                TCount++;
            }
            //如果两个都大于k了，那肯定不行了，因此判断K
            while (FCount>k&&TCount>k){
                //收缩左边界
                if (arr[left]=='F'){
                    FCount--;
                }else {
                    TCount--;
                }
                left++;
            }
            //更新答案
            result= Math.max(result,right-left+1);
            result=Math.max(result,right-left+1);
            //返回答案结果

        }
        return result;
    }
}