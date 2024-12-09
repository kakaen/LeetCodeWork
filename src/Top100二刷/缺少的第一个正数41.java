package Top100二刷;

import java.util.Arrays;

public class 缺少的第一个正数41 {
    public int firstMissingPositive(int[] nums) {
        //对于一个长度为N的数组，没有出现的最小整数只能是[1,N+1]
        //我们可以遍历数组，如果x在1-N范围内，则将数组中x-1打上flag
        //在遍历接收后，如果所有位置都被打上标记则最小值为N
        int n=nums.length;
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=0) nums[i]=n+1;
        }
        for (int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            if (index<n&&nums[index]>0){
                nums[index]=-nums[index];
            }
        }
        for (int i=0;i<n;i++){
            if (nums[i]>0){
                return i+1;
            }
        }
        return n+1;
    }

    public static void main(String[] args) {
        缺少的第一个正数41 test = new 缺少的第一个正数41();
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(test.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(test.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
