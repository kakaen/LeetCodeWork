package 贪心算法;

import java.util.Arrays;

public class 分发饼干455 {
    public static void main(String[] args) {

    }
}
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        //大尺寸饼干应该先满足大胃口的孩子
        //将孩子胃口和饼干尺寸进行排序
        int count=0;
        Arrays.sort(g);
        Arrays.sort(s);

        //从胃口小的孩子先满足
        int start=0;
        for (int i=0;i<s.length&&start<g.length;i++){
            if (s[i]>=g[start]){
                count++;
                start++;
            }
        }


        return count;
    }
    //g数组为孩子的胃口，s数组为饼干的尺寸大小
    public int findContentChildren2(int[] g, int[] s) {
        int count=0;
        int start=0;
        //排序g和s
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i=0;i<s.length;i++){
            if (s[i]>=g[start]){
                count++;
                start++;
            }
        }
        return count;
    }
}