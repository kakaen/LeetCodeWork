package 二分查找提单;

import java.util.Arrays;

public class 和有限的最长子序列2389 {

}
class Solution2389 {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int m=queries.length;
        //answer[i]是nums中元素之和小于等于quer[i](target)的子序列的最大长度
        //我可以把nums先进行排序
        Arrays.sort(nums);
        //前缀和， 下标为i的元素就是前i+1个元素的和
        for (int i=1;i<n;i++){
            nums[i]+=nums[i-1]; //原地求前缀和
        }
        int[] answer=new int[m];
        for (int i=0;i<m;i++){
            int index = binarySearch(nums, queries[i]);
            answer[i]=index+1;
        }
        return answer;
    }
    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            if (nums[mid]<=target){         //找到最后一个小于等于target的值，就是第一个大于target的数
                left=mid+1;
            }else {   //当前mid>
                right=mid-1;
            }
        }
        return left; //返回第一个大于target的值
    }
    //找到第一个大于target的元素和
    public int serarchMaxCount(int[] nums,int target){
        int i=0;
        int sum=0;
        for (i=0;i<nums.length;i++){
            sum+=nums[i];
            if (sum>target) break;
        }
        return i;
    }

}
