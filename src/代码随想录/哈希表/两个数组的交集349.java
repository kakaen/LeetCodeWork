package 代码随想录.哈希表;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 两个数组的交集349 {
    public static void main(String[] args) {

    }
}
class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] hash=new int[1000];
        List<Integer> list=new ArrayList<>();
        for (int num:nums1){
            hash[num]=1;
        }
        for (int num:nums2){
            if (hash[num]==1){
                list.add(num);
            }
        }
        return list.stream().mapToInt(x->x).toArray();
    }
}
