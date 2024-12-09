package Top100.动态规划.线性dp;

public class 两个字符串的删除操作583 {
    public static void main(String[] args) {
        两个字符串的删除操作583 test = new 两个字符串的删除操作583();
        System.out.println(test.minDistance2("sea", "eat"));
        System.out.println(test.minDistance2("leetcode", "etco"));
    }
    public int minDistance(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        //dp[i][j]表示使s的前i个元素和t的前j个元素相等所需的最小步数
        int[][] dp=new int[m+1][n+1];
        //初始化
        for (int j=0;j<=n;j++){
            dp[0][j]=j;
        }
        for (int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        //递推公式,如果s[i]==t[j]则dp[i][j]=dp[i-1][j-1]
        //否则，删除下标i或者删除下标j dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[m][n];
    }
    //使用状态压缩，减少空间复杂度
    public int minDistance2(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        int[] dp=new int[n+1];
        //初始化 dp[0][j]
        for (int j=0;j<=n;j++){
            dp[j]=j;
        }
        for (int i=1;i<=m;i++){
            int pre=dp[0];
            dp[0]++; //这个是用来记录dp[i][0]=i;的值的
            for (int j=1;j<=n;j++){
                int temp=dp[j]; //保留dp[i-1][j];赋值给pre
                if (ch1[i-1]==ch2[j-1]){
                    dp[j]=pre;//pre记录的是dp[i-1][j-1];
                }else{
                    dp[j]=Math.min(dp[j-1],dp[j])+1;
                }
                pre=temp;
            }
        }
        return dp[n];
    }
}
