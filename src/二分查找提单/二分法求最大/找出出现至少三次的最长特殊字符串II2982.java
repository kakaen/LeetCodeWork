package 二分查找提单.二分法求最大;

public class 找出出现至少三次的最长特殊字符串II2982 {
    public static void main(String[] args) {

    }
}
class Solution2983 {
    public int maximumLength(String s) {
        //找最长特殊子串的长度,最长子串的长度作为二分的条件。
        int left=0,right=s.length()-1;
        int result=0;
        //只要存在三次就可以
        while (left<=right){
            int mid=left+(right-left)/2;
            if (check(s,mid)){
            }
        }
        return result==0?-1:result;
    }

    //判断是否存在长度为mid的特殊子串
    public boolean check(String s,int mid){
        if (mid==0) return true;

        return false;
    }
    //判断子串是否都是同一个字符
    public boolean isSignel(String s){
        for (int i=0;i<s.length()-1;i++){
            if (s.charAt(i)!=s.charAt(i+1)) return false;
        }
        return true;
    }
}
