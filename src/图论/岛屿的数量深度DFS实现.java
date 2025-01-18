package 图论;

import java.util.List;
import java.util.Scanner;

public class 岛屿的数量深度DFS实现 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M= scanner.nextInt();
        int[][] grid=new int[N][M];
        boolean[][] visited=new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                grid[i][j]= scanner.nextInt();
            }
        }
        int count=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    visited[i][j]=true;
                    count++;
                    DFS(i,j,grid,visited);
                }
            }
        }
        System.out.println(count);
    }
    public static int[][] dic={{0,1},{1,0},{0,-1},{-1,0}};
    public static void DFS(int x, int y,int[][] grid,boolean[][] visited){
       for (int i=0;i<dic.length;i++){
           int nextX=x+dic[i][0];
           int nextY=y+dic[i][1];
           if (nextX<0||nextX>=grid.length||nextY<0||nextY>=grid[0].length) continue;
           if (!visited[nextX][nextY]&&grid[nextX][nextY]==1){
               visited[nextX][nextY]=true;
               DFS(nextX,nextY,grid,visited);
           }
       }
    }
}
