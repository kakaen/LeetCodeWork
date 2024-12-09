package Top100.数组;

import java.util.Arrays;

public class 除自身以外数组的乘积238 {
    public static void main(String[] args) {
        除自身以外数组的乘积238 test = new 除自身以外数组的乘积238();
        int[] ints = test.productExceptSelf3(new int[]{1, 2, 3, 4});
        int[] ints2 = test.productExceptSelf3(new int[]{-1,1,0, -3, 3});
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
    }
    public int[] productExceptSelf(int[] nums){
        //不要使用除法。使用前缀乘积 nums[i]=count[i-1]*count[i+1]
        int n=nums.length;
        int[] answer=new int[n]; //记录答案
        int[] pre=new int[n];
        for (int i=0;i<n;i++){
            if (i>0){
                pre[i]=nums[i]*pre[i-1];
            }else{
                pre[i]=nums[i];
            }
        }
        //next[i]，表示从第i个元素到最后一个元素
        int[] next=new int[n];
        for (int i=n-1;i>=0;i--){
            if (i<n-1){
                next[i]=nums[i]*next[i+1];
            }else{
                next[i]=nums[i];
            }
        }
        //pre[i]表示从第一个元素到第i个元素的乘积
        //next[i]表示从最后一个元素到第i个元素的乘积
        for (int i=0;i<n;i++){
            if (i<n-1){
                answer[i]=next[i+1];
                if (i>0) answer[i]=answer[i]*pre[i-1];
            }else{
                answer[i]=pre[i-1];
            }
        }
        return answer;
    }
    public int[] productExceptSelf2(int[] nums){
        //空间复杂度O(1)的方法
        //把输出数组作为L
        int n=nums.length;
        int[] answer=new int[n]; //代表左侧的所有数字的乘积
        answer[0]=1;
        for (int i=1;i<n;i++){
            answer[i]=nums[i-1]*answer[i-1];
        }
        //R为右侧所有元素的乘积
        int R=1;
        for (int i=n-1;i>=0;i--){
            answer[i]=answer[i]*R;
            R*=nums[i];
        }
        return answer;
    }
    public int[] productExceptSelf3(int[] nums){
        int n=nums.length;
        int[] answer=new int[n];
        answer[0]=1; //answer[i]表示前i-1个元素的乘积
        for (int i=1;i<n;i++){
            answer[i]=nums[i-1]*answer[i-1];
        }
        //计算右侧的乘积，直接乘到ans上
        int R=1;
        for (int i=n-1;i>=0;i--){
            answer[i]=answer[i]*R;
            R=R*nums[i];
        }

        return answer;
    }
}
