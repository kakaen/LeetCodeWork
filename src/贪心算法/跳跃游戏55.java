package 贪心算法;

public class 跳跃游戏55 {
}

class Solution55 {
    public boolean canJump(int[] nums) {
        //在当前位置跳几步无所谓，在于可跳的覆盖范围
        //每次取最大跳跃步数，(取最大覆盖范围)
        int maxIndex=0;
        int resultIndex=0;
        if (nums.length==1) return true;
        for (int i=0;i<=maxIndex;i++){
            maxIndex=Math.max(i+nums[i],maxIndex);
            if (maxIndex>=nums.length-1) return true;
        }

        return false;
    }
    public boolean canJump2(int[] nums){
        int maxIndex=0;
        for (int i=0;i<=maxIndex;i++){
            maxIndex=Math.max(i+nums[i],maxIndex);
            if (maxIndex>=nums.length-1) return true;
        }
        return false;
    }
}
