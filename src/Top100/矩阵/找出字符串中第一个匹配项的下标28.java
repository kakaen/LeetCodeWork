package Top100.矩阵;

public class 找出字符串中第一个匹配项的下标28 {
    public static void main(String[] args) {
        找出字符串中第一个匹配项的下标28 test = new 找出字符串中第一个匹配项的下标28();
        System.out.println(test.strStr("sadbutsad", "sad"));
        System.out.println(test.strStr("leetcode","leeto"));
    }
    public int strStr(String haystack,String needle){
        int n1=haystack.length();
        int n2=needle.length();
        if (n2>n1) return -1;
        for (int i=0;i<=n1-n2;i++){
            int j=0;
            for (;j<n2;j++){
                if (haystack.charAt(i+j)!=needle.charAt(j)){
                    break;
                }
            }
            if (j==n2) return i;
        }
        return -1;
    }
    //使用KMP算法来实现字符匹配算法
    public int strStrKMP(String haystack,String needle){
        return 10;
    }
}
