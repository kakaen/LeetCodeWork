package Top100二刷.回溯二刷.子集;

public class 找出所有子集的异或总和再求和1863 {
    public int sum=0;
    public int subsetXORSum(int[] nums){
        int pathSum=0;
        backtracking(0,nums,pathSum);
        return sum;
    }

    private void backtracking(int i, int[] nums,int pathSum) {
        sum+=pathSum; //将这个子集的异或结果加入到最终的结果集中。
//        System.out.println(pathSum);

        for (int j=i;j<nums.length;j++){
            pathSum=pathSum^nums[j];
            backtracking(j+1,nums,pathSum);
            pathSum=pathSum^nums[j];
        }
    }

    public static void main(String[] args) {
        找出所有子集的异或总和再求和1863 test = new 找出所有子集的异或总和再求和1863();
//        int i = test.subsetXORSum(new int[]{1, 3});
//        System.out.println(i);
//        System.out.println(test.subsetXORSum(new int[]{5,1,6}));
        System.out.println(test.subsetXORSum(new int[]{3,4,5,6,7,8}));
    }
}

