package 笔试真题.京东;

import java.util.*;

public class 敏感词库1 {
    public static void main(String[] args) {
        //s中任何一个字符在在形式上术语一个
        Scanner scanner = new Scanner(System.in);
        int n= scanner.nextInt(); //敏感词库中的数量
        String S=scanner.next();
        String[] words=new String[n];
        for (int i=0;i<n;i++){
            words[i]=scanner.next();
        }
        func(S,words);

    }
    public static void func(String S,String[] words){
        int n=words.length;
        int len=S.length();
        Set<Integer> set=new HashSet<>();
        for (String str:words){
            //将每个敏感词和S进行比较
            isSubStr(str,S,set);
        }
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<S.length();i++){
            if (set.contains(i)){
                builder.append("*");
            }else{
                builder.append(S.charAt(i));
            }
        }
        System.out.println(builder.toString());
    }
    public static void isSubStr(String str,String S,Set<Integer> set) {
        int index=-1;
        if (str.length()>S.length()) return;
        for (int i=0;i<=S.length()-str.length();i++){
            int j=0;
            for (j=0;j<str.length();j++){
                if (str.charAt(j)!=S.charAt(i+j)){
                    break;
                }
            }
            if (j==str.length()){
                for (int k=i;k<i+str.length();k++){
                    set.add(k);
                }
            }
        }
    }
}
