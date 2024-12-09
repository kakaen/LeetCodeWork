package 动态规划算法.矩阵;

import com.sun.org.apache.bcel.internal.generic.ARETURN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 矩阵中移动的最大次数2684 {
    public static void main(String[] args) {
        矩阵中移动的最大次数2684 test = new 矩阵中移动的最大次数2684();
        System.out.println(test.maxMove2(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
        System.out.println(test.maxMove2(new int[][]{{3, 2,4}, {2, 1, 9}, {1, 1, 7}}));
    }
    public int maxMove(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        //从矩阵的第一列的任意单元出发
        boolean[][] f=new boolean[m][n]; //f[i][j]表示(i,j)是否可以到达，
        //初始话第一列
        for (int i=0;i<m;i++){
            f[i][0]=true;
        }
        int step=0;
        boolean flag=false; //一开始可以从第一列出发
        for (int j=1;j<n;j++){
            flag=false;//判断当前列是否可以到达
            for (int i=0;i<m;i++){
                if (i==0){
                    if (f[i][j-1]==true&&grid[i][j-1]<grid[i][j]){
                        flag=true;
                        f[i][j]=true; //表示该处可以到达
                    } else if (f[i+1][j-1]==true&&grid[i+1][j-1]<grid[i][j]) {
                        flag=true;
                        f[i][j]=true;
                    }
                } else if (i==m-1) {
                    if (f[i][j-1]==true&&grid[i][j-1]<grid[i][j]){
                        flag=true;
                        f[i][j]=true; //表示该处可以到达
                    } else if (f[i-1][j-1]==true&&grid[i-1][j-1]<grid[i][j]) {
                        flag=true;
                        f[i][j]=true;
                    }
                }else {
                    if (f[i][j-1]==true&&grid[i][j-1]<grid[i][j]){
                        flag=true;
                        f[i][j]=true; //表示该处可以到达
                    } else if (f[i+1][j-1]==true&&grid[i+1][j-1]<grid[i][j]) {
                        flag=true;
                        f[i][j]=true;
                    } else if (f[i-1][j-1]==true&&grid[i-1][j-1]<grid[i][j]) {
                        flag=true;
                        f[i][j]=true;
                    }
                }
            }
            if (flag==true){
                step++;
            }else{
                break;
            }
        }
        return step;
    }
    //
    public int maxMove2(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        Set<Integer> q1=new HashSet<>(); //表示上一列可以到达的行下标。
        //一开始第一列的所有行都可到达
        for (int i=0;i<m;i++){
            q1.add(i);
        }
        //
        int step=0;
        for (int j=1;j<n;j++){
            Set q2=new HashSet();
            for (Integer i:q1){
               for (int i2=i-1;i2<=i+1;i2++){
                   if (i2>=0&&i2<m&&grid[i2][j]>grid[i][j-1]){
                       q2.add(i2);
                   }
               }
            }
            if (q2.size()==0) return step;
            q1=q2;
            step++;
        }
        return step;
    }
    public int maxMove3(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        Set<Integer> q1=new HashSet<>(); //存储上一列可以到达的行下标
        for (int i=0;i<m;i++){
            q1.add(i);
        }
        for (int j=1;j<n;j++){
            Set<Integer> q2=new HashSet<>();
            for (int i:q1){
                for (int i2=i-1;i2<=i+1;i2++){
                    if (i2>=0&&i2<m&&grid[i2][j]>grid[i][j-1]){
                        q2.add(i2);
                    }
                }
            }
            q1=q2;
            if (q1.size()==0) return j-1;
        }
        return n-1;
    }
}
