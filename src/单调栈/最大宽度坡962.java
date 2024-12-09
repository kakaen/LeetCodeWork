package 单调栈;

import com.sun.scenario.effect.Brightpass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class 最大宽度坡962 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=scanner.nextInt();
        }
        Solution962 solution962 = new Solution962();
        System.out.println(solution962.maxWidthRamp(arr));

    }
}
class Solution962{
    //暴力做法会超时
    public int maxWidthRamp2(int[] nums){
        int maxRamp=0;
        for (int i=0;i<nums.length-1;i++){
            int ai=nums[i];
            for (int j=i+1;j<nums.length;j++){
                if (nums[j]>=ai){
                    maxRamp=Math.max(maxRamp,j-i);
                }else {
                   continue;
                }
            }
        }
        return maxRamp;
    }

    /**
     * 使用单调栈进行维护
     * @param nums
     * @return
     */
    public int maxWidthRamp(int[] nums){
        //先正序遍历数组A，将以A[0]开始的递减序列的下标依次存入栈中。
        //因为是A[i]<=A[j],故要让A[i]的值尽可能的小，单调栈中记录的是从后往前每个大分段“坡底”所在的位置
        Deque<Integer> stack=new ArrayDeque<>();
        stack.push(0);
        //将以A[0]为元素递减的顺序插入到栈中。
        for (int i=0;i<nums.length;i++){
            if (nums[i]<nums[stack.peek()]){
                stack.push(i);
            }
        }
        int result=0;
        //然后逆序遍历A数组
        for (int j=nums.length-1;j>=0;j--){
            while (!stack.isEmpty()&&nums[j]>=nums[stack.peek()]){
                int i=stack.pop();
                result=Math.max(result,j-i);
            }

        }
        return result;
    }
    public int maxWidthRamp3(int[] nums){
       //这个无法只维护栈单调递减了
        //暴力发。从左往右遍历i，从右往左遍历j，如果nums[j]>=nums[i]，更新答案后，j就不需要再往左遍历了
        return 0;
    }
}
