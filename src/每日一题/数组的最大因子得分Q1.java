package 每日一题;

import sun.security.mscapi.CPublicKey;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

public class 数组的最大因子得分Q1 {
    public static void main(String[] args) {

    }
    public static long maxScore(int[] nums){
        //数组所有元素的最小公倍数，和最大公约数
        //最多移除一个元素的情况下，
        //最小公倍数一定是移除有倍数的最小的
        Arrays.sort(nums);
        //最大公约数，是互不成倍数的想乘
        long lcm=1; //最小公倍数
        return 0;
    }
}
