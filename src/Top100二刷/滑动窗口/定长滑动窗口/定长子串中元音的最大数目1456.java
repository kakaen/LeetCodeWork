package Top100二刷.滑动窗口.定长滑动窗口;

public class 定长子串中元音的最大数目1456 {
    public static void main(String[] args) {
        定长子串中元音的最大数目1456 test = new 定长子串中元音的最大数目1456();
        System.out.println(test.maxVowels("abciiidef", 3));
    }
    public int maxVowels(String s, int k) {
        //整数k为窗口的长度。
        char[] chars = s.toCharArray();
        int ans=0;
        int l=0,r=0;
        int count=0;
        for (r=0;r<chars.length;r++){
            if (check(s.charAt(r))) count++;
            if (r<k-1) continue; //还没达到窗口值大小
            //达到了窗口值大小，记录答案，并左移left指针
            ans=Math.max(ans,count);
            if (check(s.charAt(l))) count--;
            l++;
        }
        return ans;
    }
    public boolean check(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}
