package 滑动窗口算法.定长窗口;

public class 找到一个数字的k美丽值2269 {
    public static void main(String[] args) {
        int num=430043,k=2;
        Solution2269 solution2269 = new Solution2269();
        System.out.println(solution2269.divisorSubstrings(num, 2));
    }
}
class Solution2269 {
    public int divisorSubstrings(int num, int k) {
        //子字符串长度为k，子字符串可以整除num
        String str=String.valueOf(num);
        char[] array=str.toCharArray();
        int ans=0;
        int count=0;
        for (int i=0;i<str.length();i++){
            //第一步先入窗口
            count=count*10+array[i]-'0';
            if (i<k-1){
                continue;
            }
            //第二步更新答案
            if (count!=0&&num%count==0) ans++;
            //第三步，最左侧的出去
            count=count-(array[i-k+1]-'0')*(int)Math.pow(10,k-1);
        }
        return ans;
    }

}
