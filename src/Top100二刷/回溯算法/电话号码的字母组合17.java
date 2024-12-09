package Top100二刷.回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17 {

    public static void main(String[] args) {
        电话号码的字母组合17 test = new 电话号码的字母组合17();
        List<String> strings = test.letterCombinations("23");
        for (String str:strings){
            System.out.println(str);
        }
    }
    public String[] MAP=new String[]{"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        char[] path=new char[digits.length()];
        dfs2(digits,0,new StringBuilder(),res);
        return res;
    }
    //start表示构造字符串第start下标的元素
    public void dfs2(String digits,int start,StringBuilder builder,List<String> res){
        if (start==digits.length()){
            res.add(builder.toString());
            return;
        }
        //当前下标对应的字符串
        String str=MAP[digits.charAt(start)-'1'];
        for (int i=0;i<str.length();i++){
            //选当前字符
            builder.append(str.charAt(i));
            dfs2(digits,start+1,builder,res);
            //回溯，恢复现场
            builder.deleteCharAt(builder.length()-1);
        }
    }
    public void dfs(String digits,int start,StringBuilder builder,List<String> res){
        if (start==digits.length()){
            res.add(builder.toString());
            return;
        }
        char ch=digits.charAt(start); //获得对应的num数字
        String str=MAP[ch-'1'];
        for (int j=0;j<str.length();j++){
            builder.append(str.charAt(j));
            dfs(digits,start+1,builder,res);
            builder.deleteCharAt(builder.length()-1);
        }
    }
}
