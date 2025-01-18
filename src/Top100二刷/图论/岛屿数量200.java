package Top100二刷.图论;

import java.util.LinkedList;
import java.util.Queue;

public class 岛屿数量200 {
    public static void main(String[] args) {
        岛屿数量200 test = new 岛屿数量200();
        test.numIslands(new char[][]{{'1'}});
    }
    //使用BFS方式进行搜索
    public int numIslands(char[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int ans=0;
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]=='1'){
                  ans++;
                  visited[i][j]=true;
                  DFS(i,j,grid,visited);
                }
            }
        }
        return ans;
    }
    public int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    //进行深度优先遍历
    public void DFS(int i,int j,char[][] grid,boolean[][] visited){
        for (int k=0;k< dir.length;k++){
            int curI=i+dir[k][0];
            int curJ=j+dir[k][1];
            if (curI<0||curI>=grid.length||curJ<0||curJ>=grid[0].length) continue;
            if (!visited[curI][curJ]&&grid[curI][curJ]=='1'){
                visited[curI][curJ]=true;
                DFS(curI,curJ,grid,visited);
            }
        }
    }
    //从i,j出发进行遍历
    public void bfs(int i,int j,char[][] grid,boolean[][] visited){
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(i,j)); //将当前节点入栈
        while (!queue.isEmpty()){
            Pair pair = queue.poll();
            for (int[] t:dir){
                int nextI= pair.i+t[0];
                int nextJ= pair.j+t[1];
                if (nextI<0||nextI>=grid.length||nextJ<0||nextJ>=grid[0].length) continue;
                if (!visited[nextI][nextJ]&&grid[nextI][nextJ]=='1'){
                    visited[nextI][nextJ]=true;
                    queue.add(new Pair(nextI,nextJ));
                }
            }
        }

    }
    class Pair{
        int i;
        int j;
        public Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
}
