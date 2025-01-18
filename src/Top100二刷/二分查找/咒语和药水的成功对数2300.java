package Top100二刷.二分查找;

import java.lang.reflect.Array;
import java.util.Arrays;

public class 咒语和药水的成功对数2300 {
    public static void main(String[] args) {
        咒语和药水的成功对数2300 test = new 咒语和药水的成功对数2300();

    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        //spells[i]表示第i个咒语的能量强度
        //potions[j]表示第j瓶药水的能量强度。
        int n=spells.length;
        Arrays.sort(potions);
        int[] pairs=new int[n];
        for (int i=0;i<n;i++){
            pairs[i]=potions.length-binarySearch(potions,success,spells[i]);
        }
        return pairs;
    }
    //找第一个大于等于success的下标
    public int binarySearch(int[] nums,long success,int spell){
        int l=0,r=nums.length-1;
        while (l<=r){
            int m=l+(r-l)/2;
            long count=(long)nums[m]*spell;
            if (count<success){
                l=m+1;
            }else {
                r=m-1;
            }
        }
        return l;
    }
}
