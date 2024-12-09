package 每日一题;

public class 检查棋盘方格颜色是否相同3274 {
    public static void main(String[] args) {
        检查棋盘方格颜色是否相同3274 test = new 检查棋盘方格颜色是否相同3274();
        System.out.println(test.checkTwoChessboards("a1", "b2"));
    }
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        //a,c,e,g都是计数
        int c1=coordinate1.charAt(0)-'a';
        int c2=coordinate2.charAt(0)-'a';
        int r1=coordinate1.charAt(1)-'1';
        int r2=coordinate2.charAt(1)-'1';
        if (c1%2==c2%2&&r1%2==r2%2){
            return true;
        } else if (c1%2!=c2%2&&r1%2!=r2%2) {
            return true;
        }
        return false;
    }
}
