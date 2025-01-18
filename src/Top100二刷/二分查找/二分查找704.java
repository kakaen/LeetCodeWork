package Top100二刷.二分查找;

public class 二分查找704 {
    public static void main(String[] args) {
        二分查找704 test = new 二分查找704();
        System.out.println(test.search(new int[]{1, 2, 3, 4, 7, 9, 10}, 2));
        System.out.println(test.search(new int[]{0, 1, 2, 3, 4, 5, 6, 7}, 7));
    }
    public int search(int[] nums,int target){
        int l=0,r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            if (nums[m]<target){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        if (l==nums.length||nums[l]!=target) return -1;
        return l; //返回第一个大于等于target的值
    }
}
