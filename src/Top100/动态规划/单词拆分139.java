package Top100.动态规划;

import java.util.List;

public class 单词拆分139 {
    public boolean wordBreak(String s, List<String> wordDict){
        //判断是否可以用字典中的字符，拼接层s
        int n=s.length();
        //dp[i]表示以第i个字符结尾的sub字符串，是否可以被字典中的元素所表示
        boolean[] dp=new boolean[n+1];
        for (int i=0;i<n;i++){
            String subStr=s.substring(0);
        }
        return false;
    }
}
