package Top100;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import sun.nio.cs.ext.MacHebrew;

import java.util.Scanner;

public class 盛最多水的容器11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] height=new int[n];
        for (int i=0;i<n;i++){
            height[i]=scanner.nextInt();
        }
        Solution11 solution11 = new Solution11();
        System.out.println(solution11.maxArea(height));
    }
}
class Solution11 {
    public int maxArea(int[] height) {
        int left=0,right=height.length;
        int maxArea=0;
        while (left<right){
            if (height[left]<height[right]){
                maxArea=Math.max((right-left)*height[left],maxArea);
                left++;
            }else {
                maxArea= Math.max((right-left)*height[right],maxArea);
                right++;
            }
        }
        return maxArea;
    }
}
