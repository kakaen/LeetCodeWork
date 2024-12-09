package 每日一题;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class 找到连续赢K场比赛的第一位玩家3175 {
    public static void main(String[] args) {
        找到连续赢K场比赛的第一位玩家3175 test = new 找到连续赢K场比赛的第一位玩家3175();
        int[] skills=new int[]{4,2,6,3,9};
        int[] skills2=new int[]{2,5,4};
        System.out.println(test.findWiningPlayer(skills, 2));
        System.out.println(test.findWiningPlayer(skills2, 3));
    }
    public int findWiningPlayer(int[] skills,int k){
        int n=skills.length;
        Map<Integer,Integer> map=new HashMap<>();
        //队列中存储玩家的编号
        Deque<Integer> deque=new LinkedList<>();
        int max=0;
        for (int i=0;i<n;i++){
            if (max<skills[i]) max=i;
            max=Math.max(max,skills[i]);
            map.put(i,skills[i]);
            deque.offerLast(i);
        }
        if (k>=n) return max;
        int count=0;
        while (count<k){
            int fN=deque.pollFirst();
            int sN=deque.pollFirst();
            if (map.get(fN)>map.get(sN)){
                count++;
                deque.offerFirst(fN);
                deque.offerLast(sN);
            }else{
                count=1;
                deque.offerFirst(sN);
                deque.offerLast(fN);
            }
        }
        return deque.peekFirst();
    }
    //使用双指针的方法来实现
    public int findWiningPlayer2(int[] skills,int k){
        //如果前面一直没有人win
        //从前到后去遍历i，判断能否连续win k次
        int n=skills.length;
        int cnt=0;
        int i=0,last_i=0;
        //i来循环
        while (i<n){
            int j=i+1;
            while (j<n&&skills[j]<skills[i]&&cnt<k){
                j++;
                cnt++;
            }
            if (cnt==k){
                return i;
            }
            cnt=1;
            last_i=i;
            i=j;
        }
        return last_i;
    }
}
