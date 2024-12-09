package 动态规划算法;

public class 第N个泰玻那契数列 {
    public static void main(String[] args) {
        第N个泰玻那契数列 test = new 第N个泰玻那契数列();
        System.out.println(test.tribonacci(4));
    }
    public int tribonacci(int n){
        int t0=0,t1=1,t2=1;
        if (n<=2){
            return n==2?1:n;
        }
        for (int i=3;i<=n;i++){
            int t3=t0+t1+t2;
            t0=t1;
            t1=t2;
            t2=t3;
        }
        return t2;
    }
}
