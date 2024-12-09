package Top100.矩阵;

public class 有效的数独36 {
    public static void main(String[] args) {
        有效的数独36 test = new 有效的数独36();

    }
    public boolean isValidSudoku(char[][] board){
        //判断熟读是否有效，3个规则。
        //1. 每一行不可以出现。相同的元素
        for (int i=0;i<9;i++){
            int[] num=new int[9]; //存储是否1-9存在的
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    if(num[board[i][j]-'1']>0) return false;
                    num[board[i][j]-'1']++;
                }
            }
        }
        //2.每一列不可以出现重复的元素
        for (int j=0;j<9;j++){
            int[] num=new int[9]; //存储是否1-9存在的
            for (int i=0;i<9;i++){
                if (board[i][j]!='.'){
                    if(num[board[i][j]-'1']>0) return false;
                    num[board[i][j]-'1']++;
                }
            }
        }
        //3.每3*3只出现一次。
        for (int i=0;i<9;i=i+3){
            for (int j=0;j<9;j=j+3){

                for (int k=i;k<3;k++){
                    int[] num=new int[9];
                    for (int v=j;v<3;v++){
                        if (board[k][v]!='.'){
                            if (num[board[k][v]-'1']>0) return false;
                            num[board[k][v]-'1']++;
                        }
                    }
                }
            }
        }
        return true;
    }
    //一次遍历
    public boolean isValidSudoku2(char[][] board){
        int n=board.length;
        //创建二维数组rows和columns分别记录
        int[][] rows=new int[9][9];
        int[][] columns=new int[9][9]; //共9列
        //创建三维数组来
        int[][][] subboxs=new int[3][3][9];
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    if (rows[i][board[i][j]-'1']>0||
                    columns[j][board[i][j]-'1']>0||
                    subboxs[i/3][j/3][board[i][j]-'1']>0){
                        return false;
                    }else{
                        rows[i][board[i][j]-'1']++;
                        columns[j][board[i][j]-'1']++;
                        subboxs[i/3][j/3][board[i][j]-'1']++;
                    }

                }
            }
        }
        return true;
    }
}
