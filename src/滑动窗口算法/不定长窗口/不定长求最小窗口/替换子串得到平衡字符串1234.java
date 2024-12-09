package 滑动窗口算法.不定长窗口.不定长求最小窗口;

import java.util.HashMap;
import java.util.Map;

public class 替换子串得到平衡字符串1234 {
    public static void main(String[] args) {
        Solution1234 solution1234 = new Solution1234();
        System.out.println(solution1234.balancedString("QQQW"));
    }
}
class Solution1234 {
    public int balancedString(String s) {
      //如果原始s是平衡子串，则直接返回0，否则按照
        //从小到大枚举待替换子串的右边界，然后找最近的左边界
        int[] cnt=new int[26];
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            cnt[ch-'A']++;
        }
        int partial=s.length()/4;
        int res=s.length()+1;
        if (check(cnt,partial)){
            return 0;
        }
        int left=0,right;
        for (right=0;right<s.length();right++){
            char ch=s.charAt(right);
            cnt[ch-'A']--;
            //将其调整为符合的
            while (left<=right&&check(cnt,partial)){
                res=Math.min(res,right-left+1);
                char leftChar=s.charAt(left);
                cnt[leftChar-'A']++;
                left++;
            }
        }
        return res;
    }
    public boolean check(int[] cnt,int partial){
        if (cnt['Q'-'A']>partial||cnt['W'-'A']>partial||cnt['E'-'A']>partial||cnt['R'-'A']>partial){
            return false;
        }
        return true;
    }
}