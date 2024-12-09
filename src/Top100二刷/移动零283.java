package Top100二刷;

public class 移动零283 {
    public void moveZeroes(int[] nums){
        //编写所有，双指针
        int left=0;int right=0;
        for (right=0;right<nums.length;right++){
            if (nums[right]!=0){
                nums[left]=nums[right];
                left++;
            }
        }
        while (left<nums.length){
            nums[left]=0;
            left++;
        }
    }
    //使用count进行记录0的个数
    public void moveZeroes2(int[] nums){
        int zeroCount=0;
        int n=nums.length;
        for (int i=0;i<n;i++){
            if (nums[i]==0){
                zeroCount++;
            }else{
                nums[i-zeroCount]=nums[i];
            }
        }
        for (int i=0;i<zeroCount;i++){
            nums[n-1-i]=0;
        }
    }
}
