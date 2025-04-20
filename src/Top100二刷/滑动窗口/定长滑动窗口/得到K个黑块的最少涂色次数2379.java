package Top100二刷.滑动窗口.定长滑动窗口;

public class 得到K个黑块的最少涂色次数2379 {
    public static void main(String[] args) {
        得到K个黑块的最少涂色次数2379 test = new 得到K个黑块的最少涂色次数2379();
        System.out.println(test.minimumRecolors("WBBWWBBWBW", 7));
    }
    public int minimumRecolors(String blocks, int k) {
        int ans=Integer.MAX_VALUE;
        char[] chars = blocks.toCharArray();
        int wCount=0;
        int bCount=0;
        int l=0;
        for (int r=0;r<chars.length;r++){
            if (chars[r]=='W'){
                wCount++;
            }else {
                bCount++;
            }
            if (r<k-1) continue;
            //2.更新
            ans=Math.min(wCount,ans);
            if (chars[l]=='W'){
                wCount--;
            }else{
                bCount--;
            }
            l++;

        }
        return ans;
    }
}
