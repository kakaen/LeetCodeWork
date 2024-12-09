package 每日一题;

public class 统计不是特殊数字的数字数量3233 {
    public static void main(String[] args) {
        统计不是特殊数字的数字数量3233 test = new 统计不是特殊数字的数字数量3233();
        System.out.println((int)(Math.ceil(Math.sqrt(5))));
        System.out.println(test.nonSpecialCount(5, 7));
        System.out.println(test.nonSpecialCount(4, 16));
    }
    public int nonSpecialCount(int l,int r){
        int n=(int) Math.sqrt(r);
        int[] v=new int[n+1]; //记录当前下标是否为质数
        int res=r-l+1;
        //找质数
        for (int i=2;i<=n;i++){
            if (v[i]==0){ //表示当前i是质数
                if (i*i>=l&&i*i<=r){
                    res--;
                }
                for (int j=i*2;j<=n;j+=i){
                    v[j]=1;
                }
            }
        }
        return res;
       //特殊数，一定是一个平方数，并且是质数的平方
        //区间0-i的特殊数，就是【0,根号i下取整】的指数
    }
    public boolean isSpecialNums(int num){
        //对于num，1一定是因数，因此另一个一定是k的平方
        if (num==1) return false;
        else if (num==2) {
            return true;
        }
        for (int i=2;i<num;i++){
            if (num%i==0) return false;
        }
        return true;
    }
}
