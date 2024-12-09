package 贪心算法;

public class 跳跃游戏II45 {
    public static void main(String[] args) {

    }
}

class Solution45 {
    public int jump(int[] nums) {
        int curDistance=0; //当前覆盖的最远距离
        int ans=0; //记录走的最大步数
        int nextDistance=0;
        for (int i=0;i<nums.length-1;i++){
            nextDistance=Math.max(curDistance,nums[i]+i);
            if (i==curDistance){
                curDistance=nextDistance;
                ans++;
            }
        }
        return ans;
    }
}