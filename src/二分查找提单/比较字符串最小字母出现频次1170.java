package 二分查找提单;

import java.util.Arrays;

public class 比较字符串最小字母出现频次1170 {
    public static void main(String[] args) {
        Solution1170 solution1170 = new Solution1170();
        System.out.println(solution1170.getMinCount("cccbdsaa"));
    }
}
class Solution1170 {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        //queries待查表
        int n=queries.length;
        int m=words.length;
        int[] answer=new int[n]; //存放结果
        int[] counts=new int[m]; //存放words的每个字符串的最小字母的出现次数

        for (int i = 0; i < m; i++) {
            counts[i]=getMinCount(words[i]);
        }
        //把worlds的count数组进行排序
        Arrays.sort(counts);
        for (int i=0;i<n;i++){
            //作为target，去查询 world数组
            int countTarget=getMinCount(queries[i]);
            int index = binarySearch(counts, countTarget);
            answer[i]=m-index;
        }

        return answer;
    }

    public int binarySearch(int[] nums,int target){
        int left=0,right=nums.length-1;
        while (left<=right){
            int mid=left+(right-left)/2;
            //找nums[index]>target,既找第一个大于target的下标值
            if (nums[mid]<=target){
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return left;
    }
    //统计字典序最小字母出现的频次,就是题目中的F函数
    public int getMinCount(String string){
        //将字符串转为
        int count=1;
        char minCH=string.charAt(0);
        if (string.length()<=1) return count;
        for (int i=1;i<string.length();i++){
            char newChar=string.charAt(i);
            if (newChar<minCH){
                count=1;
                minCH=newChar;
            } else if (newChar==minCH) {
                count++;
            }
        }
        return count;
    }
}