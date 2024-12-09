package Top100;

public class 跳跃游戏55 {
    public static void main(String[] args) {
        跳跃游戏55 test = new 跳跃游戏55();
        System.out.println(test.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(test.canJump(new int[]{3,2,1,0,4}));
    }
    public boolean canJump(int[] nums){
        int canMax=0;//一开始最远可以到达的位置是0
        int n=nums.length;
        for (int i=0;i<n;i++){
            if (i>canMax) return false;
            int curMax=nums[i]+i; //当前下标可以到达的最大值
            canMax=Math.max(canMax,curMax); //更新可以达到的最大下标
        }
        return true;
    }
}
