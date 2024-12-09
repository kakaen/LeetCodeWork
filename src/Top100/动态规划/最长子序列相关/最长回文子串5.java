package Top100.动态规划.最长子序列相关;

public class 最长回文子串5 {
    public String longestPalindrome(String s){
        //dp[i][j]:表示字符串s的第i到j个字母组成的串
        int n=s.length();
        if (n<2) return s;
        boolean[][] dp=new boolean[n][n];
        //初始化，所有长度为1的子串都是回文串
        for (int i=0;i<n;i++){
            dp[i][i]=true;
        }
        char[] charArray=s.toCharArray();
        //枚举子串长度
        for (int L=2;L<=n;L++){
            for (int i=0;i<n;i++){
                int j=L+i-1; //计算子串的右边界
                if (j>=n) break;
                if (charArray[i]!=charArray[j]){
                    dp[i][j]=false;
                }else{
                    //子串长度为2
                    if (j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
            }
        }
        return s.substring(0,1);
    }
    public String longestPalindrome2(String s){
        int n=s.length();
        if (n==1) return s;
        boolean[][] dp=new boolean[n][n]; //dp[i][j]表示子串i-j是否为回文子串
        //初始化长度为1的子串，都是回文串
        for (int i=0;i<n;i++){
            dp[i][i]=true;
        }
        char[] chars=s.toCharArray();
        int maxLen=1;
        int start=0;
        //枚举长度L
        for (int L=2;L<=n;L++){
            for (int i=0;i<n;i++){
                int j=L+i-1;
                if (j>=n) break;
                if (chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else {
                    if (L<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if (dp[i][j]==true&&L>maxLen){
                    maxLen=L;
                    start=i;
                }
            }
        }
        for (boolean[] p:dp){
            for (boolean f:p){
                System.out.print(f+" ");
            }
            System.out.println();
        }
        return s.substring(start,start+maxLen);
    }
    public String logestPalindrome3(String s){
        //找出最长的回文子串
        int n=s.length();
        char[] chars=s.toCharArray();
        boolean[][] dp=new boolean[n][n]; //dp[i][j]表示i到j的子串是否为回文串
        //初始的每个单一字符都是回文串
        for (int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int maxLen=1; //记录最长子串的长度
        int start=0; //记录最长子串的起始位置
        //递推公式 dp[i][j]=dp[i+1][j-1]
        for (int L=2;L<=n;L++){
            for (int i=0;i<n;i++){
                int j=L+i-1;
                if (j>=n){
                    break;
                }
                if (chars[i]!=chars[j]){
                    dp[i][j]=false;
                }else{
                    if (L==2){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }

                }
                if (L>maxLen&&dp[i][j]){
                    maxLen=L;
                    start=i;
                }
            }
        }
      return s.substring(start,start+maxLen);
    }

    public static void main(String[] args) {
        最长回文子串5 test = new 最长回文子串5();
        System.out.println(test.logestPalindrome3("babad"));
    }
}
