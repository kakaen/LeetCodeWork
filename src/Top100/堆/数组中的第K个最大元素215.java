package Top100.堆;

import java.util.Scanner;

public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {
        Solution215 solution215 = new Solution215();
        int[] nums={3,2,3,1,2,4,5,5,6};
        System.out.println(solution215.findKthLargest(nums, 4));
    }
}
class Solution215{
    public int findKthLargest(int[] nums,int k){
        //数组排序后的第k个最大的元素
        int n=nums.length;
        int[] table=new int[10001]; //创建哈希表
        for(int i=0;i<n;i++){
            table[nums[i]]++;
        }
        for (int i = 10000; i >= 0; i--) {
            if (table[i] != 0) k = k - table[i];
            if (k <= 0) return i;
        }
        return 0;
    }
}
