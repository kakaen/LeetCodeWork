package Top100二刷.图论;

public class 岛屿的周长463 {
    int count=0;
    public int islandPerimeter(int[][] grid){
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]&&grid[i][j]==1){
                    visited[i][j]=true;
                    count=0; //如果是单个岛屿，那它的周长应该是4
                    DFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }
    public int[][] dir={{0,1},{1,0},{0,-1},{-1,0}};
    //使用深度优先遍历来实现
    public void DFS(int i,int j,int[][] grid,boolean[][] visited){
        for (int k=0;k<dir.length;k++){
            int nextI=i+dir[k][0];
            int nextJ=j+dir[k][1];
            if (nextI<0||nextI>=grid.length||nextJ<0||nextJ>=grid[0].length||grid[nextI][nextJ]==0){
                count++;
                continue;
            }
            if (!visited[nextI][nextJ]&&grid[nextI][nextJ]==1){
                //说明当前节点有陆地相邻，那我们再加3-1.
                //判断下一个节点有多少条边在外面

                visited[nextI][nextJ]=true;
                DFS(nextI,nextJ,grid,visited);
            }

        }
    }

    public static void main(String[] args) {
        岛屿的周长463 test = new 岛屿的周长463();
        int[][] grid=new int[][]{{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(test.islandPerimeter(grid));
        System.out.println(test.islandPerimeter(new int[][]{{1,1},{1,1}}));
    }
}
