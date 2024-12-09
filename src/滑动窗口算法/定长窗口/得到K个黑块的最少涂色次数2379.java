package 滑动窗口算法.定长窗口;

public class 得到K个黑块的最少涂色次数2379 {
    public static void main(String[] args) {
        Solution2379 solution2379 = new Solution2379();
        System.out.println(solution2379.minimumRecolors("WBBWWBBWBW", 7));
    }
}
class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        //，连续k个白色
        int n=blocks.length();
        int count=n;
        int wirteCount=0;
        char[] arr=blocks.toCharArray();
        for (int i=0;i<n;i++){
            //1.入的部分
            if (arr[i]=='W') wirteCount++;
            if (i<k-1){
                continue;
            }
            //2，更新部分
            count=Math.min(count,wirteCount);
            //3，出的部分
            if (arr[i-k+1]=='W'){
                wirteCount--;
            }

        }
        return count;
    }
}
