package 每日一题;

import java.util.HashMap;
import java.util.Map;

public class 每种字符至少取K个2516 {
    public static void main(String[] args) {
        Solution2516 solution2516 = new Solution2516();
        System.out.println(solution2516.takeCharacters("a", 1));
    }
}
class Solution2516{
    public int takeCharacters(String s,int k){
        //使用滑动窗口进行解答，外面剩余至少k个a，b,c
        int[] totalCount=new int[3];
        Map<Character,Integer> map=new HashMap<>();
        char[] array=s.toCharArray();
        for (char c : array) {
            totalCount[c-'a']++;
        }
        //
        for (int num:totalCount){
            if (num<k) return -1;
        }

        //获取到a，b，c的总数，因此寻找滑动窗口的最大值，使得
        int left=0,right=0;
        int[] count=new int[]{0,0,0};
        int maxLength=0; //找到最长的滑动窗口
        for (right=0;right<array.length;right++){
            //右边界入窗口
            count[array[right]-'a']++;
            //如果窗口不满足，则左边界出
            while ((totalCount[0]-count[0])<k||(totalCount[1]-count[1])<k||(totalCount[2]-count[2])<k){
                count[array[left]-'a']--;
                left++;
            }
            maxLength=Math.max(maxLength,right-left+1);

        }
        return array.length-maxLength;
    }
}
