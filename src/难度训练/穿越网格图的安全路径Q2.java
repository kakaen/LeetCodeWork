package 难度训练;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 穿越网格图的安全路径Q2 {
    public static void main(String[] args) {
        int[][] grid=new int[][]{{0,1,1,0,0,0},{1,0,1,0,0,0},{0,1,1,1,0,1},{0,0,1,0,1,0}};
        int h=3;
        List<List<Integer>> grid2=new ArrayList<>();
        for (int i=0;i<grid.length;i++){
            List<Integer> list=new ArrayList<>();
            for (int j=0;j<grid[i].length;j++){
                list.add(grid[i][j]);
            }
            grid2.add(list);
        }
        Solutionq2 solutionq2 = new Solutionq2();

        System.out.println(solutionq2.findSafeWalk(grid2, h));
    }
}
class Solutionq2{
    public boolean findSafeWalk(List<List<Integer>> grid,int health){
        int m=grid.size();
        int n=grid.get(0).size();
        int[][] dp=new int[m][n]; //dp[i][j]表示到达i,j处所需的最少health
        dp[0][0]=grid.get(0).get(0);
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int min=Integer.MAX_VALUE;
                if (i-1>=0){
                    min=Math.min(min,dp[i-1][j]);
                } else if (i+1<m) {
                    min=Math.min(min,dp[i+1][j]);
                } else if (j-1>=0) {
                    min=Math.min(min,dp[i][j-1]);
                }else {
                    min=Math.min(min,dp[i][j+1]);
                }
                dp[i][j]=min+grid.get(i).get(j);
            }
        }
        return health>dp[m-1][n-1]?true:false;
    }
}
