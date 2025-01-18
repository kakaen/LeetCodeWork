package Top100二刷.二分查找.二分法求最大值;

import java.util.*;

public class 找出出现至少三次的最长特殊子字符串II2982 {
    public static void main(String[] args) {
        找出出现至少三次的最长特殊子字符串II2982 test = new 找出出现至少三次的最长特殊子字符串II2982();
        System.out.println(test.maximumLength("aaaa"));
        System.out.println(test.maximumLength("abcdef"));
        System.out.println(test.maximumLength("abcaba"));
    }
    public int maximumLength(String s){
       char[] chars=s.toCharArray();
       List<Integer>[] groups=new ArrayList[26]; //字母作为下标，统计以字母i的连续子串的长度
        //初始化
        for (int i=0;i<26;i++){
            groups[i]=new ArrayList<>();
        }
        //遍历字符串
        int cnt=0;
        for (int i=0;i<chars.length;i++){
            cnt++;
            if (i+1==s.length()||chars[i]!=chars[i+1]){
                groups[chars[i]-'a'].add(cnt);
                cnt=0;
            }
        }
        int ans=0;
        //现在我们知道所有字母相同分组所拥有的子串长度了
        for (List<Integer> list:groups){
            if (list.isEmpty()) continue;
            //将其从大到小进行排序
            list.sort(Collections.reverseOrder());
            //我们可以假装有两个长度为0的子串
            list.add(0);
            list.add(0);
            //a[0],a[1],a[2]. 可能的长度
            // a[0]-2的长度，只从a[0]中选取，
            // a[0]==a[1],a[0]-1选取两个，a[1]-1选取一个
            //a[0]>a[1],从a[0]中选取两个a[1],从a[1]中选取一个a[1]。可以总结为min(a[0]-1,a[1])
            //从a[0],a[1],a[2]中各取一个
            ans=Math.max(ans,Math.max(list.get(0)-2,Math.max(Math.min(list.get(0)-1,list.get(1)),list.get(2))));
        }
        return ans==0?-1:ans;
    }
    //判断是否存在至少3次
    public boolean check(int m,String s){
        Map<String,Integer> map=new HashMap<>();
       int count=0;
        for (int i=0;i<=s.length()-m;i++){
            String subStr=s.substring(i,i+m);
            if (isSpecial(subStr)){
                map.put(subStr,map.getOrDefault(subStr,0)+1);
                count=Math.max(count,map.get(subStr));
                if (count>=3) return true;
            }
        }

        return count>=3;
    }
    public boolean isSpecial(String str){
        for (int i=0;i<str.length()-1;i++){
            if (str.charAt(i)!=str.charAt(i+1)) return false;
        }
        return true;
    }
}
