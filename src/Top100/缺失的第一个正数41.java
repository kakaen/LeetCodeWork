package Top100;

import java.util.HashSet;
import java.util.Set;

public class 缺失的第一个正数41 {
    public static void main(String[] args) {

    }
}
class Solution41 {
    public int firstMissingPositive(int[] nums) {
        //找出其中没有出现的最小的正整数
        int left=0,right=0; //标记出现的左右边界
        int n=nums.length;
        left=nums[0];right=nums[0];
        int need=nums[0]+1;
        for (int i=0;i<n;i++){
            while (nums[i]>0&&nums[i]<=n&&nums[nums[i]-1]!=nums[i]){
                int temp=nums[nums[i]-1];
                nums[nums[i]-1]=nums[i];
                nums[i]=temp;

            }

    }
        return 0;

}
    public int firstMissingPositive2(int[] nums) {
        //非常数空间
        int n=nums.length;
        Set<Integer> hashSet=new HashSet<>();
        for (int num:nums){
            hashSet.add(num);
        }
        for (int i=1;i<=n;i++){
            if (!hashSet.contains(i)) return i;
        }
        return n+1;
    }
    }
