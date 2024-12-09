package 滑动窗口算法.定长窗口二刷;

public class 半径为k的字数组平均值2090 {
    public static void main(String[] args) {

    }
}
class Solution2090 {
    public int[] getAverages(int[] nums, int k) {
        int n=nums.length;
        int[] result=new int[n];
        int left=0,right=0;
        //窗口值大小为 2k+1
        long count=0;
        for (right=0;right<n;right++){
            count+=nums[right];
            if (right<2*k){
                result[right]=-1;
                continue;
            }
            //更新答案
            result[right]=(int)(count/(2*k+1));
            //出
            count-=nums[left++];
        }
        return result;
    }
}
