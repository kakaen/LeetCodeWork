package 二分查找提单.二分查找求最小;

import java.util.*;

public class 供暖器475 {
    public static void main(String[] args) {
        Solution475 solution475 = new Solution475();
        int[] houses={1,5};int[] heaters={2};
        System.out.println(solution475.findRadius(houses, heaters));
    }
}
class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        //
        int result = 0;
        int left = 0, right = (int)1e9;

        //将供暖进行排序
        Arrays.sort(heaters);
        Arrays.sort(houses);
        while (left <= right) {
            int mid = left + (right - left) / 2;
            //计算供暖器所能供给到的距离
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            //遍历所有的供暖器，获取所有可覆盖的范围
            //判断所有房屋是否都在供暖器范围内
            if (isTrue(houses, heaters, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    //计算看是否所有的房子都满足供暖
    //找到每个房子的最近的供暖距离
    public boolean isTrue(int[] houses, int[] heaters, int mid) {
        int m=heaters.length;
        for (int i=0,j=0;i<houses.length;i++){
            //从左到右找到第一个heaters[j]的右边界包含有>=该房屋的供暖器
            while (j<m&&(heaters[j]+mid)<houses[i]){
                j++;
            }
            //如果供暖器的右边界大于house，则判断左边界是否包含包含，包含的话则说明该房屋满足供暖
            if (j<m && heaters[j]-mid<=houses[i]){
                continue;
            }
            return false;
        }
        return true;
    }
}
