package Top100.二进制相关;

public class 颠倒二进制位190 {
    public static void main(String[] args) {
        颠倒二进制位190 test = new 颠倒二进制位190();
        int n=0b11111111111111111111111111111101;
        System.out.println(test.reverseBits(n));
        System.out.println(n);
    }
    public int reverseBits(int n){
        int res=0;
        while (n!=0){
            res=res*2+(n&1);
            n=n>>>1;
        }
        return 0;
    }
}
