package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;

public class 雪糕的最大数量1833 {
    public static void main(String[] args) {

    }
}
class Solution1833 {
    public int maxIceCream(int[] costs, int coins) {
        //最大数量的雪糕
        //题目要求是计数排序
        int max=0;
        for (int num:costs){
            if (max<num) max=num;
        }
        //创建计数数组
        int[] countArr=new int[max+1];
        //进行计数排序
        for (int num:costs){
            countArr[num]++;
        }
        int count=0;
        //循环计数数组
        for (int i=0;i<max+1;i++){
            if (coins<i){
                break;
            } else if (coins>=i&&coins<i*countArr[i]) {
                int num=coins/i;
                count+=num;
                coins-=i*num;
            }else {
                coins-=i*countArr[i];
                count+=countArr[i];
            }
        }
        return count;
    }
}
