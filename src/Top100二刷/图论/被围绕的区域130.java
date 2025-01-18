package Top100二刷.图论;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class 被围绕的区域130 {
    public static void main(String[] args) {
        被围绕的区域130 test = new 被围绕的区域130();
        char[][] board=new char[][]{{'X','X','X','X'}, {'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board2=new char[][]{{'O','X','X','X'}};
        char[][] board3=new char[][]{{'O','O'},{'O','O'}};
       test.solve(board3);
        for (char[] chs:board3){
            System.out.println(Arrays.toString(chs));
        }
    }
    public void solve(char[][] board) {
        //在board边缘的无法被捕获
        int m=board.length;  //行数
        int n=board[0].length; //列数
        boolean[][] visited=new boolean[m][n];
        //遍历边界
        for (int i=0;i<m;i++){
            if (!visited[i][0]&&board[i][0]=='O'){
                BFS(i,0,board,visited);
            }
            if (!visited[i][n-1]&&board[i][n-1]=='O'){
                BFS(i,n-1,board,visited);
            }
        }
        for (int j=0;j<n;j++){
            if (!visited[0][j]&&board[0][j]=='O'){
                BFS(0,j,board,visited);
            }
            if (!visited[m-1][j]&&board[m-1][j]=='O'){
                BFS(m-1,j,board,visited);
            }
        }
        for (int i=1;i<m-1;i++){
            for (int j=1;j<n-1;j++){
                if (!visited[i][j]&&board[i][j]=='O'){
                    BFS2(i,j,board,visited);
                }
            }
        }

    }
    public int[][] dict={{0,1},{1,0},{0,-1},{-1,0}};
    //BFS进行遍历
    public void BFS(int x,int y,char[][] board,boolean[][] visited){
        Deque<int[]> deque=new ArrayDeque<>();
        visited[x][y]=true;
        deque.push(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            for (int[] dic:dict){
                int curX=pop[0]+dic[0];
                int curY=pop[1]+dic[1];
                if (curX>=0&&curX<board.length&&curY>=0&&curY<board[0].length&&!visited[curX][curY]&&board[curX][curY]=='O'){
                    visited[curX][curY]=true;
                    deque.push(new int[]{curX,curY});
                }
            }
        }
    }

    //BFS2进行遍历
    public void BFS2(int x,int y,char[][] board,boolean[][] visited){
        Deque<int[]> deque=new ArrayDeque<>();

        visited[x][y]=true;
        board[x][y]='X';
        deque.push(new int[]{x,y});
        while (!deque.isEmpty()){
            int[] pop=deque.pop();
            for (int[] dic:dict){
                int curX=pop[0]+dic[0];
                int curY=pop[1]+dic[1];
                if (curX>=0&&curX<board.length&&curY>=0&&curY<board[0].length&&!visited[curX][curY]&&board[curX][curY]=='O'){
                    visited[curX][curY]=true;
                    board[curX][curY]='X';
                    deque.push(new int[]{curX,curY});
                }
            }
        }
    }
}
