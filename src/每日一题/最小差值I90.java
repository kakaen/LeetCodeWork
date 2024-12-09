package 每日一题;

public class 最小差值I90 {
    public static void main(String[] args) {
        最小差值I90 test = new 最小差值I90();
        System.out.println(test.smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(test.smallestRangeI(new int[]{0, 3,9}, 5));
    }
    public int smallestRangeI(int[] nums,int k){
        //nums的分数是最大和最小元素的差值
        //修改nums[i]=nums[i]+x，最小值
        int min=nums[0];
        int max=nums[0];
        for (int num:nums){
            if (num<min) min=num;
            if (num>max) max=num;
        }
        return max-min>2*k?max-min-2*k:0;
    }
    public int smallestRangeI2(int[] nums,int k){
        return 0;
    }
}
