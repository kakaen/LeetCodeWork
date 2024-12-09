package 回溯算法;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合17 {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        List<String> strings = solution17.letterCombinations("");
        for (String str:strings){
            System.out.println(str);
        }
    }
}

class Solution17 {
    public String[] MAPPING={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length()==0) return result;
        StringBuilder stringBuilder=new StringBuilder();
        addList(digits,0,result,stringBuilder);
        return result;
    }
    public void addList(String s,int index,List<String> result,StringBuilder stringBuilder){
        if (stringBuilder.length()==s.length()){
            result.add(stringBuilder.toString());
            return;
        }
        int mappingIndex=s.charAt(index)-'0';
        String str=MAPPING[mappingIndex];
        for (int i=0;i<str.length();i++){
            stringBuilder.append(str.charAt(i));
            addList(s,index+1,result,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
