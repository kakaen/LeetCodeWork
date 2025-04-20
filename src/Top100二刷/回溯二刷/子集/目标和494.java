package Top100二刷.回溯二刷.子集;

import java.util.HashMap;

public class 目标和494 {
    public static void main(String[] args) {
        目标和494 test = new 目标和494();
        System.out.println(test.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
    public int count=0;
    public int findTargetSumWays(int[] nums,int target){
        // 在每个整数之前添加+或者-，就意味着运算结果等于target的不同表达式
        backtracking(nums, target, 0, 0); // 从索引0开始，当前总和为0
        new HashMap<>();
        return count;
    }

    public void backtracking(int[] nums, int target, int index, int currentSum) {
        // 如果已经处理完所有数字，检查当前总和是否等于目标值
        if (index == nums.length) {
            if (currentSum == target) {
                count++;
            }
            return;
        }

        // 选择当前数字为正号
        backtracking(nums, target, index + 1, currentSum + nums[index]);

        // 选择当前数字为负号
        backtracking(nums, target, index + 1, currentSum - nums[index]);
    }
}
