package 每日一题;

public class 使两个整数相等的位更改次数3226 {
    public static void main(String[] args) {
        使两个整数相等的位更改次数3226 test = new 使两个整数相等的位更改次数3226();
        System.out.println(test.minChanges(13, 4));
    }
    public int minChanges(int n,int k){
       int res=0;
       while (n>0||k>0){
           if (((n&1)==0)&&(k&1)==1) return -1;
           if (((n&1)==1)&&(k&1)==0) res++;
           n>>=1;
           k>>=1;
       }
        return res;
    }
}
