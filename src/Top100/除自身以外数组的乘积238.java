package Top100;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 除自身以外数组的乘积238 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]=scanner.nextInt();
        }
        Solution238 solution238 = new Solution238();
        solution238.productExceptSelf(nums);
    }
}
class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] preIndex=new int[n]; //preIndex[i]作为从nums[0]--nums[i-1];
        int[] nextIndex=new int[n];//nextIndex[i]从nums[i+1]--nums[n-1];
        preIndex[0]=1;
        for (int i=1;i<n;i++){
            preIndex[i]=preIndex[i-1]*nums[i-1];
        }
        nextIndex[n-1]=1;
        for (int i=n-2;i>=0;i--){
            nextIndex[i]=nextIndex[i+1]*nums[i+1];
        }
        int[] result=new int[n];
        for (int i=0;i<n;i++){
            result[i]=preIndex[i]*nextIndex[i];
        }
        return result;
    }
}