package 代码随想录.数组;




public class 长度最小的子数组209 {
    public static void main(String[] args) {
        Soution209_2 soution2092 = new Soution209_2();
        System.out.println(soution2092.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(soution2092.minSubArrayLen(11, new int[]{1, 1, 1,1,1,1,1,1}));
    }
}
class Soution209_2{
    public int minSubArrayLen(int target,int[] nums){
        //不定长窗口题吗
        int n=nums.length;
        int left=0,right=0;
        int count=0; //窗口值
        int min=Integer.MAX_VALUE;
        for (right=0;right<n;right++){
            count+=nums[right]; //将当前值入窗口
            while (left<=right&&count>=target){
                min=Math.min(min,right-left+1);
                count-=nums[left++];
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
