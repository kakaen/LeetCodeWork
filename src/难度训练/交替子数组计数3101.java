package 难度训练;

public class 交替子数组计数3101 {
    public static void main(String[] args) {
        Solution3101 solution3101 = new Solution3101();
        int[] nums={0,1,0,1};
        System.out.println(solution3101.countAlternatingSubarrays(nums));
    }
}
class Solution3101{
    public long countAlternatingSubarrays(int[] nums){
        int n=nums.length;
        if (n==0||n==1) return n;
        long res=0;
        //先找到第一个两两一样的数组
        int starIndex=0;
        int endIndex=0;
        for (int i=0;i<n-1;i++){
            if (i==n-2&&nums[i]==nums[i+1]){
                long x=i-starIndex+1;
                res+=(x+1)*x/2+1;
                starIndex=i+1;
            }else if (i==n-2&&nums[i]!=nums[i+1]){
                long x=i-starIndex+1+1;
                res+=(x+1)*x/2;
                starIndex=i+1;
            }
            if (nums[i]==nums[i+1]){
                long x=i-starIndex+1;
                res+=(x+1)*x/2;
                starIndex=i+1;
            }
        }
        return res;
    }
    //求
    public long countAlternatingSubarrays2(int[] nums){
        int n=nums.length;
        long res=0;
        int cnt=0;
        for (int i=0;i<nums.length;i++){
            if (i>0&&nums[i]!=nums[i-1]){
                cnt++;
            }else{
                cnt=1;
            }
            res+=cnt;
        }
        return res;
    }
}
