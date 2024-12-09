package 滑动窗口算法.不定长窗口;

public class 找到最长的半重复子字符串2730 {
    public static void main(String[] args) {
        Solution2730 solution2730 = new Solution2730();
        System.out.println(solution2730.longestSemiRepetitiveSubstring("52233"));
    }
}

class Solution2730 {
    public int longestSemiRepetitiveSubstring(String s) {
        //最多只有一对相邻字符是相等的，则称该字符串t是半重复的
        int count=0;
        int right=0,left=0;
        int sample=0;
        char[] arr=s.toCharArray();
        for (right=1;right<s.length();right++){
            //进入窗口
            char ch=arr[right];
            if (arr[right]==arr[right-1]){
                sample++;
            }
            //判断缩小窗口的左边界下标是否满足半重复
            while (sample>1){
                //如果当前窗口大于了
                left++;
                if (arr[left]==arr[left-1]) sample-=1;
            }
            //如果满足半重复子字符串的要求则更新子字符串的长度
            count=Math.max(count,right-left+1);
        }
        return count;
    }
}