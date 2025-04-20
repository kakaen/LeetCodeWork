package 美团2024;

import java.util.Scanner;

public class 小美的文本文件 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        String[] arr=new String[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.next();
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(function(arr[i]));
        }

    }
    public static String function(String s){
        char[] chars=s.toCharArray();
        StringBuilder builder=new StringBuilder();
        int n=s.length();
        for (int i=0;i<chars.length;i++){
            if (chars[i]!='R'&&chars[i]!='Z'){
                builder.append(chars[i]);
            }
            if (chars[i]=='R'){
                builder.reverse();
            }
            if (chars[i]=='Z'){
                if (i==0){
                    continue;
                }
                else if (chars[i-1]=='R') {
                    builder.reverse();
                } else if (chars[i-1]!='R') {
                    builder.deleteCharAt(builder.length()-1);
                }
            }
        }
        return builder.toString();
    }
}
