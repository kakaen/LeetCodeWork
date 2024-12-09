package 每日一题;

public class 交替数组II3208 {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        //连续k个数不相同
        int res=0;
        int n=colors.length;
        int left=0;
//        while (left<n){
//            for (int right)
//        }
        for (int right=0;right<n+k;right++){
            //右边界入
            if (right>0&&colors[right%n]==colors[(right-1)%n]){
                left=right;
            }
            if (left>=n) break;
            if (right-left+1==k){
                res++;
                left++;
            }
        }
        return res;
    }
    //
    public int numberOfAlternatingGroups2(int[] colors,int k){
      //在遍历时维护以右指针为边界的窗口长度
      int cnt=0;
      int n=colors.length;
      int res=0;
      for (int i=0;i<n+k-1;i++) {
          if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
              cnt = 1;
          } else {
              cnt++;
          }
          if (cnt >= k) {
              res++;
          }
      }
      return res;
    }

    public static void main(String[] args) {
        交替数组II3208 test = new 交替数组II3208();
        System.out.println(test.numberOfAlternatingGroups2(new int[]{0, 1, 0, 1, 0}, 3));
        System.out.println(test.numberOfAlternatingGroups2(new int[]{0, 1, 0,0, 1, 0,1}, 6));
        System.out.println(test.numberOfAlternatingGroups2(new int[]{0, 1,  0,1}, 3));
    }
}
