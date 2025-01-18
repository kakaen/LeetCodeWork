package 图论.网格图.DFS网格图;

import java.util.ArrayDeque;
import java.util.Deque;

public class 岛屿的最大面积695 {
    public static void main(String[] args) {
        岛屿的最大面积695 test = new 岛屿的最大面积695();
        int[][] grid=new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0}, {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(test.maxAreaOfIsland(grid));
    }
    public int maxAreaOfIsland(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        int maxArea=0;
        boolean[][] visited=new boolean[m][n];
        //使用BFS进行对网格图的遍历
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    int count = BFS(i, j, visited, grid);
                    maxArea=Math.max(maxArea,count);
                }
            }
        }
        return maxArea;
    }
    public int[][] dict={{0,1},{1,0},{0,-1},{-1,0}};
    //使用BFS计算岛屿的面积
    public int BFS(int x,int y,boolean[][] visited,int[][] grid){
        int count=0;
        Deque<int[]> deque=new ArrayDeque<>();
        visited[x][y]=true;
        count++;
        deque.push(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] cur = deque.poll();
            for (int[] dic:dict){
                int nextX=cur[0]+dic[0];
                int nextY=cur[1]+dic[1];
                if (nextX>=0&&nextX<grid.length&&nextY>=0&&nextY<grid[0].length&&!visited[nextX][nextY]&&grid[nextX][nextY]==1){
                    visited[nextX][nextY]=true;
                    count++;
                    deque.push(new int[]{nextX,nextY});
                }
            }
        }
        return count;
    }
    //使用DFS计算岛屿的面积
    public int DFS(int x,int y,boolean[][] visited,int[][] grid){
        int size=1;
        visited[x][y]=true;
        for (int[] dic:dict){
            int nextX=x+dic[0];
            int nextY=y+dic[1];
            if (nextX>=0&&nextX<grid.length&&nextY>=0&&nextY<grid[0].length
            &&grid[nextX][nextY]==1&&!visited[nextX][nextY]){
                visited[nextX][nextY]=true;
                size+=DFS(nextX,nextY,visited,grid);
            }
        }
        return size;
    }
}
