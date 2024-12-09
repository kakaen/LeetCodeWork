package 每日一题.竞赛;

public class 统计不是特殊数字的数字数量3233 {
    public static void main(String[] args) {
        Solution3233 solution3233 = new Solution3233();
        System.out.println(solution3233.nonSpecialCount(4, 16));
    }
}
class Solution3233 {
    public int nonSpecialCount(int l, int r) {
        //真因数，除了x本身
        //特殊数字，因为一定会被1整除，也就是计算该值能否开放
        int count=0;
        for (int num=l;num<=r;num++){
            if (!isSpecialNumber(num)){
                count++;
            }
        }
        return count;
    }
    public boolean isSpecialNumber(int number){
        if (number<=2) return false;
        boolean flag=false; //没有可以被除的
        for (int i = 2; i <=number/2 ; i++) {
            if (number%i==0){
                flag=true; //说明有被除的
                if (i*i!=number) return false;
            }
        }
        return flag;
    }
}