package 美团面试手撕题;

import java.util.Stack;

public class 接雨水42 {
    public int trap(int[] height){
        int sum=0;
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<height.length;i++){
            while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int top=stack.pop();
                if(stack.isEmpty()) break;
                int left=stack.peek();
                int width=i-left-1; //宽只能是去除左右两个
                int curHeight=Math.min(height[i],height[left])-top;
                sum+=width*curHeight;
                left++;
            }
            stack.push(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        接雨水42 test = new 接雨水42();
        System.out.println(test.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
