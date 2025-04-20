package Top100二刷.子数组;

import java.util.Arrays;

public class 除自身以外数组的乘积238 {

    public int[] productExceptSelf2(int[] nums){
    int n=nums.length;
    //pre[i]表示从0--i-1
    int[] pre=new int[n];
    pre[0]=1;
    //next[i]表示i+1到 n-1的乘积
    int[] next=new int[n];
    next[n-1]=1;
    for (int i=1;i<n;i++){
        pre[i]=pre[i-1]*nums[i-1];
    }
    for (int j=n-2;j>=0;j--){
        next[j]=next[j+1]*nums[j+1];
    }
    int[] ans=new int[n];
    for (int i=0;i<n;i++){
        ans[i]=pre[i]*next[i];
    }
    return ans;
    }
    public int[] productExceptSelf(int[] nums){
        int n=nums.length;
        //pre[i]表示 从0-i
        int[] pre=new int[n];
        int[] last=new int[n];
        pre[0]=nums[0]; //pre[i]=0--i
        last[n-1]=nums[n-1];//last[i]=i--n-1;
        for (int i=0;i<n;i++){
            if (i>0){
                pre[i]=pre[i-1]*nums[i];
            }
        }
        for (int j=n-1;j>=0;j--){
            if (j<n-1){
                last[j]=last[j+1]*nums[j];
            }
        }
        //answer[i]=pre[i-1]*last[i+1];
        int[] answer=new int[n];
        for (int i=0;i<n;i++){
            if (i>0&&i<n-1){
                answer[i]=pre[i-1]*last[i+1];
            } else if (i==0) {
                answer[i]=last[i+1];
            } else if (i==n-1) {
                answer[i]=pre[i-1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        除自身以外数组的乘积238 test = new 除自身以外数组的乘积238();
        int[] ints = test.productExceptSelf(new int[]{1, 2, 3, 4});
        int[] ints2 = test.productExceptSelf(new int[]{-1,1, 0, -3, 3});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
}
