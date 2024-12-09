package 代码随想录.数组;

public class 移动零283 {
    public static void main(String[] args) {

    }
}
class Solution283{
    public void moveZeros(int[] nums){
        int i=-1;
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=0){
                i++;
                nums[i]=nums[j];
            }
        }
        while (i<nums.length){
            nums[++i]=0;
        }
    }
}
