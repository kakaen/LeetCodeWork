package 每日一题;

public class 半有序排列2717 {
    public static void main(String[] args) {
        半有序排列2717 test = new 半有序排列2717();
        System.out.println(test.semiOrderedPermutation(new int[]{2, 1, 4, 3}));
        System.out.println(test.semiOrderedPermutation(new int[]{2, 4, 1, 3}));
        System.out.println(test.semiOrderedPermutation(new int[]{1, 3, 4, 2, 5}));
    }
    public int semiOrderedPermutation(int[] nums){
        //第一个数字为1，最后一个为n是半有序
        int n=nums.length;
        int count=0;
        int minIndex=0;
        int maxIndex=0;
        for (int i=0;i<n;i++){
            if (nums[i]==1){
                minIndex=i;
            } else if (nums[i]==n) {
                maxIndex=i;
            }
        }
        count+=minIndex-0;
        count+=n-1-maxIndex;
        return minIndex<maxIndex?count:count-1;

    }
}
