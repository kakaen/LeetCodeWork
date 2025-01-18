package 每日一题;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.IntStream;

public class K次乘运算后的最终数组I3264 {
    public static void main(String[] args) {
        K次乘运算后的最终数组I3264 test = new K次乘运算后的最终数组I3264();
        int[] finalState = test.getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2);
        System.out.println(Arrays.toString(finalState));
        System.out.println(Arrays.toString(test.getFinalState(new int[]{1,2},3,4)));
        System.out.println(Arrays.toString(test.getFinalState(new int[]{4,16,64},10,4)));
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Pair<Integer,Integer>> queue=new PriorityQueue<>((p1,p2)->{
            if (p1.getKey().equals(p2.getKey())) return p1.getValue()-p2.getValue();
            return p1.getKey()-p2.getKey();
        });
        for (int i=0;i<nums.length;i++){
            queue.add(new Pair<>(nums[i],i));
        }
        for (int i=0;i<k;i++){
            Pair<Integer, Integer> pair = queue.poll();
            nums[pair.getValue()]*=multiplier;
            queue.add(new Pair<>(nums[pair.getValue()],pair.getValue()));
        }
        return nums;
    }
}
