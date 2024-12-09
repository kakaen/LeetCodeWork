package Top100.双指针;

public class 盛最多水的容器11 {
    public static void main(String[] args) {
        盛最多水的容器11 test = new 盛最多水的容器11();
        System.out.println(test.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
    public int maxArea(int[] height){
        //使用双指针算法
        int left=0,right=height.length-1;
        int maxCount=0;//记录放置水的最大容量
        while (left<right){
            if(height[left]<height[right]){
                maxCount=Math.max(maxCount,(right-left)*height[left]);
                left++;
            }else {
                maxCount=Math.max(maxCount,(right-left)*height[right]);
                right--;
            }
        }

        return maxCount;
    }
}
