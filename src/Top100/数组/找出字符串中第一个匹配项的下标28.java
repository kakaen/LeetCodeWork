package Top100.数组;

public class 找出字符串中第一个匹配项的下标28 {
    public static void main(String[] args) {
        找出字符串中第一个匹配项的下标28 test = new 找出字符串中第一个匹配项的下标28();
        String hatstack="sadbutsad";
        String needle="sad";
        String hatstack2="leetcode";
        String needle2="leeto";
        System.out.println(test.strStr(hatstack, needle));
        System.out.println(test.strStr(hatstack2, needle2));
    }
    public int strStr(String haystack,String needle){
        //在haystack字符串中找出needle字符串的第一个匹配项
        //如果needle不是haystack的一部分，则返回-1
        int n=haystack.length();
        int m=needle.length();
        for (int i=0;i<=n-m;i++){
            boolean flag=true;
            for (int j=0;j<m;j++){

            }
        }
        return -1;
    }
}
