package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 找到稳定山的下标3285 {
    public List<Integer> stableMountains(int[] height,int threshold){
        List<Integer> res=new ArrayList<>();
        for (int i=1;i<height.length;i++){
            if (height[i-1]>threshold) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        找到稳定山的下标3285 test = new 找到稳定山的下标3285();
        System.out.println(test.stableMountains(new int[]{1, 2, 3, 4, 5}, 2));
    }
}
