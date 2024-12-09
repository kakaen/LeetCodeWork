package 代码随想录.哈希表;

public class 有效的字母异位词242 {
}
class Solution242 {
    public boolean isAnagram(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if (n1!=n2) return false;
        int[] count=new int[26]; //存放元素
        for (int i=0,j=0;i<n1;i++,j++){
            count[s.charAt(i)-'a']++;
            count[t.charAt(j)-'a']--;
        }
        //遍历元素
        for (int num : count) {
            if (num!=0) return false;
        }
        return true;
    }
}