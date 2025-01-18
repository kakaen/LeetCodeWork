package Top100二刷.二分查找;

public class 搜索插入位置35 {
    public int searchInsert(int[] nums,int target){
        //查找到目标值，也就是查找到第一个大于等于target的位置
        int n=nums.length;
        int l=0,r=n-1;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (nums[mid]<target){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        搜索插入位置35 test = new 搜索插入位置35();
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
