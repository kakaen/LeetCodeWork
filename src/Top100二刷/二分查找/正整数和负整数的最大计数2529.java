package Top100二刷.二分查找;

public class 正整数和负整数的最大计数2529 {
    public static void main(String[] args) {
        正整数和负整数的最大计数2529 test = new 正整数和负整数的最大计数2529();
        test.maximumCount(new int[]{-2,-1,-1,1,2,3});
        test.maximumCount(new int[]{-3,-2,-1,0,0,1,2});
    }
    public int maximumCount(int[] nums){
        //按非递减顺序排列的数组nums,返回正整数的数目和负整数数目中的最大值。
        int n=nums.length;
        int count1=n-binarySearch(nums,1);
        int count2=binarySearch(nums,0); //负整数为 所有元素减去大于等于0的元素个数

        return Math.max(count1,count2);
    }
    public int binarySearch(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return l; //l是大于等于target的
    }
}
