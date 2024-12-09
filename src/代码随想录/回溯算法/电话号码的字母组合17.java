package 代码随想录.回溯算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class 电话号码的字母组合17 {
    public static void main(String[] args) {

    }
}
class Solution17 {
    public String[] MAPPING={"","abc","def","ghi","jkl","mno","pdrs","tuv","wxyz"};
    public StringBuilder path=new StringBuilder();
    public List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits){
        if (digits.length()==0) return res;
        backTracking(digits,0);
        return res;
    }
    public void backTracking(String digits,int start){
        if (path.length()==digits.length()){
            res.add(path.toString());
            return;
        }
        if (start==digits.length()){
            res.add(path.toString());
            return;
        }
        //获取start下标对应数字的字符串
        String str= MAPPING[digits.charAt(start)-'1'];
        for (int i=0;i<str.length();i++){
            path.append(str.charAt(i));
            backTracking(digits,start+1);
            path.deleteCharAt(path.length()-1);
        }
    }
}