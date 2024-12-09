package Top100.动态规划.最大子数组的和;

public class 环形子数组的最大和918 {
    public static void main(String[] args) {
        环形子数组的最大和918 test = new 环形子数组的最大和918();
        System.out.println(test.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(test.maxSubarraySumCircular(new int[]{-5, -2, -3, -2}));
    }
    public int maxSubarraySumCircular(int[] nums){
        int n=nums.length;
        int ans=nums[0];
        //从第i个下标开始遍历
        for (int i=0;i<n;i++){
            int count=0;
            for (int j=0;j<n;j++){
                if (count>=0){
                    count+=nums[(i+j)%n];
                }else{
                    count=nums[(i+j)%n];
                }
                ans=Math.max(ans,count);
            }
        }
        return ans;
    }
    public int maxSubarraySumCircular2(int[] nums){
       int total=0,maxSum=nums[0],curMax=0,minSum=nums[0],curMin=0;
       for (int num:nums){
           curMax=Math.max(curMax+num,num);
           maxSum=Math.max(maxSum,curMax);
           curMin=Math.min(minSum,curMin);
           minSum=Math.min(minSum,curMin);
           total+=num;
        }
       return maxSum>0?Math.max(maxSum,total-minSum):maxSum;

    }
}
