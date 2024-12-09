package Top100.动态规划.线性dp;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

public class 最长公共子序列1143 {
    public static void main(String[] args) {
        最长公共子序列1143 test = new 最长公共子序列1143();
        System.out.println(test.longestCommonSubsequence3("abcde", "ace"));
        System.out.println(test.longestCommonSubsequence3("abc", "abc"));
        System.out.println(test.longestCommonSubsequence3("abc", "def"));
        System.out.println(test.longestCommonSubsequence3("abcba", "abcbcba"));

    }
    //将递归修改为使用动态规划的方式来实现
    public int longestCommonSubsequence2(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        //dp[i][j]表示第一个字符串的i下标和第二个字符串的第j个下标
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    //采用状态压缩的方法来实现,压缩为一维数组
    public int longestCommonSubsequence3(String text1,String text2){
        int m=text1.length();
        int n=text2.length();
        char[] chars1=text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[] dp=new int[n+1];
        for (int i=1;i<=m;i++){
            int pre=dp[0];//记录上一层的dp[i-1][j-1]
            for (int j=1;j<=n;j++){
                int tmp=dp[j]; //这里存储的是上一次的dp[i-1][j],因为我们在计数时
                if (chars1[i-1]==chars2[j-1]){
                    dp[j]=pre+1; //这个是dp[i][j]的值,pre是来记录dp[i-1][j-1]的
                }else{
                    //dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])
                    dp[j]=Math.max(dp[j-1],dp[j]); //dp[i][j-1],dp[i-1][j]
                }
                pre=tmp;//
            }
        }
        return dp[n];
    }
    //使用递归的方式来实现
    public int longestCommonSubsequence(String text1, String text2) {
        //返回两个最长公共子串序列
        //子序列不一定连续，
        //子序列的本质上就是选或不选，考虑最后一对字母，分别为x和y
        //不选x不选y，不选x选y，选x不选y，选x选y
        int n1 = text1.length();
        int n2 = text2.length();
        int count = dfs(text1.toCharArray(), text2.toCharArray(), n1 - 1, n2 - 1);
        return count;
    }

    //使用递归的方法
    public int dfs(char[] ch1, char[] ch2, int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (ch1[i] == ch2[j]) {
            return dfs(ch1, ch2, i - 1, j - 1) + 1;
        }else{
            //这个是选x不选y和不选x选y的俩种情况中选择最大的来进行比较。
            return Math.max(dfs(ch1, ch2, i - 1, j), dfs(ch1, ch2, i, j - 1));
        }
    }
    public int dfs2 ( char[] ch1, char[] ch2, int i, int j){
        if (i >= ch1.length || j >= ch2.length) {
            return 0;
        }
        return 0;
    }
}
