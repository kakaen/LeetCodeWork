package Top100二刷.二分查找.二分法求最大值;

public class H指数II275 {
    public static void main(String[] args) {
        H指数II275 test = new H指数II275();
        System.out.println(test.hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(test.hIndex(new int[]{1, 2, 100}));
        System.out.println(test.hIndex(new int[]{0}));
    }
    public int hIndex(int[] citations) {
        //按照升序排列
        //求h的最大值
        int n=citations.length;
        int l=0;
        int r=n; //最大为n
        int maxH=0;
        //我们的m是指代的要判断的h指数，然后可以通过下标
        while (l<=r){
            int m=l+(r-l)/2; //这个是要判断的h指数
            //这里l是第一个不符合的下标，因此[0,r]都是符合的
            if (citations[n-m]>=m){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return r;
    }
    //判断当前m是否满足h指数的定义
    public boolean check(int m,int[] citations){
        if (m==0) return true;
        //m应该是去判断下标，我们判断现在的m是不是H指数
        int n=citations.length;
        // n-1-i+1=m  -->i=n-m;
        if (citations[n-m]>=m) return true;
        return false;
    }
}
