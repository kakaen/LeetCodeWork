package 难度训练;

public class 最长的字母序连续子字符串的长度2414 {
    public static void main(String[] args) {
        Solution2414 solution2414 = new Solution2414();
        System.out.println(solution2414.longestContinuousSubstring("abcde"));
    }
}
class Solution2414{
    public int longestContinuousSubstring(String s){
        //不定长窗口
        char[] arrs=s.toCharArray();
        int left=0,right=0;
        int n=arrs.length;
        int maxLen=0;
        int count=0;
        for (right=0;right<n;right++){
            //是否为第一次
            if (left!=right){
                //满足连续的条件
                if (arrs[right]-arrs[right-1]==1){
                    maxLen=Math.max(maxLen,right-left+1);
                }else{
                    left=right;
                }
            }else {
                maxLen=Math.max(maxLen,right-left+1);
            }
        }
        return maxLen;
    }
}
