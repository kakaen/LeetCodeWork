package 贪心算法.从最小最大开始贪心;

import java.util.Arrays;

public class 摧毁小行星2126 {
    public static void main(String[] args) {

    }
}
class Solution2126 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // 把小行星的质量从小到大进行排序
        Arrays.sort(asteroids);
        for (int num:asteroids){
            if (mass<num){
                return false;
            }else{
                mass+=num;
            }
        }
        return true;
    }
}
