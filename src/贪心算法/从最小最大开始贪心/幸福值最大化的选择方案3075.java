package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;
import java.util.Scanner;

public class 幸福值最大化的选择方案3075 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=scanner.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=scanner.nextInt();
        }
        int k= scanner.nextInt();
        Solution3075 solution3075 = new Solution3075();
        System.out.println(solution3075.maximumHappinessSum(arr, k));
    }
}
class Solution3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        //
        long result=0;
        //从大到小排序
        Arrays.sort(happiness);
        //从大到小排序
        int num=0;//选择第几个孩子
        for (int i=happiness.length-1;i>=0;i--){
            int count=Math.max(happiness[i]-num,0);
            result+=count;
            num++;
            if (num==k) break;
        }
        return result;
        //如果有幸福值不为0的孩子则优先选择，遍历数组，找元素大于k的数
    }
}
