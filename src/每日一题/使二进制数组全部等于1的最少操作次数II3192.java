package 每日一题;

public class 使二进制数组全部等于1的最少操作次数II3192 {
    public static void main(String[] args) {
        使二进制数组全部等于1的最少操作次数II3192 test = new 使二进制数组全部等于1的最少操作次数II3192();
        System.out.println(test.minOperations(new int[]{0, 1, 1, 0, 1}));
        System.out.println(test.minOperations(new int[]{1, 0, 0, 0}));
    }
    public int minOperations(int[] nums){
        //对于nums[0]=0的话，你只能将前0--n-1都进行反转
        int n=nums.length;
        int cout=0;
        for (int i=0;i<n;i++){
            //这是前count次的反转的结果，
            if (cout%2!=0){
                nums[i]=nums[i]^1;
            }
            //判断现在这个下标是否需要反转
            if (nums[i]==1){
                continue;
            }else{
                //判断需要反转几次，count等于多少，就反转多少次;
                cout++;
                nums[i]=nums[i]^1;
            }
        }
        return cout;
    }
}
