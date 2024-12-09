package Top100.动态规划.最长子序列相关;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 单词拆分139 {
    public boolean wordBreak(String s, List<String> wordDirct){
      //定义dp[i]为前i个字符组成的字符串[0,i-1]是否可以被wordDirct中的元素组成
        //对这个(0,i-1)的字符，进行遍历分割点j拆分成两个字符串s1[0,j-1],s2[j,i-1];
        //这里的s1[0,j-1]=dp[j],只需要再判断s2是否在wordDirct中即可
        int n=s.length();
        Set<String> wordSet=new HashSet<>(wordDirct);
        boolean[] dp=new boolean[n+1];
        dp[0]=true;
        for (int i=1;i<=n;i++){
            for (int j=0;j<i;j++){
                if (dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n+1];
    }
}
