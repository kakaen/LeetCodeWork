package Top100;

import java.util.ArrayList;
import java.util.List;

public class 汇总区间228 {
    public static void main(String[] args) {
        汇总区间228 test = new 汇总区间228();
        System.out.println(test.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(test.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
    }
    public List<String> summaryRanges(int[] nums){
        //数组有序
        int n=nums.length;
        List<String> res=new ArrayList<>();
        if (n==0) return res;
        int start=nums[0];//初始的数字
        int end=nums[0];
        for (int i=1;i<n;i++){
            if (nums[i]==end||nums[i]==end+1){
                end=nums[i];
            }else { //nums[i]不等于end了
                if (start!=end){
                    String str=String.valueOf(start)
                            +"->"
                            +String.valueOf(end);
                    res.add(str);
                    start=nums[i];
                }else{
                    res.add(String.valueOf(start));
                }
                start=nums[i];
                end=start;
            }

        }
        if (start!=end){
            String str=String.valueOf(start)
                    +"->"
                    +String.valueOf(end);
            res.add(str);
        }else{
            res.add(String.valueOf(start));
        }
        return res;
    }
    public List<String> summaryRanges2(int[] nums){
        List<String> res=new ArrayList<>();
        int n=nums.length;
        return res;
    }
}
