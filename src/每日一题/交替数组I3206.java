package 每日一题;

public class 交替数组I3206 {
    public int numberOfAlternatingGroups(int[] colors){
        int res=0;
        int n=colors.length;
        for (int i=0;i<n;i++){
            if (colors[i]==colors[(i+1)%n]){
                continue;
            } else{
                if (colors[(i+1)%n]!=colors[(i+2)%n]){
                    res++;
                }
            }
        }
      return res;
    }
    public int numberOfAlternatingGroups2(int[] colors){
        int n=colors.length;
        int cnt=0;
        int res=0;
        for (int i=0;i<n+2;i++){
            if (i>0&&colors[i%n]==colors[(i-1)%n]){
                cnt=1;
            }else{
                cnt++;
            }
            if (cnt>=3){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        交替数组I3206 test = new 交替数组I3206();
        System.out.println(test.numberOfAlternatingGroups2(new int[]{1, 1, 1}));
        System.out.println(test.numberOfAlternatingGroups2(new int[]{0, 1, 0, 0, 1}));
    }
}
