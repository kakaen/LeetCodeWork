package Top100二刷;

import java.util.Arrays;

public class 颜色分类75 {
    public void sortColors(int[] nums){
        //n个元素的数组，原地对他们进行排序
        //使得相同颜色的元素相邻，按照红色、白色、蓝色排列
        //0,1,2
        int oneCount=0;
        int twoCount=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                nums[i-oneCount-twoCount]=0;
            }else if (nums[i]==1){
                oneCount++;
                nums[i-twoCount]=1;
            }else if (nums[i]==2){
                twoCount++;
            }
        }
        for (int i=0;i<twoCount;i++){
            nums[nums.length-1-i]=2;
        }
    }

    public static void main(String[] args) {
        颜色分类75 test = new 颜色分类75();
        int[] nums=new int[]{2,0,2,1,1,0};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
