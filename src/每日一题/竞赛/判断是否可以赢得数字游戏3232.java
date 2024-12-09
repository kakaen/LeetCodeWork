package 每日一题.竞赛;

public class 判断是否可以赢得数字游戏3232 {
    public static void main(String[] args) {

    }
}
class Solution3232 {
    public boolean canAliceWin(int[] nums) {
        long single=0;
        long count2=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]<10){
                single+=nums[i];
            }else {
                count2+=nums[i];
            }
        }
        return single==count2?false:true;
    }
}
