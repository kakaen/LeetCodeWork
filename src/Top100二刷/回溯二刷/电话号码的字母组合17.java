package Top100二刷.回溯二刷;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class 电话号码的字母组合17 {
    public static void main(String[] args) {
        电话号码的字母组合17 test = new 电话号码的字母组合17();
        List<String> strings = test.letterCombinations("23");
        System.out.println(strings.toString());
        System.out.println(test.letterCombinations("2").toString());
    }
    public String[] map=new String[]{"","","abc","def",
            "ghi","jkl","mno",
            "pqrs","tuv","wxyz"
    };
    public List<String> letterCombinations(String digits){
        List<String> res=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        char[] numbers=digits.toCharArray();
        int n=numbers.length; //表示递归的深度，因为我要
        if (n==0) return res;
        backtracking(res,path,0,numbers);
        return res;
    }
    public void backtracking(List<String> res,StringBuilder path,int index,char[] numbers){
        //如果index等于手机号的长度，说明遍历结束了，需要收集结果。
        if (index==numbers.length){
            //收集结果
            res.add(path.toString());
            return;
        }
        String str=map[numbers[index]-'0']; //表示手机号数字对应的字符串
        //水平进行遍历字符串
        for (int i=0;i<str.length();i++){
            //进行操作加入
            path.append(str.charAt(i));
            backtracking(res,path,index+1,numbers);
            path.deleteCharAt(path.length()-1);
        }
    }
}