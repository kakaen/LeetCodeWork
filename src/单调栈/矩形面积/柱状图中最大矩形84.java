package 单调栈.矩形面积;

import netscape.security.UserTarget;

import java.util.ArrayDeque;
import java.util.Deque;

public class 柱状图中最大矩形84 {
    public int largestRectangleArea(int[] heights){
        int n=heights.length;
        //每个柱子作为高，当遍历到h[i]小于栈顶元素柱子时说明找到了该高度下的
        Deque<Integer> stack=new ArrayDeque<>();
        int max=0;
        for (int i=0;i<n;i++){
            //如果当前元素的高度大于栈顶元素高度，则需要弹出栈顶元素，可能需要弹出很多次
            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int curHight=heights[stack.poll()];
                //查找curHight的左边界
                while (!stack.isEmpty()&&heights[stack.peek()]==curHight){
                    stack.poll();
                }
                int curWidth;
                if (stack.isEmpty()){
                    curWidth=i;
                }else{
                    curWidth=i-stack.peek()-1;
                }
                max=Math.max(max,curWidth*curHight);
            }
            stack.push(i);
        }
        //如果循环完成后，stack任然不为空
        while (!stack.isEmpty()){
            int curHeight=heights[stack.poll()];
            while (!stack.isEmpty()&&heights[stack.peek()]==curHeight){
                stack.poll();
            }
            int curWidth;
            if (stack.isEmpty()){
                curWidth=n;//为什么是n
            }else {
                curWidth=n-stack.peek()-1;
            }
            max=Math.max(max,curWidth*curHeight);
        }
        return max;
    }

    public static void main(String[] args) {
        柱状图中最大矩形84 test = new 柱状图中最大矩形84();
        int i = test.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
        System.out.println(i);
    }
}
