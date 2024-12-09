package 二分查找提单.二分查找求最小;

import com.sun.imageio.plugins.bmp.BMPImageReader;

import java.lang.reflect.Array;

public class 在D天内送达包裹的能力1011 {
    public static void main(String[] args) {
        Solution1011 solution1011 = new Solution1011();
        //int[] weights={1,2,3,4,5,6,7,8,9,10};
        int[] weights={3,2,2,4,1,4};
        int days=3;
        System.out.println(solution1011.shipWithinDays(weights, days));
    }
}

class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int result=0;
        //target =days;必须小于等于target
        //返回能在day天内最低运载数
        int left=0, right=0; //left=货物中的最大值最大运载能力
        for (int weight:weights){
            //找运载能力的左边界值
            if (weight>left) left=weight;
            //找运载能力的右边界值
            right+=weight;
        }
        System.out.println("left="+left+",right="+right);
        while (left<=right){
            int mid=left+(right-left)/2;
            //计算总耗时天数
            int total=1;
            int capacity=mid;
            for (int weight:weights){
                if (capacity<weight){
                    total++;
                    capacity=mid;
                }
                capacity-=weight;
            }
            System.out.println("mid="+mid+",total="+total);
            if (total<=days){
                result=mid  ;
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return result;
    }
}