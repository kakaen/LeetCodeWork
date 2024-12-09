package 代码随想录.数组;

public class 删除有序数组中重复的k项 {
    public static void main(String[] args) {

    }
    public int removeDuplicates(int[] nums){
         int n=nums.length;
         if (n<=1) return n;
         int slow=1,fast=1; //slow-1表示已检查元素，fast表示待检测元素
        for (;fast<n;fast++){
            if (nums[fast]!=nums[slow-1]){
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
