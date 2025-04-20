package Top100二刷.滑动窗口.定长滑动窗口;

public class 爱生气的书店老板1052 {
    public static void main(String[] args) {
        爱生气的书店老板1052 test = new 爱生气的书店老板1052();
        int[] customers=new int[]{1,0,1,2,1,1,7,5};
        int[] grumpy=new int[]{0,1,0,1,0,1,0,1};
        int minutes=3;
        System.out.println(test.maxSatisfied(customers, grumpy, minutes));
    }
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int ans=0;
        int n=customers.length;
        int l=0;
        int count=0;
        for (int r=0;r<n;r++){
           count+=customers[r];
           //如果是生气的话就需要减一
           if (grumpy[r]==1){
               minutes--;
           }
           while (minutes<0){
               if (grumpy[l]==1) minutes++;
               count-=customers[l++];
           }
           ans=Math.max(ans,count);
        }
        return ans;
    }
}
