package 图论;

import java.util.Scanner;

public class 岛屿的最大面积深度优先搜索版本 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[][] matrix=new int[N][M];
        boolean[][] visited=new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        int maxArea=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&matrix[i][j]==1){
                    visited[i][j]=true;
                    count=1;
                    dfs(i,j,matrix,visited);
                    maxArea=Math.max(maxArea,count);
                }
            }
        }
        System.out.println(maxArea);
    }
    public static int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static int count=0;
    public static void dfs(int x,int y,int[][] matrix,boolean[][] visited){

        for (int i=0;i<4;i++){
            int nextX=x+dir[i][0];
            int nextY=y+dir[i][1];
            if (nextX<0||nextX>=matrix.length||nextY<0||nextY>=matrix[0].length) continue;
            if (!visited[nextX][nextY]&&matrix[nextX][nextY]==1){
                visited[nextX][nextY]=true;
                count++;
                dfs(nextX,nextY,matrix,visited);
            }
        }
    }
}
