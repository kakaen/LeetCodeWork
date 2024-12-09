package 每日一题;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

public class 使二进制数组全部等于1的最少操作次数I3191 {
    public static void main(String[] args) {
        使二进制数组全部等于1的最少操作次数I3191 test = new 使二进制数组全部等于1的最少操作次数I3191();
        System.out.println(test.minOperations(new int[]{0, 1, 1, 1, 0, 0}));
        System.out.println(test.minOperations(new int[]{0, 1, 1, 1}));
    }
    public int minOperations(int[] nums){
        //选择任意三个元素，将其进行反转，
        //使nums中所有元素变为1的最少操作
        //对每个nums[i]=0的元素进行修改
        int n=nums.length;
        if (n==1) return 1-nums[0];
        int count=0;
        for (int i=0;i<n-2;i++){
            if (nums[i]==0){
                nums[i]=1;
                nums[i+1]=nums[i+1]^1;
                nums[i+2]=nums[i+2]^1;
                count++;
            }
        }
        for (int i=n-2;i<n;i++){
            if (nums[i]==0) return -1;
        }
        return count;
    }
    public int minOperations2(int[] nums){
        int count=0;
        for (int i=0;i<nums.length-2;i++){
            if (nums[i]==1){
                continue;
            }else{
                nums[i]=nums[i]^1;
                nums[i+1]=nums[i+1]^1;
                nums[i+2]=nums[i+2]^1;
                count++;
            }
        }
        if (nums[nums.length-2]==0||nums[nums.length-1]==0){
            return -1;
        }
        return count;
    }
}
