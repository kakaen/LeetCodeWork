package 贪心算法.从最小最大开始贪心;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 重排数组以得到最大前缀分数2587 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        Solution2587 solution2587 = new Solution2587();
        System.out.println(solution2587.maxScore(arr));
    }
}
class Solution2587 {
    public int maxScore(int[] nums) {
        //最大分数，因此将nums从大到小排序
        Arrays.sort(nums); //将数组进行排序
        ArrayList<Integer> list = new ArrayList<>();
        long total=0;
        int count=0;
        for (int i=nums.length-1;i>=0;i--){
            total+=nums[i];
            if (total>0){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
