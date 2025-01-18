package 图论;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 岛屿的最大面积100 {
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
        int maxArea=0;
        for (int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                if (!visited[i][j]&&matrix[i][j]==1){
                    maxArea=Math.max(maxArea,bfs(i,j,matrix,visited,0));
                }
            }
        }
        System.out.println("maxArea="+maxArea);
    }
    public static int[][] dir=new int[][]{{0,1},{1,0},{0,-1},{-1,0}};//顺时针进行访问
    public static int  bfs(int x,int y,int[][] matrix,boolean[][] visited,int area){
        Queue<Pair2> queue=new LinkedList<>();
        visited[x][y]=true;
        area++; //每块陆地的第一个
        queue.add(new Pair2(x,y));
        while (!queue.isEmpty()){
            int curX=queue.peek().x;
            int curY=queue.peek().y;
            queue.poll();
            for (int i=0;i<4;i++){
                int nexX=curX+dir[i][0];
                int nexY=curY+dir[i][1];
                if (nexX<0||nexX>=matrix.length||nexY<0||nexY>=matrix[0].length) continue;
                if (!visited[nexX][nexY]&&matrix[nexX][nexY]==1){
                    visited[nexX][nexY]=true;
                    area++;
                    queue.add(new Pair2(nexX,nexY));
                }
            }
        }
        return area;
    }
}
class Pair2{
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
    public Pair2(){

    }
    public Pair2(int x,int y){
        this.x=x;
        this.y=y;
    }
}