package 难度训练;

public class 各位相加258 {
    public static void main(String[] args) {
        System.out.println(f(2021,1023));
        System.out.println(f(1729,4995));
        System.out.println(f(1334,2047));
        System.out.println(f(2019,511));
    }
    public static int f(int x ,int n){
        if (x<=1)return x;
        return ((n-3)*f(x-1,n)+(n-2)*f(x-2,n))%n;
    }
}
