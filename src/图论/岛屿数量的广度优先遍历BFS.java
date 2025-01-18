package 图论;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 岛屿数量的广度优先遍历BFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N=scanner.nextInt();
        int M=scanner.nextInt();
        int[][] matrix=new int[N][M];
        boolean[][] visited=new boolean[N][M];
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                matrix[i][j]=scanner.nextInt();
            }
        }
        int ans=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&matrix[i][j]==1){
                    ans++;
                    bfs(matrix,visited,i,j); //找到第一个陆地块，从这个陆地块出发去遍历其他的块
                }
            }
        }
        System.out.println(ans);
    }
    public static int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public static void bfs(int[][] matrix,boolean[][] visited,int x,int y){
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(x,y)); //将x，y加入到队列中，这个是每块陆地的第一个地块
        visited[x][y]=true;
        //然后去访问队列
        while (!queue.isEmpty()){
            int curX=queue.peek().x;
            int curY=queue.peek().y;
            queue.poll(); //弹出当前访问的节点
            for (int i=0;i<4;i++){
                int nextX=curX+dir[i][0];
                int nextY=curY+dir[i][1];
                if (nextX<0||nextX>=matrix.length||nextY<0||nextY>=matrix[0].length) continue;
                if (!visited[nextX][nextY]&&matrix[nextX][nextY]==1){
                    visited[nextX][nextY]=true;
                    queue.add(new Pair(nextX,nextY));
                }
            }
        }
    }
}
class Pair{
    public int x;
    public int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public Pair(){

    }
    public Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}