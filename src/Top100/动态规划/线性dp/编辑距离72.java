package Top100.动态规划.线性dp;

public class 编辑距离72 {
    public static void main(String[] args) {
        编辑距离72 test = new 编辑距离72();
        System.out.println(test.minDistance3("horse", "ros"));
        System.out.println(test.minDistance3("intention", "execution"));
    }
    //采用动态规划的方式来实现
    public int minDistance2(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        //创建一个dp数组
        //dp[i][j]表示将S的前i个字符转换为T的前j个字符所需操作的最小值。
        int[][] dp=new int[m+1][n+1]; //dp[i][j]表示前i个元素和前j个元素操作的最少值
        //初始化时
        for (int j=0;j<=n;j++){
            dp[0][j]=j; //因为我s的子串为0，想要变成t的子串，肯定需要操作j次
        }
        for (int i=0;i<=m;i++){
            dp[i][0]=i;
        }
        for (int i=1;i<=m;i++){
            for (int j=1;j<=n;j++){
                if (ch1[i-1]==ch2[j-1]){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //
                    //假设都是操作s字符串
                    int del=dp[i-1][j];
                    int in=dp[i][j-1];
                    int swap=dp[i-1][j-1];
                    dp[i][j]=Math.min(Math.min(del,in),swap)+1;
                }
            }
        }
            return dp[m][n];
    }
    //将空间状态进一步压缩为一维数组
    public int minDistance3(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        char[] ch1=word1.toCharArray();
        char[] ch2=word2.toCharArray();
        int[] dp=new int[n+1];
        //初始化时s字符串的i为0长度
        for (int j=0;j<=n;j++){
            dp[j]=j;
        }
        for (int i=1;i<=m;i++){
            int pre=dp[0]; //用于记录上一行的j-1的值
            dp[0]++; //dp[0]=i+1; //这里就隐含了dp[i+1][0]的值了
            for (int j=1;j<=n;j++){
                int temp=dp[j];
                if (ch1[i-1]==ch2[j-1]){
                    dp[j]=pre;
                }else{
                    int del=dp[j-1]; //dp[i][i-1]
                    int insert=dp[j];//dp[i-1][j]
                    dp[j]=Math.min(Math.min(del,insert),pre)+1;
                }
                pre=temp; //下一个j访问时，pre就是[i-1][j-1]了
            }
        }
        return dp[n];
    }
    public int minDistance(String word1,String word2){

        return dfs(word1.toCharArray(),word2.toCharArray(),word1.length()-1,word2.length()-1);
    }
    //采用dfs递归的方式来实现
    public int dfs(char[] ch1,char[] ch2,int i,int j){
        //如果一個字符串为空，则需要将另一个字符串都去除
        if (i<0){
            return j+1;
        } else if (j<0) {
            return i+1;
        }
        if (ch1[i]==ch2[j]){
            return dfs(ch1,ch2,i-1,j-1);
        }else{
            int de=dfs(ch1,ch2,i-1,j);
            int in=dfs(ch1,ch2,i,j-1);
            int swap=dfs(ch1,ch2,i-1,j-1);
            return Math.min(Math.min(de,in),swap)+1;
        }
    }

}
