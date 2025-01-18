package Top100二刷;

public class 判断子序列题目 {
    public static void main(String[] args) {
        判断子序列题目 test = new 判断子序列题目();
        System.out.println(test.isSubsequence("abc", "ahbgdc"));

    }
    public boolean isSubsequence(String s,String t){
        //s是否为t的子序列
        int i=0; //s的指针
        int j=0; //t的指针
        while (i<s.length()&&j<t.length()){
            //如果s的i下标存在一个
            if (s.charAt(i)==t.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s.length();
    }
}
