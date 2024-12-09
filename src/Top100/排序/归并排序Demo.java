package Top100.排序;

import java.util.Arrays;

public class 归并排序Demo {
    public static void main(String[] args) {
        int[] nums=new int[]{9,5,2,6,1,7,8};
        归并排序Demo test = new 归并排序Demo();
        int[] ints = test.MergeSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(ints));
    }
    public int[] MergeSort(int[] nums,int l,int h){
        //分，治
        if (l==h){
            return new int[]{nums[l]};
        }
        int mid=l+(h-l)/2;
        int[] leftArr=MergeSort(nums,l,mid);
        int[] rightArr=MergeSort(nums,mid+1,h);
        int[] newNum=new int[leftArr.length+rightArr.length];
        //合并两个有序数组
        int m=0,i=0,j=0;
        //归并两个有序数组
        while (i<leftArr.length&&j<rightArr.length){
            newNum[m++]=leftArr[i]<rightArr[j]?leftArr[i++]:rightArr[j++];

        }
        while (i<leftArr.length){
            newNum[m++]=leftArr[i++];
        }
        while (j<rightArr.length){
            newNum[m++]=rightArr[j++];
        }
        return newNum;
    }
    //递归实现归并排序的算法
    public void mergeSortFunc(int[] array,int left,int right){
        if (left==right) return;
        int mid=left+(right-left)/2;
        //递归合并左数组
        mergeSortFunc(array,left,mid);
        mergeSortFunc(array,mid+1,right);

    }
    //合并的方法
}
