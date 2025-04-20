package 拼多多提单;

import java.util.Scanner;

public class 字符串右移三位O1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        char[] chars=str.toCharArray();
        reverse(chars,0,chars.length-1);
        reverse(chars,0,2);
        reverse(chars,3,chars.length-1);
        System.out.println(new String(chars));
        }
    public static void reverse(char[] chars,int left,int right) {
        while (left<right){
            char temp=chars[left];
            chars[left]=chars[right];
            chars[right]=temp;
            left++;
            right--;
        }
    }
    }
