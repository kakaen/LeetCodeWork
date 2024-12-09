package 代码随想录.动态规划;

public class 不同的二叉搜索树96 {
    public static void main(String[] args) {

    }
}
class Solution96 {
    public int numTrees(int n) {
       int[] dp=new int[n+1]; //dp[i]表示以i为根节点能够构造的二叉搜索树的个数
        dp[0]=1;
        dp[1]=1; //一个节点组成的二叉树只有一个
        //n-1个节点
        for (int i=2;i<=n;i++){ //这个是遍历有多少个节点的，2..i..n个节点个数
            for (int j=1;j<=i;j++){  //这个是从 1...i，选择哪个节点作为根节点
                dp[i]=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
