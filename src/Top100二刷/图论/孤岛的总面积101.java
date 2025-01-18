package Top100二刷.图论;

import java.util.Arrays;
import java.util.Scanner;

public class 孤岛的总面积101 {
    public static void main(String[] args) {
        孤岛的总面积101 test = new 孤岛的总面积101();
        Scanner scanner = new Scanner(System.in);
        int M=scanner.nextInt();
        int N=scanner.nextInt();
        int[][] grid=new int[M][N];
        for (int i=0;i<M;i++){
            for (int j=0;j<N;j++){
                grid[i][j]= scanner.nextInt();
            }
        }
        System.out.println(test.SumArea(grid));
    }
    public int SumArea(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int sumArea=0;
        //先将四条边上的岛屿全部设置为0
        for (int j=0;j<n;j++){
            if (!visited[0][j]&&grid[0][j]==1){
//                grid[0][j]=0;
                visited[0][j]=true;
                func(0,j,grid,visited);
            }
            if (!visited[m-1][j]&&grid[m-1][j]==1){
//                grid[m-1][j]=0;
                visited[m-1][j]=true;
                func(m-1,j,grid,visited);
            }
        }
        for (int i=0;i<m;i++){
            if (!visited[i][0]&&grid[i][0]==1){
//                grid[i][0]=0;
                visited[i][0]=true;
                func(i,0,grid,visited);
            }
            if (!visited[i][n-1]&&grid[i][n-1]==1){
//                grid[i][n-1]=0;
                visited[i][n-1]=true;
                func(i,n-1,grid,visited);
            }
        }
        for (int[] gr:grid){
            System.out.println(Arrays.toString(gr));
        }
        for (boolean[] b:visited){
            System.out.println(Arrays.toString(b));
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    count=1;
                    visited[i][j]=true;
                    DFS(i,j,grid,visited);
                    sumArea+=count;
                }
            }
        }
        return sumArea;
    }
    //首先遍历四条边，将所有相邻边的岛屿设置为0
    public void func(int i,int j,int[][] grid,boolean[][] visited){
        grid[i][j]=0;
        for (int k=0;k<dir.length;k++){
            int curI=i+dir[k][0];
            int curJ=j+dir[k][1];
            //说明该岛屿接触了边缘，不能算作孤岛
            if (curI<0||curI>=grid.length||curJ<0||curJ>=grid[0].length) continue;
            if (!visited[curI][curJ]&&grid[curI][curJ]==1){
                visited[curI][curJ]=true;
                func(curI,curJ,grid,visited);
            }
        }

    }
    public static int count=0;
    public int[][] dir={{1,0},{0,-1},{-1,0},{0,1}};
    public void DFS(int i,int j,int[][] grid,boolean[][] visited){
        for (int k=0;k<dir.length;k++){
            int curI=i+dir[k][0];
            int curJ=j+dir[k][1];
            //超过边界结束
            if (curI<0||curI>=grid.length||curJ<0||curJ>=grid[0].length) continue;
            if (!visited[curI][curJ]&&grid[curI][curJ]==1){
                count++;
                visited[curI][curJ]=true;
                DFS(curI,curJ,grid,visited);
            }
        }

    }
}
