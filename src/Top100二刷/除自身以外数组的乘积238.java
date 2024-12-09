package Top100二刷;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 除自身以外数组的乘积238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        //res[i]=0,1,2--i-1,i+1,n-1
        //prefix为前i个元素的乘积
        int[] prefix=new int[n+1];
        prefix[0]=1;
        //suffix表示后i个元素的乘积但是不包括(i)
        int[] suffix=new int[n+1];
        for (int i=0;i<n;i++){
            prefix[i+1]=prefix[i]*nums[i];
        }
        suffix[0]=1;
        suffix[1]=1;
        for (int i=2;i<=n;i++){
            suffix[i]=suffix[i-1]*nums[n-i+1];
        }
        int[] res=new int[n];
        //nums[i]=prefix[i-1]*suffix[]
        for (int i=0;i<n;i++){
            int num=n-i; //后面有n-1-i+1个数 n-i
            //prefix[i]表示的是前i个数的乘积
            //suffix[i]表示后i个数的乘积
            res[i]=prefix[i]*suffix[n-i];
        }
        return res;
    }
    //前缀和解题
    public int[] productExceptSelf2(int[] nums){
        int n=nums.length;
        //设置前缀和prefix[i] 表示从nums[0]到nums[i-1]
        int[] prefix=new int[n];
        prefix[0]=1; //prefix[i]表示前i个元素的乘积
        for (int i=1;i<n;i++){
            prefix[i]=prefix[i-1]*nums[i-1];

        }
        //设置后缀和suffix[i]表示从nums[i+1]到nums[n-1]
        //suffix[i-1] =suffix[i]*nums[i-1]
        int[] suffix=new int[n];
        suffix[n-1]=1;
        for (int i=n-2;i>=0;i++){
            suffix[i]=suffix[i+1]*nums[i+1];
        }
        int[] res=new int[n];
        for (int i=0;i<n;i++){
            res[i]=prefix[i]*suffix[i];
        }
        return res;
    }
    public static void main(String[] args) {
        除自身以外数组的乘积238 test = new 除自身以外数组的乘积238();
        int[] ints = test.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(Arrays.toString(ints));
        int[] ints1 = test.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(Arrays.toString(ints1));
    }
    }
