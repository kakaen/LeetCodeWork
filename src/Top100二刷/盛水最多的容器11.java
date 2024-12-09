package Top100二刷;

public class 盛水最多的容器11 {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxArea=0;
        while (left<right){
            //计算本次的最大面积
            int curArea=Math.min(height[left],height[right])*(right-left);
            maxArea=Math.max(maxArea,curArea);
            if (height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
}
