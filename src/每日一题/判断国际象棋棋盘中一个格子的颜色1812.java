package 每日一题;

public class 判断国际象棋棋盘中一个格子的颜色1812 {
    public static void main(String[] args) {
        判断国际象棋棋盘中一个格子的颜色1812 test = new 判断国际象棋棋盘中一个格子的颜色1812();
        System.out.println(test.squareIsWhite("a1"));
        System.out.println(test.squareIsWhite("h3"));
    }
    public boolean squareIsWhite(String coordinates){
        int n1=coordinates.charAt(0)-'a';
        int n2=coordinates.charAt(1)-'1';
        if ((n1+n2)%2==0) return false;
        return true;
    }
}
