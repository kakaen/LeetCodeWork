package Top100二刷.图论;

import java.util.Arrays;
import java.util.Scanner;

public class 沉没孤岛102 {
    public static void main(String[] args) {
        //就是将岛屿面积为1的岛屿沉没掉
        Scanner scanner = new Scanner(System.in);
        int N= scanner.nextInt();
        int M=scanner.nextInt();
        int[][] grid=new int[N][M];
        boolean[][] visited=new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                grid[i][j]= scanner.nextInt();
            }
        }
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    visited[i][j]=true;
                    //遍历所有元素
                    DFS(i,j,grid,visited,false);
                }
            }
        }
        for (int[] arr:grid){
            for (int num:arr){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
    public static int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    public static void DFS(int i,int j,int[][] grid,boolean[][] visited,boolean flag){
        if (i==0||i==grid.length-1||j==0||j==grid[0].length-1) flag=true;
        for (int k=0;k<dir.length;k++){
            int nextI=i+dir[k][0];
            int nextJ=j+dir[k][1];
            if (nextI<0||nextI>=grid.length||nextJ<0||nextJ>=grid[0].length) continue;
            if (!visited[nextI][nextJ]&&grid[nextI][nextJ]==1){
                flag=true;
                visited[nextI][nextJ]=true;
                DFS(nextI,nextJ,grid,visited,flag);
            }
        }
        if (!flag){
            grid[i][j]=0;
        }
    }


}
