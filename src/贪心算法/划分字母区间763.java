package 贪心算法;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 划分字母区间763 {
    public static void main(String[] args) {
        Solution763 solution763 = new Solution763();
        List<Integer> ababcbacadefegdehijhklij = solution763.partitionLabels("ababcbacadefegdehijhklij");
        ababcbacadefegdehijhklij.forEach(System.out::println);
    }
}
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        char[] charArray = s.toCharArray();
        //保存每个字符出现的最后位置
        HashMap<Character, Integer> cMap = new HashMap<>();
        for (int i=0;i<charArray.length;i++){
            //存放最远的位置
            cMap.put(charArray[i],i);
        }
        //再遍历字符串，获取最远位置，如果最远位置和当前下标一样（就说明后面没有该元素了）
        int max=0;
        int index=0; //上一次分割的下标
        for (int i=0;i<charArray.length;i++){
            max=Math.max(cMap.get(charArray[i]),max); //获取最大边界
            if (max==i){

                result.add(max-index+1);
                index=max+1;
            }
        }
        return result;
    }
}
