package 代码随想录.字符串;

public class 反转字符串344 {
    public static void main(String[] args) {

    }
}
class Solution344 {
    public void reverseString(char[] s) {
        //采用双指针的方式
        int left=0,right=s.length;
        char temp;
        while (left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
        }

    }
}