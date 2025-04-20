package 回溯算法.回溯算法二刷;

import java.util.List;

public class 求一个整数的惩罚数2698 {
    public static void main(String[] args) {
        求一个整数的惩罚数2698 test = new 求一个整数的惩罚数2698();
        System.out.println(test.punishmentNumber(10));
    }
    public int punishmentNumber(int n){
        int  ans=0;
        for (int i=1;i<=n;i++){
            String str=String.valueOf(i*i);
            if (isPunishmentNumber(str,0,0,i)){
                ans+=i*i;
            }
        }
        return ans;
    }
    public boolean isPunishmentNumber(String str,int pos,int tot,int target){
        if (pos==str.length()){
            return tot==target;
        }
        int sum=0;
        //枚举出从pos到i的所有子串
        for (int i=pos;i< str.length();i++){
            sum+=sum*10+ str.charAt(i)-'0';
            if (sum>target) break;
            //继续往下递归
            if (isPunishmentNumber(str,i+1,sum+tot,target)){
                return true;
            }
        }
        return false;
    }


}
