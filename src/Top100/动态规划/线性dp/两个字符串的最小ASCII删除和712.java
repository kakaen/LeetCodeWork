package Top100.动态规划.线性dp;

public class 两个字符串的最小ASCII删除和712 {
    public static void main(String[] args) {
        两个字符串的最小ASCII删除和712 test = new 两个字符串的最小ASCII删除和712();
        System.out.println(test.minimumDeleteSum2("sea", "eat"));
        System.out.println(test.minimumDeleteSum2("delete", "leet"));
    }
    public int minimumDeleteSum(String s1, String s2) {
        //使两个字符串
        int m=s1.length();
        int n=s2.length();
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        //dp[i][j]表示使s的前i个元素和t的前j个字符串相等所需的最小Ascii
        int[][] dp=new int[m+1][n+1];
        for (int j=1;j<=n;j++){
            dp[0][j]=dp[0][j-1]+ch2[j-1];
        }
        for (int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+ch1[i-1];
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    dp[i][j]=Math.min(dp[i-1][j]+ch1[i-1],dp[i][j-1]+ch2[j-1]);
                }
            }
        }
        return dp[m][n];
    }
    //状态空间的压缩
    public int minimumDeleteSum2(String s1,String s2){
        int m=s1.length();
        int n=s2.length();
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        int[] dp=new int[n+1]; //dp[j]表示s1的前i个长度，s2前j个长度，相等所需的最小和
        for (int j=1;j<=n;j++){
            dp[j]=dp[j-1]+ch2[j-1];
        }
        for (int i=1;i<=m;i++){
            int pre=dp[0]; //记录dp[i-1][j-1]
            dp[0]+=ch1[i-1];
            for (int j=1;j<=n;j++){
                int temp=dp[j];
                if (ch1[i-1]==ch2[j-1]){
                    dp[j]=pre;
                }else{
                    //dp[i-1][j],dp[i][j-1]
                    dp[j]=Math.min(dp[j-1]+ch2[j-1],dp[j]+ch1[i-1]);
                }
                pre=temp;
            }
        }
        return dp[n];
    }
}
