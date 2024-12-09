package Top100.动态规划.背包01类问题;

public class 一和零474 {
    public int findMaxForm(String[] strs,int m,int n){
        //找出最大子集，最多有m个0，和n个1
        //x的所有元素也是y的子集
        //类似于两个背包，一个放0最大容量为m，一个放1最大容量为n
        int c=strs.length; //获取字符串组的个数
        //表示前i个字符串，背包容量为j可以放的最大子集长度
        //表示前i个字符串，容量0为i，容量1为j可存放的最大子集长度
        int[][] dp=new int[m+1][n+1];
        dp[0][0]=0;
        for (int k=1;k<=c;k++){
            char[] chars=strs[k-1].toCharArray(); //获取第i个字符串
            int[] cnt=new int[2]; //计算字符串的01个数
            //计算该字符串的零一个数
            for (char ch:chars){
                cnt[ch-'0']++;
            }
            //递推公式，选该字符串，不选该字符串如果cnt[0]<=dp1[i][j]
            for (int i=m;i>=cnt[0];i--){
                for (int j=n;j>=cnt[1];j--){
                    dp[i][j]=Math.max(dp[i][j],dp[i-cnt[0]][j-cnt[1]]+1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        一和零474 test = new 一和零474();
        System.out.println(test.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
