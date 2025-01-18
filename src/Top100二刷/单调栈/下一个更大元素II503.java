package Top100二刷.单调栈;

import netscape.security.UserTarget;

import java.util.*;

public class 下一个更大元素II503 {
    public int[] nextGreaterElements(int[] nums){
        //找下一个循环数组的值
        int n=nums.length;
        Deque<Integer> stack=new ArrayDeque<>(); //创建一个stack
        int[] ans=new int[n]; //计算答案；
        Arrays.fill(ans,-1);
        //循环数组就是 2*n-1个元素进行
        for (int i=0;i<2*n;i++){
            while (!stack.isEmpty()&&nums[i%n]>nums[stack.peek()]){
                int j=stack.poll(); //弹出栈顶元素
                ans[j]=nums[i%n];
            }
            //后面大于的就可以不入栈了
            if (i<n){
                stack.push(i%n);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        下一个更大元素II503 test = new 下一个更大元素II503();
        int[] nums=new int[]{1,2,1};

        int[] ints = test.nextGreaterElements(nums);
        System.out.println(Arrays.toString(test.nextGreaterElements(new int[]{1, 2, 3, 4, 3})));
        System.out.println(Arrays.toString(ints));
    }
}
