package 滑动窗口算法.定长窗口;

public class 定长子串中元音的最大数目1456 {
    public static void main(String[] args) {
        Solution1456 solution1456 = new Solution1456();
        int i = solution1456.maxVowels("leetcode", 3);
        System.out.println(i);
    }
}

class Solution1456 {
    public int maxVowels(String s, int k) {
        char[] array=s.toCharArray();
        int ans=0; //记录窗口中元音字母的总个数
        int vowel=0;
        //入
        for (int i=0;i<s.length();i++){
            //1.第一步进入窗口
            if (isYuan(array[i])){
                vowel++;
            }
            if (i<k-1){ //窗口不足k
                continue;
            }
            //2.更新答案
            ans=Math.max(ans,vowel);
            //3.出，窗口最左侧的元素出去
            if (isYuan(array[i-k+1])){
                vowel--;
            }
        }
        return ans;
    }
    public boolean isYuan(char ch){
        if (ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
}