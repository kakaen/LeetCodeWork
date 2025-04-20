package Top100二刷.子数组;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最小覆盖子串76 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.next();
        String t=scanner.next();
        System.out.println(minWindow(s, t));
    }
    public static String minWindow(String s,String t){
        //返回S中覆盖T所有字符的最小子串
        Map<Character,Integer> map=new HashMap<>();
        //将T中的所有字符统计出来
        for (char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        Map<Character,Integer> sMap=new HashMap<>();
        int n=s.length();
        int left=0,right=0;
        int ansLeft=-1,ansRight=n;
        //右边界进行扩展
        for (right=0;right<n;right++){
            //将右边界入窗口
            char chRight=s.charAt(right);
            sMap.put(chRight,sMap.getOrDefault(chRight,0)+1);
            //判断当前窗口是否覆盖住t的所有字符，如果覆盖进行缩减左边界并确保任然滿足條件
            while (check(sMap,map)){ //如果覆盖的 话
                //记录符合的答案
                if (right-left<ansRight-ansLeft){
                    ansLeft=left;
                    ansRight=right;
                }
                //尝试缩减左边界。left指针指向的字母移除子串。
                char chLeft=s.charAt(left);
                if (sMap.get(chLeft)==1){
                    sMap.remove(chLeft);
                }else{
                    sMap.put(chLeft,sMap.get(chLeft)-1);
                }
                left++;
            }

        }
        //判斷是否存在覆蓋子串
        return ansLeft<0?"":s.substring(ansLeft,ansRight+1);
    }
    public static boolean check(Map<Character,Integer> sMap,Map<Character,Integer> tMap){
        for (Map.Entry<Character,Integer> entry: tMap.entrySet()){
            if (entry.getValue()>sMap.getOrDefault(entry.getKey(),0)){
                return false;
            }
        }
        return true;
    }
}
