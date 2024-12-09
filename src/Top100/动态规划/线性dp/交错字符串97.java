package Top100.动态规划.线性dp;

public class 交错字符串97 {
    public boolean isInterleave(String s1, String s2, String s3) {
        //分割成若干的子字符串，其中
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if (n1+n2!=n3) return false;
        char[] ch1=s1.toCharArray();
        char[] ch2=s2.toCharArray();
        char[] ch3=s3.toCharArray();
        //对于s3的k处而言，要么选s1[i],要么选s2[j]
        //我们采用动态规划的方式，dp[i][j]表示s1的前i个字母和s2的前j个字母是否可以交错组成s3的前i+j个元素
        boolean[][] dp=new boolean[n1+1][n2+1];
        dp[0][0]=true;
        //初始话,对于s2为0
        for (int i=1;i<=n1;i++){
            dp[i][0]=dp[i-1][0]&&ch1[i-1]==ch3[i-1];
        }
        for (int j=1;j<=n2;j++){
            dp[0][j]=dp[0][j-1]&&ch2[j-1]==ch3[j-1];
        }
        //递推公式，如果s1[i-1]等于
        for (int i=1;i<=n1;i++){
            for (int j=1;j<=n2;j++){
                int k=i+j;
//                if (i>0){
//                    dp[i][j]=dp[i-1][j]&&ch1[i-1]==ch3[k-1];
//                }
//                if (j>0){
//                    dp[i][j]=dp[i][j]||dp[i][j-1]&&ch2[j-1]==ch3[k-1];
//                }
                dp[i][j]=dp[i-1][j]&&ch1[i-1]==ch3[k-1]||dp[i][j-1]&&ch2[j-1]==ch3[k-1];
            }
        }

        return dp[n1][n2];
    }
    //采用递归的方式来实现
    public boolean isInterleave2(String s1, String s2, String s3) {
        return dfs(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), s1.length() - 1, s2.length() - 1, s3.length() - 1);
    }
    public boolean dfs(char[] ch1,char[] ch2,char[] ch3,int i,int j,int k){
        if (k<0){
            return true;
        }
        if (ch1[i]!=ch3[k]&&ch2[j]!=ch3[k]){
            return false;
        }
        if (ch1[i]==ch2[j]&&ch1[i]==ch3[k]){
            return dfs(ch1,ch2,ch3,i-1,j,k-1)||dfs(ch1,ch2,ch3,i,j-1,k-1);
        } else if (ch1[i]==ch3[k]) {
            return dfs(ch1,ch2,ch3,i-1,j,k);
        } else {
            return dfs(ch1,ch2,ch3,i,j-1,k);
        }
    }
    public boolean isInterleave3(String s1,String s2,String s3){
        int n1=s1.length();
        int n2=s2.length();
        int n3=s3.length();
        if (n1+n2!=n3) return false;
        //我们考虑s1的前i个字符和s2的前j个字符是否能组成s3的前i+j个字符
        boolean[][] dp=new boolean[n1+1][n2+1];
        dp[0][0]=true;
        //初始化
        for (int j=1;j<=n2;j++){
            dp[0][j]=dp[0][j-1]&&s2.indexOf(j-1)==s3.indexOf(j-1);
        }
        for (int i=1;i<=n1;i++){
            dp[i][0]=dp[i-1][0]&&s1.indexOf(i-1)==s3.indexOf(i-1);
        }
        //递推公式，对于s3的第i+j个字符，去判断是否等于s1的第i个字符还是s2的第j个字符
        for (int i=1;i<=n1;i++){
            for (int j=1;j<=n2;j++){
                int k=i+j;
                dp[i][j]=dp[i-1][j]&&s1.indexOf(i-1)==s3.indexOf(k-1)||dp[i][j-1]&&s2.indexOf(j-1)==s3.indexOf(k-1);
            }
        }
        return dp[n1][n2];
    }
    //状态压缩实现
    public boolean isInterleave4(String s1,String s2,String s3){
        int n1=s1.length();
        int n2=s2.length();
        boolean[] dp=new boolean[n2+1];
        dp[0]=true;
        //dp[0][j]
        for (int j=1;j<=n2;j++){
            dp[j]=dp[j-1]&&s2.charAt(j-1)==s3.charAt(j-1);
        }
        for (int i=1;i<=n1;i++){
            //dp[i][0]
            dp[0]=dp[0]&&s1.charAt(i-1)==s3.charAt(i-1);//dp[i][0]=dp[i-1][0]&&
            for (int j=1;j<=n2;j++){
                int k=i+j-1;
                //dp[i]=dp[i-1][j]||dp[i][j-1]
                dp[j]=dp[j]&&s1.charAt(i-1)==s3.charAt(k)||dp[j-1]&&s2.charAt(j-1)==s3.charAt(k);
            }
        }
        return dp[n2];
    }
    public static void main(String[] args) {
        交错字符串97 test = new 交错字符串97();
        System.out.println(test.isInterleave4("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(test.isInterleave4("aabcc", "dbbca", "aadbbbaccc"));
    }
}
