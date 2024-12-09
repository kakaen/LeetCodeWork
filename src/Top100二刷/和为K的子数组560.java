package Top100二刷;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 和为K的子数组560 {
    //固定左边界left，右移右边界right
    public int subarraySum(int[] nums, int k) {
        //整数数组nums,和k统计并返回该和为k的子数组
        //连续非空序列
        int n=nums.length;
        int count=0; //作为窗口
        //使用前缀和数组， int[]
        //由于数组不是递增的因此无法使用滑动窗口来记录值的大小
        for (int left=0;left<n;left++){
            int sum=0;
            for (int right=left;right<n;right++){
                sum+=nums[right];
                if (sum==k) count++;
            }
        }
        return count;
    }
    //使用前缀和的方式来实现
    public int subarraySum3(int[] nums,int k){
        //返回该数组中和为k的子数组的个数
        //采用前缀和的方式（i，j）的下标和为 [0,i-1],[0,j]
        int n=nums.length;
        //prefix[i]表示nums中前i个元素的和
        int[] prefix=new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+nums[i-1];
        }
        //[i,j]的和
        int count=0;
        for (int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                //这里是使用
                if (prefix[j+1]-prefix[i]==k){
                    count++;
                }
            }
        }
        return count;
    }
    //方法四：前缀和+哈希表优化
    public int subarraySum4(int[] nums,int k){
        //前缀和为key，value为对应的个数
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int[] prefix=new int[n+1];
        map.put(0,1); //前缀和为0，个数为1
        int preSum=0;
        for (int num:nums){

        }
        return 0;
    }
    public static void main(String[] args) {
        和为K的子数组560 test = new 和为K的子数组560();
        System.out.println(test.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(test.subarraySum(new int[]{1, 2, 3}, 3));
    }
}
