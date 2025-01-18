package 图论;

import java.util.Scanner;

public class 岛屿的数量深搜版 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[][] matrix=new int[N][M];
        //标记数组，遇到一个陆地，就将其所属陆地全部标记为访问
        boolean[][] visited=new boolean[N][M];
        //构造matrix数组
        for (int i = 0; i < N; i++) {
            for (int j=0;j<M;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        //遇到所有矩阵
        int ans=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&matrix[i][j]==1){
                    ans++;
                    dfs(matrix,visited,i,j);//调用dfs将该片路径全部置为true
                }
            }
        }
        System.out.println(ans);
    }
    public static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public static void dfs(int[][] matrix,boolean[][] visited,int x,int y){
        for (int i=0;i<4;i++){
            int nextx= x+dir[i][0];
            int nexty=y+dir[i][1];
            if (nextx<0||nextx>=matrix.length||nexty<0||nexty>=matrix[0].length){
                continue;
            }
            //如果visted没有被访问过，且当前矩阵是陆地的一块
            if (!visited[nextx][nexty]&&matrix[nextx][nexty]==1){
                visited[nextx][nexty]=true;
                dfs(matrix,visited,nextx,nexty);
            }
        }
    }


}
