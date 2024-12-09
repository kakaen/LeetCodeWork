package 每日一题;

public class 单调数组对的数目I3250 {
    public static int arr1; //记录Arr1的前一个元素的值
    public static int arr2;//记录arr2的前一个元素的值
    public int countOfPairs(int[] nums){
        //长度为n的
        int n=nums.length;
        //非负整数，将nums[i]拆成arr1[i]+arr2[i]
        for (int i=0;i<n;i++){
            for (int j=0;j<=nums[i];j++){
//                if (i>0&&)
            }
        }
        return 0;
    }
    //采用回溯算法，i表示向下遍历的第几个元素，nums[start]
    public void bacTracking(int[] nums,int start){
        if (start==nums.length){
            return;
        }
        //这个是横向遍历
        for (int i=0;i<=nums[start];i++){
            //i为arr1的值
            if (i<arr1||(nums[start]-i)>arr2){
                continue;
            }
            arr1=i; arr2=nums[start]-i;
            bacTracking(nums,start+1);
            //回溯
        }
    }
}
