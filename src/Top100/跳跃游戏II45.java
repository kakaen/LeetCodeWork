package Top100;

public class 跳跃游戏II45 {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        int[] nums2={2,3,0,1,4};
        跳跃游戏II45 test = new 跳跃游戏II45();
        System.out.println(test.jump(nums));
        System.out.println(test.jump(nums2));

    }
    public int jump2(int[] nums){
        int jumpCount=0; //跳跃次数
        int curMax=0; //当前可以到达的最大边界
        int nextMax=0; //下一次可以到达的最大边界
        for (int i=0;i<nums.length-1;i++){
            nextMax=Math.max(nextMax,i+nums[i]);
            //如果到达了边界，则需要进行jump
            if (i==curMax){
                jumpCount++;
                curMax=nextMax;
            }
        }
        return jumpCount;
    }
    //最小跳跃数
    public int jump(int[] nums){
        int jumCount=1; //从下标0开始跳跃为第一次
        int curMax=nums[0]; //当前的最大下标
        int nextMax=0; //当前可以到达的最大下标。
        for (int i=0;i<nums.length-1;i++){
            //下一次可以到达的最大下标
            nextMax=Math.max(nums[i]+i,nextMax);
            //说明到达了最大下标，
            if (i==curMax){
                jumCount++;
                curMax=nextMax;
            }
        }
        return jumCount;
    }

}
