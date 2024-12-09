package Top100.动态规划.最大子数组的和;

public class K次串联后最大子数组之和1191 {
    public static void main(String[] args) {
        K次串联后最大子数组之和1191 yesy = new K次串联后最大子数组之和1191();
        System.out.println(yesy.KConcatenationMaxSum(new int[]{1, 2}, 3));
        System.out.println(yesy.KConcatenationMaxSum(new int[]{1, -2, 1}, 5));
        System.out.println(yesy.KConcatenationMaxSum(new int[]{-1, -2}, 5));
        System.out.println(yesy.KConcatenationMaxSum(new int[]{-5, -2,0,0,3,9,-2,-5,4},5));
    }
    public int KConcatenationMaxSum(int[] arr,int k){
        //求最大子数组之和
        //子数组之和的几种情况，第一种：整个数组都是最大子数组之和
        int n=arr.length;
        //第二种情况，如果只是其中的某一部分
        //第三种情况，如果是两个拼接的部分
        int mod=1000000007;
        long max1=0;
        long countMax=0;
        boolean flag=true;
        //对于第一种情况来说，先遍历一个
        for (int i=0;i<n;i++){
            if (countMax<0) flag=false;
            countMax=(Math.max(countMax,0)+arr[i])%mod;
            max1=Math.max(max1,countMax);
        }
        //第二种的情况，遍历两个数组拼接在一块的情况
        long max2=0;
        long countMax2=0;
        //求两个并列的最大值
        for (int i=0;i<n*2;i++){
            countMax2=(Math.max(countMax2,0)+arr[i%n])%mod;
            max2=Math.max(max2,countMax2);
        }
        if (flag){
            return (int)max1*(k)%mod;
        }else{
            return (int) Math.max(max2,max1);
        }
    }
}
