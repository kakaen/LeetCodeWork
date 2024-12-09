package Top100;

import java.util.Arrays;
import java.util.Scanner;

public class 轮转数组189 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k=scanner.nextInt();
        int[]nums=new int[n];
        for (int i=0;i<n;i++){
            nums[i]= scanner.nextInt();
        }
        Solution189 solution189 = new Solution189();
        solution189.rotate2(nums,k);
    }
}
class Solution189{
    //使用o1的方式进行
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        int i=0;//准备移动的元素的下标
        int temp1=nums[0];
        int temp2=0;
        //temp保存要替换的位置的元素
        while (count!=n){
            //计算要替换的元素的位置
            int j=(i+k)%n;
            temp2=nums[j]; //保存被替换位置的元素
            nums[j]=temp1; //然后将替换位置的元素放在被替换位置上
            temp1=temp2;//将代替换元素修改为temp2
            i=j;
            count++;

        }
        System.out.println(Arrays.toString(nums));
    }
    public void rotate2(int[] nums,int k){
        int n=nums.length;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);

    }
    public void reverse(int[] nums,int start,int end){
        while (start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}