package 每日一题;

import java.util.Arrays;

public class 查询数组中元素的出现位置3159 {
    public static void main(String[] args) {
        查询数组中元素的出现位置3159 test = new 查询数组中元素的出现位置3159();
        int[] nums=new int[]{1,3,1,7};
        int[] queries=new int[]{1,3,2,4};
        int x=1;
        int[] ints = test.occurenceOfElement(nums, queries, x);
        for (int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }
    public int[] occurenceOfElement(int[] nums,int[] queries,int x){
        //将x元素出现次数i的下标保存到nums中,nums[i]表示x元素第i+1次出现的下标
        int cnt=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==x){
                nums[cnt++]=i;
            }
        }
        int[] ans=new int[queries.length];
        for (int i=0;i<queries.length;i++){
            ans[i]=queries[i]>cnt? -1:nums[queries[i]-1];
        }
        return ans;
    }
}
