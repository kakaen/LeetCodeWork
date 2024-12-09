package Top100.动态规划.网格dp;

import java.util.List;

public class 三角形最小路径和120 {
    public int minimumTotal(List<List<Integer>> triangle){
        int n=triangle.size();
        int[][] dp=new int[n][n];
        return 0;
        }
    public boolean isBalanced(String num) {
        int firstCount=0;
        int secondCount=0;
        for (int i=0,j=1;i<num.length()||j<num.length();i=i+2,j=j+2){
            if (i<num.length())firstCount+=num.charAt(i)-'0';
            if(j<num.length())secondCount+=num.charAt(j)-'0';
        }
        return firstCount==secondCount;
    }
}
