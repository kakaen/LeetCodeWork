package 每日一题;



import java.util.Arrays;

public class 执行子串操作后的字典序最小字符串2734 {
    public static void main(String[] args) {
        Solution2734 solution2734 = new Solution2734();
        System.out.println(solution2734.smallestString("acbbc"));
        System.out.println(solution2734.smallestString("leetcode"));
        System.out.println(solution2734.smallestString("aa"));
    }
}
class Solution2734 {
    public String smallestString(String s) {
        int n=s.length();
        char[] charArray = s.toCharArray();
        //选取第一个不为'a'的元素作为替换的start
        int start=0;
        while (start<n&&charArray[start]=='a'){
            start++;
        }
        //如果都是’a'
        if (start==n){
            StringBuilder stringBuilder=new StringBuilder(s);
            stringBuilder.deleteCharAt(s.length()-1);
            stringBuilder.append('z');
            return stringBuilder.toString();
        }
        for (int i=start;i<n;i++){
            if (charArray[i]!='a'){
                charArray[i]=(char) (charArray[i]-1);
            }else {
                break;
            }
        }

        return String.copyValueOf(charArray);
    }
    public String smallestString2(String s){
        char[] charArray = s.toCharArray();
        int n=charArray.length;
        //先找到第一个不为‘a’的下标
        for (int i=0;i<n;i++){
            if (charArray[i]>'a'){
                for (;i<n&&charArray[i]>'a';i++){
                    charArray[i]=(char) (charArray[i]-1);
                }
                return new String(charArray);
            }
        }
        //所有字母都为‘a'
        charArray[n-1]='z';
        return new String(charArray);
    }
}

