package Top100二刷.二分查找.二分法求最大值;

public class 有界数组中指定下标处的最大值1802 {
    public static void main(String[] args) {
        有界数组中指定下标处的最大值1802 test = new 有界数组中指定下标处的最大值1802();
        System.out.println(test.maxValue(4, 2, 6));
        System.out.println(test.maxValue(6, 1, 10));
        System.out.println(test.maxValue(4, 0, 4));
    }
    public int maxValue(int n, int index, int maxSum) {
        //三个正整数 n、index、maxSum
        //构造一个同时满足下述所有条件的数组nums

        int l=1; //最小肯定是0；
        int r=maxSum;
        while (l<=r){
            int m=l+(r-l)/2;
            if (check(m,n,index,maxSum)){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return r;
    }
    //判断m是否满足条件
    public boolean check(int m,int n,int index,int maxSum){
       int leftLength=index; //左半边的数组长度
       int rightLength=n-index-1; //右半边的数组长度
        return m+cal(m,leftLength)+cal(m,rightLength)<=maxSum;
    }
    //big是指我们输入的最值。
    public long cal(int big,int length){
        if (big>length+1){
            return (long) (big-1+big-length)*length/2;
        }else{
            int ones=length-(big-1); //总共有这些个1
            return (long) (big)*(big-1)/2+ones;
        }
    }
}
