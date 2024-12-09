package Top100.动态规划.字符串中的动态规划;

public class 最长回文子串5 {
    public static void main(String[] args) {
        最长回文子串5 test = new 最长回文子串5();
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
    }
    //1.首先使用暴力法
    public String longestPalindrome(String s){
        //找到s中最长的回文子串
        int n=s.length();
        String maxString=String.valueOf(s.charAt(0));
        for (int i=0;i<n;i++){
            for (int j=n-1;j>=i;j--){
                String substring = s.substring(i, j+1);
                if (isPalindrome(substring)&&substring.length()>maxString.length()){
                    maxString=substring;
                }
            }
        }
        return maxString;
    }
    //解法二：使用动态规划的方法来实现
    public String longestPalindrome2(String s){
        int n=s.length();
        //用动态规划来解决该题
        boolean[][] dp=new boolean[n][n];
        //s[i:j]表示第i到第j个字母组成的串是否为回文串
        //dp[i][j]=dp[i+1,j-1]^(si==sj)
        for (int i=0;i<n;i++){
            dp[i][i]=true;
            if (i!=n-1) dp[i][i+1]=(s.charAt(i)==s.charAt(i+1));
        }
        int begin=0;
        int maxLen=1;
        //递归开始，先枚举子串的长度
        for (int L=2;L<=n;L++){
            for (int i=0;i<n;i++){
                //由L和i来确定右边界，
                int j=L+i-1;
                if (j>=n){
                    //如果右边界超出范围，则退出当前循环
                    break;
                }
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j]=false;
                }else{
                    if (j-i<3){
                        dp[i][j]=true; //这个是长度为2的子串
                    }
                }
                if (dp[i][j]&&(j-i+1)>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public String longestPalindrome3(String s){
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        //初始化
        for (int i=0;i<n;i++){
            dp[i][i]=true;
        }
        int max=0;
        String str=null;
        for (int i=n-1;i>=0;i--){
            for (int j=i;j<n;j++){
                if (s.charAt(i)==s.charAt(j)&&((j-i<=1)||(dp[i+1][j-1]))){
                    dp[i][j]=true;
                    max=Math.max(max,j-i);
                    if (j-i>=max) str=s.substring(i,j-i+1);
                }
            }
        }
        return str;
        }
    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while (i<j){
            if (s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
