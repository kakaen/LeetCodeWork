package 每日一题;

public class 可以被一步捕获的旗子数999 {
    public static void main(String[] args) {
        可以被一步捕获的旗子数999 test = new 可以被一步捕获的旗子数999();
        char[][] board=new char[][]{{'.','.','.','.','.','.','.','.'},
        {'.','.','.','p','.','.','.','.'},{'.','.','.','R','.','.','.','p'},
                {'.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.'},
                {'.','.','.','p','.','.','.','.'},{'.','.','.','.','.','.','.','.'},
        {'.','.','.','.','.','.','.','.'}};
        System.out.println(test.numRookCaptures(board));

    }
    public int numRookCaptures(char[][] board){
        //一个白色的车R，白色的向B，黑色组p空格.
        //先找到车的位置R
        int starI=0,startJ=0;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (board[i][j]=='R'){
                    starI=i;
                    startJ=j;
                }
            }
        }
        int res=0;
        //向上走旗子
        for (int i=starI;i>=0;i--){
            if (board[i][startJ]=='B') break;
            if (board[i][startJ]=='p'){
                res++;
                break;
            }
           
        }
        //向下走
        for (int i=starI;i<8;i++){
            if (board[i][startJ]=='B'){
                break;
            }
            if (board[i][startJ]=='p'){
                res++;
                break;
            }
        }
        //向左走
        for (int j=startJ;j>=0;j--){
            if (board[starI][j]=='B') break;
            if (board[starI][j]=='p'){
                res++;
                break;
            }
        }
        //向右走
        for (int j=startJ;j<8;j++){
            if (board[starI][j]=='B') break;
            if (board[starI][j]=='p'){
                res++;
                break;

            }
        }
        return res;
    }
    //采用一次循环遍历的方式
    public int numRookCaptures2(char[][] board){
        for (int i=0;i<board.length;i++){

        }
        return 0;
    }
}
