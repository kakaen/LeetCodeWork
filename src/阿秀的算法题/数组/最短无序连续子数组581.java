package 阿秀的算法题.数组;

import java.util.Arrays;

public class 最短无序连续子数组581 {
    public static void main(String[] args) {
        Solution581 solution581 = new Solution581();
        System.out.println(solution581.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(solution581.findUnsortedSubarray(new int[]{1,2, 3, 4}));
        System.out.println(solution581.findUnsortedSubarray(new int[]{1,2, 3, 4}));
    }

}
class Solution581 {
    public int findUnsortedSubarray(int[] nums) {
        //找出最短的连续子数组进行升序排列
        // （这个子数组中最大的数小于后面的所有数，且后面的所有数都是有序排列的）
        //（这个子数组中最小的数大于前面所有数，前面所有数也是有序的）
        int n=nums.length;
        if (n<=1) return 0; //只有一个数直接返回

        int start=0;
        for (int i=1;i<n;i++){
            //说明需要进行排序，如果nums[i-1]>nums[i];则说明需要进行排序
            //从哪开始排，取决于前面哪个数小于nums[i],找到前面nums[k]<nums[i]的数
            //start+1就是需要排序的子数组的左边界
            if (nums[i]<nums[i-1]){
                start=i-1;
                //往后找，找到第一个nums[start]<nums[i];
                while (start>=0&&nums[start]>nums[i]){
                    start--;
                }
                break;
            }
        }
        //从右往左找子数组的最右侧边界
        int end=0;
        for (int i=n-2;i>=0;i--){
            //如果nums[i]>nums[i+1],
            //往右找，找到nums[i]<nums[end]

            if (nums[i]>nums[i+1]){
                end=i+1;
                while (end<n&&nums[i]>nums[end]){
                    end++;
                }
                break;
            }
        }
        if (start==end) return 0;
        return end-start-1;
    }
    //三段式拼接，分别记为numsA，numsB，numsC
    public int findUnsortedSubarray2(int[] nums){
        if (isSorted(nums)){
            return 0;
        }
        //将原数组进行拷贝，记作数组numsSorted，并对该数组进行排序
        int[] numsSorted=new int[nums.length];
        System.arraycopy(nums,0,numsSorted,0,nums.length);
        Arrays.sort(numsSorted);
        int left=0;
        while (nums[left]==numsSorted[left]){
            left++;
        }
        int right=nums.length-1;
        while (nums[right]==numsSorted[right]){
            right--;
        }
        return right-left+1;
    }
    //方法二：一次遍历
    //numsB在nums中的区间为[left,right],numsB和
    public int findUnsortedSubarray3(int[] nums){
        int n=nums.length;
        long minn=Long.MAX_VALUE;
        int left=-1;
        long maxn=Long.MIN_VALUE;
        int right=-1;
        for (int i=n-1;i>=0;i--){
            if (nums[i]>minn){
                left=i;
            }else {
                minn=nums[i];
            }
        }
        for (int i=0;i<n;i++){
            if (minn<nums[n-i-1]){
                left=n-i-1;
            }else {
                minn=nums[n-i-1];
            }
        }
        return right-left+1;
    }
    public boolean isSorted(int[] nums){
        for (int i=0;i<nums.length;i++){
            if (nums[i]<nums[i-1]){
                return false;
            }
        }
        return true;
    }

}
