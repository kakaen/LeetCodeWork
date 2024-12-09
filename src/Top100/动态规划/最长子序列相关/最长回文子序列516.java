package Top100.动态规划.最长子序列相关;



import java.util.Map;

public class 最长回文子序列516 {
    public static void main(String[] args) {
        最长回文子序列516 test = new 最长回文子序列516();
        System.out.println(test.longestPalindromeSubseq2("bbbab"));
    }
    public int longestPalindromeSubseq(String s){
        //找出其中最长的回文子序列，返回该序列的长度。
        //dp[i]:表示前i个字符的最长回文子序列
        //对于一个子序列而言，如果他是回文子序列，且长度大于2，那么它的首尾两个字符还是子序列
        int n=s.length();
        //dp[i][j]表示的是字符串s的下标范围[i,j]内的最长回文子序列的长度
        int[][] dp=new int[n][n];
        //初始化状态dp[i][i]=1
        for (int i=0;i<n;i++){
            dp[i][i]=1;
        }
        //当i<j时，需要考虑s[i]和s[j]相等和不相等的情况，相等时dp[i][j]=dp[i+1][j-1]+2
        //不相等时：dp[i][j]=Math.max(dp[i+1][j],dp[i][])
        for (int i=n-1;i>=0;i++){
            char c1=s.charAt(i);
            for (int j=i+1;j<n;j++){
                char c2=s.charAt(j);
                if (c1==c2){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
    public int longestPalindromeSubseq2(String s){
        //最长回文子序列
        int n=s.length();
        char[] chars=s.toCharArray();
        int[][] dp=new int[n][n]; //dp[i][j]表示从i到j的子串中最长的回文子串的长度
        //递推公式，如果s[i]==s[j],则dp[i][j]=dp[i+1][j-1]+2;
        //如果s[i]!=s[j]，则dp[i][j]=max(dp[i+1][j],dp[i][j-1])
        //初始化长度为1的子串
        for (int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for (int L=2;L<=n;L++){
            for (int i=0;i<n;i++){
                int j=L+i-1;
                if (j>=n) break;
                if (chars[i]==chars[j]){
                    dp[i][j]=dp[i+1][j-1]+2;
                }else{
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }


}
