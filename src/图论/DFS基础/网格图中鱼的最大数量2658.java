package 图论.DFS基础;


import java.util.ArrayDeque;
import java.util.Deque;

public class 网格图中鱼的最大数量2658 {
    public static void main(String[] args) {
        网格图中鱼的最大数量2658 test = new 网格图中鱼的最大数量2658();
        int[][] grid=new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}};
        System.out.println(test.findMaxFish(grid));
    }
    public int findMaxFish(int[][] grid){
        //就是求最大联通分量的值
        int maxCount=0;
        int m=grid.length;
        int n=grid[0].length;

        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){

                maxCount=Math.max(maxCount,DFS(i,j,grid));
            }
        }
        return maxCount;
    }
    public int[][] dict=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    //使用DFS来实现
    public int DFS(int x,int y,int[][] grids){
        if (x<0||x>=grids.length||y<0||y>=grids[0].length||grids[x][y]==0){
            return 0;
        }
        int sum=grids[x][y];
        grids[x][y]=0; //标记为已访问过
        for (int[] dic:dict){
            sum+=DFS(x+dic[0],y+dic[1],grids);
        }
        return sum;
    }
   public int BFS(int x,int y,int[][] grid){
       int sum=grid[x][y];
       grid[x][y]=0; //将访问过的路径标记
       Deque<int[]> deque=new ArrayDeque<>();
       deque.push(new int[]{x,y});
       while (!deque.isEmpty()){
           int[] pop=deque.pop();
           for (int[] dic:dict){
               int curX=pop[0]+dic[0];
               int curY=pop[1]+dic[1];
               if (curX>=0&&curX<grid.length&&curY>=0&&curY<grid[0].length&&grid[curX][curY]!=0){
                   sum+=grid[curX][curY];
                   grid[curX][curY]=0;
                   deque.push(new int[]{curX,curY});
               }
           }
       }
       return sum;
   }
}
