package Top100.贪心算法;

import java.util.*;

public class 划分字母区间763 {
    public static void main(String[] args) {
        Solution763 solution763 = new Solution763();
        List<Integer> list = solution763.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println(list.toString());
    }
}
class Solution763{
    public List<Integer> partitionLabels(String s){
        List<Integer> res=new ArrayList<>();
        char[] charArray = s.toCharArray();
        int n=charArray.length;
        Map<Character,Integer> map=new HashMap<>();
        //划分为尽可能多的片段,就是开头以及结尾,
        // 同一个字母第一次出现的下标和最后一次出现的下标必须在同一个片段中。
        int[] last=new int[26];
        //找到该元素的最后一次出现的下标值
        for (int i=0;i<n;i++){
            last[charArray[i]-'a']=i;
        }
        int startIndex=0;
        int endIndex=0;
        for (int i=0;i<n;i++){
            //获取当前元素的最后一次出现的下标
            int lastIndex = last[charArray[i] -'a'];
            endIndex=Math.max(lastIndex,endIndex);
            if (i==endIndex){
                //需要进行分段了
                res.add(endIndex-startIndex+1);
                startIndex=endIndex+1;
            }
        }
        return res;
    }
    //
    public List<Integer> partitionLabels2(String s){
      //相同元素放一段，因此该元素第一次出现和最后一次出现的下标应该在同一段
      //starindex,endIndex).这里的endIndex应该至少大于等于lastIndex
        int n=s.length();
        char[] charArr=s.toCharArray();
        int[] last=new int[26];
        //获取每个元素最后出现的下表
        for (int i=0;i<n;i++){
            last[charArr[i]-'a']=i;
        }
        int start=0,end=0;
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<n;i++){
            end=Math.max(end,last[charArr[i]-'a']);
            if (i==end){
                res.add(end-start+1);
                start=end+1;
            }
        }
        return res;
    }
}
