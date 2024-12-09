package 每日一题;

import java.util.ArrayList;
import java.util.List;

public class 统计满足K约束的子字符串的数量I3258 {
    public static void main(String[] args) {
        统计满足K约束的子字符串的数量I3258 test = new 统计满足K约束的子字符串的数量I3258();
        System.out.println(test.countKConstraintSubstrings("10101", 1));
        System.out.println(test.countKConstraintSubstrings("11111", 1));
        System.out.println(test.countKConstraintSubstrings("1010101", 2));
    }
    public int countKConstraintSubstrings(String s,int k){
        //字符串的长度最多为2*K,k的长度小于等于s长度
        //只要满足0的数量小于等于k，或1的数量小于等于k即可。
        int len=s.length();
        int count=0;
        char[] charArray = s.toCharArray();
        //检索每个下标，找到满足k约束的最短子串，然后进行长度递增
        for (int i=0;i<len;i++){
            //每个i作为滑动窗口的左指针
            int zeroCount=0;
            int oneCount=0;
            for (int right=i;right<len;right++){
                if (charArray[right]-'0'==0) zeroCount++;
                if (charArray[right]-'0'==1) oneCount++;
                if (zeroCount<=k||oneCount<=k) count++;
            }
        }
        return count;
    }
    //滑动窗口+前缀数组
    public int countKConstraintSubstrings2(String s,int k){
        //计算以0,1,2..n-1为右端点的合法子串的个数
        char[] chars=s.toCharArray();
        int ans=0;
        int left=0;
        int[] cnt=new int[2]; //记录子串中0和1的总个数
        //表示以i为结尾的子串
        for (int i=0;i<s.length();i++){
            cnt[chars[i]&1]++;
            while (cnt[0]>k&&cnt[1]>k){
                cnt[chars[left]&1]--;
                left++;
            }
            //
            ans+=i-left+1;
        }
        return ans;
    }

}
