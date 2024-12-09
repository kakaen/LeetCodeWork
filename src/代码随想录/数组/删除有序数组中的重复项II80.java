package 代码随想录.数组;

import java.util.Arrays;

public class 删除有序数组中的重复项II80 {
    public static void main(String[] args) {
        删除有序数组中的重复项II80 test = new 删除有序数组中的重复项II80();
        int[] nums1=new int[]{1,1,1,2,2,3};
        int[] nums=new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(test.removeDuplicates2(nums));
        System.out.println(Arrays.toString(nums));
    }
    public int removeDuplicates(int[] nums){
        //原地删除重复出现的元素
        int n=nums.length;
        int first=-1,second=0; //表示当前要设置的下标的前一个
        int count=0;
        //i来循环所有的数组
        for (second=0;second<n;second++){
            //表示第一次，或者当前元素第一次出现
            if (first==-1||nums[first]!=nums[second]){
                first=first+1; //表示要
                nums[first]=nums[second];
                count=1;
            } else if (count<2&&nums[first]==nums[second]) {
                //表示之前元素已经存在过，判断存在了几个
                first++;
                nums[first]=nums[second];
                count++;
            }else {
                //表示现在元素已经超过2个了
                continue; //直接continue结束
            }
        }
        return first+1;
    }
    //使用O(1)的额外空间的条件下完成
    public int removeDuplicates2(int[] nums){
      //使用双指针的解法，给定元素是有序的，固相同元素必然连续
        //双指针slow和fast，fast用来遍历，slow用来处理数组的长度
        int n=nums.length;
        if (n<=2) return n;
        int slow=2,fast=2;
        for (;fast<n;fast++){
            if (nums[fast]!=nums[slow-2]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
