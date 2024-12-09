package 回溯算法;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17_2 {
    public static void main(String[] args) {

    }
}
class Solution172{
    public String[] MAPPING={"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> res=new ArrayList<>();
    public StringBuilder builder=new StringBuilder();
    public List<Character> path=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        backtracking(0,digits);
        return res;
    }
    public void backtracking(int starIndex,String digits){
        if (builder.length()==digits.length()){
            res.add(builder.toString());
            return;
        }
        String str=MAPPING[digits.charAt(starIndex)-'0'];
        for (int i=0;i<str.length();i++){
            builder.append(str.charAt(i));

            backtracking(starIndex+1,digits);
            builder.deleteCharAt(builder.length()-1);

        }
    }
}
