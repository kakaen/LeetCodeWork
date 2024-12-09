package 滑动窗口算法.定长窗口二刷;

public class 定长子串中元音的最大数目 {
    public static void main(String[] args) {

    }
}
class Solution1456{
    public int maxVowels(String s,int k){
        int left=0,right=0;
        int result=0,count=0;
        char[] charArray = s.toCharArray();
        for (right=0;right<s.length();right++){
            //右边界进行扩充
            if (isVowel(charArray[right])) count++;
            //判断是否满足窗口长度
            if (right<k-1) continue;
            //更新答案
            result=Math.max(count,result);
            //左边界出窗口
            if (isVowel(charArray[left++])) count--;
        }
        return result;
    }
    public boolean isVowel(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
