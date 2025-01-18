package 每日一题;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 字符串及其反转中是否存在同一字符串3083 {
    public static void main(String[] args) {
        字符串及其反转中是否存在同一字符串3083 test = new 字符串及其反转中是否存在同一字符串3083();
        System.out.println(test.isSubstringPresent("abcdba"));
        System.out.println(test.isSubstringPresent("abccdf"));
        System.out.println(test.isSubstringPresent("abcdef"));
    }
    public boolean isSubstringPresent(String s) {
        //遍历所有的长度为2的子串，加入到map中
        int n=s.length();
        int j;
        Set<String> set=new HashSet<>(); //存放反转的
        for (int i=0;i<n-1;i++){
           j=i+1;
           if (s.charAt(i)==s.charAt(j)) return true;
           String subS = s.substring(i, j + 1);
           String reversS=""+s.charAt(j)+s.charAt(i);
           if (set.contains(subS)) return true;
           set.add(reversS);
        }
        return false;
    }
}
