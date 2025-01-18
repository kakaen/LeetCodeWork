package Top100二刷.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class 柱状图中最大的矩形84 {
    public int largestRectangleArea(int[] heights) {
        //给n个非负整数，表示柱状图中各个柱子的高度，每个柱子彼此相邻，且宽度为1
        //构造一个单调增的
        //如果新增的柱子的高度大于等于前面的最小高度的柱子，则加
        //如果新增的柱子的高度 小于前面最小的柱子，需要考虑增加后的面积是大于原来的面积还是小于原来的面积
        //第i位置最大面积是什么，就是以第i根柱子为最矮柱子所能延伸的最大面积
        //假设h=height[i]是矩形的高度，那矩形的宽度最大是多少？
        //在i左侧的小于h的最近元素的下标left，，求出在i左侧的大于等于h的最近元素的下标。
        //在i右侧的小于h的最近元素right，right-1就是在i的右侧的大于等于h的最近元素
        int n=heights.length;
        Deque<Integer> stack=new ArrayDeque<>();
        int ans=0;
        //枚举每一个height[i]将其作为最高的高度,对于每一个高度，分别向两边进行扩散，求出以当前高度为矩形的最大宽度是多少?
        //
        for (int i=0;i<n;i++){
            int height=heights[i];
            int left=i,right=i;
            //确定左边界
            while (left-1>=0&&heights[left-1]>=height){
                left--;
            }
            while (right+1<n&&heights[right+1]>=height){
                right++;
            }
            //计算面积
            ans=Math.max(ans,(right-left+1)*height);

        }
        return ans;
    }
    //优化，上面是暴力解法，会超时
    public int largestRectangleArea2(int[] heights){
        int n=heights.length;
        int max=0;
        //存储遍历柱子的高度
        Deque<Integer> stack=new ArrayDeque<>();
        for (int i=0;i<n;i++){
            while (!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                int curHight=heights[stack.poll()];//右边界无法进行扩展
                //找到左边界
                while (!stack.isEmpty()&&curHight==heights[stack.peek()]){
                    stack.poll();
                }
                int curWidth;
                if (stack.isEmpty()){
                    curWidth=i;
                }else{
                    curWidth=i-stack.peek()-1;
                }
                max=Math.max(max,curHight*curWidth);
            }
            stack.push(i);
        }
        //如果stack不为空
        while (!stack.isEmpty()){
            int curHeight=heights[stack.poll()];
            while (!stack.isEmpty()&&curHeight==heights[stack.peek()]){
                stack.poll();
            }
            int curWidth;
            if (stack.isEmpty()){
                curWidth=n;
            }else{
                curWidth=n-stack.peek()-1;
            }
            max=Math.max(max,curHeight*curWidth);
        }
        return max;
    }

    public static void main(String[] args) {
        柱状图中最大的矩形84 test = new 柱状图中最大的矩形84();
        System.out.println(test.largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea2(new int[]{2, 4}));
    }
}
