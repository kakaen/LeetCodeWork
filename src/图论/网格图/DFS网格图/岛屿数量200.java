package 图论.网格图.DFS网格图;

import 基础转换.数组和List转换;

import java.util.ArrayDeque;
import java.util.Deque;

public class 岛屿数量200 {
    public static void main(String[] args) {
//        岛屿数量200 test = new 岛屿数量200();
//        char[][] grid=new char[][]{{}}
//        test.numIslands()
    }
    public int numIslands(char[][] grid){
        //计算网格中的岛屿数量
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]=='1'){
                    visited[i][j]=true;
                    count++;
                    DFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    public int[][] dict={{0,1},{1,0},{0,-1},{-1,0}};
    //使用BFS来实现
    public void BFS(int x,int y,char[][] grid,boolean[][] visited){
        Deque<int[]> deque=new ArrayDeque<>();
        deque.add(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] cur=deque.poll();
            x=cur[0]; y=cur[1];

        }
    }
    public void DFS(int x,int y,char[][] grid,boolean[][] visited){
        for (int[] dic:dict){
            int nextX=x+dic[0];
            int nextY=y+dic[1];
            if (nextX>=0&&nextX<grid.length&&nextY>=0&&nextY<grid[0].length&&
                    !visited[nextX][nextY]&&grid[nextX][nextY]=='1'){
                visited[nextX][nextY]=true;
                DFS(nextX,nextY,grid,visited);
            }
        }
    }
}
