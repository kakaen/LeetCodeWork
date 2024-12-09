package Top100.数组;

public class 最长连续序列128 {
    public static void main(String[] args) {

    }
}
class Solution128{
    public int longestConsecutive(int[] nums){
        int max=0;
         for (int num:nums){
             max=Math.max(max,num);
         }
         int[] arr=new int[max+1];
         for (int num:nums){
             arr[num]=1;
         }
         int total=0;
         int maxLen=arr[0];
         for (int i=1;i<=max;i++){
             if (arr[i]==1&&arr[i-1]==0){
                 maxLen++;
                 total=Math.max(total,maxLen); 
             }
         }
         return 0;
    }
}
