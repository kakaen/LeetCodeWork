package 图论.DFS基础;

public class 岛屿的周长463 {
    public static void main(String[] args) {
        岛屿的周长463 test = new 岛屿的周长463();
        int[][] grid=new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid2=new int[][]{{1,0}};
        System.out.println(test.islandPerimeter(grid));
        System.out.println(test.islandPerimeter(grid2));
    }
    public int islandPerimeter(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    visited[i][j]=true;
                    count+=4;
                    DFS(i,j,visited,grid);
                }
            }
        }
        return count;
    }
    public int[][] dict={{0,1},{1,0},{0,-1},{-1,0}};
    public int count=0;
    public void DFS(int x,int y,boolean[][] visited,int[][] grid){
        for (int[] dic:dict){
            int curX=x+dic[0];
            int curY=y+dic[1];
            if (curX<0||curX>=grid.length||curY<0||curY>=grid[0].length||grid[curX][curY]==0){
                count++;
                continue;
            }
            if (!visited[curX][curY]&&grid[curX][curY]==1){
                visited[curX][curY]=true;
                DFS(curX,curY,visited,grid);
            }

        }
    }
}
