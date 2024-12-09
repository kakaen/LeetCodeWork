package ACM模式练习;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long a=scanner.nextLong();
        long b=scanner.nextLong();
        long c=scanner.nextLong();
        long k=scanner.nextLong();
        System.out.println(function(a, b, c, k));
    }
    public static long function(long a,long b,long c,long k){
        long MOD=1000000007;

        // 对 a, b, c 排序，使得 a <= b <= c
        long[] arr = {a, b, c};
        Arrays.sort(arr);

        // 将操作次数分配给最小的两个数
        while (k > 0) {
           if (a<b&&a<c){
               long minDif=Math.min(b-a,c-a);
               if (k>=minDif) a+=minDif;
           }
        }

        // 计算最终的乘积并对 10^9 + 7 取模
        long result = (arr[0] * arr[1] % MOD) * arr[2] % MOD;
        return result;
    }
}
