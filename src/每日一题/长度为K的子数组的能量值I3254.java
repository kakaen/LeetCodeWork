package 每日一题;

import java.util.Arrays;

public class 长度为K的子数组的能量值I3254 {
    public static void main(String[] args) {
        长度为K的子数组的能量值I3254 test = new 长度为K的子数组的能量值I3254();
        int[] ints = test.resultsArray2(new int[]{1, 2, 3, 4, 3, 2, 5}, 3);
        int[] ints2 = test.resultsArray2(new int[]{2,2,2,2,2}, 4);
        int[] ints3 = test.resultsArray2(new int[]{3,2,3,2,3,2}, 2);
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(ints2));
        System.out.println(Arrays.toString(ints3));
    }
    public int[] resultsArray(int[] nums,int k){
        if (k==1) return nums;
        int n=nums.length;
        int m=n-k+1;
        int[] res=new int[m];
        int i=0;
        for (int j=1;j<n;j++){
            if (nums[j]!=nums[j-1]+1){
                i=j;
            }
            if (j<k-1) continue;
            if ((j-i+1)==k){
                res[j-k+1]=nums[j];
                i++;
            }else{
                res[j-k+1]=-1;
            }
        }
        return res;
    }
    public int[] resultsArray2(int[] nums,int k){
        int n=nums.length;
        int m=n-k+1;
        int[] res=new int[m];
        Arrays.fill(res,-1);
        int count=0; //表示当前连续递增的元素个数
        for (int j=0;j<n;j++){
           if (j>0&&nums[j]==nums[j-1]+1){
                count++;
            }else{
               count=1;
           }
            if (count>=k){
                res[j-k+1]=nums[j];
            }
        }
        return res;
    }
}
