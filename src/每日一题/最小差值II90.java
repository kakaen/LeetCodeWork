package 每日一题;

import java.util.Arrays;

public class 最小差值II90 {
    public int smallestRangeII(int[] nums,int k){
       //先吧nums进行排序
        Arrays.sort(nums);
        int n=nums.length;
        int ans=nums[n-1]-nums[0];
        for (int i=1;i<n;i++){
            int mx=Math.max(nums[i-1]+k,nums[n-1]-k);
            int mn=Math.min(nums[0]+k,nums[i]-k);
            ans=Math.min(ans,mx-mn);
        }
        return ans;
    }
}
