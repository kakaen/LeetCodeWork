package Top100.贪心算法;

public class 跳跃游戏55 {
    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        int[] nums={3,2,1,0,4};
        System.out.println(solution55.canJump(nums));
    }
}
class Solution55{
    public boolean canJump(int[] nums){
        //最初为与第一个下表
        //每次跳跃时更新最大范围,max表示当前可以到达的最大下标
        int max=0;
        int i=0;
        for ( i=0;i<nums.length;i++){
            int temp=nums[i];//在i处可以跳跃的步伐
            if (i<=max){
                //更新可以跳跃的最大范围
                max=Math.max(max,i+temp);
            }else{
                break;
            }
        }
        return nums.length==i?true:false;
    }
    //方法一：维护最右可达位置
    public boolean canJump2(int[] nums){
        int mx=0;
        for (int i=0;i<nums.length;i++){
            if (i<mx){
                //该位置不可达
                return false;
            }
            mx=Math.max(mx,i+nums[i]);
        }
        return true;
    }
}
