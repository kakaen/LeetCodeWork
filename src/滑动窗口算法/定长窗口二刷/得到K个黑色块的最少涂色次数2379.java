package 滑动窗口算法.定长窗口二刷;

public class 得到K个黑色块的最少涂色次数2379 {
    public static void main(String[] args) {

    }
}
class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int left=0,right=0;
        int result=k+1;
        int count=0;
        char[] arr=blocks.toCharArray();
        for (right=0;right<blocks.length();right++){
            if (arr[right]=='W') count++;
            if (right<k-1) continue;
            result=Math.min(count,result);
            if (arr[left]=='W'){
                count--;
            }
            left++;
        }
        return result;
    }
}
