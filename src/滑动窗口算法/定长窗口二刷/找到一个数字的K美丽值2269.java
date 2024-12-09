package 滑动窗口算法.定长窗口二刷;

public class 找到一个数字的K美丽值2269 {
    public static void main(String[] args) {

    }
}
class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        int left=0,right=0;
        int result=0,count=0;
        String str=String.valueOf(num); //将int转为string类型
        char[] charArray = str.toCharArray();
        int chushu=0;
        for (right=0;right<str.length();right++){
            //入窗口
            chushu=chushu*10+charArray[right]-'0';
            if (right<k-1) continue;
            //更新数字
            if (chushu!=0&&(num%chushu==0)) count++;
            //左边界出窗口
            chushu=chushu%((int)Math.pow(10,k-1));
        }
        return count;
    }
}
