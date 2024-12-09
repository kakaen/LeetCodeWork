package 每日一题;

public class 求出硬币游戏的赢家3222 {
    public String losingPlayer(int x,int y){
        //115，表示必须有一个75的硬币和4个10元的
        int countPerson=1;
        while (x>=1&&y>=4){
            x--;
            y=y-4;
            countPerson++;
        }
        return countPerson%2==0?"Alice":"Bob";
    }

    public static void main(String[] args) {
        求出硬币游戏的赢家3222 test = new 求出硬币游戏的赢家3222();
        System.out.println(test.losingPlayer(2, 7));
        System.out.println(test.losingPlayer(4, 11));
    }
}
