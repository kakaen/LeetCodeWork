package Top100二刷;

import java.util.ArrayList;
import java.util.List;

public class 单词搜索79 {
    public static void main(String[] args) {

    }
    //我们循环遍历查找是否匹配的字符
    public boolean exist(char[][] board,String word){
        boolean[][] visited=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (check(i,j,0,visited,word,board)) return true;
            }
        }
        return false;
    }
    //判断以网格的(i,j)位置出发，能否搜到单词[k,....]
    public boolean check(int i,int j,int k,boolean[][] visited,String word,char[][] board){
        if (board[i][j]!=word.charAt(k)) return false;
        if (k==word.length()-1) return true;

        //将当前(i,j)元素设置为true
        visited[i][j]=true;
        int[][] directions={{0,1},{0,-1},{1,0},{-1,0}};
        boolean res=false;
        for (int[] dir:directions){
            int newi=i+dir[0],newj=j+dir[1];
            if (newi>=0&&newi<board.length&&newj>=0&&newj<board[0].length){
                if (!visited[newi][newj]){
                    boolean flag = check(newi, newj, k + 1, visited, word, board);
                    if (flag){
                        res=true;
                        break;
                    }
                }
            }
        }
        return true;
    }
}
