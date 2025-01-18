package 图论.网格图.DFS网格图;

import java.util.ArrayDeque;
import java.util.Deque;

public class 飞地的数量1020 {
    public static void main(String[] args) {
        飞地的数量1020 test = new 飞地的数量1020();
        int[][] grid=new int[][]{{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
        int[][] grid2=new int[][]{{0,0,0,0},{1,0,1,0},{0,1,1,0},{0,0,0,0}};
        System.out.println(test.numEnclaves(grid2));
    }
    public int numEnclaves(int[][] grid){
        //就是返回不在边界的岛屿的面积
        int sum=0;
        int m=grid.length;
        int n=grid[0].length;
        for (int i=0;i<m;i++){
            if (grid[i][0]==1){
                BFS(i,0,grid);
            }
            if (grid[i][n-1]==1){
                BFS(i,n-1,grid);
            }
        }
        for (int j=0;j<n;j++){
            if (grid[0][j]==1){
                BFS(0,j,grid);
            }
            if (grid[m-1][j]==1){
                BFS(m-1,j,grid);
            }
        }
        for (int i=1;i<m-1;i++){
            for (int j=1;j<n-1;j++){
                if (grid[i][j]==1){
                    sum+=BFS(i,j,grid);
                }
            }
        }
        return sum;
    }
    public int[][] dict=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    //先把所有和边界相邻的岛屿置为0
    public int BFS(int x,int y,int[][] grid){
        int count=0;
        Deque<int[] > deque=new ArrayDeque<>();
        grid[x][y]=0; //将遍历过低进行标识
        count++;
        deque.add(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            for (int[] dic:dict){
                int curX=pop[0]+dic[0];
                int curY=pop[1]+dic[1];
                if (curX>=0&&curX<grid.length&&curY>=0&&curY<grid[0].length&&grid[curX][curY]==1){
                    grid[curX][curY]=0;
                    count++;
                    deque.push(new int[]{curX,curY});
                }
            }
        }
        return count;
    }

}
