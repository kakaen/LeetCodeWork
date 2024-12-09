package 二分查找提单;

import com.sun.org.apache.bcel.internal.generic.ARETURN;
import com.sun.org.apache.bcel.internal.generic.EnumElementValueGen;

import java.util.Arrays;

public class 咒语和药水的成功对数2300 {
    public static void main(String[] args) {
        int[] spells={5,1,3};
        int[] potions={1,2,3,4,5};
        long success=7;
        Solution2300 solution2300 = new Solution2300();
        int[] ints = solution2300.successfulPairs(spells, potions, success);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
class Solution2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n=spells.length;
        int m=potions.length;
        //当 spells[i]*ptions[j]>=success.
        //pair[i]是可以和第i个咒语成功组合的药水的数目
        int[] pairs=new int[n];
        //可以使用二分插值,先把药水强度进行排序
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int index=binarySearch(potions,spells[i],success);
            pairs[i]=m-index;
        }
        return pairs;
    }
    public int binarySearch(int[] potions,int spell,long success){
        int left=0,right=potions.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            //当 potions[i]*spell>=success是，即找到第一个大于等于 success/spell
            if (potions[mid]*(long)spell<success){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
}