package Top100.数组;

public class 分发糖果135 {
    public static void main(String[] args) {
        分发糖果135 test = new 分发糖果135();
        System.out.println(test.candy(new int[]{1, 0, 2}));
    }
    //
    public int candy(int[] ratings){
        int n=ratings.length;
        int[] left=new int[n];
        //先进行左优化
        left[0]=1;
        for (int i=1;i<n;i++){
            if (ratings[i]>ratings[i-1]){
                left[i]=left[i-1]+1;
            }else{
                left[i]=1;
            }
        }
        int[] right=new int[n];
        right[n-1]=1;
        for (int i=n-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                right[i]=right[i+1]+1;
            }else{
                right[i]=1;
            }
        }
        int res=0;
        for (int i=0;i<n;i++){
            res+=Math.max(left[i],right[i]);
        }
        return res;
    }
}
