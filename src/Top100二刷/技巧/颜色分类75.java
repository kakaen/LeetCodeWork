package Top100二刷.技巧;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.Arrays;

public class 颜色分类75 {
    public static void main(String[] args) {
        颜色分类75 test = new 颜色分类75();
        int[] nums=new int[]{2,0,2,1,1,0};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors2(int[] nums){
        //使用双指针来交换0,和1
        int n=nums.length;
        int p0=0,p1=0;
        for (int i=0;i<n;i++){
            if (nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[p1];
                nums[p1]=temp;
                p1++;
            } else if (nums[i]==0) {
                int temp=nums[i];
                nums[i]=nums[p0];
                nums[p0]=temp;
                if (p0<p1){
                    //如果是这种情况的话
                    temp=nums[i];
                    nums[i]=nums[p1];
                    nums[p1]=temp;
                }
                p0++;
                p1++;
            }
        }
    }
    public void sortColors(int[] nums) {
        //原地对他们进行排序 0,1,2分别表示红色、白色、蓝色
        //常数空间的扫描算法
       int zeroCount=0;
       int oneCount=0;
       int twoCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                zeroCount++;
            } else if (nums[i]==1) {
                oneCount++;
            }else {
                twoCount++;
            }
        }
        for (int i=0;i<zeroCount;i++){
            nums[i]=0;
        }
        for (int i=0;i<oneCount;i++){
            nums[i+zeroCount]=1;
        }
        for (int i=0;i<twoCount;i++){
            nums[i+oneCount+zeroCount]=2;
        }
    }
}
