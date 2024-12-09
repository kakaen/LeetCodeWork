package 难度训练;

public class 最佳观光组合1014 {
    public static void main(String[] args) {
        Solution1014 solution1014 = new Solution1014();
        System.out.println(solution1014.maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6}));
    }
}
class Solution1014{
    public int maxScoreSightseeingPair(int[] values){
        //距离最,选取values[i]-i;的最大数，但是第一个不需要最大啊,距离最小，且和最大
        int n=values.length;
        int vj=Integer.MIN_VALUE;
        //values[i]+i  +values[j]-j// 这部分不会变，因此只需要维护前面的
        int max=values[0]+0;
        int total=Integer.MIN_VALUE;
        for (int j=1;j<n;j++){
            vj=values[j]-j;
            total=Math.max(total,max+vj);
            max=Math.max(max,values[j]+j);
        }
       return total;
    }
    public int maxScoreSightseeingPair2(int[] values){
        int n=values.length;
        int res=Integer.MIN_VALUE;
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                res=Math.max(res,values[i]+values[j]+i-j);
            }
        }
        return res;
    }
}
