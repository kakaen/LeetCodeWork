package 贪心算法;

public class 柠檬水找零860 {
    public static void main(String[] args) {
        Solution860 solution860 = new Solution860();
        System.out.println(solution860.lemonadeChange(new int[]{5, 5, 5, 10, 20}));
        System.out.println(solution860.lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}
class Solution860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0]!=5) return false;
        int n=bills.length;
        int count_5=0;
        int count_10=0;
        for (int i=0;i<n;i++){
            if (bills[i]==5){
                count_5++;
            }else if (bills[i]==10){
                if (count_5<=0) return false;
                count_10++;
                count_5--;
            }else {
                //如果5块的没有或总钱数小于15
                if (count_5<=0||(count_5*5+count_10*10)<15) return false;
                if (count_10>0){
                    //说明有10块的
                    count_10--;
                    count_5--;
                }else {
                    //说明都是5块的
                    count_5=count_5-3;
                }
            }

        }
        return true;
    }
}