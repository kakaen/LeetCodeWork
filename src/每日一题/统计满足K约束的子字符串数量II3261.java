package 每日一题;

import java.util.Arrays;

public class 统计满足K约束的子字符串数量II3261 {
    public static void main(String[] args) {
        统计满足K约束的子字符串数量II3261 test = new 统计满足K约束的子字符串数量II3261();
        int[][] queries=new int[][]{{0,6}};
        int[][] queries2=new int[][]{{0,5},{1,4},{2,3}};

        long[] longs = test.countKConstraintSubstrings("0001111", 2, queries);
        long[] longs2 = test.countKConstraintSubstrings("010101", 1, queries2);
        System.out.println(Arrays.toString(longs));
        System.out.println(Arrays.toString(longs2));
    }
    public long[] countKConstraintSubstrings(String s,int k,int[][] queries){
        int n=queries.length;
        long[] res=new long[n];
        char[] chars=s.toCharArray();
        int x=0;
        int[][] maxSub=getK(chars,k);
        for (int[] querie:queries){
            int i=querie[0];
            int j=querie[1];
            int mini=maxSub[j][0]; //这是以j为结尾的最小左下标
            int total=0;
            while (i<mini){
                j=mini-1; //求出前面的
                if (j<0) break;
                mini=maxSub[j][0];
                total+=j-mini+1; //计算(mini,j)的总数
            }
            total+=j-mini+1;
            res[x++]=total;

        }
        return res;
    }

    public int[][] getK(char[] chars,int k){
        int i=0;
        int n=chars.length;
        int[] cnt=new int[2];
        int[][] count=new int[n][2]; //表示以j结尾的可以的最大子串

        for (int j=0;j<n;j++){
            cnt[chars[j]-'0']++;
            while (cnt[0]>k&&cnt[1]>k){
                cnt[chars[i]-'0']--;
                i++;
            }
            //这里可以计算出所有以j为结尾的最左侧的最大值(i,j)左侧是可以满足的最小值
            count[j][0]=i;count[j][1]=j;
        }
        return count;
    }
}
