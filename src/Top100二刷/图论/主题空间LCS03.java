package Top100二刷.图论;

import java.util.ArrayDeque;
import java.util.Deque;

public class 主题空间LCS03 {
    public int largestArea(String[] grid) {
        int m=grid.length;
        int n=grid[0].length();
        int[][] spaces=new int[m][n];
        //不与主题空间相邻的主题空间
        for (int i=0;i<m;i++){
            for (int j=0;j<grid[i].length();j++){
                spaces[i][j]=grid[i].charAt(j)-'0';
            }
        }
        return 0;
    }
    public int[][] dict=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    public int count=0;
    //先将所有与0相邻的主题空间置为0
    public void BFS(int x,int y,boolean[][] visited,int[][] grid){
        Deque<int[]> deque=new ArrayDeque<>();
        visited[x][y]=true;
        deque.push(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            for (int[] dic:dict){

            }
        }
    }
}
