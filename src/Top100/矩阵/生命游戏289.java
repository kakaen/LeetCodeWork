package Top100.矩阵;

import javax.jnlp.ClipboardService;
import java.util.Arrays;

public class 生命游戏289 {
    public void gameOfLife(int[][] board ){
       int m=board.length;
       int n=board[0].length;
       //使用一个
        int[][] newboard=new int[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int live=0;
                if (i-1>=0){
                    live+=board[i-1][j];
                    if (j-1>=0) live+=board[i-1][j-1];
                    if (j+1<n) live+=board[i-1][j+1];
                }
                if (i+1<m){
                    live=board[i+1][j];
                    if (j-1>=0) live+=board[i+1][j-1];
                    if (j+1<n) live+=board[i+1][j+1];
                }
                if (j-1>=0) live+=board[i][j-1];
                if (j+1<n) live+=board[i][j+1];
                if (board[i][j]==1){
                    if (live<2||live>3) {
                        newboard[i][j] = 0;
                    }else {
                        newboard[i][j]=1;
                    }
                }
                if (board[i][j]==0&&live==3) newboard[i][j]=1;
            }
        }
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                board[i][j]=newboard[i][j];
            }
        }
    }
}
