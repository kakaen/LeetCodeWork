package 图论.网格图.DFS网格图;

public class 矩阵中移动的最大次数2684 {
    public static void main(String[] args) {
        矩阵中移动的最大次数2684 test = new 矩阵中移动的最大次数2684();
        int[][] grid=new int[][]{{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(test.maxMoves(grid));
    }
    public int maxMoves(int[][] grid){
        //使用DFS进行
        int max=0;
        for (int i=0;i<grid.length;i++){
            count=0;
            max=0;
        }
        return max;
    }
    //初始位置为（x，y）
    public int[][] dict=new int[][]{{-1,1},{0,1},{1,1}};
    public int count=0;
    public int max=0;
    //返回从x,y出发可以移动的次数
    public void DFS(int x,int y,int[][] grid){
        max=Math.max(max,y);

        for (int[] dic :dict){
            int curX=x+dic[0];
            int curY=y+dic[1];
            if (curX>=0&&curX<grid.length&&curY>=0&&curY<grid[0].length&&grid[curX][curY]>grid[x][y]){ //表示可以从x，y移动到curX，curY
                count++;
                DFS(curX,curY,grid);

            }
        }

    }
}
