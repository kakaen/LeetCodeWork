package 代码随想录.数组;

public class 删除排序数组中的重复项26 {
    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int[] nums={1,1,2};
        System.out.println(solution26.removeDuplicates(nums));
    }
}
class Solution26{
    public int removeDuplicates(int[] nums){
        int n=nums.length;
        int i=0,j; //i指向下一个非重复的
        for (j=1;j<n;j++){
            if (nums[j]==nums[i]) continue;
            nums[++i]=nums[j];
        }
        return i+1;
    }
}
