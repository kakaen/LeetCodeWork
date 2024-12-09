package 每日一题;

public class 优质数对的总数I3162 {
    public static void main(String[] args) {
        优质数对的总数I3162 test = new 优质数对的总数I3162();
        int[] nums1=new int[]{1,3,4};
        int[] nums3=new int[]{1,2,4,12};
        int[] nums2=new int[]{1,3,4};
        int[] nums4=new int[]{2,4};
        int k=1;
        System.out.println(test.numberOfPairs(nums3, nums4, 3));

    }
    public int numberOfPairs(int[] nums1,int[] nums2,int k){
        //暴力遍历解法
        int res=0;
        for (int i=0;i<nums1.length;i++){
            for (int j=0;j<nums2.length;j++){
                if (nums1[i]%(nums2[j]*k)==0) res++;
            }
        }
        return res;
    }
}
