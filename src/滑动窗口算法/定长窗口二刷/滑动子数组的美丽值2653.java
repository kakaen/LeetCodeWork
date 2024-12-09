package 滑动窗口算法.定长窗口二刷;

public class 滑动子数组的美丽值2653 {
    public static void main(String[] args) {
        Solution2653 solution2653 = new Solution2653();
        int[] nums={1,-1,-3,-2,3};int k=3,x=2;
        int[] subarrayBeauty = solution2653.getSubarrayBeauty(nums, k, x);
        for (int i : subarrayBeauty) {
            System.out.println(i);
        }
    }
}
class Solution2653 {
    final static int BIAS=50;
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n=nums.length;
        int[] result=new int[n-k+1];
        int left=0,right=0;

        //窗口值，借鉴计数排序，用一个cnt数组来维护窗口中每个数出现的次数，然后遍历cnnt去寻找第x小的数
        int[] cnt=new int[BIAS*2+1];
        for (right=0;right<n;right++){
            cnt[nums[right]+BIAS]++;
            if (right<k-1) continue;
            //找出第x小的数，美丽值
            int beautifull=getXNumber(cnt,x);
            if (beautifull<0) result[right-k+1]=beautifull;
            //修改左边界的
            cnt[nums[left]+BIAS]--;
            left++;
        }
        return result;
    }
    public int getXNumber(int[] cnt,int x){
       for (int i=0;i<cnt.length;i++){
           x-=cnt[i];
           if (x<=0) return i-BIAS;
       }
       return 0;
    }
}
