package Top100二刷.二分查找.二分法求最大值;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 可移除字符的最大数目1898 {
    public static void main(String[] args) {
        可移除字符的最大数目1898 test = new 可移除字符的最大数目1898();
        System.out.println(test.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
        System.out.println(test.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(test.maximumRemovals("abcab", "abc", new int[]{0,1,2,3,4}));
    }
    public int maximumRemovals(String s,String p,int[] remove){
        //这个k一定是单掉的,我可以移除k成功，则k-1一定成功
        int n1=p.length(); //p子序列的长度
        int n2=s.length(); //s的长度
        int[] p1=new int[n1]; //将p1表示为数组
        int[] s1=new int[n2]; //为了后续进行比较
        //由于p是s的子串因此 k最大为 n2-n1，但是我们是从remove中挑选因此取两者最小值
        int l=0,r=Math.min(n2-n1,remove.length);
        while (l<=r){
            int m=l+(r-l)/2;
            if(check(s,p,remove,m)){
                l=m+1;
            }else{
                r=m-1;
            }
        }
        return r;
    }
    public boolean check(String s,String p,int[] remove,int k){
        //从remove中选择前k个下标。从p中移除该k个下标判断当前s是否满足
        //判断p是否为s中的子序列，使用双指针方法来实现。
        int i=0;
        int j=0;
        Set set=new HashSet();
        for (int a=0;a<k;a++){
            set.add(remove[a]);
        }
        while (i<s.length()&&j<p.length()){
            while (i<s.length()&&set.contains(i)){
                i++;
            }
            if (s.charAt(i)==p.charAt(j)){
                j++;
            }
            i++;
        }

        return j==p.length();
    }
}
