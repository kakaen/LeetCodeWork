package 图论.DFS基础;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 边界着色问题1034 {
    public static void main(String[] args) {
        边界着色问题1034 test = new 边界着色问题1034();
        int[][] grid=new int[][]{{1,1},{1,2}};
        int[][] grid2=new int[][]{{1,2,2},{2,3,2}};
        int[][] grid3=new int[][]{{1,1,1},{1,1,1},{1,1,1}};
        int[][] grid4=new int[][]{{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
        int[][] ints = test.colorBorder(grid4, 1, 3, 1);
        for (int[] arr:ints){
            System.out.println(Arrays.toString(arr));
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited=new boolean[grid.length][grid[0].length];
        BFS(row,col,color,visited,grid);
        return grid;
    }
    public void DFS(int[][] grid,int row,int col,int color,boolean[][] visited){
//        int curC=grid[row][col];
//        visited[row][col]=true;
//        if ()
    }
    public int[][] dict=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public void BFS(int row,int col,int color,boolean[][] visited,int[][] grid){
        //这个是原始联通分量的颜色
        int curColor=grid[row][col];
        Deque<int[]> deque=new ArrayDeque<>();
        Deque<int[]> changeColor=new ArrayDeque<>();
        visited[row][col]=true;
        deque.push(new int[]{row,col});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            //判断是否需要修改颜色
            if (pop[0]==0||pop[0]== grid.length-1||pop[1]==0||pop[1]==grid[0].length-1){
                changeColor.add(new int[]{pop[0],pop[1]});
            }
            //遍历当前节点的四个方向值,我们希望这四个方向的值都是curC，
            for (int[] dic:dict){
                int curX=dic[0]+pop[0];
                int curY=dic[1]+pop[1];
                if (curX>=0&&curX<grid.length&&curY>=0&&curY<grid[0].length&&
                        !visited[curX][curY]&&grid[curX][curY]!=curColor){
                    changeColor.add(new int[]{pop[0],pop[1]});
                }
                //遍历所有的联通值
                if (curX>=0&&curX<grid.length&&curY>=0&&curY<grid[0].length&&
                        !visited[curX][curY]&&grid[curX][curY]==curColor){
                    visited[curX][curY]=true;
                    deque.push(new int[]{curX,curY});
                }

            }

            for (int[] p:changeColor){
                grid[p[0]][p[1]]=color;
            }

        }
    }
}
