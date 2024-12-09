package 难度训练;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class 字符串相乘43 {
    public static void main(String[] args) {

    }
}
class Solution43{
    public String multiply(String num1,String num2){
        char[] nums1=num1.toCharArray();
        char[] nums2=num2.toCharArray();
        int n1=num1.length();
        int n2=num2.length();
        int i=n1-1,j=n2-1;
        int flag=0; //设置进位
        StringBuilder builder=new StringBuilder();
        while (i>=0&&j>=0) {
            //得到乘积
            int num=(nums1[i]-'0')*(nums2[j]-'0');
            flag=num/10;
            builder.append(num%10);
        }
        return "";
    }
}
