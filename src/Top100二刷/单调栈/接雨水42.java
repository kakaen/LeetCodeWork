package Top100二刷.单调栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class 接雨水42 {
    //暴力解法,会超时
    public int trap(int[] height){
        int ans=0;
        int n=height.length;
        //按列计算
        for (int i=0;i<n;i++){
            if (i==0||i==n-1) continue;
            int rHeight=height[i]; //记录右边柱子的最高高度
            int lHeight=height[i]; //记录左边柱子的最高高度
            //从当前下标往左遍历，查找最高柱子
            for (int l=0;l<i;l++){
                if (height[l]>lHeight) lHeight=height[l];
            }
            //从当前下标往右遍历，查找最高柱子
            for (int r=i;r<n;r++){
                if (height[r]>rHeight) rHeight=height[r];
            }
            ans+=Math.max(0,Math.min(lHeight,rHeight)-height[i]);
        }
        return ans;
    }
    //双指针优化，使用数组记录每个下标的左侧柱子的最大高度，和右侧最大高度
    public int trap2(int[] height){
       int n=height.length;
       int[] lHeight=new int[n];
       int[] rHeight=new int[n];
       lHeight[0]=height[0];
       //求左侧柱子的最大值
       for (int i=1;i<n;i++){
           lHeight[i]=Math.max(lHeight[i-1],height[i]);
       }
       //求右侧柱子的最大值
       rHeight[n-1]=height[n-1];
       for (int i=n-2;i>=0;i--){
           rHeight[i]=Math.max(rHeight[i+1],height[i]);
       }
       int ans=0;
       for (int i=1;i<n-1;i++){
           ans+=Math.max(Math.min(rHeight[i],lHeight[i])-height[i],0);
       }
       return ans;
    }
    //使用单调栈进行解决
    public int trap3(int[] height){
       int n=height.length;
       //单调递减的栈
       Deque<Integer> stack=new ArrayDeque<>();
       int ans=0;
       for (int i=0;i<n;i++){
           while (!stack.isEmpty()&&height[i]>height[stack.peek()]){
               //弹出栈顶元素
               int bootH=height[stack.poll()];
               //判断是否有左边界
               if (stack.isEmpty()) break;
               int h=Math.min(height[stack.peek()],height[i])-bootH;
               ans+=h*(i-stack.peek()-1);
           }
           stack.push(i);
       }
       return ans;
    }
    //使用数组来记录每一列的左侧柱子最大高度和右侧柱子最大高度
    public int trap4(int[] height){
        int n=height.length;
        if (n<=2) return 0;
        int[] lHeight=new int[n];
        int[] rHeight=new int[n];
        lHeight[0]=height[0];
        for (int i=1;i<n;i++){
            lHeight[i]=Math.max(lHeight[i-1],height[i]);
        }
        //求右侧的最大柱子高度
        rHeight[n-1]=height[n-1];
        for (int i=n-2;i>=0;i--){
            rHeight[i]=Math.max(rHeight[i+1],height[i]);
        }
        int ans=0;
        for (int i=0;i<n;i++){
            ans+=Math.max(0,Math.min(lHeight[i],rHeight[i])-height[i]);
        }
        return ans;
    }
    //使用双指针，实现O(n)级时间复杂度和O(1)级空间复杂度
    public int trap5(int[] height){
        int n=height.length;
        //维护两个指针left和right，以及两个变量leftMax和rightMax
        int left=0,right=n-1,leftMax=0,rightMax=0;
        //当两个指针没有相遇时，
        return 0;
    }
    public static void main(String[] args) {
        接雨水42 test = new 接雨水42();
        System.out.println(test.trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(test.trap3(new int[]{4,2,0,3,2,5}));
    }
}
