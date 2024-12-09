package 滑动窗口算法.定长窗口;

import java.util.*;

public class 滑动子数组的美丽值2653 {
    public static void main(String[] args) {
        Solution2653 solution2653 = new Solution2653();
        int[] integers=new int[]{1,-1,-3,-2,3};
        int[] subarrayBeauty = solution2653.getSubarrayBeauty(integers, 3, 2);
        System.out.println(Arrays.toString(subarrayBeauty));
    }
}

class Solution2653 {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        //美丽值定义：如果子数组中第x小整数是负数，则美丽值为第x小的数，否则美丽值为0
        int n=nums.length;
        int[] result=new int[n-k+1];
        //先进先出的嘛
        Deque<Integer> subList=new LinkedList<Integer>();
        for (int i=0;i<n;i++){
            //1.入窗口
            subList.add(nums[i]);
            if (i<k-1){
                continue;
            }
            //2.更新答案，计算美丽值
            int beautifullValue=getBeautiful(subList,x);
            result[i-k+1]=beautifullValue;
            //3.出窗口,最左侧的元素弹出队列
            subList.pop();
        }
        return result;
    }

    public int getBeautiful(Deque<Integer> subList, int x) {
        int[] arr=new int[subList.size()];
        int i=0;
        for (Integer integer : subList) {
            arr[i++]=integer;
        }
        Arrays.sort(arr);
        int result=arr[x-1];
        return result<0?result:0;
    }

}