package Top100二刷.图论;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿的最大面积695 {
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int maxArea=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    count=1;
                    maxArea=Math.max(maxArea,BFS(i,j,grid,visited));
                }
            }
        }
        return maxArea;
    }
    public int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    //采用广度优先遍历来实现
    public int BFS(int i,int j,int[][] grid,boolean[][] visited){
        Queue<Pair> queue=new LinkedList<>();
        visited[i][j]=true;
        queue.add(new Pair(i,j));
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int k=0;k<dir.length;k++){
                int curI=pair.i+dir[k][0];
                int curJ=pair.j+dir[k][1];
                if (curI<0||curI>=grid.length||curJ<0||curJ>=grid[0].length) continue;
                if (!visited[curI][curJ]&&grid[curI][curJ]==1){
                    count++;
                    visited[curI][curJ]=true;
                    queue.add(new Pair(curI,curJ));
                }
            }
        }
        return count;
    }
    class Pair{
        int i;
        int j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    //采用dfs进行计算,DFS计算当前
    public int count=1;
    public int DFS(int i,int j,int[][] grid,boolean[][] visited){
        for (int k=0;k< dir.length;k++){
            int curI=i+dir[k][0];
            int curJ=j+dir[k][1];
            if (curI<0||curI>=grid.length||curJ<0||curJ>=grid[0].length) continue;
            if (!visited[curI][curJ]&&grid[curI][curJ]==1){
                visited[curI][curJ]=true;
                count++;
                DFS(curI,curJ,grid,visited);
            }
        }
        return count;
    }
}
