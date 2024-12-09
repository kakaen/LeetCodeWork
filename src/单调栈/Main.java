package 单调栈;

import java.util.Scanner;



public class Main {

    public static int maxAdjacentProduct(int n, int[] arr) {
        // 计算初始的最大相邻乘积
        int initialMaxValue = Integer.MIN_VALUE;
        int index=0;
        for (int i = 0; i < n - 1; i++) {
            if (initialMaxValue<arr[i]*arr[i+1]){
                index=i;
                initialMaxValue=arr[i] * arr[i + 1]; //得到最大下标
            }
        }
        // 最大的可能值
        int maxPossibleValue = initialMaxValue;
        int swapMax=0;
        for (int i=0;i<n;i++){

            if (i!=index&&i!=(index+1)){
                if (arr[index]<arr[index+1]){
                    //交换走i下标的值
                    swapMax=Math.max(swapMax,arr[i]*arr[index+1]);
                }else {
                    swapMax=Math.max(swapMax,arr[i]*arr[index]);
                }
            }
        }

        // 尝试交换每对相邻元素并计算新的最大相邻乘积
        int second=0;
        for (int i = 0; i < n - 1; i++) {
            // 交换 arr[i] 和 arr[i + 1]
            swap(arr, i, i + 1);

            // 计算受影响的乘积
            int affectedValue = Integer.MIN_VALUE;
            if (i > 0) {
                affectedValue = Math.max(affectedValue, arr[i - 1] * arr[i]);
            }
            affectedValue = Math.max(affectedValue, arr[i] * arr[i + 1]);
            if (i + 1 < n - 1) {
                affectedValue = Math.max(affectedValue, arr[i + 1] * arr[i + 2]);
            }
            //

            // 更新最大可能值
            maxPossibleValue = Math.max(maxPossibleValue, affectedValue);
            //更新交换后的最大可能值
            second=Math.max(second,affectedValue);

            // 交换回来
            swap(arr, i, i + 1);
        }

        return second;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int result = maxAdjacentProduct(n, arr);
        System.out.println(result);

        scanner.close();
    }
}

