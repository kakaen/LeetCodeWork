package 每日一题;

import java.util.HashSet;
import java.util.Set;

public class 平方数之和633 {
    public static void main(String[] args) {
        平方数之和633 test = new 平方数之和633();
        System.out.println(test.judgeSquareSum2(5));
        System.out.println(test.judgeSquareSum2(3));
        System.out.println(test.judgeSquareSum2(2));
    }
    //暴力法超时
    public boolean judgeSquareSum(int c){
        for (int i=0;i<=c/2;i++){
            if (isSquare(i)&&isSquare(c-i)) return true;
        }
        return false;
    }
    public boolean isSquare(int num){
        for (int i=0;i<=num;i++){
            if (i*i==num) return true;
        }
        return false;
    }
    public boolean judgeSquareSum2(int c){
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<=Math.sqrt(c);i++){
            int target=c-i*i;
            if (set.contains(target)||(target==i*i)){
                return true;
            }
            set.add(i*i);
        }
        return false;
    }
}
