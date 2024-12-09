package 难度训练;

public class 检查棋盘方格颜色是否相同3274 {
    public static void main(String[] args) {

    }
}
class Solution3274 {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        char col1=coordinate1.charAt(0);
        int row1=coordinate1.charAt(1)-'0';
        char col2=coordinate2.charAt(0);
        int row2=coordinate2.charAt(1)-'0';
        int colDiff=Math.abs(col2-col1); //如果是0,2,4说明是一样的列
        int rowDiff=Math.abs(row2-row1); //如果是0,2,4说明是一样的行
        if ((colDiff%2==0&&rowDiff%2==0)||(colDiff%2!=0&&rowDiff%2!=0)){
            return true;
        }
        return false;
    }
}
