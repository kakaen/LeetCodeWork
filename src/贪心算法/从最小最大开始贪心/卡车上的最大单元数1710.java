package 贪心算法.从最小最大开始贪心;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class 卡车上的最大单元数1710 {
    public static void main(String[] args) {

    }
}
class Solution1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        //bo
        //按装载单元的数量进行排序
        List<int[]> list=new ArrayList<>();
        for (int[] box : boxTypes) {
            list.add(box);
        }
        //将list按照单元数降序排列
        Collections.sort(list,((o1, o2) -> o2[1]-o1[1]));
        int totalCell=0;
        for (int[] ints : list) {
            int min = Math.min(ints[0], truckSize);
            totalCell+=min*ints[1];
            truckSize-=min;
            if (truckSize==0) break;
        }
        return totalCell;
    }
}